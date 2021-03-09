package com.dev.Demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student,Integer> {
    //@Query("select i from Student i where i.name=?1")
    //Optional<Student> findByName(Student name);
}
