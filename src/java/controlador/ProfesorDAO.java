/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.ArbolProfesores;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import Modelo.Profesor;

/**
 *
 * @author Labing
 */
public class ProfesorDAO {

    private RandomAccessFile profesorDB;
    private ArbolProfesores arbol = new ArbolProfesores();
    public int id;
    public String nuevo1="";
    public String nuevo2="";
    public int ext;
    
    public int id2;
    public String nuevo3="";
    public String nuevo4="";
    public int ext2;
    
    public ProfesorDAO() throws FileNotFoundException {
        this.profesorDB = new RandomAccessFile("C:\\Users\\crist\\Desktop\\profesor.txt", "rw");
    }
  
    public boolean insertar(Profesor profesor) throws IOException {
        long posicionMemoria = this.profesorDB.length();
        this.profesorDB.seek(posicionMemoria);
        arbol.Ingresar(profesor.getId(), posicionMemoria);
        arbol.ListarArbol();
        this.profesorDB.writeInt(profesor.getId());
        
        for (int i = 0; i < profesor.getNombre().length; i++) {
            char letra = profesor.getNombre()[i];
            this.profesorDB.writeChar(letra);
        }
        this.profesorDB.seek(posicionMemoria + 44);
//        System.out.println(this.profesorDB.getFilePointer());

        for (int i = 0; i < profesor.getApellido().length; i++) {
            char letra2 = profesor.getApellido()[i];
            this.profesorDB.writeChar(letra2);
        }
        this.profesorDB.seek(posicionMemoria + 84);
//        System.out.println(this.profesorDB.getFilePointer());

        this.profesorDB.writeInt(profesor.getExt());

        return true;
    }

    public boolean actualizar(Profesor profesor) {

        return false;
    }

    public boolean borrar(Profesor profesor) {
        return false;
    }

    public ArrayList<Profesor> listarTodo() throws IOException {
        for (long i = 0; i < this.profesorDB.length(); i = i + 88) {
            this.profesorDB.seek(i);
            id2 = this.profesorDB.readInt();
            System.out.println(id2);
            for (int j = 0; j < 20; j++) {
                nuevo3 = nuevo3 + this.profesorDB.readChar();
            }
            System.out.println(nuevo3);
            for (int k = 0; k < 20; k++) {
                nuevo4 = nuevo4 + this.profesorDB.readChar();
            }
            System.out.println(nuevo4);
            ext2 = this.profesorDB.readInt();
            System.out.println(ext2);
            System.out.println("");
        }
        return null;
    }

    public void ListarUnitario(int identificacion) throws IOException {
   
        long posm = arbol.Buscar(identificacion);
        this.profesorDB.seek(posm);
        id = this.profesorDB.readInt();
        for (int j = 0; j < 20; j++) {
            nuevo1 = nuevo1 + this.profesorDB.readChar();
        }
        for (int k = 0; k < 20; k++) {
            nuevo2 = nuevo2 + this.profesorDB.readChar();
        }
        ext = this.profesorDB.readInt();

    }

    public void destructor() throws IOException {
        this.profesorDB.close();
    }
}
