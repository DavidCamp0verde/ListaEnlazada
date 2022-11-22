/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.dao;

import Controlador.Listas.ListaEnlazada;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author david
 */
public interface InterfazDao <T>{
    
    public void guardar(T dato) throws FileNotFoundException, JAXBException;
    public void modificiar(T dato);
    public ListaEnlazada<T> listar();
    public T obtener(Integer id);
    
    
}
