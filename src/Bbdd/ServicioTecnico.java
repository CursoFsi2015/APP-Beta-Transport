package Bbdd;



/**
 * Identificador, id_cliente, id_producto, id_factura, descripcion_averia, garantia,
 * fecha_entrada, fecha_salida, estado
 * @author Marco Ant. Quirós
 * @version 1.1 */
public class ServicioTecnico extends Actualizador{
	
	int id, idCliente, idProducto, idFactura;
	String descripcionAveria, fechaEntrada, fechaSalida, estado;
	boolean garantia;
	
	/**
	 * Constructor nulo para usar las querys de insercion de datos */
	public ServicioTecnico(){}
	/**
	 * @param id
	 * @param idCliente
	 * @param idProducto
	 * @param idFactura
	 * @param descripcionAveria
	 * @param fechaEntrada
	 * @param fechaSalida
	 * @param estado
	 * @param garantia */
	public ServicioTecnico(int id, int idCliente, int idProducto,
			int idFactura, String descripcionAveria, boolean garantia, String fechaEntrada,
			String fechaSalida, String estado) {
		this.id = id;
		this.idCliente = idCliente;
		this.idProducto = idProducto;
		this.idFactura = idFactura;
		this.descripcionAveria = descripcionAveria;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.estado = estado;
		this.garantia = garantia;
	}
	
	/**
	 * Inserta un nuevo registro en la tabla Reparaciones
	 * @param id <code>Integer</code>
	 * @param idCliente <code>Integer</code>
	 * @param idProducto <code>Integer</code>
	 * @param idFactura <code>Integer</code>
	 * @param descripcionAveria <code>String</code>
	 * @param garantia <code>boolean</code>
	 * @param fechaEntrada <code>String</code>
	 * @param fechaSalida <code>String</code>
	 * @param estado <code>String</code>
	 * @return boolean */
	public boolean insertar(int id, int idCliente, int idProducto,
			int idFactura, String descripcionAveria, boolean garantia, String fechaEntrada,
			String fechaSalida, String estado){
		String query = "INSERT INTO Reparaciones (Id_Reparacion, Id_Cliente, Id_Producto, Id_Factura, Descripcion_Averia, Garantia, Fecha_Entrada, Fecha_Salida, Estado) "
				+ "VALUES ("+id+", "+idCliente+", "+idProducto+", "+idFactura+", '"+descripcionAveria+"', "+garantia+", #"+fechaEntrada+"#, #"+fechaSalida+"#, '"+estado+"')";
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Actualiza un registro en la BBDD
	 * @return boolean */
	public boolean actualizar(){
		String query = "UPDATE Reparaciones SET Id_Cliente = "+this.getIdCliente()+", Id_Producto = "+this.getIdProducto()+", Id_Factura = "+this.getIdFactura()+", Descripcion_Averia = '"+this.getDescripcionAveria()+"', Garantia = "+this.isGarantia()+", Fecha_Entrada = #"+this.getFechaEntrada()+"#, Fecha_Salida = #"+this.getFechaSalida()+"#, Estado = '"+this.getEstado()+"' WHERE Id_Reparacion = "+this.getId();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Actualiza un registro en la BBDD pasado por parametro
	 * @param p <code>{@link #ServicioTecnico}</code>
	 * @return boolean */
	public boolean actualizar(ServicioTecnico p){
		String query = "UPDATE Reparaciones SET Id_Cliente = "+p.getIdCliente()+", Id_Producto = "+p.getIdProducto()+", Id_Factura = "+p.getIdFactura()+", Descripcion_Averia = '"+p.getDescripcionAveria()+"', Garantia = "+p.isGarantia()+", Fecha_Entrada = #"+p.getFechaEntrada()+"#, Fecha_Salida = #"+p.getFechaSalida()+"#, Estado = '"+p.getEstado()+"' WHERE Id_Reparacion = "+p.getId();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Elimina un registro de la BBDD
	 * @return boolean */
	public boolean eliminar(){
		String query = "DELETE FROM Reparaciones WHERE Id_Reparacion = "+this.getId();
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
	 * @return the idFactura */
	public int getIdFactura() {
		return idFactura;
	}
	/**
	 * @return the descripcionAveria */
	public String getDescripcionAveria() {
		return descripcionAveria;
	}
	/**
	 * @return the fechaEntrada */
	public String getFechaEntrada() {
		return fechaEntrada.substring(0, 10);
	}
	/**
	 * @return the fechaSalida */
	public String getFechaSalida() {
		return fechaSalida.substring(0, 10);
	}
	/**
	 * @return the estado */
	public String getEstado() {
		return estado;
	}
	/**
	 * @return the garantia */
	public boolean isGarantia() {
		return garantia;
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
			String query = "UPDATE Reparaciones SET Id_Cliente = '" + idCliente + "' WHERE Id_Reparacion = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param idProducto <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setIdProducto(int idProducto, boolean update) {
		this.idProducto = idProducto;
		if(update){
			String query = "UPDATE Reparaciones SET Id_Producto = '" + idProducto + "' WHERE Id_Reparacion = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param idFactura <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setIdFactura(int idFactura, boolean update) {
		this.idFactura = idFactura;
		if(update){
			String query = "UPDATE Reparaciones SET Id_Factura = '" + idFactura + "' WHERE Id_Reparacion = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param descripcionAveria <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setDescripcionAveria(String descripcionAveria, boolean update) {
		this.descripcionAveria = descripcionAveria;
		if(update){
			String query = "UPDATE Reparaciones SET Descripcion_Averia = '" + descripcionAveria + "' WHERE Id_Reparacion = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param fechaEntrada <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setFechaEntrada(String fechaEntrada, boolean update) {
		this.fechaEntrada = fechaEntrada;
		if(update){
			String query = "UPDATE Reparaciones SET Fecha_Entrada = #" + fechaEntrada + "# WHERE Id_Reparacion = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param fechaSalida <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setFechaSalida(String fechaSalida, boolean update) {
		this.fechaSalida = fechaSalida;
		if(update){
			String query = "UPDATE Reparaciones SET Fecha_Salida = #" + fechaSalida + "# WHERE Id_Reparacion = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param estado <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setEstado(String estado, boolean update) {
		this.estado = estado;
		if(update){
			String query = "UPDATE Reparaciones SET Estado = '" + estado + "' WHERE Id_Reparacion = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param garantia <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setGarantia(boolean garantia, boolean update) {
		this.garantia = garantia;
		if(update){
			String query = "UPDATE Reparaciones SET Garantia = '" + garantia + "' WHERE Id_Reparacion = " + this.id;
			updateQuery(query);
		}
	}

}
