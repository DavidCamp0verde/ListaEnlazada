/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Utilidades;

import Modelo.TipoIdentificacion;
import javax.swing.JComboBox;

/**
 *
 * @author david
 */
public class Utilidades {
    public static void cargarTipoIdentificacion(JComboBox cbx){
        cbx.removeAllItems();
        for(TipoIdentificacion tipo: TipoIdentificacion.values()){
            cbx.addItem(tipo);
        }
    }
    
    public static TipoIdentificacion obtenerTipoIdentificacion(JComboBox cbx){
        return (TipoIdentificacion) cbx.getSelectedItem();
    }
    
    
}
