/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Utiles;

import java.lang.reflect.Field;

/**
 *
 * @author david
 */
public class Utilidades {
    public static String capitalizar(String nombre){
        char[] aux = nombre.toCharArray();
        aux[0] = Character.toUpperCase(aux[0]);
        return new String (aux);
    }
    
    public static Field obtenerAtributo(Class clase, String nombre){
        Field atributo = null;
        for(Field aux : clase.getDeclaredFields()){
            if(nombre.equalsIgnoreCase(aux.getName())){
                atributo = aux;
                break;
            }
        }
        return atributo;
    }
    
    
    public static Object transformarDato(Field atributo, String dato){
        Object transformar = null;
        if(atributo.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")){
            if(atributo.getType().getSimpleName().equals("Integer")){
                transformar = Integer.parseInt(dato);
            }
        }else{
            transformar = dato;
        }
        return transformar;
    }
    
}
