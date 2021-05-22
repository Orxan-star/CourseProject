package az.course.service;

import az.course.model.Student;

import java.util.List;

public interface IStudentService {
    void addStudent(Student student);
    void deleteStudent(Long id);
    void updateStudent(Long id, Student student);
    Student getStudentById(Long id);
    List<Student> getStudents();
}
