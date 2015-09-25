package Bbdd;



/**
 * Identificador, nombre, direccion, localidad, codigo postal, descripcion
 * @author Marco Ant. Quirós
 * @version 1.1 */
public class Departamentos extends Actualizador{
	
	private int id, cp;
	private String nombre, direccion, localidad, descripcion;
	
	/**
	 * Constructor nulo para usar las querys de insercion de datos */
	public Departamentos(){}
	/**
	 * Instancia el objeto con los siguientes parametros
	 * @param id <code>Integer</code>
	 * @param nombre <code>String</code>
	 * @param direccion <code>String</code>
	 * @param localidad <code>String</code>
	 * @param cp <code>Integer</code>
	 * @param descripcion <code>String</code> */
	Departamentos(int id, String nombre, String direccion, String localidad, int cp, String descripcion){
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.localidad = localidad;
		this.cp = cp;
		this.descripcion = descripcion;
	}
	
	/**
	 * Inserta un nuevo registro en la tabla Departamentos
	 * @param id <code>Integer</code>
	 * @param nombre <code>String</code>
	 * @return boolean */
	public boolean insertar(int id, String nombre){
		String query = "INSERT INTO Departamentos (Id_Departamento, Nombre) VALUES ("+id+", '"+nombre+"')";
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	/**
	 * Inserta un nuevo registro en la tabla Departamentos
	 * @param id <code>Integer</code>
	 * @param nombre <code>String</code>
	 * @param direccion <code>String</code>
	 * @param localidad <code>String</code>
	 * @param cp <code>Integer</code>
	 * @return boolean */
	public boolean insertar(int id, String nombre, String direccion, String localidad, int cp){
		String query = "INSERT INTO Departamentos (Id_Departamento, Nombre, Direccion, Localidad, Codigo_Postal) VALUES ("+id+", '"+nombre+"', '"+direccion+"', '"+localidad+"', "+cp+")";
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Inserta un nuevo registro en la tabla Departamentos
	 * @param id <code>Integer</code>
	 * @param nombre <code>String</code>
	 * @param direccion <code>String</code>
	 * @param localidad <code>String</code>
	 * @param cp <code>Integer</code>
	 * @param descripcion <code>String</code>
	 * @return boolean */
	public boolean insertar(int id, String nombre, String direccion, String localidad, int cp, String descripcion){
		String query = "INSERT INTO Departamentos (Id_Departamento, Nombre, Direccion, Localidad, Codigo_Postal, Descripcion) VALUES ("+id+", '"+nombre+"', '"+direccion+"', '"+localidad+"', "+cp+", '"+descripcion+"')";
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Actualiza el registro en la BBDD
	 * @return boolean */
	public boolean actualizar(){
		String query = "UPDATE Departamentos SET Nombre = '"+this.getNombre()+"', Direccion = '"+this.getDireccion()+"', Localidad = '"+this.getLocalidad()+"', Codigo_Postal = "+this.getCp()+", Descripcion = '"+this.getDescripcion()+"' WHERE Id_Departamento = " + this.getId();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Actualiza el registro en la BBDD pasado por parametros
	 * @param d <code>{@link #Departamentos}</code>
	 * @return boolean */
	public boolean actualizar(Departamentos d){
		String query = "UPDATE Departamentos SET Nombre = '"+d.getNombre()+"', Direccion = '"+d.getDireccion()+"', Localidad = '"+d.getLocalidad()+"', Codigo_Postal = "+d.getCp()+", Descripcion = '"+d.getDescripcion()+"' WHERE Id_Departamento = " + d.getId();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Elimina un registro de la BBDD
	 * @return boolean */
	public boolean eliminar(){
		String query = "DELETE FROM Departamentos WHERE Id_Departamento = "+this.getId();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}

	/**
	 * retorna el id
	 * @return <code>Integer</code> */
	public int getId() {
		return id;
	}

	/**
	 * retorna el nombre
	 * @return <code>String</code> */
	public String getNombre() {
		return nombre;
	}

	/**
	 * retorna la direccion
	 * @return <code>String</code> */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * retorna la localidad
	 * @return <code>String</code> */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * retorna el codigo postal
	 * @return <code>Integer</code> */
	public int getCp() {
		return cp;
	}

	/**
	 * retorna la descripcion
	 * @return */
	public String getDescripcion() {
		return descripcion;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * setea el nombre de departamento
	 * @param nombre <code>String</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setNombre(String nombre, boolean update) {
		this.nombre = nombre;
		if(update){
			String query = "UPDATE Departamentos SET Nombre = '" + nombre + "' WHERE Id_Departamento = " + this.id;
			updateQuery(query);
		}
	}

	/**
	 * setea la direccion
	 * @param direccion <code>String</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setDireccion(String direccion, boolean update) {
		this.direccion = direccion;
		if(update){
			String query = "UPDATE Departamentos SET Direccion = '" + direccion + "' WHERE Id_Departamento = " + this.id;
			updateQuery(query);
		}
	}

	/**
	 * setea la localidad
	 * @param localidad <code>String</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setLocalidad(String localidad, boolean update) {
		this.localidad = localidad;
		if(update){
			String query = "UPDATE Departamentos SET Localidad = '" + localidad + "' WHERE Id_Departamento = " + this.id;
			updateQuery(query);
		}
	}

	/**
	 * setea el codigo postal
	 * @param cp <code>Integer</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setCp(int cp, boolean update) {
		this.cp = cp;
		if(update){
			String query = "UPDATE Departamentos SET Codigo_Postal = " + cp + " WHERE Id_Departamento = " + this.id;
			updateQuery(query);
		}
	}

	/**
	 * setea la descripcion
	 * @param descripcion <code>String</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setDescripcion(String descripcion, boolean update) {
		this.descripcion = descripcion;
		if(update){
			String query = "UPDATE Departamentos SET Descripcion = '" + descripcion + "' WHERE Id_Departamento = " + this.id;
			updateQuery(query);
		}
	}
	
	public String toString(){
		return "id_departamento: " + this.id + ";"
		+ "nombre: " + this.nombre + ";"
		+ "Direccion: " + this.direccion + ";"
		+ "Localidad: " + this.localidad + ";"
		+ "Codigo_Postal: " + this.cp + ";"
		+ "Descripción: " + this.descripcion + ";\n";
	}

}
