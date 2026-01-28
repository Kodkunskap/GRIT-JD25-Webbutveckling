package se.gritacademy.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class SimpleServlet implements Servlet {

    private ServletConfig config;
    private int counter = 0;

    /**
     * init() – anropas när servleten laddas in av servletcontainern (t.ex. Tomcat).
     * Här kan du göra uppstartslogik, läsa konfiguration, initiera resurser osv.
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        config = servletConfig;
        System.out.println("SimpleServlet init() körs. Servleten initieras.");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("SimpleServlet serivce() körs.");

        counter++;

        servletResponse.setContentType("text/html");

        PrintWriter out = servletResponse.getWriter();
        out.println("""
            <html>
                <head>
                    <title>SimpleServlet</title>
                </head>
                <body>
                    <h1>Hej från SimpleServlet</h1>
                    <p>lorem ipsum</p>
                    <p>Sidan har besökts 
            """);
        out.println(counter);
        out.println("""
                    gånger.</p>
                </body>
            </html>
        """);

    }

    @Override
    public String getServletInfo() {
        return "SimpleServlet - en enkelt servlet som implementerar Servlet-gränssnittet direkt!";
    }

    @Override
    public void destroy() {
        System.out.println("SimpleServlet destroy() körs. Goodbye!");
    }
}
