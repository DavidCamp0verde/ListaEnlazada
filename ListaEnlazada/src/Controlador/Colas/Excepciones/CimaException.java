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
public class CimaException extends Exception{
    
    public CimaException(){
       super("La cola esta llena");
    }
    
    public CimaException(String msg){
        super(msg);
    }
}
