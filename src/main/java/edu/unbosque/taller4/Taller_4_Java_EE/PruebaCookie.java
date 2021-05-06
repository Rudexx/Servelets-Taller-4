package edu.unbosque.taller4.Taller_4_Java_EE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cookies", value = "/prueba")
public class PruebaCookie extends HttpServlet {

    private String message;



    public void init() {
        System.out.println("llegue aca");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String userName = req.getParameter("user");
        System.out.println(userName);

        try{
            PrintWriter out = resp.getWriter();

            Cookie c1 = new Cookie("usuario" , userName);
            resp.addCookie(c1);



            Cookie[] c = req.getCookies();
            String name = "n";
            for (int i = 0; i <c.length ; i++) {
                if(c[i].getName() == "usuario"){
                    name = c[i].getValue();
                    i = c.length;
                }
            }

            out = resp.getWriter();
            resp.sendRedirect("main.jsp");




            out.println("<header>\n" +
                    "    <div class=\"alert alert-info\">\n" +
                    "        <h3>Bienvenido, Ingresa la foto de tu mascota a continuación </h3>\n" +
                    "    </div>\n" +
                    "</header>");



            out.close();


        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void destroy() {
    }
}



