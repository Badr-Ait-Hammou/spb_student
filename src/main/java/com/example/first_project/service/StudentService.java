package com.example.first_project.service;

import com.example.first_project.dao.StudentRepository;
import com.example.first_project.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentService {


    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    //@Query("SELECT YEAR(s.dateNaissance) AS annee FROM Student s GROUP BY YEAR(s.dateNaissance) ORDER BY YEAR(s.dateNaissance)")
    public List<Student> findStudentByYear(Date dateNaissance) {
        return studentRepository.findStudentByYear(dateNaissance);
    }

    public int save(Student student) {
        if(findById(student.getId())!=null){
            return -1;
        }else{
            studentRepository.save(student);
            return 3;
        }

    }


    @Transactional
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Autowired
    private StudentRepository studentRepository;
}
