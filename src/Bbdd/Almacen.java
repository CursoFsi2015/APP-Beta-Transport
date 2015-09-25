package Bbdd;



/**
 * Identificador, partida de compra, stock libre, stock reservado
 * @author Marco Ant. Quirós
 * @version 1.1 */
public class Almacen extends Actualizador{
	
	int id, partidaCompra, stockLibre, stockReser;

	/**
	 * Constructor nulo para usar las querys de insercion de datos */
	public Almacen(){}
	/**
	 * Instancia el objeto con los siguientes parametros
	 * @param id
	 * @param partidaCompra
	 * @param stockLibre
	 * @param stockReser */
	public Almacen(int id, int partidaCompra, int stockLibre, int stockReser) {
		this.id = id;
		this.partidaCompra = partidaCompra;
		this.stockLibre = stockLibre;
		this.stockReser = stockReser;
	}
	
	/**
	 * Inserta un nuevo registro en la tabla Almacen
	 * @param id
	 * @param partidaCompra
	 * @param stockLibre
	 * @param stockReser
	 * @return boolean */
	public boolean insertar(int id, int partidaCompra, int stockLibre, int stockReser){
		String query = "INSERT INTO Almacen (Id_Producto, Partida_Compra, Stock_Libre, Stock_Reservado) "
				+ "VALUES ("+id+", "+partidaCompra+", "+stockLibre+", "+stockReser+")";
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Actualiza un registro en la BBDD
	 * @return boolean */
	public boolean actualizar(){
		String query = "UPDATE Almacen SET Partida_Compra = "+this.getPartidaCompra()+", Stock_Libre = "+this.getStockLibre()+", Stock_Reservado = "+this.getStockReser()+" WHERE Id_Producto = "+this.getId();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Actualiza un registro en la BBDD pasado por parametro
	 * @param a <code>{@link #Almacen}</code>
	 * @return boolean */
	public boolean actualizar(Almacen a){
		String query = "UPDATE Almacen SET Partida_Compra = "+a.getPartidaCompra()+", Stock_Libre = "+a.getStockLibre()+", Stock_Reservado = "+a.getStockReser()+" WHERE Id_Producto = "+a.getId();
		if(updateQuery(query)){
			return true;
		}
		return false;
	}
	
	/**
	 * Elimina un registro de la BBDD
	 * @return boolean */
	public boolean eliminar(){
		String query = "DELETE FROM Almacen WHERE Id_Producto = "+this.getId();
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
	 * @return the stockLibre */
	public int getStockLibre() {
		return stockLibre;
	}

	/**
	 * @return the stockReser */
	public int getStockReser() {
		return stockReser;
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
			String query = "UPDATE Almacen SET Partida_Compra = " + partidaCompra + " WHERE Id_Producto = " + this.id;
			updateQuery(query);
		}
	}

	/**
	 * @param stockLibre <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setStockLibre(int stockLibre, boolean update) {
		this.stockLibre = stockLibre;
		if(update){
			String query = "UPDATE Almacen SET Stock_Libre = " + stockLibre + " WHERE Id_Producto = " + this.id;
			updateQuery(query);
		}
	}

	/**
	 * @param stockReser <code>el parametro a setear</code>
	 * @param update <code>boolean</code> TRUE para actualizar la BBDD */
	public void setStockReser(int stockReser, boolean update) {
		this.stockReser = stockReser;
		if(update){
			String query = "UPDATE Almacen SET Stock_Reservado = " + stockReser + " WHERE Id_Producto = " + this.id;
			updateQuery(query);
		}
	}
	
}
