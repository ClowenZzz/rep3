package com.turing.sp5.service;

import com.turing.sp5.entity.EasyUIDataGrid;
import com.turing.sp5.entity.Emp;
import com.turing.sp5.entity.Emp2;
import com.turing.sp5.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements  EmpService {
    
    @Autowired
    private EmpMapper empMapper;
//    @Override
//    public List<Emp2> findAllEmp2() {
//        List<Emp2> emp2s = empMapper.findAllEmp2();
//        return emp2s;
//    }

    @Override
    public Emp findbyid(Integer id) {
        return  empMapper.selectByPrimaryKey(id);

    }

    @Override
    public int insert(Emp emp) {
        int i = empMapper.insertSelective(emp);
        return i;
    }

    @Override
    public int updEmp(Emp emp) {
        int i = empMapper.updateByPrimaryKeySelective(emp);
        return i;
    }

    @Override
    public int delEmp(Integer id) {
        int i = empMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public EasyUIDataGrid findBypage(Integer pageNum, Integer pageSize, String sort, String order, String date1, String date2, String ename, Integer deptno) {
        EasyUIDataGrid grid = new EasyUIDataGrid();
        grid.setRows(empMapper.selectEmpandDept((pageNum-1)*pageSize, pageSize,sort,order,date1,date2,ename,deptno));
        grid.setTotal(empMapper.selectCount()) ;
        return grid;
    }



    @Override
    public int deleteB(String[] ids) {
        int i = empMapper.deleteBatch(ids);
        return i;
    }
}
