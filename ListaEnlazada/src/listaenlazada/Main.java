/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaenlazada;

import Controlador.Listas.Excepciones.ListaVaciaExcepcion;
import Controlador.Listas.Excepciones.PosicionNoEncontradaException;
import Controlador.Listas.ListaEnlazada;
import Controlador.Utiles.Utilidades;
import Controlador.dao.AdaptadorDao;
import Modelo.Persona;
import Modelo.Rol;
import java.lang.reflect.Field;

/**
 *
 * @author david
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
//        lista.insertar(1);
//        lista.insertar(50);
//        lista.insertar(200);
//        lista.insertar(300);
//        lista.insertarCabecera(5);
//        
//        try {
//            lista.insertarPosicion(12, 3);
//            //lista.insertarPosicion(36, 2);
//            Integer pos = 1;
//            System.out.println("Elemento en posicion "+pos+": "+lista.obtener(pos));
//        } catch (PosicionNoEncontradaException | ListaVaciaExcepcion e) {
//            System.out.println(e.getMessage());
//        }
//        
//        
//        lista.imprimir();
//        System.out.println(lista.getSize());
//        
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

//        AdaptadorDao<Rol> ad = new AdaptadorDao<Rol>(Rol.class);
//        Rol aux = new Rol();
//        aux.setId(2);
//        aux.setNombre("cajero");
//        aux.setDescripcion("cajero descripcion xd");
//        
//        try {
//            ad.guardar(aux);
////            ad.listar();
////            Field a = Utilidades.obtenerAtributo(Rol.class, "id");
//            ad.listar().imprimir();
////            System.out.println(a.getType().getSimpleName());
//            //Utilidades.obtenerAtributo(aux.getClass(), "");
//        } catch (Exception e) {
//        }
        AdaptadorDao<Persona> ad = new AdaptadorDao<Persona>(Persona.class);
        
        try {
            Persona p = new Persona();
            
            p.setApellidos("Chimbo");
            p.setNombres("Jhandry");
            p.setId(2);
            ad.guardar(p);
        } catch (Exception e) {
        }
        
    }
    
}
