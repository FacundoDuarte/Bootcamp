package com.facundoduarte.mvc.mvc.controlls;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facundoduarte.mvc.mvc.models.Contact;
import com.facundoduarte.mvc.mvc.models.Student;
import com.facundoduarte.mvc.mvc.services.ContactService;
import com.facundoduarte.mvc.mvc.services.StudentService;

import jakarta.validation.Valid;

@RestController
public class ApiService {
    private final StudentService studentService;
    private final ContactService contactService;

    public ApiService(StudentService studentService, ContactService contactService) {
        this.studentService = studentService;
        this.contactService = contactService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudentsByURL() {
        List<Student> students = contactService.getAllStudentsWithContacts();
        return students;
    }

    @RequestMapping(value = "/students")
    public List<Student> getAllStudents() {
        List<Student> students = contactService.getAllStudentsWithContacts();
        return students;
    }

    @GetMapping(value = "/students/new")
    public Student createStudentByURL(@Valid @ModelAttribute("student") Student student) {
        return studentService.createStudent(student);
    }

    @RequestMapping(value = "/students/new", method = RequestMethod.POST)
    public Student createStudent(@Valid @ModelAttribute("student") Student student) {
        return studentService.createStudent(student);
    }

    @RequestMapping(value = "/contact/new", method = RequestMethod.POST)
    public Contact createContact(@RequestParam Long student, @RequestParam String address, @RequestParam String city,
            @RequestParam String state) {
        return contactService.createContact(student, address, city, state);
    }

    @GetMapping(value = "/contact/new")
    public Contact createContactByURL(@RequestParam Long student, @RequestParam String address,
            @RequestParam String city, @RequestParam String state) {
        return contactService.createContact(student, address, city, state);
    }
}
