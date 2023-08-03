package com.facundoduarte.mvc.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.Contact;
import com.facundoduarte.mvc.mvc.models.Student;
import com.facundoduarte.mvc.mvc.repositories.ContactRepository;
import com.facundoduarte.mvc.mvc.repositories.StudentRepository;

@Service
public class ContactService {
    private final ContactRepository contactRepository;
    private final StudentRepository studentRepository;

    public ContactService(ContactRepository contactRepository, StudentRepository studentRepository) {
        this.contactRepository = contactRepository;
        this.studentRepository = studentRepository;

    }

    public Contact createContact(Long studentId, String address, String city, String state) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            Contact contact = new Contact(address, city, state, optionalStudent.get());
            return contactRepository.save(contact);
        } else {
            return null;
        }
    }

    public List<Student> getAllStudentsWithContacts() {
        return studentRepository.findAll();
    }

}
