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
public class Empleado {
    private Departamento departamento;
    private String nombre;
    private String apellido;
    private String fechaNac;
    private String cedula;

    public Empleado(Departamento departamento, String nombre, String apellido, String fechaNac, String cedula) {
        this.departamento = departamento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.cedula = cedula;
    }
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    

    @Override
    public String toString() {
        return departamento + " / " + nombre + " / " + apellido + " / " + fechaNac + " / " + cedula;
    }
    
    
    
    
    
    
}
