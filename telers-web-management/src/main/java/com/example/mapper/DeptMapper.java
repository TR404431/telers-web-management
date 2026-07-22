package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    //手动结果映射
//    @Results({
//            @Result(column = "create_time",property = "createTime"),
//            @Result(column = "update_time",property = "updateTime")
//    })
    //方式二起别名
//    @Select("select  id,name,create_time createTime,update_time updateTime from dept order by update_time desc ;")
    //查询
    @Select("select  id,name,create_time ,update_time from dept order by update_time desc ;")
    List<Dept> findAll();
    //根据id删除部门
    @Delete("delete  from dept where id  = #{id}")
    void deleteById(Integer id);
    //添加
    @Insert("INSERT INTO dept (name, create_time, update_time) VALUES (#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);
    //修改
    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
    @Select("SELECT  * from dept where  id = #{id}")
    Dept getById(Integer id);
}
