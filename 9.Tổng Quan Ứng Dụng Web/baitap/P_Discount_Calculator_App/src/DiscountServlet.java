import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet ",urlPatterns = "/discountServlet")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDes = request.getParameter("productDes");
        double listPrice = Double.parseDouble(request.getParameter("listPrice")) ;
        double discount = Double.parseDouble(request.getParameter("discountPercent"));
        double result = listPrice * discount * 0.01;
        String str = productDes+ " Discount Amount:" + String.valueOf(result);
        request.setAttribute("resultServlet",str);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
