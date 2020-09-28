import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConvertServlet",urlPatterns = "/convertcurent")
public class ConvertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String  rate =request.getParameter("rate");
String usd=request.getParameter("usd");
Float vnd=Float.parseFloat(rate)*Float.parseFloat(usd);
//        PrintWriter writer =response.getWriter();
//        writer.println("<html>");
//        writer.println("<h1>Rate: " + rate+ "</h1>");
//        writer.println("<h1>USD: " + usd+ "</h1>");
//        writer.println("<h1>VND: " + vnd+ "</h1>");
//        writer.println("</html>");
        request.setAttribute("vndtrande",vnd);
        request.getRequestDispatcher("sum.jsp").forward(request,response);
        response.sendRedirect("sum.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
