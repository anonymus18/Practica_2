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
public class Departamento {
    private Empresa empresa;
    private String nombreDepartamento;

    public Departamento(Empresa empresa, String nombreDepartamento) {
        this.empresa = empresa;
        this.nombreDepartamento = nombreDepartamento;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    @Override
    public String toString() {
        return empresa + " / " + nombreDepartamento;
    }

    
}
