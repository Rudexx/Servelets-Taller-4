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






    public Bean(String usuario, String desc , String date, String name){
    file = new Archivo();
    user_list = file.leerArchivo();

    crearImagen(usuario,desc,date,name);
    }

    public void crearImagen(String usuario, String desc , String date, String name){
        User u = new User(usuario,desc,date,name);
        file.escribirArchivo(user_list);
    }

    public ArrayList<User> leerImagenes(){
        return file.leerArchivo();
    }







}
