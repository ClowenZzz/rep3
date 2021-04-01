package com.turing.sp5.service;

import com.turing.sp5.entity.Dept;

import com.turing.sp5.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements  DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> list() {
        return  deptMapper.selectByExample(null);
    }
}
