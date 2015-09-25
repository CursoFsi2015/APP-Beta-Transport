package Bbdd;

/**
 * Identificador, id_cliente, id_producto, tipo_viaje, fecha_entrega, fecha_recogida
 * @author Marco Ant. Quirós
 * @version 1.1 */
public class Transporte extends Actualizador{
	
	int id, idCliente, idProducto;
	String fechaEntrega, fechaRecogida, tipoViaje;
	
	/**
	 * Constructor nulo para usar las querys de insercion de datos */
	public Transporte(){}
	/**
	 * @param id
	 * @param idCliente
	 * @param idProducto
	 * @param tipoViaje
	 * @param fechaEntrega
	 * @param fechaRecogida */
	public Transporte(int id, int idCliente, int idProducto, String tipoViaje,
			String fechaEntrega, String fechaRecogida) {
		this.id = id;
		this.idCliente = idCliente;
		this.idProducto = idProducto;
		this.tipoViaje = tipoViaje;
		this.fechaEntrega = fechaEntrega;
		this.fechaRecogida = fechaRecogida;
	}
	
	/**
	 * Inserta un nuevo registro en la tabla Transporte
	 * @param id <code>Integer</code>
	 * @param idCliente <code>Integer</code>
	 * @param idProducto <code>Integer</code>
	 * @param tipoViaje <code>boolean</code>
	 * @param fechaEntrega <code>String</code>
	 * @param fechaRecogida <code>String</code>
	 * @return boolean */
	public boolean insertar(int id, int idCliente, int idProducto, String tipoViaje,
			String fechaEntrega, String fechaRecogida){
		String query = "INSERT INTO Transporte (Id_Transporte, Id_Cliente, Id_Producto, Tipo_Viaje, Fecha_Entrega, Fecha_Recogida) "
				+ "VALUES ("+id+", "+idCliente+", "+idProducto+", '"+tipoViaje+"', #"+fechaEntrega+"#, #"+fechaRecogida+"#)";
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Actualiza un registro en la BBDD
	 * @return boolean */
	public boolean actualizar(){
		String query = "UPDATE Transporte SET Id_Cliente = "+this.getIdCliente()+", Id_Producto = "+this.getIdProducto()+", Tipo_Viaje = '"+this.isTipoViaje()+"', Fecha_Entrega = #"+this.getFechaEntrega()+"#, Fecha_Recogida = #"+this.getFechaRecogida()+"# WHERE Id_Transporte = "+this.getId();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Actualiza un registro en la BBDD pasado por parametro
	 * @param p <code>{@link #Transporte}</code>
	 * @return boolean */
	public boolean actualizar(Transporte p){
		String query = "UPDATE Transporte SET Id_Cliente = "+p.getIdCliente()+", Id_Producto = "+p.getIdProducto()+", Tipo_Viaje = '"+p.isTipoViaje()+"', Fecha_Entrega = #"+p.getFechaEntrega()+"#, Fecha_Recogida = #"+p.getFechaRecogida()+"# WHERE Id_Transporte = "+p.getId();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Elimina un registro de la BBDD
	 * @return boolean */
	public boolean eliminar(){
		String query = "DELETE FROM Transporte WHERE Id_Transporte = "+this.getId();
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
	 * @return the idCliente */
	public int getIdCliente() {
		return idCliente;
	}
	/**
	 * @return the idProducto */
	public int getIdProducto() {
		return idProducto;
	}
	/**
	 * @return the tipoViaje */
	public String isTipoViaje() {
		return tipoViaje;
	}
	/**
	 * @return the fechaEntrega */
	public String getFechaEntrega() {
		return fechaEntrega.substring(0, 10);
	}
	/**
	 * @return the fechaRecogida */
	public String getFechaRecogida() {
		return fechaRecogida.substring(0, 10);
	}
	/**
	 * @param id the id to set */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param idCliente <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setIdCliente(int idCliente, boolean update) {
		this.idCliente = idCliente;
		if(update){
			String query = "UPDATE Transporte SET Id_Cliente = " + idCliente + " WHERE Id_Transporte = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param idProducto <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setIdProducto(int idProducto, boolean update) {
		this.idProducto = idProducto;
		if(update){
			String query = "UPDATE Transporte SET Id_Producto = " + idProducto + " WHERE Id_Transporte = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param tipoViaje <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setTipoViaje(String tipoViaje, boolean update) {
		this.tipoViaje = tipoViaje;
		if(update){
			String query = "UPDATE Transporte SET Tipo_Viaje = '" + tipoViaje + "' WHERE Id_Transporte = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param fechaEntrega <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setFechaEntrega(String fechaEntrega, boolean update) {
		this.fechaEntrega = fechaEntrega;
		if(update){
			String query = "UPDATE Transporte SET Fecha_Entrega = #" + fechaEntrega + "# WHERE Id_Transporte = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param fechaRecogida <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setFechaRecogida(String fechaRecogida, boolean update) {
		this.fechaRecogida = fechaRecogida;
		if(update){
			String query = "UPDATE Transporte SET Fecha_Recogida = #" + fechaRecogida + "# WHERE Id_Transporte = " + this.id;
			updateQuery(query);
		}
	}

}