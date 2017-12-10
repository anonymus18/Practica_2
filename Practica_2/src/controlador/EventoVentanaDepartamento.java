/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
        if (ae.getSource().equals(this.ventanaDepartamento.getBoton1())) {
            
            String ruta=this.ventanaDepartamento.getTxtList().get(0).getText();
            String empresa= this.ventanaDepartamento.getCombo().getSelectedItem().toString();
            String nombreEmpresa=this.ventanaDepartamento.getTxtList().get(1).getText();
            
            try {
                                
                Departamento d = new Departamento(this.ventanaDepartamento.getgD().buscarEmpresa(empresa),nombreEmpresa);

                boolean retorno = false;
                for (Departamento de : this.ventanaDepartamento.getgD().getDepartamentoList()) {
                    if (nombreEmpresa.equals(d.getNombreDepartamento()) == true) {
                        retorno = true;
                        break;
                    }
                }
                if (retorno == true) {

                    throw new TestException("Datos ya INGRESADOS");
                } else {
                    this.ventanaDepartamento.getgD().addDepartamento(d);

                }

                Object[][] dato = this.ventanaDepartamento.cargaDatosTabla(this.ventanaDepartamento.getgD().getDepartamentoList().size(), 3);
                this.ventanaDepartamento.setDatos(dato);
                this.ventanaDepartamento.getModeloTabla().setDataVector(this.ventanaDepartamento.getDatos(), this.ventanaDepartamento.getEncabezado());
                
                File guardarArchivo = new File(ruta);
                this.ventanaDepartamento.getgD().persistirDepartamentoList(this.ventanaDepartamento.getgD().getDepartamentoList(),guardarArchivo);
                this.ventanaDepartamento.getgD().LeerEmpleadoList(guardarArchivo);
                

            } catch (TestException te) {

                JOptionPane.showMessageDialog(ventanaDepartamento, "NO ingresar DEPARTAMENTOS repetidos", "ERROR!", JOptionPane.ERROR_MESSAGE);
            } catch (java.lang.NullPointerException npe) {
                JOptionPane.showMessageDialog(ventanaDepartamento, "Ingrese los DATOS en todas las CASILLAS", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (ae.getSource().equals(this.ventanaDepartamento.getBoton2())) {
            this.ventanaDepartamento.getTxtList().get(0).setText("");
            this.ventanaDepartamento.getTxtList().get(1).setText("");
            
        }

        if (ae.getSource().equals(this.ventanaDepartamento.getBoton3())) {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            JFrame frame = new JFrame("JComboBox Test");
            frame.setLayout(new FlowLayout());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile.getName());
            System.out.println(selectedFile.getAbsolutePath());   
                        
            frame.pack();
            frame.setVisible(true);
            
            this.ventanaDepartamento.getTxtList().get(0).setText(selectedFile.getAbsolutePath());   
        }
    }    
}
