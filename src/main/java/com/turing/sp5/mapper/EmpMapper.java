package com.turing.sp5.mapper;

import com.turing.sp5.entity.Emp;
import com.turing.sp5.entity.Emp2;
import com.turing.sp5.entity.EmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EmpMapper {
    int countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(Integer empno);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    List<Emp2> findAllEmp2();

    /**
     * 自定义查询：关联查询员工和部门
     * @return
     */
    List<Emp2> selectEmpandDept(@Param("pageNum") Integer pageNum,@Param("pageSize")
            Integer pageSize,@Param("sort") String sort,@Param("order") String order,
             @Param("date1") String date1,@Param("date2") String date2,@Param("ename") String ename,
             @Param("deptno") Integer deptno);

    //分页查询
    @Select("select * from emo limit #{arg0},#{arg1}")
    List<Emp> selectByPage(Integer pagenum,Integer pagesize);

    //总记录数
    @Select("select count(*) from emp")
    int selectCount();

    int deleteBatch(String[] ids);


}