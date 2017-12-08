/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionDato;
import java.util.ArrayList;
import java.util.List;
import modelo.Departamento;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Empleado;
import modelo.Empresa;
import modelo.Empresa;
import vista.VentanaInicial;
import vista.VentanaInicial;

/**
 *
 * @author Marcelo11
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Empleado> empleado = new ArrayList<Empleado>();
        List<Departamento> departamento = new ArrayList<Departamento>();
        List<Empresa> empresa = new ArrayList<Empresa>();
        
        GestionDato gD = new GestionDato(empleado, departamento, empresa);
        
        VentanaInicial vI = new VentanaInicial(gD);
        vI.setVisible(true);
    }
    
}
