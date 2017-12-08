/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Empresa;
/**
 *
 * @author Marcelo11
 */
public class GestionDato {
    private List<Empleado> empleadoList;
    private List<Departamento> departamentoList;
    private List<Empresa> empresaList;

    public GestionDato(List<Empleado> empleadoList, List<Departamento> departamentoList, List<Empresa> empresaList) {
        this.empleadoList = empleadoList;
        this.departamentoList = departamentoList;
        this.empresaList = empresaList;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    public boolean addDepartamento(Departamento d) {
        return this.departamentoList.add(d);
    }
    
    public boolean addEmpresa(Empresa e) {
        return this.empresaList.add(e);
    }
    
    public boolean addEmpleado(Empleado em) {
        return this.empleadoList.add(em);
    }
    public Empleado buscarEmpleado(String empleado){
        for(Empleado e:this.getEmpleadoList()){
            if(e.getClass().equals(empleado)==true){
            return e;            
            }
        }
        return null;
    }
}