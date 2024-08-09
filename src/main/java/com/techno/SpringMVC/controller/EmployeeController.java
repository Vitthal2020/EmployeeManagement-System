 package com.techno.SpringMVC.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.techno.SpringMVC.POJO.Admin;
import com.techno.SpringMVC.POJO.Employee;
import com.techno.SpringMVC.service.AdminService;
import com.techno.SpringMVC.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;          
import javax.servlet.http.HttpSession;
import java.util.List;
               
@Controller
public class EmployeeController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/Add")
    public String add(ModelMap map, @SessionAttribute(value="Login", required=false) Admin admin) {
        if (admin == null) {
            return "Login";
        }                               
        List<Employee> employees = employeeService.searchAllEmployees();
        if (employees != null) {
            map.addAttribute("employees", employees);
        }
        return "Add";                
    }
    @PostMapping("/Add")
    public String addEmployee(@RequestParam String name, @RequestParam String surname, @RequestParam String email, @RequestParam String designation, ModelMap map, @SessionAttribute(value="Login", required=false) Admin admin) {
        if (admin == null) {
            return "Login";
        }
        Employee employee = employeeService.AddEmployee(name, surname, email, designation);
        if (employee != null) {
        	  List<Employee> employees = employeeService.searchAllEmployees();
              if (employees != null) {
                  map.addAttribute("employees", employees);
              }
            map.addAttribute("msg", "Data inserted successfully");
            return "Add";
        }         
        map.addAttribute("msg", "Data not inserted");                             
        return "Add";
    }
    @GetMapping("/search")
    public String search(ModelMap map, @SessionAttribute(value="Login", required=false) Admin admin) {
        if (admin == null) {
            return "Login";
        }
        List<Employee> employees = employeeService.searchAllEmployees();
        if (employees != null) {
            map.addAttribute("employees", employees);
        }
        return "search";    
    }

    @PostMapping("/search")
    public String searchEmployee(@RequestParam int id, ModelMap map, @SessionAttribute(value="Login", required=false) Admin admin) {
        if (admin == null) {
            return "Login";
        }        Employee employee = employeeService.searchEmployee(id);
        if (employee != null) {
        	  List<Employee> employees = employeeService.searchAllEmployees();
              if (employees != null) {
                  map.addAttribute("employees", employees);
              }
            map.addAttribute("msg", "Data found successfully");
            map.addAttribute("emp", employee);
            return "search";
        }
        map.addAttribute("msg", "Data not found");
        return "search";
    }
    @GetMapping("/Update")
    public String update(ModelMap map, @SessionAttribute(value="Login", required=false) Admin admin) {
        if (admin == null) {
            return "Login";
        }
        List<Employee> employees = employeeService.searchAllEmployees();
        if (employees != null) {
            map.addAttribute("employees", employees);
        }
        return "Update";
    }
    @PostMapping("/Update")
    public String updateEmployee(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("email") String email, @RequestParam("designation") String designation, ModelMap map, @SessionAttribute(value="Login", required=false) Admin admin) {
        if (admin == null) {
            return "Login";
        }
        Employee employee = employeeService.UpdateEmployee(id, name, surname, email, designation);
        if (employee != null) {
        	  List<Employee> employees = employeeService.searchAllEmployees();
              if (employees != null) {
                  map.addAttribute("employees", employees);
              } 
            map.addAttribute("msg", "Employee updated successfully.");
            map.addAttribute("emp", employee);
        } else {
            map.addAttribute("msg", "Employee not found.");
        }
        return "Update";
    }
    @GetMapping("/Delete")
    public String delete(ModelMap map, @SessionAttribute(value="Login", required=false) Admin admin) {
        if (admin == null) {
            return "Login";
        }
        List<Employee> employees = employeeService.searchAllEmployees();
        if (employees != null) {
            map.addAttribute("employees", employees);
        }
        return "Delete";    
    }
    @PostMapping("/Delete")
    public String deleteEmployee(@RequestParam int searchId, ModelMap map, @SessionAttribute(value="Login", required=false) Admin admin) {
        if (admin == null) {
            return "Login";
        }
        Employee employee = employeeService.deleteEmployee(searchId);
        if (employee != null) {
        	  List<Employee> employees = employeeService.searchAllEmployees();
              if (employees != null) {
                  map.addAttribute("employees", employees);
              }
            map.addAttribute("msg", "Deleted successfully");
            return "Delete";                  
        }
        map.addAttribute("msg", "Data not found");
        return "Delete";
    }
    @GetMapping("/Logout")
    public String logout(HttpSession session, ModelMap map) {
        session.invalidate();
        map.addAttribute("msg", "Logout Successfully");         
        return "Login";     
    }
    @PostMapping("/Login")
    public String login(@RequestParam String username, @RequestParam String password, ModelMap map, HttpServletRequest request) {
        Admin admin = adminService.login(username, password);
        if (admin != null) {
            map.addAttribute("msg", "Login successfully");
            HttpSession session = request.getSession();
            session.setAttribute("Login", admin);
            return "Home";
        }
        map.addAttribute("msg", "Login Unsuccessful");
        return "Login";
    }
    @GetMapping("/create")
    public String createAccount() {                 
        return "Admin";               
    }                       
    @PostMapping("/create")
    public String addAdmin(@RequestParam String username, @RequestParam String password,ModelMap map)  {
        Admin admin =adminService .addAdmin(username, password);
        if (admin != null) {
        	  List<Employee> employees = employeeService.searchAllEmployees();
              if (employees != null) {
                  map.addAttribute("employees", employees);
              }
            map.addAttribute("msg", "Account created  successfully");
            return "Login";
        }
        map.addAttribute("msg", "Not inserted");
        return "Admin";
    }
}

