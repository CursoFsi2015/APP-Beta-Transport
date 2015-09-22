package appfinal;

import javax.swing.UIManager;

public class AppProyecto {
	 
    public static void main(String[] args) throws Throwable  { //sin el throwable no funciona lookandfeel
        try{
               
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); //ponemos lookandfeel
                 //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                 // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                 //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                 //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            }catch(Exception e){
              e.printStackTrace();
            } 
     
        InterfazComun app=new InterfazComun();
         
 
    }
 
}
