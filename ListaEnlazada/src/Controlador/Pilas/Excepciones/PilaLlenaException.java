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
public class PilaLlenaException extends Exception{
    
    public PilaLlenaException(){
       super("La pila esta llena");
    }
    
    public PilaLlenaException(String msg){
        super(msg);
    }
}
