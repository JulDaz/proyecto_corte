/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author USER
 */
public class Inscripciones {
   
    
    int IdEst;
    int IdCurso;
    char[] Fecha_ins;
    char[] Fecha_fin;
    int nota;

    public Inscripciones(int IdEst, int IdCurso, char[] Fecha_ins, char[] Fecha_fin, int nota) {
        this.IdEst = IdEst;
        this.IdCurso = IdCurso;
        this.Fecha_ins = Fecha_ins;
        this.Fecha_fin = Fecha_fin;
        this.nota = nota;
    }

    public int getIdEst() {
        return IdEst;
    }

    public void setIdEst(int IdEst) {
        this.IdEst = IdEst;
    }

    public int getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(int IdCurso) {
        this.IdCurso = IdCurso;
    }

    public char[] getFecha_ins() {
        return Fecha_ins;
    }

    public void setFecha_ins(char[] Fecha_ins) {
        this.Fecha_ins = Fecha_ins;
    }

    public char[] getFecha_fin() {
        return Fecha_fin;
    }

    public void setFecha_fin(char[] Fecha_fin) {
        this.Fecha_fin = Fecha_fin;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Inscribciones{" + "IdEst=" + IdEst + ", IdCurso=" + IdCurso + ", Fecha_ins=" + Fecha_ins + ", Fecha_fin=" + Fecha_fin + ", nota=" + nota + '}';
    }

    
    
}
