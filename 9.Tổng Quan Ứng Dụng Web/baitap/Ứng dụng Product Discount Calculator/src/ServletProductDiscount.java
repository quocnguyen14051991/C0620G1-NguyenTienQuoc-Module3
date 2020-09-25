import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletProductDiscount", urlPatterns = "/index")
public class ServletProductDiscount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String listPrice = request.getParameter("list");
        String discountPercent = request.getParameter("discount");
        Double result = Integer.parseInt(listPrice) + (Integer.parseInt(discountPercent)*0.01);
        request.setAttribute("resultAmount", String.valueOf(result));
        request.getRequestDispatcher("sum.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
