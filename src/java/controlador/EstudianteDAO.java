/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Estudiantes;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import Modelo.ArbolEstudiantes;

/**
 *
 * @author crist
 */
public class EstudianteDAO {
    private RandomAccessFile EstudianteDB;
    private ArbolEstudiantes arbol = new ArbolEstudiantes();
    public int id;
    public String nuevo1="";
    public String nuevo2="";
    public int tel;
    
    public int id2;
    public String nuevo3="";
    public String nuevo4="";
    public int tel2;
    
    public EstudianteDAO() throws FileNotFoundException {
        this.EstudianteDB = new RandomAccessFile("C:\\Users\\crist\\Desktop\\estudiante.txt", "rw");
    }
  
   
    public boolean insertar(Estudiantes estudiante) throws IOException {
        long posicionMemoria = this.EstudianteDB.length();
        this.EstudianteDB.seek(posicionMemoria);

        arbol.Ingresar(estudiante.getId(), posicionMemoria);
        this.EstudianteDB.writeInt(estudiante.getId());
        
        for (int i = 0; i < estudiante.getNombre().length; i++) {
            char letra = estudiante.getNombre()[i];
            this.EstudianteDB.writeChar(letra);
        }
        this.EstudianteDB.seek(posicionMemoria + 44);

        for (int i = 0; i < estudiante.getApellido().length; i++) {
            char letra2 = estudiante.getApellido()[i];
            this.EstudianteDB.writeChar(letra2);
        }
        this.EstudianteDB.seek(posicionMemoria + 84);

        this.EstudianteDB.writeInt(estudiante.getTelefono());

        return true;
    }

    public boolean actualizar(Estudiantes estudiante) {

        return false;
    }

    public boolean borrar(Estudiantes estudiante) {
        return false;
    }

    public ArrayList<Estudiantes> listarTodo() throws IOException {
        for (long i = 0; i < this.EstudianteDB.length(); i = i + 88) {
            this.EstudianteDB.seek(i);
            id2 = this.EstudianteDB.readInt();
            System.out.println(id2);
            for (int j = 0; j < 20; j++) {
                nuevo3 = nuevo3 + this.EstudianteDB.readChar();
            }
            System.out.println(nuevo3);
            for (int k = 0; k < 20; k++) {
                nuevo4 = nuevo4 + this.EstudianteDB.readChar();
            }
            System.out.println(nuevo4);
            tel2 = this.EstudianteDB.readInt();
            System.out.println(tel2);
            System.out.println("");
        }
        return null;
    }

    public void ListarUnitario(int identificacion) throws IOException {

        long posm = arbol.Buscar(identificacion);
        this.EstudianteDB.seek(posm);
        id = this.EstudianteDB.readInt();
        for (int j = 0; j < 20; j++) {
            nuevo1 = nuevo1 + this.EstudianteDB.readChar();
        }
        for (int k = 0; k < 20; k++) {
            nuevo2 = nuevo2 + this.EstudianteDB.readChar();
        }
        tel = this.EstudianteDB.readInt();
    }

    public void destructor() throws IOException {
        this.EstudianteDB.close();
    }

}
