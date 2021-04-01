package com.turing.sp5.service;

import com.turing.sp5.entity.Menu;
import com.turing.sp5.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class MenuServiceImpl implements  MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> findMenu() {
        List<Menu> list=menuMapper.findAll();
        for (Menu menu:list){
           List<Menu> menus= menuMapper.findbyid(menu.getId());
            menu.setChildren(menus);
            for (Menu m:menus){
                m.setChildren(menuMapper.findbyid(m.getId()));
            }
        }
        return list;
    }
}
