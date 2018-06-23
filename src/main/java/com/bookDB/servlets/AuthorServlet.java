package com.bookDB.servlets;

import com.bookDB.DAO.AuthorDAO;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebServlet("/author")
public class AuthorServlet extends HttpServlet {

    private AuthorDAO authorDAO;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);

        final ApplicationContext springContext =  new AnnotationConfigApplicationContext("yourPackage");

        this.authorDAO = springContext.getBean(AuthorDAO.class);
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("authors", authorDAO.getAllAuthors());
        req.getRequestDispatcher("/author.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String firstName = req.getParameter("firstName");
        final String lastName = req.getParameter("lastName");
    }
} 

