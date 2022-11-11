/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Colas;

import Controlador.Colas.Excepciones.CimaException;
import Controlador.Colas.Excepciones.ColaVaciaException;
import Controlador.Listas.Excepciones.ListaVaciaExcepcion;
import Controlador.Listas.Excepciones.PosicionNoEncontradaException;
import Controlador.Listas.ListaEnlazada;

/**
 *
 * @author david
 */
public class Cola<E> extends ListaEnlazada<E>{
    private Integer cima;

    public Cola(Integer cima) {
        this.cima = cima;
    }
    
    public Boolean estaLleno(){
        return cima == getSize();
    }
    
    public void queue(E dato) throws PosicionNoEncontradaException, CimaException{
        if(!estaLleno()){
            insertar(dato);
        } else throw new CimaException();
    }
    
    public E dequeue() throws ColaVaciaException, ListaVaciaExcepcion, PosicionNoEncontradaException {
        if (!estaVacia()){
            E dato = eliminar(0);
            return dato;
            
        } else throw new ColaVaciaException();
    }
}
