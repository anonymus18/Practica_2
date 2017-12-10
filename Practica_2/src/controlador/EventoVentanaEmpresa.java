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
import modelo.Empresa;
import vista.VentanaEmpresa;

/**
 *
 * @author Marcelo11
 */
public class EventoVentanaEmpresa implements ActionListener{
    private VentanaEmpresa ventanaEmpresa;

    public EventoVentanaEmpresa(VentanaEmpresa ventanaEmpresa) {
        this.ventanaEmpresa = ventanaEmpresa;
    }

    public VentanaEmpresa getVentanaEmpresa() {
        return ventanaEmpresa;
    }

    public void setVentanaEmpresa(VentanaEmpresa ventanaEmpresa) {
        this.ventanaEmpresa = ventanaEmpresa;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(this.ventanaEmpresa.getBoton1())) {
            String ruta = this.ventanaEmpresa.getTxtList().get(0).getText();
            String nombre = this.ventanaEmpresa.getTxtList().get(1).getText();
            String ciudad = this.ventanaEmpresa.getTxtList().get(2).getText();
            String ruc = this.ventanaEmpresa.getTxtList().get(3).getText();
        
            try {
                Empresa empresa = new Empresa(nombre, ciudad, ruc);
                boolean retorno = false;
                for (Empresa em : this.ventanaEmpresa.getgD().getEmpresaList()) {
                    if (ruc.equals(em.getRuc()) == true) {
                        retorno = true;
                        break;
                    }
                }
                if (retorno == true) {

                    throw new TestException("Datos ya INGRESADOS");
                } else {
                    this.ventanaEmpresa.getgD().addEmpresa(empresa);

                }

                Object[][] dato = this.ventanaEmpresa.cargaDatosTabla(this.ventanaEmpresa.getgD().getEmpresaList().size(), 4);
                this.ventanaEmpresa.setDatos(dato);
                this.ventanaEmpresa.getModeloTabla().setDataVector(this.ventanaEmpresa.getDatos(), this.ventanaEmpresa.getEncabezado());
                
                File guardarArchivo = new File(this.ventanaEmpresa.getBoton3().getActionCommand());
                this.ventanaEmpresa.getgD().persistirEmpresaList(this.ventanaEmpresa.getgD().getEmpresaList(),guardarArchivo);
                this.ventanaEmpresa.getgD().LeerEpresaList(guardarArchivo);
                

            } catch (TestException te) {

                JOptionPane.showMessageDialog(ventanaEmpresa, "NO ingresar EMPRESAS repetidas", "ERROR!", JOptionPane.ERROR_MESSAGE);
            } catch (java.lang.NullPointerException npe) {
                JOptionPane.showMessageDialog(ventanaEmpresa, "Ingrese los DATOS en todas las CASILLAS", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (ae.getSource().equals(this.ventanaEmpresa.getBoton2())) {
            this.ventanaEmpresa.getTxtList().get(0).setText("");
            this.ventanaEmpresa.getTxtList().get(1).setText("");
            this.ventanaEmpresa.getTxtList().get(2).setText("");
            this.ventanaEmpresa.getTxtList().get(3).setText("");
            
        }

        if (ae.getSource().equals(this.ventanaEmpresa.getBoton3())) {
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
            
            this.ventanaEmpresa.getTxtList().get(0).setText(selectedFile.getAbsolutePath());   
        }
    }    


    
    
}
