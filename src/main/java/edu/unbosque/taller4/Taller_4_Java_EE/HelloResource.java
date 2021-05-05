package edu.unbosque.taller4.Taller_4_Java_EE;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}