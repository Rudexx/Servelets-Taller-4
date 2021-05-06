package edu.unbosque.taller4.Taller_4_Java_EE.beans;

import edu.unbosque.taller4.Taller_4_Java_EE.model.User;

import javax.ejb.Singleton;
import java.io.*;
import java.util.ArrayList;


@Singleton

public class Bean implements Serializable {
    private static final long serialVersionUID = 5443351151396868724L;
    private ArrayList<User> user_list;
    private Archivo file;






    public Bean(){
    file = new Archivo();
    user_list = file.leerArchivo();


    }

    public void crearImagen(String usuario, String desc , String date, String name){
        User u = new User(usuario,desc,date,name);
        user_list.add(u);
        file.escribirArchivo(user_list);
    }

    public String leerImagenes(){
        String resultado = "";
        System.out.println(file.leerArchivo().size());
        for (int i = 0; i <file.leerArchivo().size() ; i++) {
            resultado = resultado + file.leerArchivo().get(i).toString() + "\n";
        }
        return resultado;
    }







}
