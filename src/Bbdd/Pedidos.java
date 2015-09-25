package Bbdd;



/**
 * Identificador, id_empleado, id_cliente, id_producto, unidades
 * precio_venta_ud, fecha_pedido, fecha_entrega
 * @author Marco Ant. Quirós
 * @version 1.1 */
public class Pedidos extends Actualizador{
	
	int idPedido, idEmpleado, idCliente, idProducto, unidades;
	double precioVentaUd;
	String fechaPedido, fechaEntrega;
	
	/**
	 * Constructor nulo para usar las querys de insercion de datos */
	public Pedidos(){}
	/**
	 * @param idPedido
	 * @param idEmpleado
	 * @param idCliente
	 * @param idProducto
	 * @param unidades
	 * @param precioVentaUd
	 * @param fechaPedido
	 * @param fechaEntrega */
	public Pedidos(int idPedido, int idEmpleado, int idCliente, int idProducto,
			int unidades, double precioVentaUd, String fechaPedido,
			String fechaEntrega) {
		this.idPedido = idPedido;
		this.idEmpleado = idEmpleado;
		this.idCliente = idCliente;
		this.idProducto = idProducto;
		this.unidades = unidades;
		this.precioVentaUd = precioVentaUd;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
	}
	
	/**
	 * Inserta un nuevo registro en la tabla Pedidos
	 * @param idPedido <code>Integer</code>
	 * @param idEmpleado <code>Integer</code>
	 * @param idCliente <code>Integer</code>
	 * @param idProducto <code>Integer</code>
	 * @param unidades <code>Integer</code>
	 * @param precioVentaUd <code>Double</code>
	 * @param fechaPedido <code>String</code>
	 * @param fechaEntrega <code>String</code>
	 * @return boolean */
	public boolean insertar(int idPedido, int idEmpleado, int idCliente, int idProducto,
			int unidades, double precioVentaUd, String fechaPedido,
			String fechaEntrega){
		String query = "INSERT INTO Pedidos (Id_Pedido, Id_Empleado, Id_Cliente, Id_Producto, Unidades, Precio_Venta_Ud, Fecha_Pedido, Fecha_Entrega) "
				+ "VALUES ("+idPedido+", "+idEmpleado+", "+idCliente+", "+idProducto+", "+unidades+", "+precioVentaUd+", #"+fechaPedido+"#, #"+fechaEntrega+"#)";
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Actualiza un registro en la BBDD
	 * @return boolean */
	public boolean actualizar(){
		String query = "UPDATE Pedidos SET Id_Empleado = "+this.getIdEmpleado()+", Id_Cliente = "+this.getIdCliente()+", Id_Producto = "+this.getIdProducto()+", Unidades = "+this.getUnidades()+", Precio_Venta_Ud = "+this.getPrecioVentaUd()+", Fecha_Pedido = #"+this.getFechaPedido()+"#, Fecha_Entrega = #"+this.getFechaEntrega()+"# WHERE Id_Pedido = "+this.getIdPedido();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Actualiza un registro en la BBDD pasado por parametro
	 * @param p <code>{@link #Pedidos}</code>
	 * @return boolean */
	public boolean actualizar(Pedidos p){
		String query = "UPDATE Pedidos SET Id_Empleado = "+p.getIdEmpleado()+", Id_Cliente = "+p.getIdCliente()+", Id_Producto = "+p.getIdProducto()+", Unidades = "+p.getUnidades()+", Precio_Venta_Ud = "+p.getPrecioVentaUd()+", Fecha_Pedido = #"+p.getFechaPedido()+"#, Fecha_Entrega = #"+p.getFechaEntrega()+"# WHERE Id_Pedido = "+p.getIdPedido();;
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Elimina un registro de la BBDD
	 * @return boolean */
	public boolean eliminar(){
		String query = "DELETE FROM Pedidos WHERE Id_Pedido = "+this.getIdPedido();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * @return the idPedido */
	public int getIdPedido() {
		return idPedido;
	}
	/**
	 * @return the idEmpleado */
	public int getIdEmpleado() {
		return idEmpleado;
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
	 * @return the unidades */
	public int getUnidades() {
		return unidades;
	}
	/**
	 * @return the precioVentaUd */
	public double getPrecioVentaUd() {
		return precioVentaUd;
	}
	/**
	 * @return the fechaPedido */
	public String getFechaPedido() {
		return fechaPedido.substring(0, 10);
	}
	/**
	 * @return the fechaEntrega */
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	/**
	 * @param idPedido the idPedido to set */
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	/**
	 * @param idEmpleado <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setIdEmpleado(int idEmpleado, boolean update) {
		this.idEmpleado = idEmpleado;
		if(update){
			String query = "UPDATE Pedidos SET Id_Empleado = " + idEmpleado + " WHERE Id_Pedido = " + this.idPedido;
			updateQuery(query);
		}
	}
	/**
	 * @param idCliente <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setIdCliente(int idCliente, boolean update) {
		this.idCliente = idCliente;
		if(update){
			String query = "UPDATE Pedidos SET Id_Cliente = " + idCliente + " WHERE Id_Pedido = " + this.idPedido;
			updateQuery(query);
		}
	}
	/**
	 * @param idProducto <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setIdProducto(int idProducto, boolean update) {
		this.idProducto = idProducto;
		if(update){
			String query = "UPDATE Pedidos SET Id_Producto = " + idProducto + " WHERE Id_Pedido = " + this.idPedido;
			updateQuery(query);
		}
	}
	/**
	 * @param unidades <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setUnidades(int unidades, boolean update) {
		this.unidades = unidades;
		if(update){
			String query = "UPDATE Pedidos SET Unidades = " + unidades + " WHERE Id_Pedido = " + this.idPedido;
			updateQuery(query);
		}
	}
	/**
	 * @param precioVentaUd <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setPrecioVentaUd(double precioVentaUd, boolean update) {
		this.precioVentaUd = precioVentaUd;
		if(update){
			String query = "UPDATE Pedidos SET Precio_Venta_Ud = " + precioVentaUd + " WHERE Id_Pedido = " + this.idPedido;
			updateQuery(query);
		}
	}
	/**
	 * @param fechaPedido <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setFechaPedido(String fechaPedido, boolean update) {
		this.fechaPedido = fechaPedido;
		if(update){
			String query = "UPDATE Pedidos SET Fecha_Pedido = #" + fechaPedido + "# WHERE Id_Pedido = " + this.idPedido;
			updateQuery(query);
		}
	}
	/**
	 * @param fechaEntrega <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setFechaEntrega(String fechaEntrega, boolean update) {
		this.fechaEntrega = fechaEntrega;
		if(update){
			String query = "UPDATE Pedidos SET Fecha_Entrega = #" + fechaEntrega + "# WHERE Id_Pedido = " + this.idPedido;
			updateQuery(query);
		}
	}

}
