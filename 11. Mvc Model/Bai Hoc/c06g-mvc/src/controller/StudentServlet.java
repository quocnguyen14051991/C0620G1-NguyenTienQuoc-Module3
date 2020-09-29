package controller;

import bo.StudentBO;
import bo.StudentBOImpl;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"", "/listStudent"})
public class StudentServlet extends HttpServlet {

    StudentBO studentBO = new StudentBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUserAbc = request.getParameter("actionUser");

        if (actionUserAbc == null) {
            response.sendRedirect("");
        } else {
            String nameStudent = request.getParameter("nameStudent");
            String dateOfBirth = request.getParameter("dateOfBirth");

            int idRandom = (int) (Math.random() * 1000);
            Student student = new Student(idRandom, nameStudent, dateOfBirth, 0, 1);

            String message = this.studentBO.save(student);
            request.setAttribute("message", message);

            request.getRequestDispatcher("create.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUserAbc = request.getParameter("actionUser");

        if (actionUserAbc == null) {

            List<Student> studentList = this.studentBO.findAll();


            request.setAttribute("abcList", studentList);
//        request.setAttribute("testVariable", "<script>location.href = 'https://www.google.com/'; </script>");
            request.getRequestDispatcher("list.jsp").forward(request, response);

        } else if (actionUserAbc.equals("create")) {
            response.sendRedirect("create.jsp");
        }
    }
}
