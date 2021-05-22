package az.course;

import az.course.exception.StudentException;
import az.course.model.Student;
import az.course.service.impl.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();
        String name, surname, phone;
        Long id;
        Student student;
        System.out.println("1.add 2.delete 3.update 4.get by id 5. get all 6.exit");
        int secim = scanner.nextInt();
        while (secim != 6) {
            switch (secim) {
                case 1:
                    System.out.println("telebenin adini daxil edin");
                    name = scanner.next();
                    System.out.println("telebenin soyadini daxil edin");
                    surname = scanner.next();
                    System.out.println("telebenin nomresin daxil edin");
                    phone = scanner.next();
                    student = new Student();
                    student.setSurname(surname);
                    student.setName(name);
                    student.setPhone(phone);
                    studentService.addStudent(student);
                    System.out.println("telebe elave olundu");
                    break;
                case 2:
                    System.out.println("id-ni daxil edin");
                    id = scanner.nextLong();
                    try {
                        studentService.deleteStudent(id);
                        System.out.println("telebe silindi");
                    } catch (StudentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("id-ni daxil edin");
                    id = scanner.nextLong();
                    System.out.println("telebenin yeni adini daxil edin");
                    name = scanner.next();
                    System.out.println("telebenin yeni soyadini daxil edin");
                    surname = scanner.next();
                    System.out.println("telebenin yeni nomresin daxil edin");
                    phone = scanner.next();
                    student = new Student();
                    student.setSurname(surname);
                    student.setName(name);
                    student.setPhone(phone);
                    try {
                        studentService.updateStudent(id, student);
                        System.out.println("telebe melumatlari yenilendi");
                    } catch (StudentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("id-ni daxil edin");
                    id = scanner.nextLong();
                    try {
                        student = studentService.getStudentById(id);
                        System.out.println(student);
                    } catch (StudentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case 5:
                    List<Student>students =  studentService.getStudents();
                    students.forEach(System.out::println);
                    break;

                default:
                    System.out.println("yanlis secim");

            }

            System.out.println("1.add 2.delete 3.update 4.get by id 5. get all 6.exit");
            secim = scanner.nextInt();
        }

    }
}
