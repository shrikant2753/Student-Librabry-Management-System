package com.example.Student_Library_Management_System.Controller;

import com.example.Student_Library_Management_System.Model.Student;
import com.example.Student_Library_Management_System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/get-user")
    public String getUserByEmail(@RequestParam("email")String email){
        return studentService.findByEmail(email);
    }

    @PutMapping("/update_mob")
    public String updateMobileNo(@RequestBody Student student){
        return studentService.updateMobileNo(student);
    }
}
