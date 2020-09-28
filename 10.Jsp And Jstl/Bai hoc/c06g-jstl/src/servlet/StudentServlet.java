package servlet;

import object.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"", "/listStudent"})
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Din", "17/02/2000", 9, 1));
        studentList.add(new Student(2, "Din2", "17/03/2000", 4, 0));
        studentList.add(new Student(3, "Din3", "17/04/2000", 5, 3));

        request.setAttribute("abcList", studentList);
//        request.setAttribute("testVariable", "<script>location.href = 'https://www.google.com/'; </script>");
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
