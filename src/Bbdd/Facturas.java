package Bbdd;



/**
 * Identificador, id_pedido, fecha_factura, tipo_pago, iva, descuento
 * @author Marco Ant. Quirós
 * @version 1.1 */
public class Facturas extends Actualizador{
	
	int idFactura, idPedido;
	String fechaF, tipoPago;
	double iva, descuento;
	
	/**
	 * Constructor nulo para usar las querys de insercion de datos */
	public Facturas(){}
	/**
	 * @param idFactura
	 * @param idPedido
	 * @param fechaF
	 * @param tipoPago
	 * @param iva
	 * @param descuento
	 */
	public Facturas(int idFactura, int idPedido, String fechaF,
			String tipoPago, double iva, double descuento) {
		this.idFactura = idFactura;
		this.idPedido = idPedido;
		this.fechaF = fechaF;
		this.tipoPago = tipoPago;
		this.iva = iva;
		this.descuento = descuento;
	}
	
	/**
	 * Inserta un nuevo registro en la tabla Facturas
	 * @param idFactura <code>Integer</code>
	 * @param idPedido <code>Integer</code>
	 * @param fechaF <code>String</code>
	 * @param tipoPago <code>String</code>
	 * @param iva <code>Double</code>
	 * @param descuento <code>Double</code>
	 * @return boolean
	 */
	public boolean insertar(int idFactura, int idPedido, String fechaF,
			String tipoPago, double iva, double descuento){
		String query = "INSERT INTO Facturas (Id_Factura, Id_Pedido, Fecha_Factura, Tipo_Pago, IVA, Descuento) "
				+ "VALUES ("+idFactura+", "+idPedido+", #"+fechaF+"#, '"+tipoPago+"', "+iva+", "+descuento+")";
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Actualiza un registro en la BBDD
	 * @return boolean
	 */
	public boolean actualizar(){
		String query = "UPDATE Facturas SET Id_Pedido = "+this.getIdPedido()+", Fecha_Factura = #"+this.getFechaF()+"#, Tipo_Pago = '"+this.getTipoPago()+"', IVA = "+this.getIva()+", Descuento = "+this.getDescuento()+" WHERE Id_Empleado = " + this.getIdFactura();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Actualiza un registro en la BBDD pasado por parametro
	 * @param f <code>{@link #Facturas}</code>
	 * @return boolean
	 */
	public boolean actualizar(Facturas f){
		String query = "UPDATE Facturas SET Id_Pedido = "+f.getIdPedido()+", Fecha_Factura = #"+f.getFechaF()+"#, Tipo_Pago = '"+f.getTipoPago()+"', IVA = "+f.getIva()+", Descuento = "+f.getDescuento()+" WHERE Id_Empleado = " + f.getIdFactura();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Elimina un registro de la BBDD
	 * @return boolean
	 */
	public boolean eliminar(){
		String query = "DELETE FROM Facturas WHERE Id_Factura = "+this.getIdFactura();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * @return the idFactura
	 */
	public int getIdFactura() {
		return idFactura;
	}
	/**
	 * @return the idPedido
	 */
	public int getIdPedido() {
		return idPedido;
	}
	/**
	 * @return the fechaF
	 */
	public String getFechaF() {
		return fechaF.substring(0, 10);
	}
	/**
	 * @return the tipoPago
	 */
	public String getTipoPago() {
		return tipoPago;
	}
	/**
	 * @return the iva
	 */
	public double getIva() {
		return iva;
	}
	/**
	 * @return the descuento
	 */
	public double getDescuento() {
		return descuento;
	}
	/**
	 * @param idFactura the idFactura to set
	 */
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	/**
	 * @param idPedido <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setIdPedido(int idPedido, boolean update) {
		this.idPedido = idPedido;
		if(update){
			String query = "UPDATE Facturas SET Id_Pedido = '" + idPedido + "' WHERE Id_Factura = " + this.idFactura;
			updateQuery(query);
		}
	}
	/**
	 * @param fechaF <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setFechaF(String fechaF, boolean update) {
		this.fechaF = fechaF;
		if(update){
			String query = "UPDATE Facturas SET Fecha_Factura = #" + fechaF + "# WHERE Id_Factura = " + this.idFactura;
			updateQuery(query);
		}
	}
	/**
	 * @param tipoPago <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setTipoPago(String tipoPago, boolean update) {
		this.tipoPago = tipoPago;
		if(update){
			String query = "UPDATE Facturas SET Tipo_Pago = '" + tipoPago + "' WHERE Id_Factura = " + this.idFactura;
			updateQuery(query);
		}
	}
	/**
	 * @param iva <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setIva(double iva, boolean update) {
		this.iva = iva;
		if(update){
			String query = "UPDATE Facturas SET IVA = '" + iva + "' WHERE Id_Factura = " + this.idFactura;
			updateQuery(query);
		}
	}
	/**
	 * @param descuento <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setDescuento(double descuento, boolean update) {
		this.descuento = descuento;
		if(update){
			String query = "UPDATE Facturas SET Descuento = " + descuento + " WHERE Id_Factura = " + this.idFactura;
			updateQuery(query);
		}
	}

}
