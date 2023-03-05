package com.clean.code.springboot.web.rest;


import com.clean.code.springboot.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {
    @GetMapping("/students/all")
    public ResponseEntity getAll(){
        Student student = new Student(1L, "Abdugani", "Xudoyqulov", "4-kurs");
        Student student1 = new Student(1L, "Jeck", "Jimy", "4-kurs");
        Student student2 = new Student(1L, "Yaxshiboy", "Shomurodov", "4-kurs");

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);

        return ResponseEntity.ok(students);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Student student = new Student(id, "Abdugani", "Xudoyqulov", "4-kurs");
        return ResponseEntity.ok(student);
    }
    @PostMapping("/students")
    public ResponseEntity create(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }
    @GetMapping("/students")
    public ResponseEntity getOne(@RequestParam Long id,
                                 @RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam String course){
        Student student = new Student(id, firstName, lastName, course);
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok("Ma'lumot o'chirildi");
    }
    @PutMapping("/students")
    public ResponseEntity update(@RequestBody Student studentNew){
        Student student = new Student(1L, "Abdugani", "Xudoyqulov", "4-kurs");
        student.setFirstName(studentNew.getFirstName());
        student.setLastName(studentNew.getLastName());
        return ResponseEntity.ok(student);
    }

}
