package FinalLaGestionTransport;

import javax.swing.UIManager;

import Bbdd.Disparador;
import Bbdd.Tablas;

public class LauncherTrans {

	public static void main(String[] args) {
		 try{
             
	            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); //ponemos lookandfeel
	                 //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	                 // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
	                 //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	                 //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
	            }catch(Exception e){
	              e.printStackTrace();
	            } 
	     	//Disparador id = new Disparador("idTransporte");
		 	//Tablas bbdd = new Tablas(); //instancia una clase con los registros de todas las tablas
	        InterfaceTrans appTrans =new InterfaceTrans();

	}

}
