package edu.unbosque.taller4.Taller_4_Java_EE;

import edu.unbosque.taller4.Taller_4_Java_EE.beans.Bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;

@WebServlet(name = "cookiesImprimir", value = "/save-image")
@MultipartConfig
public class UploadImage extends HttpServlet {

    private String message;



    public void init() {
        System.out.println("llegue aca");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String loaded_image = request.getParameter("image");

            Cookie[] cookie = request.getCookies();



            String name = cookie[0].getValue();
            String fecha = java.util.Calendar.getInstance().getTime().toString();
            String desc = request.getParameter("desc");
            Bean b = new Bean();
            for (int i = 0; i < cookie.length; i++) {
            if(cookie[i].getName().equals("usuario")){
                name =cookie[i].getValue();
            }
        }
            b.crearImagen(name, desc, fecha, loaded_image);

            PrintWriter out = resp.getWriter();
            String img = b.leerImagenes();



            out.println("<p>" + img + " hola" +
                "</p>");
            out.println("<a href=main.jsp>Ingresar otra imagen</a>");
            out.close();
    }


    public void destroy() {
    }
}
