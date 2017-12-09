/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
/**
 *
 * @author Marcelo11
 */
public class Empresa {
    private String nombre;
    private String ciudad;
    private String ruc;

    public Empresa(String nombre, String ciudad, String ruc) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    @Override
    public String toString() {
        return nombre + " / " + ciudad + " / " + ruc;
    }
    
    
    
}
