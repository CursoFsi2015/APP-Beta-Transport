package appfinal;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;


public class InterfaceTransporte extends InterfazComun {

	private static final long serialVersionUID = 1L;
    private static JFileChooser archivo;
	private JMenuItem abrir;
	private JLabel iconTruck;

	
	
	//---------------------------------------------------------
	//--------------- A partir de aqui metodo del JFileChooser -----------------
	//---------------------------------------------------------
	        
			private static void metodo_archivotrans() throws Throwable{
	        	
	        	archivo = new JFileChooser();
	        	archivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        	
	        	//Creamos el filtro
	        	FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt"); // 1 titulo - 2 extension
	        	FileNameExtensionFilter filtro2 = new FileNameExtensionFilter("*.DOC", "doc");
	        	
	        	//Le indicamos el filtro
	        	archivo.setFileFilter(filtro);
	        	archivo.setFileFilter(filtro2);
	        	
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

	//---------------------------------------
		// FIN DEL METODO DE SELECCION DE ARCHIVO

	/**
	 * Create the frame.
	 */
	public InterfaceTransporte() {
		tb1.setSize(1280, 50);
		tb1.setLocation(0, 0);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);
		
		JLabel lblModuloTranporte = new JLabel("MODULO TRANPORTE");
		lblModuloTranporte.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblModuloTranporte.setBounds(294, 61, 265, 50);
		getContentPane().add(lblModuloTranporte);
		
		iconTruck = new JLabel("");
		iconTruck.setIcon(new ImageIcon(InterfaceTransporte.class.getResource("/appfinal/truckmini.png")));
		iconTruck.setBounds(215, 61, 69, 45);
		getContentPane().add(iconTruck);
		
		setTitle("Transporte");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH); //asi se ajusta el marco al maximo de la pantalla
		
        //donde se ejecute el programa
        setResizable(true);
        setVisible(true);
        
      //Quito la visibilidad de los elementos del padre que no necesito
         
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
                    InterfaceTransporte.metodo_archivotrans();
                    } catch (Throwable e) {
                    e.printStackTrace();
                }
                 
            }
             
        });
        super.menu1.add(abrir);       
  

	}
}
