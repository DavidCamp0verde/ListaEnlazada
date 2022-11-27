/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Listas;

import Controlador.Listas.Excepciones.ListaVaciaExcepcion;
import Controlador.Listas.Excepciones.PosicionNoEncontradaException;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@XmlRootElement
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private Integer size;

    public ListaEnlazada() {
        cabecera = null;
        size = 0;
    }

    public Boolean estaVacia() {
        return cabecera == null;
    }

    /*
    private Integer tamanio(){
        Integer tamanio = 0;
        NodoLista<E> aux = cabecera;
        
        while(aux != null){
            tamanio++;
            aux = aux.getSiguiente();
        }
        
        
        return tamanio;
    }*/
    public void insertar(E dato) {
        NodoLista<E> nodo = new NodoLista<>(dato, null);

        if (estaVacia()) {
            this.cabecera = nodo;

        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
        size++;
    }

    public void insertarCabecera(E dato) {
        
        if (estaVacia()) {
            insertar(dato);
        } else {
            NodoLista<E> nodo = new NodoLista<>(dato, null);
            nodo.setSiguiente(cabecera);
            cabecera = nodo;
            size++;
        }
    }
    
    public void insertarPosicion(E dato, Integer pos) throws PosicionNoEncontradaException{
        if(estaVacia()){
            insertar(dato);
        }else if(pos>=0 && pos < size){
            if(pos == 0){
                insertarCabecera(dato);
            } else{
                NodoLista<E> nodo = new NodoLista(dato, null);
                NodoLista<E> aux = cabecera;

                for (int i = 0; i < (pos-1); i++ ){
                    aux = aux.getSiguiente();
                }
                NodoLista<E> siguiente = aux.getSiguiente();
                aux.setSiguiente(nodo);
                nodo.setSiguiente(siguiente);
                size++;
            }
            
        }else{
            throw new PosicionNoEncontradaException();
        }
    }
    
    public void modificarPosicion(E dato, Integer pos) throws PosicionNoEncontradaException{
        if(estaVacia()){
            insertar(dato);
        }else if(pos>=0 && pos < size){
            if(pos == 0){
                cabecera.setDato(dato);
            } else{
                
                NodoLista<E> aux = cabecera;

                for (int i = 0; i < pos; i++ ){
                    aux = aux.getSiguiente();
                }
                aux.setDato(dato);
            }
            
        }else{
            throw new PosicionNoEncontradaException();
        }
    }
    
    public E obtener(Integer pos) throws ListaVaciaExcepcion, PosicionNoEncontradaException{
        
        if(!estaVacia()){
            E dato = null;
            if (pos>= 0 && pos < size){
                if(pos == 0){
                    dato = cabecera.getDato();
                }else{
                    NodoLista<E> aux = cabecera;

                    for (int i = 0; i < pos; i++ ){
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }
                
            } else throw new PosicionNoEncontradaException();
            return dato;
        }else throw new ListaVaciaExcepcion();
        
        
    }
    
    public E eliminar (Integer pos) throws ListaVaciaExcepcion, PosicionNoEncontradaException{
        System.out.println("pos "+pos);
        if(!estaVacia()){
            E dato = null;
            if (pos>= 0 && pos < size){
                if(pos == 0){
                    dato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    size--;
                    
                }else{
                    NodoLista<E> aux = cabecera;

                    for (int i = 0; i < pos; i++ ){
                        aux = aux.getSiguiente();
                    }
                    
                    dato = aux.getDato();
                    NodoLista<E> proximo= aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    size--;
                }
                
            } else throw new PosicionNoEncontradaException();
            return dato;
        }else throw new ListaVaciaExcepcion();
        
        
    }

    public void imprimir() {
        System.out.println("-------------------------LISTA ENLAZADA-------------------------");
        NodoLista<E> aux = cabecera;
        while (aux != null) {
            System.out.println(aux.getDato().toString());
            aux = aux.getSiguiente();
        }
        System.out.println("-------------------------LISTA ENLAZADA-------------------------");
    }

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
