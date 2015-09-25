package Bbdd;



/**
 * Identificador, partida_compra, id_empleado, id_proveedor, familia, subfamilia,
 * marca, modelo, fecha_compra, precio_compra_ud, unidades
 * @author Marco Ant. Quirós
 * @version 1.1 */
public class Productos extends Actualizador{
	
	int id, partidaCompra, idEmpleado, idProveedor, unidades;
	String familia, subFamilia, marca, modelo, fechaCompra;
	double precioCompraUd;
	
	/**
	 * Constructor nulo para usar las querys de insercion de datos */
	public Productos(){}
	/**
	 * @param id
	 * @param partidaCompra
	 * @param idEmpleado
	 * @param idProveedor
	 * @param precioCompraUd
	 * @param unidades
	 * @param familia
	 * @param subFamilia
	 * @param marca
	 * @param modelo
	 * @param fechaCompra
	 */
	public Productos(int id, int partidaCompra, int idEmpleado,
			int idProveedor,  String familia, String subFamilia, String marca, 
			String modelo, String fechaCompra, double precioCompraUd, int unidades) {
		this.id = id;
		this.partidaCompra = partidaCompra;
		this.idEmpleado = idEmpleado;
		this.idProveedor = idProveedor;
		this.precioCompraUd = precioCompraUd;
		this.unidades = unidades;
		this.familia = familia;
		this.subFamilia = subFamilia;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaCompra = fechaCompra;
	}
	
	/**
	 * Inserta un nuevo registro en la tabla Productos
	 * @param id <code>Integer</code>
	 * @param partidaCompra <code>Integer</code>
	 * @param idEmpleado <code>Integer</code>
	 * @param idProveedor <code>Integer</code>
	 * @param familia <code>String</code>
	 * @param subFamilia <code>String</code>
	 * @param marca <code>String</code>
	 * @param modelo <code>String</code>
	 * @param fechaCompra <code>String</code>
	 * @param precioCompraUd <code>Double</code>
	 * @param unidades <code>Integer</code>
	 * @return boolean */
	public boolean insertar(int id, int partidaCompra, int idEmpleado,
			int idProveedor,  String familia, String subFamilia, String marca, 
			String modelo, String fechaCompra, double precioCompraUd, int unidades){
		String query = "INSERT INTO Productos (Id_Producto, Partida_Compra, Id_Empleado, Id_Proveedor, Familia, SubFamilia, Marca, Modelo, Fecha_Compra, Precio_Compra_Ud, Unidades) "
				+ "VALUES ("+id+", "+partidaCompra+", "+idEmpleado+", "+idProveedor+", '"+familia+"', '"+subFamilia+"', '"+marca+"', '"+modelo+"', #"+fechaCompra+"#, "+precioCompraUd+", "+unidades+")";
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Actualiza un registro en la BBDD
	 * @return boolean */
	public boolean actualizar(){
		String query = "UPDATE Productos SET Partida_Compra = "+this.getPartidaCompra()+", Id_Empleado = "+this.getIdEmpleado()+", Id_Proveedor = "+this.getIdProveedor()+", Familia = '"+this.getFamilia()+"', SubFamilia = '"+this.getSubFamilia()+"', Marca = '"+this.getMarca()+"', Modelo = '"+this.getModelo()+"', Fecha_Compra = #"+this.getFechaCompra()+"#, Precio_Compra_Ud = "+this.getPrecioCompraUd()+", Unidades = "+this.getUnidades()+" WHERE Id_Producto = "+this.getId();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Actualiza un registro en la BBDD pasado por parametro
	 * @param p <code>{@link #Productos}</code>
	 * @return boolean */
	public boolean actualizar(Productos p){
		String query = "UPDATE Productos SET Partida_Compra = "+p.getPartidaCompra()+", Id_Empleado = "+p.getIdEmpleado()+", Id_Proveedor = "+p.getIdProveedor()+", Familia = '"+p.getFamilia()+"', SubFamilia = '"+p.getSubFamilia()+"', Marca = '"+p.getMarca()+"', Modelo = '"+p.getModelo()+"', Fecha_Compra = '"+p.getFechaCompra()+"', Precio_Compra_Ud = "+p.getPrecioCompraUd()+", Unidades = "+p.getUnidades()+" WHERE Id_Producto = "+p.getId();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Elimina un registro de la BBDD
	 * @return boolean */
	public boolean eliminar(){
		String query = "DELETE FROM Productos WHERE Id_Producto = "+this.getId();
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
	 * @return the partidaCompra */
	public int getPartidaCompra() {
		return partidaCompra;
	}
	/**
	 * @return the idEmpleado */
	public int getIdEmpleado() {
		return idEmpleado;
	}
	/**
	 * @return the idProveedor */
	public int getIdProveedor() {
		return idProveedor;
	}
	/**
	 * @return the precioCompraUd */
	public double getPrecioCompraUd() {
		return precioCompraUd;
	}
	/**
	 * @return the unidades */
	public int getUnidades() {
		return unidades;
	}
	/**
	 * @return the familia */
	public String getFamilia() {
		return familia;
	}
	/**
	 * @return the subFamilia */
	public String getSubFamilia() {
		return subFamilia;
	}
	/**
	 * @return the marca */
	public String getMarca() {
		return marca;
	}
	/**
	 * @return the modelo */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @return the fechaCompra */
	public String getFechaCompra() {
		return fechaCompra.substring(0, 10);
	}
	/**
	 * @param id the id to set */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param partidaCompra <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setPartidaCompra(int partidaCompra, boolean update) {
		this.partidaCompra = partidaCompra;
		if(update){
			String query = "UPDATE Productos SET Partida_Compra = " + partidaCompra + " WHERE Id_Producto = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param idEmpleado <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setIdEmpleado(int idEmpleado, boolean update) {
		this.idEmpleado = idEmpleado;
		if(update){
			String query = "UPDATE Productos SET Id_Empleado = " + idEmpleado + " WHERE Id_Producto = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param idProveedor <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setIdProveedor(int idProveedor, boolean update) {
		this.idProveedor = idProveedor;
		if(update){
			String query = "UPDATE Productos SET Id_Proveedor = " + idProveedor + " WHERE Id_Producto = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param precioCompraUd <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setPrecioCompraUd(int precioCompraUd, boolean update) {
		this.precioCompraUd = precioCompraUd;
		if(update){
			String query = "UPDATE Productos SET Precio_Compra_Ud = " + precioCompraUd + " WHERE Id_Producto = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param unidades <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setUnidades(int unidades, boolean update) {
		this.unidades = unidades;
		if(update){
			String query = "UPDATE Productos SET Unidades = " + unidades + " WHERE Id_Producto = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param familia <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setFamilia(String familia, boolean update) {
		this.familia = familia;
		if(update){
			String query = "UPDATE Productos SET Familia = '" + familia + "' WHERE Id_Producto = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param subFamilia <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setSubFamilia(String subFamilia, boolean update) {
		this.subFamilia = subFamilia;
		if(update){
			String query = "UPDATE Productos SET SubFamilia = '" + subFamilia + "' WHERE Id_Producto = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param marca <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setMarca(String marca, boolean update) {
		this.marca = marca;
		if(update){
			String query = "UPDATE Productos SET Marca = '" + marca + "' WHERE Id_Producto = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param modelo <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setModelo(String modelo, boolean update) {
		this.modelo = modelo;
		if(update){
			String query = "UPDATE Productos SET Modelo = '" + modelo + "' WHERE Id_Producto = " + this.id;
			updateQuery(query);
		}
	}
	/**
	 * @param fechaCompra <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setFechaCompra(String fechaCompra, boolean update) {
		this.fechaCompra = fechaCompra;
		if(update){
			String query = "UPDATE Productos SET Fecha_Compra = #" + fechaCompra + "# WHERE Id_Producto = " + this.id;
			updateQuery(query);
		}
	}

}
