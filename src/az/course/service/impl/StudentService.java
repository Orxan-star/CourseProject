package az.course.service.impl;

import az.course.exception.StudentException;
import az.course.model.Student;
import az.course.dao.StudentDao;
import az.course.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {

    private StudentDao studentDao = new StudentDao();

    @Override
    public void addStudent(Student student){
        if (student.getName().isEmpty()
                || student.getSurname().isEmpty()
                || student.getPhone().isEmpty()) {

            throw new StudentException("{name, surname, phone} bosh ola bilmez ");

        }

        studentDao.add(student);
    }


    @Override
    public void deleteStudent(Long id) {
        Student student = studentDao.getById(id);
        if (student == null) {
            throw new StudentException("telebe tapilmadi");
        }

        studentDao.delete(id);
    }

    @Override
    public void updateStudent(Long id, Student student) {
        Student s = studentDao.getById(id);
        if (s == null) {
            throw new StudentException("telebe tapilmadi");
        }

        if (student.getName().isEmpty()
                || student.getSurname().isEmpty()
                || student.getPhone().isEmpty()) {

            throw new StudentException("{name, surname, phone} bosh ola bilmez ");
        }

        studentDao.update(id, student);
    }

    @Override
    public Student getStudentById(Long id) {
        Student s = studentDao.getById(id);
        if (s == null) {
            throw new StudentException("telebe tapilmadi");
        }

        return s;
    }

    @Override
    public List<Student> getStudents() {
       return studentDao.getAll();
    }

}
