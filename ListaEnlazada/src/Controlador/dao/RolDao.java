/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.dao;

import Modelo.Rol;

/**
 *
 * @author david
 */
public class RolDao extends AdaptadorDao<Rol>{
    
    private Rol rol;

    public RolDao() {
        super(Rol.class);
    }

    public Rol getRol() {
        if(rol == null)
            rol = new Rol();
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public boolean guardar() throws Exception{
        this.rol.setId(generarId());
        guardar(this.rol);
        return true;
    }
    
    public boolean modificar(Integer pos) throws Exception{
        modificiar(this.rol, pos);
        return true;
    }
    
    private Integer generarId(){
        return listar().getSize()+1;
    }
    
    public void crearRoles(){
        if(listar().estaVacia()){
            
            try {
                this.getRol().setNombre("Gerente");
                this.getRol().setDescripcion("Control de todo");
                this.setRol(rol);
                this.guardar();
                this.setRol(null);
                
                this.getRol().setNombre("Asistente");
                this.getRol().setDescripcion("Ayuda al gerente");
                this.setRol(rol);
                this.guardar();
                this.setRol(null);
                
                this.getRol().setNombre("Sistemas");
                this.getRol().setDescripcion("Tiene permisos sobre el sistema");
                this.setRol(rol);
                this.guardar();
                this.setRol(null);
                
                this.getRol().setNombre("Cliente");
                this.getRol().setDescripcion("Trae los dineros");
                this.setRol(rol);
                this.guardar();
                
            } catch (Exception e) {
            }
        }
    }
    
}
