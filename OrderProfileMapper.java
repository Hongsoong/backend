package com.example.demo.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.OrderProfile;



@Mapper
public interface OrderProfileMapper {
    @Select("SELECT * FROM order_table WHERE order_id=#{order_id}")
    OrderProfile getOrderProfile(@Param("order_id") Integer order_id);

    @Select("SELECT * FROM order_table")
    List<OrderProfile> getOrderProfileList();

    @Insert("INSERT INTO order_table VALUES(#{order_id}, #{user_id}, #{borrow_start_time}, #{borrow_return_time}, #{clothing_id})")
    int putOrderProfile(@Param("order_id") Integer order_id,@Param("user_id") String user_id, @Param("borrow_start_time") String borrow_start_time,@Param("borrow_return_time") String borrow_return_time, @Param("clothing_id") String clothing_id);

    @Update("UPDATE order_table SET user_id=#{user_id},borrow_start_time=#{borrow_start_time},borrow_return_time=#{borrow_return_time},clothing_id=#{clothing_id} WHERE order_id=#{order_id}")
    int updateOrderProfile(@Param("order_id") Integer order_id,@Param("user_id") String user_id, @Param("borrow_start_time") String borrow_start_time, @Param("borrow_return_time") String borrow_return_time, @Param("clothing_id") String clothing_id);

    @Delete("DELETE FROM order_table WHERE order_id=#{order_id}")
    int deleteOrderProfile(@Param("order_id") Integer order_id);
}
