package appfinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class InterfazComun extends JFrame implements ActionListener{
  
  public JToolBar tb1;
  private JButton b1;
  protected JPanel contentPane;
  public JMenuBar menubar1;
  public JMenu menu1,menu2,submenu21,submenu212,menu3;
  public JMenuItem submenu11,submenu211,submenu2121,submenu2122,submenu22,submenu23,submenu24,submenu25,submenu26,submenu31;
    
    public InterfazComun(){
        setTitle("La Gestion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(800,600);
        setLocationRelativeTo(null);
        setResizable(false);
 
     //OJO!!! este codigo te ocultará tu panel al heredar
        contentPane=new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(contentPane, BorderLayout.CENTER);
    //---------------------------------------------------------------
        menubar1=new JMenuBar();
        menubar1.setName("menubar1");
        setJMenuBar(menubar1);
  
        menu1=new JMenu("Archivo");
        menu1.setMnemonic('A');
        menu1.setName("menu1");
        menubar1.add(menu1);
          
        menu2=new JMenu("Modulos");
        menu2.setMnemonic('M');
        menu2.setName("menu2");
        menubar1.add(menu2);
          
        menu3=new JMenu("Ayuda");
        menu3.setMnemonic('y');
        menu3.setName("menu3");
        menubar1.add(menu3);
  
        submenu11=new JMenuItem("Salir");
        submenu11.addActionListener(this);
        submenu11.setMnemonic(KeyEvent.VK_F7);
        submenu11.setName("submenu11");
        submenu11.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        menu1.add(submenu11);
  
        submenu21=new JMenu("Tienda");
        submenu21.setName("submenu21");
        submenu21.setEnabled(true);
        submenu21.addActionListener(new ActionListener(){
 
            public void actionPerformed(ActionEvent e) {
                //LoginSTecnico login=new LoginSTecnico();
                JOptionPane.showMessageDialog(null, "En construccion");
            }
             
        });
        menu2.add(submenu21);
  
        submenu212 = new JMenu("Ventas");
        submenu212.setName("submenu212");
        submenu212.setEnabled(true);
        submenu21.add(submenu212);
  
        submenu2121= new JMenuItem("Pedidos");
        submenu2121.setMnemonic('P');
        submenu2121.setName("submenu2121");
        submenu2121.setEnabled(true);
        submenu2121.addActionListener(new ActionListener(){
 
            public void actionPerformed(ActionEvent e) {
                //LoginPedidos login=new LoginPedidos();
                JOptionPane.showMessageDialog(null, "En construccion");
            }
             
        });
        submenu212.add(submenu2121);
  
        submenu2122= new JMenuItem("Facturas");
        submenu2122.setMnemonic('F');
        submenu2122.setName("submenu2122");
        submenu2122.setEnabled(true);
        submenu2122.addActionListener(new ActionListener(){
 
            public void actionPerformed(ActionEvent e) {
                //LoginFacturas login=new LoginFacturas();
                JOptionPane.showMessageDialog(null, "En construccion");
            }
             
        });
        submenu212.add(submenu2122);
  
        submenu211 = new JMenuItem("Compras");
        submenu211.setMnemonic('C');
        submenu211.setName("submenu211");
        submenu211.setEnabled(true);
        submenu211.addActionListener(new ActionListener(){
 
            public void actionPerformed(ActionEvent e) {
                //LoginVentas login=new LoginVentas();
                JOptionPane.showMessageDialog(null, "En construccion");
            }
             
        });
        submenu21.add(submenu211);
  
        submenu22=new JMenuItem("Servicio Técnico");
        submenu22.setMnemonic('S');
        submenu22.setName("submenu22");
        submenu22.setEnabled(true);
        submenu22.addActionListener(new ActionListener(){
 
            public void actionPerformed(ActionEvent e) {
                //LoginSTecnico login=new LoginSTecnico();
                JOptionPane.showMessageDialog(null, "En construccion");
            }
             
        });
        menu2.add(submenu22);
  
        submenu23=new JMenuItem("Almacén");
        submenu23.setMnemonic('l');
        submenu23.setName("submenu23");
        submenu23.setEnabled(true);
        submenu23.addActionListener(new ActionListener(){
 
            public void actionPerformed(ActionEvent e) {
                LoginAlmacen login=new LoginAlmacen();
                 
            }
             
        });
        menu2.add(submenu23);
  
        submenu24=new JMenuItem("Transporte");
        submenu24.setMnemonic('r');
        submenu24.setName("submenu24");
        submenu24.setEnabled(true);
        submenu24.addActionListener(new ActionListener(){
 
            public void actionPerformed(ActionEvent e) {
                //LoginTransporte login=new LoginTransporte();
            	InterfaceTransporte enter = new InterfaceTransporte();
                //JOptionPane.showMessageDialog(null, "En construccion");
            }
             
        });
        menu2.add(submenu24);
  
        submenu25=new JMenuItem("Recursos Humanos");
        submenu25.setMnemonic('e');
        submenu25.setName("submenu25");
        submenu25.setEnabled(true);
        submenu25.addActionListener(new ActionListener(){
 
            public void actionPerformed(ActionEvent e) {
                //LoginRRHH login=new LoginRRHH();
                JOptionPane.showMessageDialog(null, "En construccion");
            }
             
        });
        menu2.add(submenu25);
  
        submenu26=new JMenuItem("Contabilidad");
        submenu26.setMnemonic('o');
        submenu26.setName("submenu26");
        submenu26.setEnabled(true);
        submenu26.addActionListener(new ActionListener(){
 
            public void actionPerformed(ActionEvent e) {
                //LoginContabilidad login=new LoginContabilidad();
                JOptionPane.showMessageDialog(null, "En construccion");
            }
             
        });
        menu2.add(submenu26);
  
        submenu31=new JMenuItem("Acerca De La Gestión");
        submenu31.setMnemonic('G');
        submenu31.setName("submenu31");
        submenu31.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "En construccion");
            }
        });
        menu3.add(submenu31);
          
        tb1 = new JToolBar();
        tb1.setFloatable(false);  //Impide que se pueda mover desde el rectángulo punteado
        tb1.setOrientation(JToolBar.HORIZONTAL); // Determina que sea horizontal, valor predeterminado
        tb1.setBounds(0,80,200,50);
          
        b1 = new JButton("Salir");
        b1.setBounds(0,0,70,40);
        b1.setMnemonic('E');
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        tb1.add(b1);
        getContentPane().add(tb1, BorderLayout.NORTH);
    }
  
    //Este método queda vacio porque las acciones las ejecuta el hijo, que
    //es el objeto instanciado. Sin embargo hay que tener el método declarado
    //aqui para que no de error.
    public void actionPerformed(ActionEvent ev) {}
      
//    public void conectar(){
//        ConexionBBDD conn= new ConexionBBDD();//Conectamos a la base de datos
//        String [] nombre=new String[conn.getNumeroEmpleados("Compras")];
//        nombre=conn.getEmpleados("Compras");
// 
//        //El siguiente codigo es solo de ejemplo. Borrar de aqui y escribir en funcion
//        //a parte una vez comprendido su funcionamiento.
//        JOptionPane.showMessageDialog(null, "Numero de empleados: "+conn.getNumeroEmpleados("Compras"));
//        for (int i=0;i<conn.getNumeroEmpleados("Compras");i++){
//            JOptionPane.showMessageDialog(null,"Empleado: "+nombre[i]);
//        }
//        conn.cerrarConexion();
//    }
}