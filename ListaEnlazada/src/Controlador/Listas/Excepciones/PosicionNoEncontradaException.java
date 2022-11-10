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
public class PosicionNoEncontradaException extends Exception{
    
    public PosicionNoEncontradaException(String msg){
        super(msg);
        
    }
    
    public PosicionNoEncontradaException(){
        super("La posición dada está fuera de los límites");
    }
    
}
