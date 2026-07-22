package com.example.mapper;

import com.example.pojo.Emp;
import com.example.pojo.JobOption;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface EmpMapper {
    //---------原始分页查询----------
//    @Select("select  count(*) from emp e left join dept d  on e.dept_id = d.id;")
//    public Long count();
//    @Select("select  e.*,d.name deptName from emp e left join dept d  on e.dept_id = d.id order by e.update_time desc " +
//            "limit #{start},#{pageSize};")
//    public List<Emp> list(@Param("start") int start, @Param("pageSize") int pageSize);
    //使用pageHelper插件
//        @Select("select  e.*,d.name deptName from emp e left join dept d  on e.dept_id = d.id order by e.update_time desc ")
         public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);
    @Options(useGeneratedKeys = true,keyProperty = "id")//获取到生成的主键--主键返回
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "VALUES (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);
    /**
     * 根据id批量删除员工的基本信息
     */
    void deleteByIds(List<Integer> ids);

    Emp getById(Integer id);

    void updateById(Emp emp);
    /*
    统计员工职位人数
     */
    List<Map<String,Object>> countEmpJobData() ;

    List<Map<String, Object>> countGenderData();
    @Select("SELECT id,username,name from emp")
    List<Emp> selectAll();
    @Select("select id,username,name from emp where username = #{username} and password = #{password}")
    Emp selectByUsernameAndPassword(Emp emp);
}
