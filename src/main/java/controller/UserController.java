package controller;

import dao.UserDAO;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            register(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("register/register.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User employee = new User();
        employee.setFirstName();
        employee.setLastName();
        employee.setUsername();
        employee.setPassword();

        try {
            int result = userDAO.resignterEmployee(employee);
            if (result == 1) {
                request.setAttribute("NOTIFICATION", "User Register Succesfullu!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("register/register.jsp");
        dispatcher.forward(request, response);

    }


}
