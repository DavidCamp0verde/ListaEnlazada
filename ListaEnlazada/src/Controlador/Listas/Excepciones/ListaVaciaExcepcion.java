/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Listas.Excepciones;

/**
 *
 * @author david
 */
public class ListaVaciaExcepcion extends Exception{
    
    public ListaVaciaExcepcion(String msg){
        super(msg);
    }
    
    public ListaVaciaExcepcion(){
        super("La lista esta vacia");
    }
}
