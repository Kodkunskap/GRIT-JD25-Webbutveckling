package se.gritacademy.gritcrm.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.gritacademy.gritcrm.dao.UserDAO;
import se.gritacademy.gritcrm.model.User;

import java.io.IOException;

@WebServlet("/register")
public class RegisterController  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
        } catch (Throwable ex) {
            throw ex;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username") == null ? "" :  request.getParameter("username");
        String password1 = request.getParameter("password1") == null ? "" :  request.getParameter("password1");
        String password2 = request.getParameter("password2") == null ? "" :  request.getParameter("password2");
        String error = null;

        if(username.isBlank() || password1.isBlank() || password2.isBlank()) {
            error = "Please fill all the required fields.";
        }

        if(!password1.equals(password2)) {
            error = "Passwords don't match.";
        }

        if(error != null) {
            request.setAttribute("error", error);
            request.setAttribute("username", username);
            request.setAttribute("password1", password1);
            request.setAttribute("password2", password2);

            try {
                System.out.println("Returning to registration page with error: " + error);
                request.getRequestDispatcher("/view/register.jsp").forward(request, response);
            } catch(Throwable ex) {
                throw ex;
            }
            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password1);        // Om jag vill hash:a lösenordet - behöver jag göra det innan jag
                                            // använder setPassword()
        UserDAO userDAO = new UserDAO();
        try {
            userDAO.save(user);
            request.setAttribute("success", "Your user has been created.");
        } catch(Throwable ex) {
            request.setAttribute("error", "Your user could not be created. Sorry!");
            System.out.println(ex.getMessage());
        }

        try {
            request.getRequestDispatcher("/view/register.jsp").forward(request, response);
        } catch(Throwable ex) {
            throw ex;
        }
    }

}
