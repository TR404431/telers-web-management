package com.example.mapper;

import com.example.pojo.DegreeStat;
import com.example.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    List<Student> list(String name, Integer degree, Integer clazzId);

    void deleteById(Integer[] ids);
    @Insert("insert into student(name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id,update_time) values (#{name},#{no},#{gender},#{phone},#{idCard},#{isCollege},#{address},#{degree},#{graduationDate},#{clazzId},now())")
    void insert(Student student);
    @Select("select id, name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, violation_count, violation_score, create_time, update_time from student where  id = #{id}")
    Student getStudentById(Integer id);

    void updateStudent(Student student);
    @Update("update student set violation_score = violation_score + #{score},violation_count = violation_count + 1 where id = #{id}")
    void updateStudentViolation(Integer id, short score);

    List<DegreeStat> getValveAndName();

    List<Map<String, Object>> getStudentCountData();
}
