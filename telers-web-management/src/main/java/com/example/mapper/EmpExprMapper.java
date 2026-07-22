package com.example.mapper;

import com.example.pojo.EmpExpr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    /**
     * 批量保存员工的工作信息
     * @param empExprList
     */
    void insertBash(List<EmpExpr> empExprList);
    /*
    根据员工id批量删除员工工作经历
     */
    void deleteByEmpIds(List<Integer> ids);
}
