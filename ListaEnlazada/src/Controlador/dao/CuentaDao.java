/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.dao;

import Controlador.Utiles.Utilidades;
import Modelo.Cuenta;
import Controlador.dao.PersonaDao;
import Modelo.TipoIdentificacion;

/**
 *
 * @author david
 */
public class CuentaDao extends AdaptadorDao<Cuenta>{
    private Cuenta cuenta;
    private String clave ="ABC123";

    public CuentaDao() {
        super(Cuenta.class);
    }

    public Cuenta getCuenta() {
        if(cuenta == null)
            cuenta = new Cuenta();
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    public boolean guardar() throws Exception{
        this.cuenta.setId(generarId());
        this.cuenta.setClave(Utilidades.encriptarClave(this.cuenta.getClave(), clave));
        guardar(this.cuenta);
        return true;
    }
    
    public boolean modificar(Integer pos) throws Exception{
        modificar(this.cuenta, pos);
        return true;
    }
    
    private Integer generarId(){
        return listar().getSize()+1;
    }
    
    public void crearCuenta(){
        if(listar().estaVacia()){
            try {
                PersonaDao pd = new PersonaDao();
                pd.getPersona().setApellidos("Administrador");
                pd.getPersona().setNombres("Administrador");
                pd.getPersona().setCorreo("admin@admin.com");
                pd.getPersona().setIdentificacion("1111111111");
                pd.getPersona().setTipoIdentificacion(TipoIdentificacion.CEDULA);
                pd.getPersona().setId_rol(3);
                pd.guardar();
                this.getCuenta().setUsuario(pd.getPersona().getCorreo());
                this.getCuenta().setEstado(Boolean.TRUE);
                this.getCuenta().setId_persona(pd.getPersona().getId());
                this.getCuenta().setClave("admin123");
                this.guardar();
                pd.setPersona(null);
                this.setCuenta(null);
                
                pd.getPersona().setApellidos("Final");
                pd.getPersona().setNombres("Consumidor");
                pd.getPersona().setCorreo("consumidor@admin.com");
                pd.getPersona().setIdentificacion("999999999");
                pd.getPersona().setTipoIdentificacion(TipoIdentificacion.CEDULA);
                pd.getPersona().setId_rol(4);
                pd.guardar();
                
            } catch (Exception e) {
            }
            
        }
    }
    
    
}

