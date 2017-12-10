/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
    
    public Empresa buscarEmpresa(String empresa)
    {
        for(Empresa e:this.getEmpresaList()){
            if((e.getNombre()+" | "+e.getCiudad()).equals(empresa)== true){
                return e;
            }
        }
        return null;
    }
       
    public Departamento buscarDepartamento(String departamento){
        for(Departamento d:this.getDepartamentoList()){
            if(d.getNombreDepartamento().equals(departamento)== true){
                return d;
            }
        }
        return null;
    }
    
    public boolean persistirEmpleadoList(List<Empleado> lista, File datosEmpleado){
        try{
            FileWriter ae = new FileWriter(datosEmpleado.getAbsolutePath(),true);
            BufferedWriter escritura = new BufferedWriter(ae);
            for(Empleado e:lista ){
            escritura.append(e.toString());
            escritura.newLine();
        }
           
            escritura.close();
           return true;     
        }
        catch(IOException e){
            return false;
        }
    }
    
    public boolean persistirDepartamentoList(List<Departamento> lista, File datosDepartamento){
        try{
            FileWriter ae = new FileWriter(datosDepartamento.getAbsolutePath(),true);
            BufferedWriter escritura = new BufferedWriter(ae);
            for(Departamento d:lista ){
            escritura.append(d.toString());
            escritura.newLine();
        }
           
            escritura.close();
           return true;     
        }
        catch(IOException dk){
            return false;
        }
    }
    
    public boolean persistirEmpresaList(List<Empresa> lista, File datosEmpresa){
        try{
            FileWriter ae = new FileWriter(datosEmpresa.getAbsolutePath(),true);
            BufferedWriter escritura = new BufferedWriter(ae);
            for(Empresa e:lista ){
            escritura.append(e.toString());
            escritura.newLine();
        }
           
            escritura.close();
           return true;     
        }
        catch(IOException ek){
            return false;
        }
    }
    
    public Empleado dividido(String direccion){
        String[] lineaArray= direccion.split(" / ");
        Empleado e = new Empleado(this.buscarDepartamento(lineaArray[0]),lineaArray[1],lineaArray[2],lineaArray[3],lineaArray[4]);
        return e;
    }
    
    public Departamento dividido1(String direccion){
        String[] lineaArray= direccion.split(" / ");
        Departamento d = new Departamento(this.buscarEmpresa(lineaArray[0]),lineaArray[1]);
        return d;
    }
    
    public Empresa dividido2(String direccion){
        String[] lineaArray= direccion.split(" / ");
        Empresa em = new Empresa(lineaArray[0], lineaArray[1], lineaArray[2]);
        return em;
    }
    
    public List<Empleado> LeerEmpleadoList(File datosEmpleado){
        try{
            List<Empleado> em = new ArrayList<Empleado>();
            FileReader ae = new FileReader(datosEmpleado.getAbsolutePath());
            BufferedReader lectura = new BufferedReader(ae); 
            String linea;
            while((linea=lectura.readLine())!=null){
                em.add(this.dividido(linea));
            }
            lectura.close();   
            return em;      
        }
        catch(IOException e){
            return null;
        }
    }
        
    public List<Departamento> LeerDepartamentoList(File datosDepartamento){
        try{
            List<Departamento> de = new ArrayList<Departamento>();
            FileReader ae = new FileReader(datosDepartamento.getAbsolutePath());
            BufferedReader lectura1 = new BufferedReader(ae); 
            String linea1;
            while((linea1=lectura1.readLine())!=null){
                de.add(this.dividido1(linea1));
            }
            lectura1.close();   
            return de;      
        }
        catch(IOException e){
            return null;
        }
    }
    
    public List<Empresa> LeerEmpresaList(File datosEmpresa){
        try{
            List<Empresa> em = new ArrayList<Empresa>();
            FileReader ae = new FileReader(datosEmpresa.getAbsolutePath());
            BufferedReader lectura = new BufferedReader(ae); 
            String linea;
            while((linea=lectura.readLine())!=null){
                em.add(this.dividido2(linea));
            }
            lectura.close();   
            return em;      
        }
        catch(IOException e){
            return null;
        }
    }
}