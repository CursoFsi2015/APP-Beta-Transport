package appfinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.toedter.calendar.JDateChooser;

public class InterfazAlmacen extends InterfazComun{
    
    private JTabbedPane separador;
    private JPanel panel1,panel2; 
    private JLabel logoCodProd,logoAlbaran,logoCalendario,logoProveedores,logoStock;
    private JTextField cajaMarca,cajaModelo,cajaStock,cajaCantidad,cajaProveedor,cajaAlbaranProv;
    private JLabel lblTabla,lblMarca,lblModelo,lblStock,lblCantidad,lblProveedor,lblFechaRecepcion,lblAlbaranProv,lblSeleccionCod;
    private JButton guardar,borrar;
    private JScrollPane sp;
    private JTable tabla;
    private JMenuItem abrir;
    private static JFileChooser archivo;
     
    //------------------------------------------------------------------------
    //codigo para cambiar tacita de cafe java
//  Image icon = new ImageIcon(getClass().getResource("/programa/imagenes/love.png")).getImage();
//  setIconImage(icon);
    //----------------------------------------------------------------------
     
   //------------- JComboBox-------------------
       private JComboBox<String>combo1;
        
   //----------- Calendario dateChooser --------------------------
       private final JDateChooser dateChooser = new JDateChooser();
        
     //---------------A partir de aqui metodo del JFileChooser-----------------
       //---------------------------------------------------------
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
    
       public InterfazAlmacen(){
            
            
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
           abrir.setIcon(new ImageIcon(InterfazAlmacen.class.getResource("")));  //para colocar un icono
           abrir.addActionListener(new ActionListener(){
                
               public void actionPerformed(ActionEvent ae) {
                   try {
                       InterfazAlmacen.metodo_archivo();
                   } catch (Throwable e) {
                       e.printStackTrace();
                   }
                    
               }
                
           });
           super.menu1.add(abrir);
            
        //-------------- Tabla ----------------------------------------------
        //-------------------------------------------------------------------
           String filas[][] = {
                   {" "," "," ","",""},
                   {" "," "," ","",""},
                   {" "," "," ","",""},
                   {" "," "," ","",""},
                   {" "," "," ","",""},
                   {" "," "," ","",""},
                   {" "," "," ","",""},
                   {" "," "," ","",""},
                   {" "," "," ","",""},
                   {" "," "," ","",""},
                   {" "," "," ","",""},
                   {" "," "," ","",""},
                   {" "," "," ","",""},
                   {" "," "," ","",""},
                   {" "," "," ","",""},
                   {" "," "," ","",""},
                   {" "," "," ","",""},
                   {" "," "," ","",""},
                   {" "," "," ","",""}
           };
            
           String columnas[]={" PROVEEDOR "," Nº ALBARAN "," MARCA"," MODELO "," STOCK"};
            
           tabla=new JTable(filas,columnas);
           tabla.setShowVerticalLines(false); //No queremos ver las lineas verticales
           tabla.setShowHorizontalLines(false); //No queremos ver las lineas verticales
           tabla.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); //se puede seleccionar mas de una fila
           tabla.setVisible(true);
            
           sp=new JScrollPane(tabla); //Necesita un Scrol para que se vean las columnas
           sp.setBounds(700, 150, 465, 330);
  
           //---------------------------------------------------------
           //-------A partir de aqui el tabbedPaned-------------------
           //---------------------------------------------------------
            
           separador = new JTabbedPane();
           // Creamos el primer separador Panel1
           panel1=new JPanel();
           panel1.setBackground(Color.LIGHT_GRAY); //asi le damos color al panel1
           panel1.setLayout(null); //anulamos layout para colocar los objetos donde queramos
           //setContentPane(panel1);
            
//------------ JComboBox ------------------------
            
           combo1=new JComboBox<String>();
           combo1.setBounds(100, 82, 250, 25);
           combo1.addItem("cod:123");
           combo1.addItem("cod:456");
           combo1.addItem("cod:789");
           combo1.addItem("cod:051");
//         Border bordeCombo=BorderFactory.createBevelBorder(HEIGHT, Color.BLACK, Color.BLACK);//(2,"Codigo Producto");
//         combo1.setBorder(bordeCombo);
           //combo1.addItemListener(this);
            
           //---------labels -------------------
           lblSeleccionCod=new JLabel("SELECCIONE EL CODIGO DE PRODUCTO");
           lblSeleccionCod.setFont(new Font("Arial",Font.BOLD,16));
           lblTabla=new JLabel("PRODUCTOS EN STOCK");
           lblTabla.setFont(new Font("Arial",Font.BOLD,16));
           lblMarca=new JLabel("MARCA:");
           lblMarca.setFont(new Font("Arial",Font.BOLD,13));
           lblModelo=new JLabel("MODELO:");
           lblModelo.setFont(new Font("Arial",Font.BOLD,13));
           lblStock=new JLabel("STOCK ACTUAL:");
           lblStock.setFont(new Font("Arial",Font.BOLD,13));
           lblCantidad=new JLabel("CANTIDAD ENTRADA:");
           lblCantidad.setFont(new Font("Arial",Font.BOLD,13));
           lblProveedor=new JLabel("PROVEEDOR:");
           lblProveedor.setFont(new Font("Arial",Font.BOLD,13));
           lblFechaRecepcion=new JLabel("FECHA RECEPCION:");
           lblFechaRecepcion.setFont(new Font("Arial",Font.BOLD,13));
           lblAlbaranProv=new JLabel("Nº ALBARAN PROVEEDOR:");
           lblAlbaranProv.setFont(new Font("Arial",Font.BOLD,13));
            
         //-------- labels de logos -------
            
           logoCodProd = new JLabel("");
           logoAlbaran = new JLabel("");
           logoCalendario = new JLabel("");
           logoProveedores = new JLabel("");
           logoStock = new JLabel("");
            
//           logoCodProd.setIcon(new ImageIcon(InterfazAlmacen.class.getResource("codProd.png")));
//           logoStock.setIcon(new ImageIcon(InterfazAlmacen.class.getResource("stock.png")));
//           logoCalendario.setIcon(new ImageIcon(InterfazAlmacen.class.getResource("calendario.png")));
//           logoProveedores.setIcon(new ImageIcon(InterfazAlmacen.class.getResource("proveedores.png")));
//           logoAlbaran.setIcon(new ImageIcon(InterfazAlmacen.class.getResource("albaranes.png")));
           
            
           logoCodProd.setBounds(352, 73, 150, 40);
           logoStock.setBounds(525, 248, 150, 40);
           logoProveedores.setBounds(525, 348, 150, 40);
           logoCalendario.setBounds(525, 398, 150, 40);
           logoAlbaran.setBounds(525, 448, 150, 40);
             
           //----------cajas de texto ----------------
            
           cajaMarca=new JTextField();
           cajaModelo=new JTextField();
           cajaStock=new JTextField();
           cajaCantidad=new JTextField();
           cajaProveedor=new JTextField();
           cajaAlbaranProv=new JTextField();
            
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
                    
                   cajaMarca.setText(null);
                   cajaModelo.setText(null);
                   cajaStock.setText(null);
                   cajaCantidad.setText(null);
                   cajaProveedor.setText(null);
                   dateChooser.setCalendar(null); //vaciamos la caja del calendario
                   cajaAlbaranProv.setText(null);
               }
                
           });
       
         //-------A partir de aqui colocamos elementos en el panel 1 --------------
           //-----LABELS-------
            
           lblSeleccionCod.setBounds(73, 52, 400, 14); //le damos un tamaño y posicion a dicha label
           lblTabla.setBounds(845, 122, 400, 14);
           lblMarca.setBounds(73, 160, 250, 14);
           lblModelo.setBounds(73, 210, 250, 14);
           lblStock.setBounds(73, 260, 250, 14);
           lblCantidad.setBounds(73, 310, 250, 14);
           lblProveedor.setBounds(73, 360, 250, 14);
           lblFechaRecepcion.setBounds(73, 410, 250, 14);
           lblAlbaranProv.setBounds(73, 460, 250, 14);
             
           //----------Cajas-------------
            
           cajaMarca.setBounds(270, 152, 250, 30);
           cajaModelo.setBounds(270, 202, 250, 30);
           cajaStock.setBounds(270, 252, 250, 30);
           cajaCantidad.setBounds(270, 302, 250, 30);
           cajaProveedor.setBounds(270, 352, 250, 30);
           cajaAlbaranProv.setBounds(270, 452, 250, 30);
            
           //----------Botones-------------
            
           guardar.setBounds(500, 512, 85, 30);
           borrar.setBounds(620, 512, 85, 30);

           dateChooser.setBounds(270, 402, 250, 30);
            
           panel1.add(combo1);
           panel1.add(sp);
            
           panel1.add(guardar);
           panel1.add(borrar);
            
           panel1.add(lblSeleccionCod);
           panel1.add(lblTabla);
           panel1.add(lblMarca);
           panel1.add(lblModelo);
           panel1.add(lblStock);
           panel1.add(lblCantidad);
           panel1.add(lblProveedor);
           panel1.add(lblFechaRecepcion);
           panel1.add(lblAlbaranProv);
            
           panel1.add(cajaMarca);
           panel1.add(cajaModelo);
           panel1.add(cajaStock);
           panel1.add(cajaCantidad);
           panel1.add(cajaProveedor);
           panel1.add(cajaAlbaranProv);
            
           panel1.add(logoCodProd);
           panel1.add(logoAlbaran);
           panel1.add(logoCalendario);
           panel1.add(logoProveedores);
           panel1.add(logoStock);
            
           separador.addTab("Recepción Material", null, panel1, "Separador1"); // Añadimos el Panel1 al separador
            
           panel1.add(dateChooser);
            
    //------------------------------------------------------------------------------------------------    
    //--------------------------A partir de aquí el panel 2 ------------------------------------------ 
    //------------------------------------------------------------------------------------------------ 
           panel2=new JPanel();
           panel2.setBackground(Color.LIGHT_GRAY); //asi le damos color al panel1
           panel2.setLayout(null); 
            
           separador.addTab("Salida Material", null, panel2, "Separador1");
           getContentPane().add(separador); // sin esto no se veria nada, añadimos al JFrame el JTabbedPane
            
       }
}
