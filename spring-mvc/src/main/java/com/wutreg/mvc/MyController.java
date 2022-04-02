package com.wutreg.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
        employee.setPhoneNumber("123-45-67");
        model.addAttribute("employee", employee);
        return "ask-emp-details-view";
    }

    @RequestMapping("showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee employee,
                                 BindingResult bindingResult) {
//        System.out.println("surname length = " + employee.getSurname().length());
        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        }
        else {
            return "show-employee-details-view";
        }
    }


}
