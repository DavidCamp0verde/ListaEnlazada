/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaenlazada;

import Controlador.Colas.Cola;
import Controlador.Listas.Excepciones.ListaVaciaExcepcion;
import Controlador.Listas.Excepciones.PosicionNoEncontradaException;
import Controlador.Listas.ListaEnlazada;
import Controlador.Pilas.Pila;

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
            lista.insertarPosicion(12, 0);
            lista.insertarPosicion(36, 2);
            Integer pos = 1;
            System.out.println("Elemento en posicion "+pos+": "+lista.obtener(pos));
        } catch (PosicionNoEncontradaException | ListaVaciaExcepcion e) {
            System.out.println(e.getMessage());
        }
        
        
        lista.imprimir();
        System.out.println(lista.getSize());
        
//        Pila<String> pila = new Pila<>(8);
//        try {
//            pila.push("Chimbo");
//            pila.push("David");
//            pila.push("Nivelo");
//            pila.push("Steven");
//            pila.push("Peter");
//            pila.imprimir();
//            
//            pila.pop();
//            pila.imprimir();
//        
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        
//        Cola<String> cola = new Cola<>(8);
//        try {
//            cola.queue("Peter");
//            cola.queue("David");
//            cola.queue("Steven");
//            cola.queue("Nivelo");
//            cola.imprimir();
//            
//            cola.dequeue();
//            cola.imprimir();
//            cola.dequeue();
//            cola.imprimir();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }


        
    }
    
}
