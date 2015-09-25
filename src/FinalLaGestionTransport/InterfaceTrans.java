package FinalLaGestionTransport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import Bbdd.Disparador;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class InterfaceTrans extends InterfazComun{
    
    private JTabbedPane separador;
    private JPanel panel1; 
    private JTextField cajaId_Transporte,cajaId_Cliente,cajaId_Producto,cajaTipo_Viaje;
    private JLabel lblId_Transporte,lblId_Cliente,lblId_Producto,lblTipo_Viaje,lblFechaEnvio,lblFechaRecepcion;
    private JButton guardar,borrar;
    private JScrollPane sp;
    private JTable tabla;
    private JMenuItem abrir;
    private static JFileChooser archivo;
        
   //----------- Calendario dateChooser --------------------------
       private final JDateChooser dateRecep = new JDateChooser();
       private JDateChooser dateEnvio;
       @SuppressWarnings("rawtypes")
       private JComboBox comboBox;
       private JButton btnOk;
       private JButton btnNewButton;
       private JLabel lblModuloTransporte;
        
     //---------------A partir de aqui metodo del JFileChooser-----------------
       //---------------------------------------------------------
       @SuppressWarnings("unused")
	private static void metodo_archivo() throws Throwable{
            
           archivo = new JFileChooser();
           archivo.setCurrentDirectory(new File("/"));
           archivo.setFileFilter(new javax.swing.filechooser.FileFilter(){
                
               public boolean accept(File f){
                   return f.getName().toLowerCase().endsWith(".doc") || f.isDirectory();
               }
                
               public String getDescription(){
                    
                   return "Documentos de Word";
               }
           });
            
           int r=archivo.showOpenDialog(null);
           if (r==JFileChooser.APPROVE_OPTION) {
               String path=archivo.getSelectedFile().getPath();
               Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+path);
           }
           else if (r == JFileChooser.CANCEL_OPTION) {
               JOptionPane.showMessageDialog(null, "Ha cancelado su selección");
           }
           else {
               JOptionPane.showMessageDialog(null, "Se ha producido un error en la selección");
           }
            
       }
    
       @SuppressWarnings({ "unchecked", "rawtypes" })
	public InterfaceTrans(){
            
            
           setTitle("Pantalla Principal");
           setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           setExtendedState(MAXIMIZED_BOTH);//asi se ajusta el marco al maximo de la pantalla
           //donde se ejecute el programa
           setResizable(true);
           setVisible(true);
            
           //Quito la visibilidad de los elementos del padre que no necesito
           super.contentPane.setVisible(false); //para que se vea mi Panel en vez del gris heredado
           super.menu2.setVisible(false);
           super.tb1.setVisible(false);
            
           //Añado a la barra los elementos que si necesito
            
           abrir=new JMenuItem("Abrir...   Alt+B");
           abrir.setMnemonic('B');
           abrir.setIcon(new ImageIcon(InterfaceTrans.class.getResource("")));  //para colocar un icono
           abrir.addActionListener(new ActionListener(){
                
               public void actionPerformed(ActionEvent ae) {
                   try {
                	   InterfaceTrans.metodo_archivo();
                   } catch (Throwable e) {
                       e.printStackTrace();
                   }
                    
               }
                
           });
           super.menu1.add(abrir);
            
        //-------------- Tabla ----------------------------------------------
        //-------------------------------------------------------------------
           String filas[][] = {
                   {" "," "," ","","",""},
                   {" "," "," ","","",""},
                   {" "," "," ","","",""},
                   {" "," "," ","","",""},
                   {" "," "," ","","",""},
                   {" "," "," ","","",""},
                   {" "," "," ","","",""},
                   {" "," "," ","","",""},
                   {" "," "," ","","",""},
                   {" "," "," ","","",""},
                   {" "," "," ","","",""},
                   {" "," "," ","","",""},
                   {" "," "," ","","",""},
                   {" "," "," ","","",""},
                   {" "," "," ","","",""},
                   {" "," "," ","","",""},
                   {" "," "," ","","",""},
                   {" "," "," ","","",""},
                   {" "," "," ","","",""}
           };
            
           String columnas[]={" N\u00BA Transporte "," ID Cliente "," ID Producto "," Tipo Viaje "," Fecha Envio ", " Fecha Recogida "};
            
           tabla=new JTable(filas,columnas);
           tabla.setShowVerticalLines(false); //No queremos ver las lineas verticales
           tabla.setShowHorizontalLines(false); //No queremos ver las lineas verticales
           tabla.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); //se puede seleccionar mas de una fila
           tabla.setVisible(true);
            
           sp=new JScrollPane(tabla); //Necesita un Scrol para que se vean las columnas
           sp.setBounds(608, 182, 616, 337);
  
           //---------------------------------------------------------
           //-------A partir de aqui el tabbedPaned-------------------
           //---------------------------------------------------------
            
           separador = new JTabbedPane();
           panel1=new JPanel();
           panel1.setBackground(Color.LIGHT_GRAY); //asi le damos color al panel
           panel1.setLayout(null);
           lblId_Transporte=new JLabel("N\u00BA Transporte:");
           lblId_Transporte.setFont(new Font("Arial",Font.BOLD,13));
           lblId_Cliente=new JLabel("ID Cliente:");
           lblId_Cliente.setFont(new Font("Arial",Font.BOLD,13));
           lblId_Producto=new JLabel("ID Producto:");
           lblId_Producto.setFont(new Font("Arial",Font.BOLD,13));
           lblTipo_Viaje=new JLabel("Tipo Viaje:");
           lblTipo_Viaje.setFont(new Font("Arial",Font.BOLD,13));
           lblFechaEnvio=new JLabel("Fecha Envio:");
           lblFechaEnvio.setFont(new Font("Arial",Font.BOLD,13));
           lblFechaRecepcion=new JLabel("Fecha Rcogida:");
           lblFechaRecepcion.setFont(new Font("Arial",Font.BOLD,13));
             
           //----------cajas de texto ----------------
            
           cajaId_Transporte=new JTextField();
           cajaId_Transporte.setEnabled(false);
           cajaId_Cliente=new JTextField();
           cajaId_Producto=new JTextField();
           cajaTipo_Viaje=new JTextField();
            
          //--------botones------------------- 
            
           guardar = new JButton("Guardar");
           guardar.addActionListener(new ActionListener(){
                
               public void actionPerformed(ActionEvent e) {
                    
                   // Aqui es donde pondre el codigo que almacene en la base de datos 
                   // lo que se introduzca en los campos
               }
                
           });
            
           borrar= new JButton("Borrar");
           borrar.addActionListener(new ActionListener(){
                
               public void actionPerformed(ActionEvent e) { //usado para dejar las cajas de texto vacías 
                    
                   cajaId_Transporte.setText(null);
                   cajaId_Cliente.setText(null);
                   cajaId_Producto.setText(null);
                   cajaTipo_Viaje.setText(null);
                   dateRecep.setCalendar(null);
                   dateEnvio.setCalendar(null); //vaciamos la caja del calendario
                  
               }
                
           });
           lblId_Transporte.setBounds(73, 181, 187, 28);
           lblId_Cliente.setBounds(73, 220, 187, 30);
           lblId_Producto.setBounds(73, 261, 187, 30);
           lblTipo_Viaje.setBounds(73, 302, 187, 30);
           lblFechaEnvio.setBounds(73, 343, 187, 28);
           lblFechaRecepcion.setBounds(73, 382, 187, 30);
             
           //----------Cajas-------------
            
           cajaId_Transporte.setBounds(270, 179, 124, 30);
           cajaId_Cliente.setBounds(270, 221, 250, 30);
           cajaId_Producto.setBounds(270, 262, 250, 30);
           cajaTipo_Viaje.setBounds(270, 302, 85, 30);
            
           //----------Botones-------------
            
           guardar.setBounds(270, 423, 85, 30);
           borrar.setBounds(435, 423, 85, 30);

           dateRecep.setBounds(270, 382, 250, 30);
           panel1.add(sp);
            
           panel1.add(guardar);
           panel1.add(borrar);
           panel1.add(lblId_Transporte);
           panel1.add(lblId_Cliente);
           panel1.add(lblId_Producto);
           panel1.add(lblTipo_Viaje);
           panel1.add(lblFechaEnvio);
           panel1.add(lblFechaRecepcion);
            
           panel1.add(cajaId_Transporte);
           panel1.add(cajaId_Cliente);
           panel1.add(cajaId_Producto);
           panel1.add(cajaTipo_Viaje);
            
           separador.addTab("Recepción Material", null, panel1, "Separador1"); // Añadimos el Panel1 al separador
            
           panel1.add(dateRecep);
           
           dateEnvio = new JDateChooser();
           dateEnvio.setBounds(270, 343, 250, 30);
           panel1.add(dateEnvio);
           
           btnOk = new JButton("OK");
           btnOk.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
        	   cajaTipo_Viaje.setText((String) comboBox.getSelectedItem());
           	}
          });
           btnOk.setBounds(473, 302, 47, 30);
           panel1.add(btnOk);
           
           comboBox = new JComboBox();
           comboBox.setModel(new DefaultComboBoxModel(new String[] {"Entrega", "Recogida", "Mixto", "Anulado"}));
           comboBox.setBounds(365, 302, 98, 30);
           panel1.add(comboBox);
           
           btnNewButton = new JButton("Generar N\u00BA");
           btnNewButton.addActionListener(new ActionListener() {
           	public void actionPerformed(ActionEvent e) {
           		cajaId_Transporte.setText(new Disparador("idTransporte").nextValue()+"");
           	}
           });
           btnNewButton.setBounds(404, 182, 116, 26);
           panel1.add(btnNewButton);
           
           lblModuloTransporte = new JLabel("MODULO TRANSPORTE");
           lblModuloTransporte.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
           lblModuloTransporte.setBounds(101, 28, 362, 37);
           panel1.add(lblModuloTransporte);
           
           JSeparator separatortitulo = new JSeparator();
           separatortitulo.setBackground(Color.BLACK);
           separatortitulo.setBounds(46, 68, 417, 10);
           panel1.add(separatortitulo);
           
           JLabel label = new JLabel("");
           label.setIcon(new ImageIcon(InterfaceTrans.class.getResource("/FinalLaGestionTransport/truckmini.png")));
           label.setBounds(47, 11, 62, 54);
           panel1.add(label);
           
           JLabel label_logo = new JLabel("");
           label_logo.setIcon(new ImageIcon(InterfaceTrans.class.getResource("/FinalLaGestionTransport/mini-logo.png")));
           label_logo.setBounds(1058, 11, 207, 114);
           panel1.add(label_logo);
           getContentPane().add(separador); // sin esto no se veria nada, añadimos al JFrame el JTabbedPane
            
       }
}
