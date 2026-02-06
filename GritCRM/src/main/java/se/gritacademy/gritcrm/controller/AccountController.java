package se.gritacademy.gritcrm.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/account")
public class AccountController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("editId") != null) {

            req.getRequestDispatcher("/view/account/edit.jsp").forward(req, resp);
            return;
        }

        req.getRequestDispatcher("/view/account/list.jsp").forward(req, resp);

    }
}
