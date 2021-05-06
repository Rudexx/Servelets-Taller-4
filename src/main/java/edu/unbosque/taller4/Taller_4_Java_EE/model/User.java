package edu.unbosque.taller4.Taller_4_Java_EE.model;

import java.io.InputStream;
import java.io.Serializable;

public class User implements Serializable {
    private String nombre;
    private String desc;
    private String date;
    private String img_name;
    private static final long serialVersionUID = 5443351151396868724L;

    public User(String n, String desc, String date, String img){
        nombre = n;
        this.desc = desc;
        this.date = date;
        img_name = img;

    }



}
