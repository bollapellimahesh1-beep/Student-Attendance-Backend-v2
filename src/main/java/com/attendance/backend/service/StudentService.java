package com.attendance.backend.service;

import com.attendance.backend.model.Student;
import com.attendance.backend.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        student.setId(null); // the database creates the id
        return studentRepository.save(student);
    }

    public Optional<Student> updateStudent(Long id, Student data) {
        return studentRepository.findById(id).map(existing -> {
            existing.setName(data.getName());
            existing.setRollNumber(data.getRollNumber());
            existing.setDepartment(data.getDepartment());
            existing.setEmail(data.getEmail());
            existing.setPhone(data.getPhone());
            return studentRepository.save(existing);
        });
    }

    public boolean deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }
}
