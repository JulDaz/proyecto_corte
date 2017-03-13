/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import static javafx.scene.input.KeyCode.K;
import static javafx.scene.input.KeyCode.V;

/**
 *
 * @author crist
 */
public class ArbolProvedor {

    public static TreeMap<Integer, Long> arbol = new TreeMap<>();

    public void Ingresar(int numero, long posicion) {
        arbol.put(numero, posicion);
    }

    public void ListarArbol() {
        arbol.entrySet().stream().map((ent) -> ent.getValue()).forEachOrdered((p) -> {
            System.out.println(p);
        });
    }

    public long Buscar(int id) {
        long valor = 0;
        if (arbol.containsKey(id) == true) {
            valor = arbol.get(id);
        }
        return valor;
    }

    public boolean Existencia(int id) {
        boolean respues;
        respues = arbol.containsKey(id) == true;
        return respues;
    }
}
