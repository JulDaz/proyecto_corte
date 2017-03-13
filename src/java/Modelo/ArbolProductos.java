/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.TreeMap;

/**
 *
 * @author crist
 */
public class ArbolProductos {
    public static TreeMap<Integer, Long> arbol0 = new TreeMap<>();

    public void Ingresar(int numero, long posicion) {
        arbol0.put(numero, posicion);
    }

    public void ListarArbol() {
        arbol0.entrySet().stream().map((ent) -> ent.getValue()).forEachOrdered((p) -> {
            System.out.println(p);
        });
    }

    public long Buscar(int id) {
        long valor = 0;
        if (arbol0.containsKey(id) == true) {
            valor = arbol0.get(id);
        }
        return valor;
    }

    public boolean Existencia(int id) {
        boolean respues;
        respues = arbol0.containsKey(id) == true;
        return respues;
    }
}
