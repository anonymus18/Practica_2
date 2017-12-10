/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoVentanaDepartamento;
import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Departamento;
import modelo.Empresa;
/**
 *
 * @author Marcelo11
 */
public class VentanaDepartamento extends JFrame{
    private List<JLabel> etiList;
    private List<JTextField> txtList;
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JPanel panelPrincipal;
    private GestionDato gD;
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    private JComboBox combo;
    
    public VentanaDepartamento(GestionDato gD) {
        super("Registrar Departamento");
        this.gD=gD;
        this.iniciaComponentes();
        this.setLocation(325, 50);
        this.setSize(325, 325);
        this.setDefaultCloseOperation(3);
    }
    public void iniciaComponentes(){
        this.etiList = new ArrayList<JLabel>();
        this.etiList.add(new JLabel("Buscar Ruta"));
        this.etiList.add(new JLabel("Ruta Seleccionada-> "));
        this.etiList.add(new JLabel("Empresa"));
        this.etiList.add(new JLabel("Nombre del Departamento"));
        
        
        this.txtList= new ArrayList<JTextField>();
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        
        this.combo = new JComboBox(this.cargarCombo());
        this.boton1 = new JButton("Guardar");
        this.boton2 = new JButton("Limpiar");
        this.boton3 = new JButton("Carpeta");
        
        LayoutManager disenioPrincipal = new BorderLayout();
        this.panelPrincipal = new JPanel(disenioPrincipal);
        LayoutManager disenioSup = new GridLayout(5,3);
        JPanel panelSup = new JPanel(disenioSup);
        
        this.encabezado = new Object[3];
        this.encabezado[0]= "Ruta";
        this.encabezado[1] = "Empresa";
        this.encabezado[2] = "Nombre Departamento";
        
        this.datos = this.cargaDatosTabla(this.gD.getDepartamentoList().size(),3);
        this.modeloTabla = new DefaultTableModel(this.datos,this.encabezado);
        this.tabla = new JTable(modeloTabla);
        this.scroll = new JScrollPane(tabla);
        
        panelSup.add(this.etiList.get(0));
        panelSup.add(this.boton3);
        
        panelSup.add(this.etiList.get(1));
        panelSup.add(this.txtList.get(0));
        
        panelSup.add(this.etiList.get(2));
        panelSup.add(this.combo);
        
        panelSup.add(this.etiList.get(3));
        panelSup.add(this.txtList.get(1));
        
        panelSup.add(this.boton1);
        panelSup.add(this.boton2);
        
        this.panelPrincipal.add(panelSup,BorderLayout.NORTH);
        this.panelPrincipal.add(this.scroll,BorderLayout.CENTER);
        
        this.boton1.addActionListener(new EventoVentanaDepartamento(this));
        this.boton2.addActionListener(new EventoVentanaDepartamento(this));
        this.boton3.addActionListener(new EventoVentanaDepartamento(this));
        
        
        this.add(this.panelPrincipal);
    }

    public Object[][] cargaDatosTabla(int h, int w){
         Object[][] retorno= new Object[h][w];
        int i=0;
        for(Departamento d:this.gD.getDepartamentoList())
        {
            retorno[i][0]="";
            retorno[i][1]=d.getEmpresa();
            retorno[i][2]=d.getNombreDepartamento();
            
            i++;
        }        
        return retorno;
       
    }
    
    public Object[] cargarCombo(){
        Object[] retorno = new Object[this.gD.getEmpresaList().size()];
        int i=0;
        for(Empresa e:this.gD.getEmpresaList()){
            retorno[i]=e.getNombre()+" | "+e.getCiudad();
            i++;
        }
        return retorno;
    }
     
     
    public List<JLabel> getEtiList() {
        return etiList;
    }

    public void setEtiList(List<JLabel> etiList) {
        this.etiList = etiList;
    }

    public List<JTextField> getTxtList() {
        return txtList;
    }

    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }

    public JButton getBoton1() {
        return boton1;
    }

    public void setBoton1(JButton boton1) {
        this.boton1 = boton1;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JComboBox getCombo() {
        return combo;
    }

    public void setCombo(JComboBox combo) {
        this.combo = combo;
    }

    public JButton getBoton2() {
        return boton2;
    }

    public void setBoton2(JButton boton2) {
        this.boton2 = boton2;
    }

    public JButton getBoton3() {
        return boton3;
    }

    public void setBoton3(JButton boton3) {
        this.boton3 = boton3;
    }
    
    
}
