/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Pilas.Excepciones;

/**
 *
 * @author david
 */
public class PilaVaciaException extends Exception{
    
    public PilaVaciaException(){
        super("La pila esta vacia");
    }
    
    public PilaVaciaException(String msg){
        super(msg);
    }
    
}
