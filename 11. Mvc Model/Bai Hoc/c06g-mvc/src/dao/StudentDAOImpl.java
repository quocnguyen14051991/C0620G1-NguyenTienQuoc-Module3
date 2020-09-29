package dao;

import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StudentDAOImpl implements StudentDAO {

    static Map<Integer, Student> studentMap = new TreeMap<>();

    static {
        studentMap.put(1, new Student(1, "Din", "17/02/2000", 9, 1));
        studentMap.put(2, new Student(2, "Din10", "17/03/2000", 4, 0));
        studentMap.put(3, new Student(3, "Din11", "17/04/2000", 6, 1));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public String save(Student student) {
        studentMap.put(student.getId(), student);
        return "OK";
    }
}
