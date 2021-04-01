package com.turing.sp5.mapper;

import com.turing.sp5.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {

    @Select("select * from menu where pid = 0")
    List<Menu> findAll();

    @Select("select * from menu where pid =#{id}")
    List<Menu> findbyid(@Param("id") Integer id);
}
