/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import modelo.Empleado;
import vista.VentanaEmpleado;

/**
 *
 * @author Estudiante
 */
public class EventoVentanaEmpleado implements ActionListener{
    private VentanaEmpleado ventanaEmpleado;

    public EventoVentanaEmpleado(VentanaEmpleado ventanaEmpleado) {
        this.ventanaEmpleado = ventanaEmpleado;
    }

    public VentanaEmpleado getVentanaEmpleado() {
        return ventanaEmpleado;
    }

    public void setVentanaEmpleado(VentanaEmpleado ventanaEmpleado) {
        this.ventanaEmpleado = ventanaEmpleado;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(this.ventanaEmpleado.getBoton1())){
            try{
            String ruta = this.ventanaEmpleado.getTxtList().get(0).getText();
            String departamento = this.ventanaEmpleado.getTxtList().get(1).getText();
            String nombre = this.ventanaEmpleado.getTxtList().get(2).getText();
            String apellido = this.ventanaEmpleado.getTxtList().get(3).getText();
            String fechaNac = this.ventanaEmpleado.getTxtList().get(4).getText();
            String cedula = (this.ventanaEmpleado.getTxtList().get(5).getText());
            
             Empleado empleado = new Empleado(this.ventanaEmpleado.getgD().buscarDepartamento(departamento),nombre,apellido,fechaNac,cedula);
            
            
            boolean retorno = false;
            for(Empleado e:this.ventanaEmpleado.getgD().getEmpleadoList()){
                if(cedula.equals(e.getCedula())==true){
                    retorno=true;
                    break;
                }
            }
             if(retorno==true){
            
                throw new TestException("no debe ser repetido");
             }
             else{
                this.ventanaEmpleado.getgD().addEmpleado(empleado);
           
             }
            
           
            
            Object[][] dato= this.ventanaEmpleado.cargaDatosTabla(this.ventanaEmpleado.getgD().getEmpleadoList().size(), 3);
            this.ventanaEmpleado.setDatos(dato);
            this.ventanaEmpleado.getModeloTabla().setDataVector(this.ventanaEmpleado.getDatos(), this.ventanaEmpleado.getEncabezado());
            
            
            }
            catch(TestException te){
                
                JOptionPane.showMessageDialog(ventanaEmpleado, "No ingresar Empleados Repetidos", "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(java.lang.NullPointerException npe){
                JOptionPane.showMessageDialog(ventanaEmpleado, "Ingrese los datos en todas las casillas", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        if(ae.getSource().equals(this.ventanaEmpleado.getBoton2())){
           this.ventanaEmpleado.getTxtList().get(0).setText("");
           this.ventanaEmpleado.getTxtList().get(1).setText("");
           this.ventanaEmpleado.getTxtList().get(2).setText("");
           this.ventanaEmpleado.getTxtList().get(3).setText("");
           this.ventanaEmpleado.getTxtList().get(4).setText("");
           this.ventanaEmpleado.getTxtList().get(5).setText("");
        }
            
        
    }

    
    
    
    
}
