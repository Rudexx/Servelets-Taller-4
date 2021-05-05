package edu.unbosque.taller4.Taller_4_Java_EE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "cookiesImprimir", value = "/save-image")
public class ImageCookie extends HttpServlet {

    private String message;



    public void init() {
        System.out.println("llegue aca");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String userName = req.getParameter("user");
        System.out.println(userName);

        try{
            PrintWriter out = resp.getWriter();

            Cookie c1 = new Cookie("usuario" , userName);
            resp.addCookie(c1);


            out.println("alert('Sesion Iniciada correctamente');");
            resp.sendRedirect("main.html");

            Cookie[] cookie = req.getCookies();
            for (int i = 0; i < cookie.length ; i++) {
                System.out.println(cookie[i].getName() + "\n" + cookie[i].getValue());
            }

            out.close();


        }catch (Exception e){
            System.out.println(e);
        }
    }


    public void destroy() {
    }
}
