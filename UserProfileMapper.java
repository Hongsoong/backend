package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.UserProfile;



@Mapper
public interface UserProfileMapper {
    @Select("SELECT * FROM user_table WHERE user_id=#{user_id}")
    UserProfile getUserProfile(@Param("user_id")String user_id);

    @Select("SELECT * FROM user_table")
    List<UserProfile> getUserProfileList();

    @Insert("INSERT INTO user_table VALUES(#{user_id}, #{user_name}, #{user_qwd}, #{user_phone_number}, #{user_sex}, #{user_size}, #{user_addr}, #{user_authority}, #{user_birth})")
    int putUserProfile(@Param("user_id") String user_id,@Param("user_name") String user_name, @Param("user_qwd") String user_qwd, @Param("user_phone_number") String user_phone_number, @Param("user_sex") String user_sex, @Param("user_size") String user_size, @Param("user_addr") String user_addr, @Param("user_authority") String user_authority, @Param("user_birth") String user_birth);

    @Update("UPDATE user_table SET user_name=#{user_name}, user_qwd=#{user_qwd}, user_phone_number=#{user_phone_number}, user_sex=#{user_sex}, user_size=#{user_size}, user_addr=#{user_addr}, user_authority=#{user_authority}, user_birth=#{user_birth} WHERE user_id=#{user_id}")
    int updateUserProfile(@Param("user_id") String user_id,@Param("user_name") String user_name, @Param("user_qwd") String user_qwd, @Param("user_phone_number") String user_phone_number, @Param("user_sex") String user_sex, @Param("user_size") String user_size, @Param("user_addr") String user_addr, @Param("user_authority") String user_authority, @Param("user_birth") String user_birth);

    @Delete("DELETE FROM user_table WHERE user_id=#{user_id}")
    int deleteUserProfile(@Param("user_id") String user_id);
}
