/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Utiles;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

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
    
    public static Field obtenerAtributo(Class clase, String nombre){ //Devuelve que tipo de dato es el atributo enviado
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
        } else if(atributo.getType().isEnum()){
            Enum enumeracion = Enum.valueOf((Class)atributo.getType(), dato.toString());
            transformar = enumeracion;
        }
        else{
            transformar = dato;
        }
        return transformar;
    }
    
    
    public static String encriptar(String dato){
        return Base64.getEncoder().encodeToString(dato.getBytes());
    }
    
    public static String desencriptar(String dato){
        return new String(Base64.getDecoder().decode(dato));
    }
    
    //Otra forma
    
    public static SecretKeySpec crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        byte[] claveEncription = clave.getBytes("UTF-8");
        //MessageDigest sha = MessageDigest.getInstance("SHA-1");
        //claveEncription = sha.digest(claveEncription);
        claveEncription = Arrays.copyOf(claveEncription, 16);
        SecretKeySpec keySpec = new SecretKeySpec(claveEncription, "AES");
        return keySpec;
    }
    
    public static String encriptarClave(final String datos, final String claveSecreta) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        byte[] decodeKey = Base64.getDecoder().decode(claveSecreta);
        SecretKey secretKeySpec = crearClave(new String(decodeKey));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        
        //byte[] datosEncriptar = datos.getBytes("UTF8");
        byte[] bytesEncriptar = cipher.doFinal(datos.getBytes("UTF8"));
        //String encriptado = encriptar(new String(bytesEncriptar));
        return Base64.getEncoder().encodeToString(bytesEncriptar);
    }
    
    public static String desencriptarClave(final String datos, final String claveSecreta) throws UnsupportedEncodingException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
        byte[] decodeKey = Base64.getDecoder().decode(claveSecreta);
        SecretKey secretKeySpec = crearClave(new String (decodeKey));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        
        byte[] bytesEncriptados = Base64.getDecoder().decode(datos);
        byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
        return new String(datosDesencriptados);
    }
    
    public static void main (String[] args){
        //System.out.println(Utilidades.encriptar("David"));
        //System.out.println(Utilidades.desencriptar("RGF2aWQ="));
        try {
            String claveSecreta = "ABC123";
            System.out.println(Utilidades.encriptarClave("David", claveSecreta));
            System.out.println(Utilidades.desencriptarClave("2nnJOdN+mDwWm9im4TMNeg==", claveSecreta));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
}
