/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
    }

    
    
    
    
}
