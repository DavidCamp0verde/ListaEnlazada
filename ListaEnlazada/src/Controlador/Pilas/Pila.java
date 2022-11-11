/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Pilas;
import Controlador.Listas.Excepciones.ListaVaciaExcepcion;
import Controlador.Listas.Excepciones.PosicionNoEncontradaException;
import Controlador.Listas.ListaEnlazada;
import Controlador.Pilas.Excepciones.PilaLlenaException;
import Controlador.Pilas.Excepciones.PilaVaciaException;

/**
 *
 * @author david
 */
public class Pila<E> extends ListaEnlazada<E> {
    private Integer tope;

    public Pila() {
    }

    public Pila(Integer tope) {
        this.tope = tope;
    }
    
    public Boolean estaLleno(){
        return tope == getSize();
    }
    
    public void push(E dato) throws PilaLlenaException{
        if(!estaLleno()){
            insertarCabecera(dato);
        } else throw new PilaLlenaException();
    }
    
    public E pop() throws PilaVaciaException, ListaVaciaExcepcion, PosicionNoEncontradaException{
        if (!estaVacia()){
            E dato = eliminar(0);
            
            return dato;
        } else throw new PilaVaciaException();
    }
    
}
