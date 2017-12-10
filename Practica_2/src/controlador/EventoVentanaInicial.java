/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaDepartamento;
import vista.VentanaEmpleado;
import vista.VentanaEmpresa;
import vista.VentanaInicial;
/**
 *
 * @author Marcelo11
 */
public class EventoVentanaInicial implements ActionListener{
    private VentanaInicial ventanaInicial;

    public EventoVentanaInicial(VentanaInicial ventanaInicial) {
        this.ventanaInicial = ventanaInicial;
    }

    public VentanaInicial getVentanaInicial() {
        return ventanaInicial;
    }

    public void setVentanaInicial(VentanaInicial ventanaInicial) {
        this.ventanaInicial = ventanaInicial;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(this.ventanaInicial.getItemMenuList().get(0))){
            VentanaEmpresa vE = new VentanaEmpresa(this.ventanaInicial.getgD());
            vE.setVisible(true);
        }
        
        if(e.getSource().equals(this.ventanaInicial.getItemMenuList().get(1))){
            VentanaDepartamento vD = new VentanaDepartamento(this.ventanaInicial.getgD());
            vD.setVisible(true);
            
        }
        
        if(e.getSource().equals(this.ventanaInicial.getItemMenuList().get(2))){
            VentanaEmpleado vE = new VentanaEmpleado(this.ventanaInicial.getgD());
            vE.setVisible(true);
            
        }
        
    }
    
}
