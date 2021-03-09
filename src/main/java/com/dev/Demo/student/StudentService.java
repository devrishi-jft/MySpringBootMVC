package com.dev.Demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service // or @Component to tell that bean
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();//GET-save operation
    }

    public void addNewStudent(Student student) {
        //Optional<Student> studentOptional =studentRepository.findById(student.getId());
        System.out.println("student1 = " + student);
        studentRepository.save(student);
        System.out.println("student2 = " + student);
    }

    public void deleteStudent(Integer studentId) {
        System.out.println("studentIdservice = " + studentId);
        studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Integer studentId, String name) {
        Optional<Student> optional= studentRepository.findById(studentId);
        Student student=optional.get();
        System.out.println("studentId = " + studentId + ", name = " + name);
        student.setName("Sherawat Dev");

    }
}
