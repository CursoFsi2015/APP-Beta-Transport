package Bbdd;

import java.sql.*;

import javax.swing.JOptionPane;

public class ConexionMarco {
	
	Connection conn;
	Statement st;
	
	private final String bbddName, bbddUser, bbddPass;
	
	/**
	 * Instancia la clase de conexion
	 */
	ConexionMarco(){
		this.bbddName = "C:\\LaGestion\\LaGestion.accdb";
		this.bbddUser = "";
		this.bbddPass = "";
	}
	/**
	 * Conecta a la base de datos
	 * @return boolean
	 */
	boolean conectar(){
		try {
			conn = DriverManager.getConnection("jdbc:ucanaccess://"+bbddName, bbddUser, bbddPass);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, this.getClass().getSimpleName()
					+ ".conectar().Connection => SQLException\n" + e.getMessage());
			return false;
		}
		
		try {
			this.st = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, this.getClass().getSimpleName() 
					+ ".conectar().Statement => SQLException\n" + e.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * Desconecta de la base de datos
	 * @return boolean
	 */
	boolean desconectar(){
		try {
			this.conn.close();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, this.getClass().getSimpleName() 
					+ ".desconectar() => SQLException\n" + e.getMessage());
		}
		return false;
	}
	
	/**
	 * Realiza una consulta del tipo SELECT
	 * @param sql String
	 * @return ResultSet
	 */
	ResultSet selectQuery(String sql){
		try {
			ResultSet rs = this.st.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, this.getClass().getSimpleName() 
					+ ".sendQuery("+sql+")\n" + e.getMessage());
		}
		
		return null;
	}
	
	/**
	 * Realiza una consulta de los tipos INSERT, UPDATE y DELETE
	 * @param sql String
	 * @return numero de filas actualizadas
	 */
	int execQuery(String sql){
		try {
			int rs = this.st.executeUpdate(sql);
			return rs;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, this.getClass().getSimpleName() 
					+ ".execQuery("+sql+")\n" + e.getMessage());
		}
		return 0;
	}


}
