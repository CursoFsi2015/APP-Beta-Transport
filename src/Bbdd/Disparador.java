package Bbdd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
 
import javax.swing.JOptionPane;

 
public class Disparador implements Serializable{
    private static final long serialVersionUID = 1L;
 
    private int identificador = 0, anterior = -1; //valores
     
    private File directorio = new File(System.getenv("SYSTEMDRIVE")+File.separator //directorio de destino
            +"LaGestion");
    private File archivo = new File( //archivo de destino
            //crea el archivo con el nombre de la clase y extension ".cls" en el directorio
            directorio+File.separator+Disparador.class.getSimpleName()+".cls");
     
    /**
     * Constructor de la clase
     */
    public Disparador(String name){ //constructor
        archivo = new File(directorio+File.separator+name+".cls");
        if(!directorio.exists()){ //si el directorio no existe
            if(!directorio.mkdirs()){ //si no puedes crear el directorio
                JOptionPane.showMessageDialog(null,
                        "No se ha podido crear el directorio."
                        + "\nEl directorio ya existe.",
                        "Operación no permitida.", JOptionPane.ERROR_MESSAGE);
            }
            this.save(); //salva el archivo
        }else{
            if(!archivo.exists()){
                this.save();
            }
            this.load(); //carga el archivo
        }
    }
     
    /**
     * Retorna el siguiente valor para el autonumerico y lo avanza una posicion
     * @return {@link #identificador}
     */
    public int insert(){
        anterior = identificador; //coloca el siguiente valor en el penultimo valor
        identificador++; //suma y asigna el identificador
        this.save(); //guarda el archivo
        return identificador; //retorna el valor valido
    }
     
    /**
     * Retorna el siguiente valor a insertar
     * @return Integer
     */
    public int nextValue(){
        return identificador + 1;
    }
     
    /**
     * Retorna el ultimo valor insertado
     * @return Integer
     */
    public int lastValue(){
        return identificador;
    }
     
    /**
     * Retorna el valor previo al insertado
     * @return Integer
     */
    public int previousValue(){
        return anterior;
    }
     
    /**
     * Setea un nuevo valor para el identificador
     * @param i
     */
    public void setValue(int i){
        if(i > 0){
            anterior = i - 1;
            identificador = i;
        }
    }
     
    public File getDir(){ //getter del directorio
        return directorio;
    }
     
    public File getFile(){ //getter del archivo
        return archivo;
    }
     
    /**
     * Carga el contenido de la clase desde el archivo
     * y setea los valores del objeto
     */
    protected void load(){
        try{
            FileInputStream door = new FileInputStream(archivo);//abre el archivo para su lectura
            ObjectInputStream reader = new ObjectInputStream(door);//objeto que guarda los datos del archivo
            try{
                Disparador x = (Disparador) reader.readObject(); //crea instancia local del archivo guardado
                door.close();//cierra las puertas
                reader.close(); //cierra las puertas
                identificador = x.lastValue(); //asigna valor
                anterior = x.previousValue(); //asigna valor
                directorio = x.getDir(); //asigna valor
                archivo = x.getFile(); //asigna valor
            }catch(ClassNotFoundException e){ //excepcion de clase no encontrada
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR ClassNotFound", JOptionPane.ERROR_MESSAGE);
            }
        }catch (IOException e){ //excepcion de entrada/salida
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR IOException", JOptionPane.ERROR_MESSAGE);
        }
    }
     
    /**
     * Guarda los datos del objeto en un archivo
     */
    protected void save(){
        try{
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(archivo));//abre el archivo para escribir
            out.writeObject(this);//escribe el archivo
            out.close();//cierra el archivo
        }catch(IOException e){ //excepcion de entrada/salida
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

}
