package com.example.first_project.ws;

import com.example.first_project.dao.StudentRepository;
import com.example.first_project.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/id/{id}")
    public Student findById(@PathVariable int id) {
        return studentRepository.findById(id);
    }


    @PostMapping("/")
    public void save(@RequestBody Student student){
        studentRepository.save(student);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable String id){
        Student student = studentRepository.findById(Integer.parseInt(id));
        studentRepository.delete(student);
    }
    @GetMapping("/")
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

   /* @GetMapping(value = "/count")
    public long countStudent() {
        return studentRepository.count();
    }
*/
    @GetMapping("/dateNaissance/{dateNaissance}")
    public List<Student> findByYear(@PathVariable Date dateNaissance) {
        return studentRepository.findStudentByYear(dateNaissance);
    }

}
