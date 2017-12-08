/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Departamento;
import vista.VentanaDepartamento;
/**
 *
 * @author Marcelo11
 */
public class EventoVentanaDepartamento implements ActionListener{
    private VentanaDepartamento ventanaDepartamento;

    public EventoVentanaDepartamento(VentanaDepartamento ventanaDepartamento) {
        this.ventanaDepartamento = ventanaDepartamento;
    }
    
    public VentanaDepartamento getVentanaDepartamento() {
        return ventanaDepartamento;
    }

    public void setVentanaDepartamento(VentanaDepartamento ventanaDepartamento) {
        this.ventanaDepartamento = ventanaDepartamento;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
            String r=this.ventanaDepartamento.getTxtList().get(0).getText();
            String e= this.ventanaDepartamento.getCombo().getSelectedItem().toString();
            String nE=this.ventanaDepartamento.getTxtList().get(0).getText();
            
            Departamento d = new Departamento(this.ventanaDepartamento.getgD().buscarEmpleado(e), nE);
            this.ventanaDepartamento.getgD().addDepartamento(d);
            
            Object [][] dato=this.ventanaDepartamento.cargaDatosTabla(this.ventanaDepartamento.getgD().getDepartamentoList().size(),3);
	this.ventanaDepartamento.setDatos(dato);
        this.ventanaDepartamento.getModeloTabla().setDataVector(this.ventanaDepartamento.getDatos(), this.ventanaDepartamento.getEncabezado());
    }
    
    
}
