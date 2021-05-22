package az.course.dao;

import az.course.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDao {

    private static Map<Long, Student> map = new HashMap<>();
    private static Long count = 0L;

    public void add(Student student) {
        map.put(count++, student);
    }

    public void delete(Long id) {
        map.remove(id);
    }

    public void update(Long id, Student student) {
        map.put(id, student);
    }

    public Student getById(Long id) {
        return map.get(id);
    }

    public List<Student> getAll() {
        return new ArrayList<>(map.values());
    }

}
