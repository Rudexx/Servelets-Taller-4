package edu.unbosque.taller4.Taller_4_Java_EE.beans;

import edu.unbosque.taller4.Taller_4_Java_EE.model.User;

import java.io.*;
import java.util.ArrayList;

public class Archivo {

    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private File f;

    /**
     * Constructor de la clase Archivo. Inicializa la clase
     */


    public Archivo() {
        f= new File(System.getProperty("user.dir") + "\\data\\usuarios.dat");
    }


    /**
     * metodo de escritura de archivos, en este caso binarios
     * <b>pre</b> se ha inicializado la clase archivo<br>
     * <b>post</b> se guardó el valor solicitado en el archivo correctamente <br>
     * @param Apostador: una lista de Apostadores a guardar
     */


    public void escribirArchivo(ArrayList<User> Apostador) {
        try {
            salida = new ObjectOutputStream(new FileOutputStream(f));
            salida.writeObject(Apostador);
            salida.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * metodo de lectura de archivos, en este caso binarios
     * <b>pre</b> se ha inicializado la clase archivo<br>
     * <b>post</b> se retorno el valor solicitado del archivo correctamente <br>
     * @return una lista con todos los Apostadors
     */



    public ArrayList<User> leerArchivo() {

        ArrayList<User> Apostador = new ArrayList<User>();
        if (f.length() != 0) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(f));
                Apostador = (ArrayList<User>) entrada.readObject();
            } catch (FileNotFoundException e) {
                // TODO: handle exception
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return Apostador;
    }


    /**
     * @return the f
     */
    public File getF() {
        return f;
    }


    /**
     * @param f the f to set
     */
    public void setF(File f) {
        this.f = f;
    }



}