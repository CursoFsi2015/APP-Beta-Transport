package Bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 * Instancia un objeto con las tablas de la BBDD
 * @author Marco Ant. Quirós
 * @version 1.0 */
public class Tablas {
	
	public HashMap<Integer, Departamentos> departamentos = new HashMap<Integer, Departamentos>();
	public HashMap<Integer, Empleados> empleados = new HashMap<Integer, Empleados>();
	public HashMap<Integer, Almacen> almacen = new HashMap<Integer, Almacen>();
	public HashMap<Integer, Clientes> clientes = new HashMap<Integer, Clientes>();
	public HashMap<Integer, Facturas> facturas = new HashMap<Integer, Facturas>();
	public HashMap<Integer, Pedidos> pedidos = new HashMap<Integer, Pedidos>();
	public HashMap<Integer, Productos> productos = new HashMap<Integer, Productos>();
	public HashMap<Integer, Proveedores> proveedores = new HashMap<Integer, Proveedores>();
	public HashMap<Integer, ServicioTecnico> servicioTecnico = new HashMap<Integer, ServicioTecnico>();
	public HashMap<Integer, Transporte> transporte = new HashMap<Integer, Transporte>();
	
	String departamentosQuery = "SELECT * FROM Departamentos",
			empleadosQuery = "SELECT * FROM Empleados",
			almacenQuery = "SELECT * FROM Almacen",
			clientesQuery = "SELECT * FROM Clientes",
			facturasQuery = "SELECT * FROM Facturas",
			pedidosQuery = "SELECT * FROM Pedidos",
			productosQuery = "SELECT * FROM Productos",
			proveedoresQuery = "SELECT * FROM Proveedores",
			servicioTecnicoQuery = "SELECT * FROM Reparaciones",
			transporteQuery = "SELECT * FROM Transporte";
	
	public Tablas(){
		ConexionAccess bbdd = new ConexionAccess();
		bbdd.conectar();
		ResultSet departamentosMap = bbdd.selectQuery(departamentosQuery),
				empleadosMap = bbdd.selectQuery(empleadosQuery),
				almacenMap = bbdd.selectQuery(almacenQuery),
				clientesMap = bbdd.selectQuery(clientesQuery),
				facturasMap = bbdd.selectQuery(facturasQuery),
				pedidosMap = bbdd.selectQuery(pedidosQuery),
				productosMap = bbdd.selectQuery(productosQuery),
				proveedoresMap = bbdd.selectQuery(proveedoresQuery),
				servicioTecnicoMap = bbdd.selectQuery(servicioTecnicoQuery),
				transporteMap = bbdd.selectQuery(transporteQuery);
		bbdd.desconectar();
		try {
			while(departamentosMap.next()){
				departamentos.put(departamentosMap.getInt("Id_Departamento"), //indice del HashMap
						new Departamentos( //contenido
								departamentosMap.getInt("Id_Departamento"),
								departamentosMap.getString("Nombre"),
								departamentosMap.getString("Direccion"),
								departamentosMap.getString("Localidad"),
								departamentosMap.getInt("Codigo_Postal"),
								departamentosMap.getString("Descripcion")));
			}
			while(empleadosMap.next()){
				empleados.put(empleadosMap.getInt("Id_Empleado"), //indice del HashMap
						new Empleados( //contenido
								empleadosMap.getInt("Id_empleado"),
								empleadosMap.getString("Nombre"),
								empleadosMap.getString("Apellido1"),
								empleadosMap.getString("Apellido2"),
								empleadosMap.getString("DNI"),
								empleadosMap.getString("Fecha_Ingreso"),
								empleadosMap.getString("Fecha_Despido"),
								empleadosMap.getDouble("Salario"),
								empleadosMap.getDouble("Comision"),
								empleadosMap.getBoolean("Objetivo"),
								empleadosMap.getString("Password"),
								empleadosMap.getInt("Id_Departamento")));
			}
			while(almacenMap.next()){
				almacen.put(almacenMap.getInt("Id_Producto"), //indice del HashMap
						new Almacen( //contenido
								almacenMap.getInt("Id_Producto"),
								almacenMap.getInt("Partida_Compra"),
								almacenMap.getInt("Stock_Libre"),
								almacenMap.getInt("Stock_Reservado")));
			}
			while(clientesMap.next()){
				clientes.put(clientesMap.getInt("Id_Cliente"), //indice del HashMap
						new Clientes( //contenido
								clientesMap.getInt("Id_Cliente"),
								clientesMap.getString("Nombre_Razon_Social"),
								clientesMap.getString("DNI_NIF"),
								clientesMap.getString("Direccion"),
								clientesMap.getString("Telefono"),
								clientesMap.getString("Fax"),
								clientesMap.getString("Email")));
			}
			while(facturasMap.next()){
				facturas.put(facturasMap.getInt("Id_Factura"), //indice del HashMap
						new Facturas( //contenido
								facturasMap.getInt("Id_Factura"),
								facturasMap.getInt("Id_Pedido"),
								facturasMap.getString("Fecha_Factura"),
								facturasMap.getString("Tipo_Pago"),
								facturasMap.getDouble("IVA"),
								facturasMap.getDouble("Descuento")));
			}
			while(pedidosMap.next()){
				pedidos.put(pedidosMap.getInt("Id_Pedido"), //indice del HashMap
						new Pedidos( //contenido
								pedidosMap.getInt("Id_Pedido"),
								pedidosMap.getInt("Id_Empleado"),
								pedidosMap.getInt("Id_Cliente"),
								pedidosMap.getInt("Id_Producto"),
								pedidosMap.getInt("Unidades"),
								pedidosMap.getInt("Precio_Venta_Ud"),
								pedidosMap.getString("Fecha_Pedido"),
								pedidosMap.getString("Fecha_Entrega")));
			}
			while(productosMap.next()){
				productos.put(productosMap.getInt("Id_Producto"), //indice del HashMap
						new Productos( //contenido
								productosMap.getInt("Id_Producto"),
								productosMap.getInt("Partida_Compra"),
								productosMap.getInt("Id_Empleado"),
								productosMap.getInt("Id_Proveedor"),
								productosMap.getString("Familia"),
								productosMap.getString("SubFamilia"),
								productosMap.getString("Marca"),
								productosMap.getString("Modelo"),
								productosMap.getString("Fecha_Compra"),
								productosMap.getDouble("Precio_Compra_Ud"),
								productosMap.getInt("Unidades")));
			}
			while(proveedoresMap.next()){
				proveedores.put(proveedoresMap.getInt("Id_Proveedor"), //indice del HashMap
						new Proveedores( //contenido
								proveedoresMap.getInt("Id_Proveedor"),
								proveedoresMap.getString("Razon_Social"),
								proveedoresMap.getString("NIF"),
								proveedoresMap.getString("Direccion"),
								proveedoresMap.getString("Telefono"),
								proveedoresMap.getString("Fax"),
								proveedoresMap.getString("Email")));
			}
			while(servicioTecnicoMap.next()){
				servicioTecnico.put(servicioTecnicoMap.getInt("Id_Reparacion"), //indice del HashMap
						new ServicioTecnico( //contenido
								servicioTecnicoMap.getInt("Id_Reparacion"),
								servicioTecnicoMap.getInt("Id_Cliente"),
								servicioTecnicoMap.getInt("Id_Producto"),
								servicioTecnicoMap.getInt("Id_Factura"),
								servicioTecnicoMap.getString("Descripcion_Averia"),
								servicioTecnicoMap.getBoolean("Garantia"),
								servicioTecnicoMap.getString("Fecha_Entrada"),
								servicioTecnicoMap.getString("Fecha_Salida"),
								servicioTecnicoMap.getString("Estado")));
			}
			while(transporteMap.next()){
				transporte.put(transporteMap.getInt("Id_Transporte"), //indice del HashMap
						new Transporte( //contenido
								transporteMap.getInt("Id_Transporte"),
								transporteMap.getInt("Id_Cliente"),
								transporteMap.getInt("Id_Producto"),
								transporteMap.getString("Tipo_Viaje"),
								transporteMap.getString("Fecha_Entrega"),
								transporteMap.getString("Fecha_Recogida")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, this.getClass().getSimpleName() + ".construct()\n" + e.getMessage());
		}
		
	}
	
}
