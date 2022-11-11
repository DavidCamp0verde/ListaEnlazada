/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Colas.Excepciones;

/**
 *
 * @author david
 */
public class ColaVaciaException extends Exception{
    
    public ColaVaciaException(){
        super("La cola esta vacia");
    }
    
    public ColaVaciaException(String msg){
        super(msg);
    }
    
}
