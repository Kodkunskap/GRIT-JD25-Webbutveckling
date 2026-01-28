package se.gritacademy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/BigHTTPServlet")
public class BigHTTPServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("BigHTTPServlet init() körs");
    }

    @Override
    public void destroy() {
        System.out.println("BigHTTPServlet destroy()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {

        String id = req.getParameter("id");

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("""
                <html>
                    <head>
                        <title>Servlet BigHTTPServlet</title>
                    </head>
                    <body>
                """);

        out.println("<h1>Servlet BigHTTPServlet</h1>");

        out.println("<p>Sidans id: " + id + "</p>");

        printForm(out);
        printParams(req, resp);

        out.println("""
                    </body>
                </html>
                """);

    }

    private void printParams(HttpServletRequest req, HttpServletResponse resp)
        throws IOException
    {
        Map<String, String[]> queryParams = req.getParameterMap();

        PrintWriter out = resp.getWriter();
        out.println("<h2>Lista av Query Parametrar</h2>");
        out.println("<ul>");

        queryParams.forEach((key, value) -> {
            out.println("<li>");
            out.println(key + " [");
            for(int i=0; i < value.length; i++) {
                out.println(value[i]+" ");
            }
            out.println("]</li>");
        });

        out.println("</ul>");
    }

    private void printForm(PrintWriter out) {
        out.println("""
                <form method="POST" action="BigHTTPServlet">
                    <label for="search">Söksträng</label>
                    <input type="text" name="search" id="search">
                    <input type="submit" value="Sök">
                </form>
                """);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws IOException
    {
        PrintWriter out = resp.getWriter();

        out.println("""
                <html>
                    <head>
                        <title>Servlet BigHTTPServlet</title>
                    </head>
                    <body>
                """);
        out.println("<h1>Hello from doPost()</h1>");
        out.println("<p>" + req.getParameter("search") + "</p>");

        printParams(req, resp);

        out.println("""
                    </body>
                </html>
                """);
    }


}
