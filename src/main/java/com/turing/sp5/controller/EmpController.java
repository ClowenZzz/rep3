package com.turing.sp5.controller;

import com.turing.sp5.entity.Dept;
import com.turing.sp5.entity.EasyUIDataGrid;
import com.turing.sp5.entity.Emp;
import com.turing.sp5.entity.Emp2;
import com.turing.sp5.mapper.EmpMapper;
import com.turing.sp5.service.DeptService;
import com.turing.sp5.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emp")
@Slf4j
public class EmpController {
    @Autowired
    private EmpService empService;

    @Autowired
    private DeptService deptService;

//    @GetMapping("/list")
//    public String findAll(Model model){
//        List<Emp2> emps = empService.findAllEmp2();
//        model.addAttribute("emps", emps);
//        return "forward:/user/index";
//    }

    @PostMapping("/insertE")
    @ResponseBody
    public String inser(Emp emp){
        log.debug("--------------执行了添加------------");
        return empService.insert(emp)>0?"success":"error";
    }

    /**
     * 显示部门列表
     * @return 部门列表JSON
     */
    @PostMapping("/depts")
    @ResponseBody
    public List<Dept> depts(){
        return deptService.list();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public String emp(@PathVariable("id") Integer id){
        log.info("--------------执行了删除------------");
        return empService.delEmp(id)>0?"success":"error";
    }
    @PostMapping("/update")
    @ResponseBody
    public String update(Emp emp){
        log.info("--------------执行了修改------------");
        return empService.updEmp(emp)>0?"success":"error";
    }

    @GetMapping("/page")
    @ResponseBody
    public EasyUIDataGrid findByPage(@RequestParam(value = "page",defaultValue = "1") Integer pageNum, @RequestParam(value = "rows",defaultValue = "10")
            Integer pageSize,String sort,String order, String date1, String date2, String ename,Integer deptno){
        return  empService.findBypage(pageNum, pageSize,sort,order,date1,date2,ename,deptno);
    }

    @PostMapping("/deletes")
    @ResponseBody
    public String dels(String[] ids){
        log.info("--------------执行了批量删除------------");
        int i= empService.deleteB(ids);
        return empService.deleteB(ids)>0?"删除了"+i+"行":"error";
    }
}
