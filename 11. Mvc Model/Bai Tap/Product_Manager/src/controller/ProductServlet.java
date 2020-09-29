package controller;

import bo.ProductBO;
import bo.ProductBOimpl;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"", "/listProduct"})
public class ProductServlet extends HttpServlet {
    ProductBO productBO = new ProductBOimpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionProduct = request.getParameter("actionProduct");
        if (actionProduct == null) {
            response.sendRedirect("");
        } else if (actionProduct.equals("create")) {
            String idProduct = request.getParameter("idProduct");
            String nameProduct = request.getParameter("nameProduct");
            String inventoryProduct = request.getParameter("inventoryProduct");
            Product product = new Product(idProduct, nameProduct, inventoryProduct);
            String message = productBO.save(product);
            request.setAttribute("message", message);
            request.getRequestDispatcher("create.jsp").forward(request, response);
        } else if (actionProduct.equals("edit")) {
            String idProduct = request.getParameter("id");
            String nameProduct = request.getParameter("nameProduct");
            String inventoryProduct = request.getParameter("inventoryProduct");
            Product product = this.productBO.findById(Integer.parseInt(idProduct));
            product.setIdProduct(idProduct);
            product.setNameProduct(nameProduct);
            product.setInventoryProduct(inventoryProduct);
            String message = this.productBO.update(Integer.parseInt(idProduct), product);
            request.setAttribute("message", message);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } else if (actionProduct.equals("delete")) {
            String idProduct = request.getParameter("id");
            String nameProduct = request.getParameter("nameProduct");
            String inventoryProduct = request.getParameter("inventoryProduct");
            Product product = this.productBO.findById(Integer.parseInt(idProduct));
            if (product == null) {
                response.sendRedirect("");
            } else {
                String message = this.productBO.remove(Integer.parseInt(idProduct));
                request.setAttribute("message", message);
                List<Product> listProduct = this.productBO.findAll();
                request.setAttribute("listProduct", listProduct);
                request.getRequestDispatcher("list.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionProduct = request.getParameter("actionProduct");
        if (actionProduct == null) {
            List<Product> listProduct = this.productBO.findAll();
            request.setAttribute("listProduct", listProduct);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } else if (actionProduct.equals("create")) {
            request.getRequestDispatcher("create.jsp").forward(request, response);
        } else if (actionProduct.equals("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = this.productBO.findById(id);
            request.setAttribute("Product", product);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } else if (actionProduct.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = this.productBO.findById(id);
            request.setAttribute("product", product);
            request.getRequestDispatcher("delete.jsp").forward(request, response);
        } else if (actionProduct.equals("search")) {
            String message = null;
            String name = request.getParameter("Search");
            List<Product> list = this.productBO.findAll();
            List<Product> listSearch = this.productBO.findNameRelative(list, name);
            if (listSearch.size()==0) {
                message = "Product not found";
                request.setAttribute("message", message);
                request.getRequestDispatcher("list.jsp").forward(request, response);
            } else {
                request.setAttribute("listProduct", listSearch);
                request.getRequestDispatcher("list.jsp").forward(request, response);
            }

        }
    }
}
