package Bbdd;



/**
 * Identificador, nombre, NIF, direccion, telefono, fax, email
 * @author Marco Ant. Quirós
 * @version 1.1 */
public class Clientes extends Actualizador{
	
	int id;
	String nombre, nif, direccion, telefono, fax, email;
	
	/**
	 * Constructor nulo para usar las querys de insercion de datos */
	public Clientes(){}
	/**
	 * @param id <code>Integer</code>
	 * @param nombre <code>String</code>
	 * @param nif <code>String</code>
	 * @param direccion <code>String</code>
	 * @param telefono <code>String</code>
	 * @param fax <code>String</code>
	 * @param email <code>String</code> */
	public Clientes(int id, String nombre, String nif, String direccion,
			String telefono, String fax, String email) {
		this.id = id;
		this.nombre = nombre;
		this.nif = nif;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fax = fax;
		this.email = email;
	}
	
	/**
	 * Inserta un nuevo registro en la tabla Clientes
	 * @param id <code>Integer</code>
	 * @param nombre <code>String</code>
	 * @param nif <code>String</code>
	 * @param direccion <code>String</code>
	 * @param telefono <code>String</code>
	 * @param fax <code>String</code>
	 * @param email <code>String</code>
	 * @return boolean */
	public boolean insertar(int id, String nombre, String nif, String direccion,
			String telefono, String fax, String email){
		String query = "INSERT INTO Clientes (Id_Cliente, Nombre_Razon_Social, DNI_NIF, Direccion, Telefono, Fax, Email) "
				+ "VALUES ("+id+", '"+nombre+"', '"+nif+"', '"+direccion+"', '"+telefono+"', '"+fax+"', '"+email+"')";
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Inserta un nuevo registro en la tabla Clientes
	 * @param id
	 * @param nombre
	 * @param nif
	 * @param direccion
	 * @param telefono
	 * @return boolean */
	public boolean insertar(int id, String nombre, String nif, String direccion,
			String telefono){
		String query = "INSERT INTO Clientes (Id_Cliente, Nombre_Razon_Social, DNI_NIF, Direccion, Telefono) "
				+ "VALUES ("+id+", '"+nombre+"', '"+nif+"', '"+direccion+"', '"+telefono+"')";
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Inserta un nuevo registro en la tabla Clientes
	 * @param id
	 * @param nombre
	 * @param nif
	 * @param direccion
	 * @param telefono
	 * @param email
	 * @return boolean */
	public boolean insertar(int id, String nombre, String nif, String direccion,
			String telefono, String email){
		String query = "INSERT INTO Clientes (Id_Cliente, Nombre_Razon_Social, DNI_NIF, Direccion, Telefono, Email) "
				+ "VALUES ("+id+", '"+nombre+"', '"+nif+"', '"+direccion+"', '"+telefono+"', '"+email+"')";
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Actualiza un registro en la BBDD
	 * @return boolean */
	public boolean actualizar(){
		String query = "UPDATE Clientes SET Nombre_Razon_Social = '"+this.getNombre()+"', DNI_NIF = '"+this.getNif()+"', Direccion = '"+this.getDireccion()+"', Telefono = '"+this.getTelefono()+"', Fax = '"+this.getFax()+"', Email = '"+this.getEmail()+"' WHERE Id_Cliente = " + this.getId();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Actualiza un registro en la BBDD pasado como parametro
	 * @param c <code>{@link #Clientes}</code>
	 * @return boolean */
	public boolean actualizar(Clientes c){
		String query = "UPDATE Clientes SET Nombre_Razon_Social = '"+c.getNombre()+"', DNI_NIF = '"+c.getNif()+"', Direccion = '"+c.getDireccion()+"', Telefono = '"+c.getTelefono()+"', Fax = '"+c.getFax()+"', Email = '"+c.getEmail()+"' WHERE Id_Cliente = " + c.getId();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Elimina un registro de la BBDD
	 * @return boolean */
	public boolean eliminar(){
		String query = "DELETE FROM Clientes WHERE Id_Cliente = "+this.getId();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * @return the id */
	public int getId() {
		return id;
	}
	/**
	 * @return the nombre */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @return the nif */
	public String getNif() {
		return nif;
	}
	/**
	 * @return the direccion */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @return the telefono */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @return the fax */
	public String getFax() {
		return fax;
	}
	/**
	 * @return the email */
	public String getEmail() {
		return email;
	}
	/**
	 * @param id the id to set */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param nombre <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setNombre(String nombre, boolean update) {
		this.nombre = nombre;
		if(update){
			String query = "UPDATE Clientes SET Nombre_Razon_Social = '" + nombre + "' WHERE Id_Cliente = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param nif <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setNif(String nif, boolean update) {
		this.nif = nif;
		if(update){
			String query = "UPDATE Clientes SET DNI_NIF = '" + nif + "' WHERE Id_Cliente = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param direccion <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setDireccion(String direccion, boolean update) {
		this.direccion = direccion;
		if(update){
			String query = "UPDATE Clientes SET Direccion = '" + direccion + "' WHERE Id_Cliente = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param telefono <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setTelefono(String telefono, boolean update) {
		this.telefono = telefono;
		if(update){
			String query = "UPDATE Clientes SET Telefono = '" + telefono + "' WHERE Id_Cliente = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param fax <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setFax(String fax, boolean update) {
		this.fax = fax;
		if(update){
			String query = "UPDATE Clientes SET Fax = '" + fax + "' WHERE Id_Cliente = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param email <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setEmail(String email, boolean update) {
		this.email = email;
		if(update){
			String query = "UPDATE Clientes SET Email = '" + email + "' WHERE Id_Cliente = " + this.id;
			updateQuery(query);
		}
	}

}
