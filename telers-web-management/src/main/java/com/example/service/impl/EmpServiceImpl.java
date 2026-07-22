package com.example.service.impl;

import com.example.mapper.EmpExprMapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.*;
import com.example.service.EmpService;
import com.example.utils.JwtUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpMapper empMapper;
       //----------原始分页查询---------
//    @Override
//    public PageResult<Emp> page( int page , int pageSize) {
//        //1调用mapper接口，查询总记录数
//        Long total =  empMapper.count();
//
//        //2调用mapper接口，查询结果列表
//        int start = (page - 1) * pageSize;
//        List<Emp> rows = empMapper.list(start, pageSize);
//        //3封装结果 PageResult
//
//        return new PageResult<Emp>(total, rows);
//    }
//
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        //1设置分页参数（PageHelper)
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        //2执行查询
        List<Emp> empList = empMapper.list(empQueryParam.getName(),empQueryParam.getGender(),  empQueryParam.getBegin() ,empQueryParam.getEnd());
        //3解析查询结果，并封装
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(),p.getResult());
    }
    //提交事物
    //rollbackfor用于控制出现何种异常类型，回滚事物
    @Transactional(rollbackFor = Exception.class)//默认出现运行时异常RuntimeException才会回滚 若不是则不会回滚 想要让它能够回滚需要添加rollbackfor
    @Override
    public void save(Emp emp) {

            //1.保存员工的基本信息
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);
            //2.保存员工的工作经历信息
            List<EmpExpr> empExprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(empExprList)){
                //遍历集合
                empExprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                } );
               empExprMapper.insertBash(empExprList);
            }

    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Integer> ids) {
        //1.删除员工的基本信息
        empMapper.deleteByIds(ids);
        //2.批量删除员工的工作经历信息
        empExprMapper.deleteByEmpIds(ids);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
        public void update(Emp emp) {
            //1：根据ID修改员工的基本信息
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.updateById(emp);
            //2: 根据ID修改员工的工作经历信息
                //2.1先根据员工ID删除原有的工作经历
            empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));
                //2.2再添加这个员工新的工作经历
            List<EmpExpr> empExprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(empExprList)){
               empExprList.forEach(empExpr -> {empExpr.setEmpId(emp.getId());});
               empExprMapper.insertBash(emp.getExprList());
            }

        }

    @Override
    public List<Emp> list() {
        List<Emp> i = empMapper.list(null,null,null,null);
        return i;
    }

    @Override
    public List<Emp> selectAll() {
        List<Emp> i = empMapper.selectAll();
        return i;
    }

    @Override
    public LoginInfo login(Emp emp) {
        //1.调用mapper接口，根据用户名和密码查询员工信息
        Emp  e =  empMapper.selectByUsernameAndPassword(emp);

        //2，判断：判断是否存在这个员工，如果存在，组装登录成功信息
        if(e!=null){
            Map<String,Object> map = new HashMap<>();
            map.put("id",e.getId());
            map.put("username",e.getUsername());
            String JWt = JwtUtils.generateJwt(map);

            return new LoginInfo(e.getUsername(),e.getName(),e.getId(),JWt);
        }
        //3.不存在，返回null
        return null;
    }

    @Override
    public Emp getInfo(Integer id) {

        return empMapper.getById(id);
    }

}
