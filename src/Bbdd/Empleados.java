package Bbdd;


/**
 * Identificador, nombre, apellido1, apellido2, DNI, fecha alta, fecha baja,
 * salario, comision, objetivo, contraseña, departamento
 * @author Marco Ant. Quirós
 * @version 1.1 */
public class Empleados extends Actualizador{
	
	int id, idDept;
	double comision, salario;
	String nombre, ap1, ap2, dni, fechaI, fechaD, password;
	boolean objetivo;
	
	/**
	 * Constructor nulo para usar las querys de insercion de datos */
	public Empleados(){}
	/**
	 * Instancia el objeto con los siguientes parametros
	 * @param id <code>Integer Identificador</code>
	 * @param nombre <code>String nombre</code>
	 * @param a1 <code>String apellido1</code>
	 * @param a2 <code>String apellido2</code>
	 * @param dni <code>String dni</code>
	 * @param fi <code>String fecha alta</code>
	 * @param fd <code>String fecha baja</code>
	 * @param sal <code>Double salario</code>
	 * @param comm <code>Double comision</code>
	 * @param obj <code>Boolean objetivos</code>
	 * @param pass <code>String contraseña</code>
	 * @param iD <code>Integer id_departamento</code> */
	Empleados(int id, String nombre, String a1, String a2, String dni, 
			String fi, String fd, double sal, double comm, boolean obj, String pass, int iD){
		this.id = id;
		this.nombre = nombre;
		this.ap1 = a1;
		this.ap2 = a2;
		this.dni = dni;
		this.fechaI = fi;
		this.fechaD = fd;
		this.salario = sal;
		this.comision = comm;
		this.objetivo = obj;
		this.password = pass;
		this.idDept = iD;
	}
	
	/**
	 * Inserta un nuevo registro en la tabla Empleados
	 * @param id <code>Integer</code>
	 * @param nombre <code>String</code>
	 * @param a1 <code>String</code>
	 * @param a2 <code>String</code>
	 * @param dni <code>String</code>
	 * @param fi <code>String</code>
	 * @param sal <code>Double</code>
	 * @param comm <code>Double</code>
	 * @param obj <code>boolean</code>
	 * @param pass <code>String</code>
	 * @param iD <code>Integer</code>
	 * @return boolean */
	public boolean insertar(int id, String nombre, String a1, String a2, String dni, 
			String fi, double sal, double comm, boolean obj, String pass, int iD){
		String query = "INSERT INTO Empleados (Id_Empleado, Nombre, Apellido1, Apellido2, DNI, Fecha_Ingreso, Salario, Comision, Objetivo, Password, Id_Departamento) "
				+ "VALUES ("+id+", '"+nombre+"', '"+a1+"', '"+a2+"', '"+dni+"', #"+fi+"#, "+sal+", "+comm+", "+obj+", '"+pass+"', "+iD+")";
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Inserta un nuevo registro en la tabla Empleados
	 * @param id
	 * @param nombre
	 * @param a1
	 * @param a2
	 * @param dni
	 * @param fi
	 * @param sal
	 * @param pass
	 * @param iD
	 * @return boolean */
	public boolean insertar(int id, String nombre, String a1, String a2, String dni, 
			String fi, double sal, String pass, int iD){
		String query = "INSERT INTO Empleados (Id_Empleado, Nombre, Apellido1, Apellido2, DNI, Fecha_Ingreso, Salario, Password, Id_Departamento) "
				+ "VALUES ("+id+", '"+nombre+"', '"+a1+"', '"+a2+"', '"+dni+"', #"+fi+"#, "+sal+", '"+pass+"', "+iD+")";
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Actualiza un registro en la BBDD
	 * @return boolean */
	public boolean actualizar(){
		String query = "UPDATE Empleados SET Nombre = '"+this.getNombre()+"', Apellido1 = '"+this.getAp1()+"', Apellido2 = '"+this.getAp2()+"', DNI = '"+this.getDni()+"', Fecha_Ingreso = '"+this.getFechaI()+"', Fecha_Despido = '"+this.getFechaD()+"', Salario = "+this.getSalario()+", Comision = "+this.getComision()+", Objetivo = "+this.isObjetivo()+", Password = '"+this.getPassword()+"', Id_Departamento = "+this.getIdDept()+" WHERE Id_Empleado = " + this.getId();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Actualiza un registro en la BBDD pasado por parametro
	 * @param e <code>{@link #Empleados}</code>
	 * @return boolean */
	public boolean actualizar(Empleados e){
		String query = "UPDATE Empleados SET Nombre = '"+e.getNombre()+"', Apellido1 = '"+e.getAp1()+"', Apellido2 = '"+e.getAp2()+"', DNI = '"+e.getDni()+"', Fecha_Ingreso = #"+e.getFechaI()+"#, Fecha_Despido = #"+e.getFechaD()+"#, Salario = "+e.getSalario()+", Comision = "+e.getComision()+", Objetivo = "+e.isObjetivo()+", Password = '"+e.getPassword()+"', Id_Departamento = "+e.getIdDept()+" WHERE Id_Empleado = " + e.getId();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Elimina un registro de la BBDD
	 * @return boolean */
	public boolean eliminar(){
		String query = "DELETE FROM Empleados WHERE Id_Empleado = "+this.getId();
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
	 * @return the idDept */
	public int getIdDept() {
		return idDept;
	}

	/**
	 * @return the comision */
	public double getComision() {
		return comision;
	}

	/**
	 * @return the salario */
	public double getSalario() {
		return salario;
	}

	/**
	 * @return the nombre */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the ap1 */
	public String getAp1() {
		return ap1;
	}

	/**
	 * @return the ap2 */
	public String getAp2() {
		return ap2;
	}

	/**
	 * @return the dni */
	public String getDni() {
		return dni;
	}

	/**
	 * @return the fechaI */
	public String getFechaI() {
		return fechaI.substring(0, 10);
	}

	/**
	 * @return the fechaD */
	public String getFechaD() {
		return fechaD.substring(0, 10);
	}
	/**
	 * @return the password */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the objetivo */
	public boolean isObjetivo() {
		return objetivo;
	}

	/**
	 * @param id the id to set */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param idDept <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setIdDept(int idDept, boolean update) {
		this.idDept = idDept;
		if(update){
			String query = "UPDATE Empleados SET Id_Departamento = " + idDept + " WHERE Id_Empleado = " + this.id;
			updateQuery(query);
		}
	}

	/**
	 * @param comision <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setComision(double comision, boolean update) {
		this.comision = comision;
		if(update){
			String query = "UPDATE Empleados SET Comision = " + comision + " WHERE Id_Empleado = " + this.id;
			updateQuery(query);
		}
	}

	/**
	 * @param salario <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setSalario(double salario, boolean update) {
		this.salario = salario;
		if(update){
			String query = "UPDATE Empleados SET Salario = " + salario + " WHERE Id_Empleado = " + this.id;
			updateQuery(query);
		}
	}

	/**
	 * @param nombre <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setNombre(String nombre, boolean update) {
		this.nombre = nombre;
		if(update){
			String query = "UPDATE Empleados SET Nombre = '" + nombre + "' WHERE Id_Empleado = " + this.id;
			updateQuery(query);
		}
	}

	/**
	 * @param ap1 <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setAp1(String ap1, boolean update) {
		this.ap1 = ap1;
		if(update){
			String query = "UPDATE Empleados SET Apellido1 = '" + ap1 + "' WHERE Id_Empleado = " + this.id;
			updateQuery(query);
		}
	}

	/**
	 * @param ap2 <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setAp2(String ap2, boolean update) {
		this.ap2 = ap2;
		if(update){
			String query = "UPDATE Empleados SET Apellido2 = '" + ap2 + "' WHERE Id_Empleado = " + this.id;
			updateQuery(query);
		}
	}

	/**
	 * @param dni <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setDni(String dni, boolean update) {
		this.dni = dni;
		if(update){
			String query = "UPDATE Empleados SET DNI = '" + dni + "' WHERE Id_Empleado = " + this.id;
			updateQuery(query);
		}
	}

	/**
	 * @param fechaI <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setFechaI(String fechaI, boolean update) {
		this.fechaI = fechaI;
		if(update){
			String query = "UPDATE Empleados SET Fecha_Ingreso = #" + fechaI + "# WHERE Id_Empleado = " + this.id;
			updateQuery(query);
		}
	}

	/**
	 * @param fechaD <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setFechaD(String fechaD, boolean update) {
		this.fechaD = fechaD;
		if(update){
			String query = "UPDATE Empleados SET Fecha_Despido = #" + fechaD + "# WHERE Id_Empleado = " + this.id;
			updateQuery(query);
		}
	}

	/**
	 * @param password <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setPassword(String password, boolean update) {
		this.password = password;
		if(update){
			String query = "UPDATE Empleados SET Password = '" + password + "' WHERE Id_Empleado = " + this.id;
			updateQuery(query);
		}
	}

	/**
	 * @param objetivo <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setObjetivo(boolean objetivo, boolean update) {
		this.objetivo = objetivo;
		if(update){
			String query = "UPDATE Empleados SET Objetivo = " + objetivo + " WHERE Id_Empleado = " + this.id;
			updateQuery(query);
		}
	}
	
	

}
