package com.turing.sp5.service;

import com.turing.sp5.entity.EasyUIDataGrid;
import com.turing.sp5.entity.Emp;
import com.turing.sp5.entity.Emp2;

import java.util.List;

public interface EmpService {
    //List<Emp2> findAllEmp2();
    Emp findbyid(Integer id);
    int insert(Emp emp);
    int updEmp(Emp emp);
    int delEmp(Integer id);

    EasyUIDataGrid findBypage(Integer pageNum, Integer pageSize,String sort,String order,String date1,String date2,String ename,Integer deptno);

    int deleteB(String[] ids);
}
