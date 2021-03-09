package com.dev.Demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
 private final StudentService studentService;
@Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @PostMapping
    public void newStudent(@RequestBody Student student){
        System.out.println("student = " + student);
        studentService.addNewStudent(student);
    }
   @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
       System.out.println("studentId = " + studentId);
    studentService.deleteStudent(studentId);

    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Integer studentId,
            @RequestParam(required = false) String name
    ){
    studentService.updateStudent(studentId,name);
    }

}
