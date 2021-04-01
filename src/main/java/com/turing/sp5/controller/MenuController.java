package com.turing.sp5.controller;

import com.turing.sp5.entity.Menu;
import com.turing.sp5.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/showMenu")
    @ResponseBody
    public List<Menu> showMenu(){
        return  menuService.findMenu();
    }

}
