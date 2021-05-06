package edu.unbosque.taller4.Taller_4_Java_EE;

import edu.unbosque.taller4.Taller_4_Java_EE.beans.Bean;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "uploading", value = "/upload")
public class SeeImages extends HttpServlet {
    private String message;

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Bean b = new Bean();
        String img = b.leerImagenes();


        PrintWriter out = response.getWriter();
        out.println("<p>" + img + " hola" +
                "</p>");
        out.println("<a href=main.jsp>Ingresar otra imagen</a>");
        out.close();

    }

    public void destroy() {
    }
}