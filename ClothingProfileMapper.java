package com.example.demo.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.ClothingProfile;


@Mapper
public interface ClothingProfileMapper {
    @Select("SELECT * FROM clothing_table WHERE clothing_id=#{clothing_id}")
    ClothingProfile getClothingProfile(@Param("clothing_id")String clothing_id);

    @Select("SELECT * FROM clothing_table")
    List<ClothingProfile> getClothingProfileList();

    @Insert("INSERT INTO clothing_table VALUES(#{clothing_id}, #{clothing_name}, #{clothing_size}, #{clothing_condition}, #{user_id})")
    int putClothingProfile(@Param("clothing_id") String clothing_id,@Param("clothing_name") String clothing_name, @Param("clothing_size") String clothing_size,@Param("clothing_condition") String clothing_condition, @Param("user_id") String user_id);

    @Update("UPDATE clothing_table SET clothing_name=#{clothing_name},clothing_size=#{clothing_size},clothing_condition=#{clothing_condition},user_id=#{user_id} WHERE clothing_id=#{clothing_id}")
    int updateClothingProfile(@Param("clothing_id") String clothing_id,@Param("clothing_name") String clothing_name, @Param("clothing_size") String clothing_size, @Param("clothing_condition") String clothing_condition, @Param("user_id") String user_id);

    @Delete("DELETE FROM clothing_table WHERE clothing_id=#{clothing_id}")
    int deleteClothingProfile(@Param("clothing_id") String clothing_id);
}
