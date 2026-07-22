package com.example.mapper;

import com.example.pojo.Clazz;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ClazzMapper {
   List<Clazz> clazzList (String name,LocalDate begin, LocalDate end);
   @Delete("delete from clazz where id = #{id}")
   void deletrById(String id);
   @Insert("insert into clazz (name, room, begin_date, end_date, master_id, subject, create_time, update_time) VALUE (#{name},#{room},#{beginDate},#{endDate},#{masterId},#{subject},Now(),Now())")
   void save(Clazz clazz);
   @Select("select id,name,room,begin_date,end_date,create_time,update_time,master_id,subject from clazz where id = #{id}")
   Clazz getById(String id);
   @Update("update clazz set name = #{name},room = #{room},begin_date=#{beginDate},end_date=#{endDate},master_id = #{masterId},subject = #{subject} where id = #{id}")
   void update(Clazz clazz);
   @Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from clazz")
   List<Clazz> seleteAll();
}
