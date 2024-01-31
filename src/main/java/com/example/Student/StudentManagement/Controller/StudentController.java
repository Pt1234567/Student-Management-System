package com.example.Student.StudentManagement.Controller;

import com.example.Student.StudentManagement.Entity.Student;
import com.example.Student.StudentManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {


    private StudentService service;

    public StudentController(StudentService service) {
        super();
        this.service = service;
    }

    //handler method to handle list of all students
    @GetMapping("/students")
    public String getAllStudents(Model theModel){
        theModel.addAttribute("students",service.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model theModel){
        //create student object to hold form data
        Student student=new Student();

        theModel.addAttribute("student",student);

        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        service.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id,Model theModel){
        theModel.addAttribute("student",service.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student,Model model){
          Student existingStudent=service.getStudentById(id);
          existingStudent.setId(id);
          existingStudent.setFirstName(student.getFirstName());
          existingStudent.setLastName(student.getLastName());
          existingStudent.setEmail(student.getEmail());

          service.update(existingStudent);

          return "redirect:/students";
    }


    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id ,Model model){
          service.deleteStudentById(id);
          return "redirect:/students";
     }
}
