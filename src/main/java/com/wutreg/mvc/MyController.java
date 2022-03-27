package com.wutreg.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("employee/")
public class MyController {

    @RequestMapping("")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("askDetails")
    public String askEmployeeDetails(Model model){
        Employee employee = new Employee();
        employee.setName("Иван");
        employee.setSurname("Petrov");
        employee.setSalary(4000);
        model.addAttribute("employee", employee);
        return "ask-emp-details-view";
    }

    @RequestMapping("showDetails")
    public String showEmpDetails(@ModelAttribute("employee") Employee employee) {

        String name = employee.getName();
        employee.setName("Mr. " + name);

        return "show-employee-details-view";
    }


}
