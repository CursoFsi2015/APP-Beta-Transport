package Bbdd;



/**
 * Clase principal que realiza querys INSERT, UPDATE y DELETE
 * @author Marco Ant. Quirós
 * @version 1.0 */
public class Actualizador {
	
	/**
	 * Realiza INSERT, UPDATE y DELETE en la BBDD
	 * @param query <code>SQLString</code>
	 * @return boolean */
	protected boolean updateQuery(String query){
		ConexionAccess c = new ConexionAccess();
		c.conectar();
		if(c.execQuery(query) > 0){
			c.desconectar();
			return true;
		}
		c.desconectar();
		return false;
	}

}
