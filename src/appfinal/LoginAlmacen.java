package appfinal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginAlmacen extends JFrame{
    
    private JPanel laminaLogin;
    private JLabel lblEnunciado,lblUsuario,lblPass;
    private JTextField cajaUsuario;
    private JPasswordField cajaPass;
    private JButton validar;
     
        public LoginAlmacen(){
             
            setTitle("Login Almacen");
            setSize(500,380);
            getContentPane().setLayout(null); //para colocar el contenido donde pongamos las coordenadas
            setLocationRelativeTo(null); //para colocar el marco en el centro de la pantalla.
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //para que solo se cierre el login y no todo
            setResizable(false); //para que no se pueda redimensionar
            setVisible(true);
             
            laminaLogin=new JPanel();
            setContentPane(laminaLogin);
            laminaLogin.setLayout(null); //anulamos layout para colocar los objetos donde queramos
            laminaLogin.setBackground(Color.LIGHT_GRAY); //asi le damos color al panel1
             
            lblEnunciado = new JLabel("Introduzca sus Claves para acceder al Almacen");
            lblEnunciado.setBounds(50,50,500,30);
            lblEnunciado.setFont(new Font("Arial",Font.BOLD,16));
             
            lblUsuario=new JLabel("Usuario:");
            lblUsuario.setBounds(100,120,100,30);
            lblUsuario.setFont(new Font("Arial",Font.BOLD,12));
             
            lblPass=new JLabel("Contraseña:");
            lblPass.setBounds(100,160,100,30);
            lblPass.setFont(new Font("Arial",Font.BOLD,12));
             
            cajaUsuario=new JTextField();
            cajaUsuario.setBounds(180,120,150,30);
            cajaUsuario.setFont(new Font("Arial",Font.BOLD,12));
             
            cajaPass=new JPasswordField();
            cajaPass.setBounds(180,160,150,30);
            cajaPass.setFont(new Font("Arial",Font.BOLD,12));
             
            InputMap map= new InputMap();
            map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,false), "Pulsado");
            map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,true), "Suelto");
             
            validar=new JButton("Validar");
            validar.setBounds(180,200,150,30);
            validar.setFont(new Font("Arial",Font.BOLD,12));
            validar.setInputMap(0, map); 
            validar.addActionListener(new ActionListener(){
 
                public void actionPerformed(ActionEvent e) {
                     
                    char[] p=cajaPass.getPassword();
                    String contra=new String(p);
                    String usuario=cajaUsuario.getText();
                     
                    if (usuario.equals("Almacen")) {
                         
                        if (contra.equals("12345")) {
                             
                            JOptionPane.showMessageDialog(null, "Bienvenido al sistema!!");
                            setVisible(false);
                            InterfazAlmacen almacen =new InterfazAlmacen();
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Contraseña Incorrecta!!");
                            cajaUsuario.setText("Almacen");
                            cajaPass.setText(null);
                            cajaPass.requestFocus();
                        }//cierre else primer if
                    }//cierre if
                    else {
                        JOptionPane.showMessageDialog(null, "Acceso denegado\n Comprueba los datos introducidos.");
                        cajaUsuario.setText(null);
                        cajaPass.setText(null);
                        cajaUsuario.requestFocus(); // la caja gana el foco
                    }
                }   
            });
             
             
            laminaLogin.add(lblEnunciado);
            laminaLogin.add(lblUsuario);
            laminaLogin.add(lblPass);
            laminaLogin.add(cajaUsuario);
            laminaLogin.add(cajaPass);
            laminaLogin.add(validar);
        }
     
        public static void main(String[] args) {
            new LoginAlmacen();
        }
} 
