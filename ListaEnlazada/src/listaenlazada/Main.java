/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaenlazada;

import Controlador.Listas.Excepciones.ListaVaciaExcepcion;
import Controlador.Listas.Excepciones.PosicionNoEncontradaException;
import Controlador.Listas.ListaEnlazada;

/**
 *
 * @author david
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.insertar(1);
        lista.insertar(50);
        lista.insertar(200);
        lista.insertar(300);
        lista.insertarCabecera(5);
        
        try {
            lista.insertarPosicion(12, 4);
            Integer pos = 1;
            System.out.println("Elemento en posicion "+pos+": "+lista.obtener(pos));
        } catch (PosicionNoEncontradaException | ListaVaciaExcepcion e) {
            System.out.println(e.getMessage());
        }
        
        lista.imprimir();
        System.out.println(lista.getSize());
        
        
    }
    
}
