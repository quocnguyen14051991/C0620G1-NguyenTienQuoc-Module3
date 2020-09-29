package bo;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;

import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public List<Student> findAll() {
        return this.studentDAO.findAll();
    }

    @Override
    public String save(Student student) {
        String message = "";
        if (student.getName() == null || student.getName().equals("")) {
            message = "Please input name";
        } else {
            message = studentDAO.save(student);
        }

        return message;
    }
}
