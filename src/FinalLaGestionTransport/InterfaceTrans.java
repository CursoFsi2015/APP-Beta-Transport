package FinalLaGestionTransport;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map.Entry;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import Bbdd.Disparador;
import Bbdd.Tablas;
import Bbdd.Transporte;
import jxl.Sheet;
import jxl.Workbook;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class InterfaceTrans extends InterfazComun implements Runnable {

	private JTabbedPane separador;
	private JPanel panel1, panel2;
	private JTextField cajaId_Transporte, cajaId_Cliente, cajaId_Producto, cajaTipo_Viaje;
	private JLabel lblId_Transporte, lblId_Cliente, lblId_Producto, lblTipo_Viaje, lblFechaEnvio, lblFechaRecepcion;
	
	private JButton guardar, borrar;
	private JScrollPane sp;
	
	
	private JTable tabla;
	String columnas[] = { 
			" N\u00BA Transporte ", 
			" ID Cliente ", 
			" ID Producto ", 
			" Tipo Viaje ", 
			" Fecha Envio ",
			" Fecha Recogida " };
	private Object[][] contenido;
    private DefaultTableModel ModeloTablaTrans;

    
	private JMenuItem abrir;
	private static JFileChooser archivo;

	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JButton btnOk;
	private JButton btnNewButton;
	private JLabel lblModuloTransporte;
	private JLabel label;
	private JLabel label_logo;
	private JButton btnAgregarCondutores;

	// ----------- Calendario dateChooser --------------------------
	private final JDateChooser dateRecep = new JDateChooser();
	private JDateChooser dateEnvio;
	private JLabel labelConductor;
	private JLabel label_2;
	private JLabel labelLogo;

	// Reloj
	private JLabel lblReloj;
	private String dia, mes, año, hora, minutos, segundos;
	private Calendar calendario = new GregorianCalendar();
	Thread hilo;
	private JSeparator separatorTitulo;
	private JLabel lblVerturno;
	private JLabel lblTurno;
	// Fin Reloj

	// Table 2
	private static JTable tabla2;
	private static DefaultTableModel tabla21;
	private JButton btnVerConductores;
	

	
	// ---------------------------------------------------------
	// --------------- A partir de aqui metodo del JFileChooser
	// -----------------
	// ---------------------------------------------------------

	private static void archivotrans() throws Throwable {

		// Evento de selecionar fichero
		archivo = new JFileChooser();
		archivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

		// Creamos el filtro

		// 1 titulo - 2 extension
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.PDF", "pdf");
		FileNameExtensionFilter filtro2 = new FileNameExtensionFilter("*.DOC", "doc");
		FileNameExtensionFilter filtro3 = new FileNameExtensionFilter("*.TXT", "txt");

		// Le indicamos el filtro
		archivo.setFileFilter(filtro);
		archivo.setFileFilter(filtro2);
		archivo.setFileFilter(filtro3);

		int r = archivo.showOpenDialog(null);
		if (r == JFileChooser.APPROVE_OPTION) {
			String path = archivo.getSelectedFile().getPath();
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + path);
		} else if (r == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "Ha cancelado su selección");
		} else {
			JOptionPane.showMessageDialog(null, "Se ha producido un error en la selección");
		}

	}

	// ---------------------------------------
	// FIN DEL METODO DE SELECCION DE ARCHIVO

	// ---------------------------
	// METODOS -- CONSTRUCTORES -- RELOJ
	// --------------------------
	public InterfaceTrans(int x, int y, int p, int p1) { // Constructor
		setBounds(x, y, p, p1);
	} // fin constructor

	public void actualiza() { // MEtodo para actualizar la hora

		Date fechaHoraActual = new Date();
		calendario.setTime(fechaHoraActual);

		// Hora
		hora = String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
		minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE)
				: "0" + calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND)
				: "0\n\n" + calendario.get(Calendar.SECOND);

		// dias Meses
		dia = calendario.get(Calendar.DATE) > 9 ? "" + calendario.get(Calendar.DATE)
				: "0" + calendario.get(Calendar.DATE);
		mes = calendario.get(Calendar.MONTH) > 9 ? "" + calendario.get(Calendar.MONTH)
				: "0" + calendario.get(Calendar.MONTH);
		año = calendario.get(Calendar.YEAR) > 9 ? "" + calendario.get(Calendar.YEAR)
				: "0" + calendario.get(Calendar.YEAR);

	}

	@Override
	public void run() { // RUN DEL RELOJ
		Thread ct = Thread.currentThread();
		while (ct == hilo) {
			try {
				actualiza();

				// Convierto String a Integer
				int mesE = Integer.valueOf(mes) + 1;

				// Ver Hora
				lblReloj.setText("<html><center>" + dia + " / " + mesE + " / " + año + "<br><br>" + hora + ":" + minutos
						+ ":" + segundos); // Salida por pantalla reloj
				// Refresco Reloj
				Thread.sleep(1000);

			} catch (InterruptedException ex) {
				System.out.println(ex.getMessage());
			}

			// Inicio ver tunos
			// convertimos hora a int
			int horat = Integer.valueOf(hora);

			// Ver turnos con IF
			if (horat >= 6 && horat <= 13) {
				lblVerturno.setText("MAÑANA");
			}

			else if (horat >= 14 && horat <= 21) {
				lblVerturno.setText("TARDE");
			}

			else {
				lblVerturno.setText("NOCHE");
			}
			// Fin Ver turno
		}

	}

	static void creaFrame() {// Metodo que agrega un Frame con reloj incluido

		@SuppressWarnings("unused")
		InterfaceTrans reloj = new InterfaceTrans(0, 0, 0, 0);// Instancia de
																// nuestra clase
																// Reloj
		// (0,0,0,0 ya que el layout es x defecto)

	}

	@SuppressWarnings("unused")
	private void setHorizontalAlignment(int center) {
	} // Sin este metodo no funciona el Reloj
	// ----------------------
	// FIN METODOS RELOJ
	// ---------------------

	/// ***************************

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public InterfaceTrans() {

		setTitle("Pantalla Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(1280, 720); // Tamaño
		setLocationRelativeTo(null);// Centrar ventana

		// donde se ejecute el programa
		setResizable(true);
		setVisible(true);

		// Quito la visibilidad de los elementos del padre que no necesito
		super.contentPane.setVisible(false); // para que se vea mi Panel en vez
												// del gris heredado
		super.menu2.setVisible(false);
		super.tb1.setVisible(false);

		// Añado a la barra los elementos que si necesito

		abrir = new JMenuItem("Abrir...   Alt+B");
		abrir.setMnemonic('B');
		abrir.setIcon(new ImageIcon(InterfaceTrans.class.getResource(""))); // ""
																			// para
																			// colocar
																			// un
																			// icono
		abrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					InterfaceTrans.archivotrans();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});
		super.menu1.add(abrir);

		// -------------- Tabla ----------------------------------------------
		// -------------------------------------------------------------------
       
		tabla = new JTable();
		
		//ARRAY QUE CAPTURA EL CONTENIDO
		contenido = new Object[Tablas.transporte.size()][6];
        int contador = 0;
        for(Entry<Integer, Transporte> entrada : Tablas.transporte.entrySet()){
                contenido[contador][0] = entrada.getValue().getId();
                contenido[contador][1] = entrada.getValue().getIdCliente();
                contenido[contador][2] = entrada.getValue().getIdProducto();
                contenido[contador][3] = entrada.getValue().isTipoViaje();
                contenido[contador][4] = entrada.getValue().getFechaEntrega();
                contenido[contador][5] = entrada.getValue().getFechaRecogida();
                contador++;
        }
         
        ModeloTablaTrans = new DefaultTableModel(contenido, columnas){
            private static final long serialVersionUID = 1L;
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            }
             
        };
        //-----

        //COJEMO EL MODELO DE LA TABLA
        tabla = new JTable(ModeloTablaTrans);
		tabla.setShowVerticalLines(true);
		tabla.setShowHorizontalLines(true);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //SELECCION SENCILLA
		tabla.setVisible(true);

		sp = new JScrollPane(tabla); // Necesita un Scroll para que se vean las  columnas
		sp.setBounds(608, 182, 616, 337);

		
		
		

		// -------A partir de aqui el tabbedPaned-------------------

		separador = new JTabbedPane();
		panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY); // asi le damos color al panel
		panel1.setLayout(null);
		lblId_Transporte = new JLabel("N\u00BA Transporte:");
		lblId_Transporte.setFont(new Font("Arial", Font.BOLD, 13));
		lblId_Cliente = new JLabel("ID Cliente:");
		lblId_Cliente.setFont(new Font("Arial", Font.BOLD, 13));
		lblId_Producto = new JLabel("ID Producto:");
		lblId_Producto.setFont(new Font("Arial", Font.BOLD, 13));
		lblTipo_Viaje = new JLabel("Tipo Viaje:");
		lblTipo_Viaje.setFont(new Font("Arial", Font.BOLD, 13));
		lblFechaEnvio = new JLabel("Fecha Envio:");
		lblFechaEnvio.setFont(new Font("Arial", Font.BOLD, 13));
		lblFechaRecepcion = new JLabel("Fecha Rcogida:");
		lblFechaRecepcion.setFont(new Font("Arial", Font.BOLD, 13));

		// ----------cajas de texto ----------------

		cajaId_Transporte = new JTextField();
		cajaId_Transporte.setEnabled(false);
		cajaId_Cliente = new JTextField();
		cajaId_Producto = new JTextField();
		cajaTipo_Viaje = new JTextField();

		// --------botones-------------------

		guardar = new JButton("Guardar");
		guardar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Transporte t = new Transporte();
				Disparador d = new Disparador("idTransporte");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				if(t.insertar(d.nextValue(), Integer.parseInt(cajaId_Cliente.getText()),
						Integer.parseInt(cajaId_Producto.getText()), cajaTipo_Viaje.getText(), 
						sdf.format(dateEnvio.getCalendar().getTime()), 
						sdf.format(dateRecep.getCalendar().getTime())) == true
				){
					JOptionPane.showMessageDialog(null, "El registro " + 
				d.insert() + " se ha insertado correctamente");
				}
			}

		});

		borrar = new JButton("LIMPIAR REGISTRO");
		borrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { // usado para dejar las vacías

				cajaId_Transporte.setText(null);
				cajaId_Cliente.setText(null);
				cajaId_Producto.setText(null);
				cajaTipo_Viaje.setText(null);
				dateRecep.setCalendar(null); // vaciamos la caja del calendario
				dateEnvio.setCalendar(null); // vaciamos la caja del calendario

			}

		});
		lblId_Transporte.setBounds(73, 181, 187, 28);
		lblId_Cliente.setBounds(73, 220, 187, 30);
		lblId_Producto.setBounds(73, 261, 187, 30);
		lblTipo_Viaje.setBounds(73, 302, 187, 30);
		lblFechaEnvio.setBounds(73, 343, 187, 28);
		lblFechaRecepcion.setBounds(73, 382, 187, 30);

		// ----------Cajas-------------

		cajaId_Transporte.setBounds(270, 179, 124, 30);
		cajaId_Cliente.setBounds(270, 221, 250, 30);
		cajaId_Producto.setBounds(270, 262, 250, 30);
		cajaTipo_Viaje.setBounds(270, 302, 85, 30);

		// ----------Botones-------------

		guardar.setBounds(270, 423, 85, 30);
		borrar.setBounds(384, 423, 136, 30);

		dateRecep.setBounds(270, 382, 250, 30);
		panel1.add(sp);

		panel1.add(guardar);
		panel1.add(borrar);
		panel1.add(lblId_Transporte);
		panel1.add(lblId_Cliente);
		panel1.add(lblId_Producto);
		panel1.add(lblTipo_Viaje);
		panel1.add(lblFechaEnvio);
		panel1.add(lblFechaRecepcion);

		panel1.add(cajaId_Transporte);
		panel1.add(cajaId_Cliente);
		panel1.add(cajaId_Producto);
		panel1.add(cajaTipo_Viaje);

		separador.addTab("Gestion  de Transporte", null, panel1, "Separador1"); // Añadimos
																				// el
																				// Panel1
																				// al
																				// separador

		panel1.add(dateRecep);

		dateEnvio = new JDateChooser();
		dateEnvio.setBounds(270, 343, 250, 30);
		panel1.add(dateEnvio);

		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cajaTipo_Viaje.setText((String) comboBox.getSelectedItem());
			}
		});
		btnOk.setBounds(473, 302, 47, 30);
		panel1.add(btnOk);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Entrega", "Recogida", "Mixto", "Anulado" }));
		comboBox.setBounds(365, 302, 98, 30);
		panel1.add(comboBox);

		btnNewButton = new JButton("Generar N\u00BA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cajaId_Transporte.setText(new Disparador("idTransporte").nextValue() + "");
			}
		});
		btnNewButton.setBounds(404, 182, 116, 26);
		panel1.add(btnNewButton);

		lblModuloTransporte = new JLabel("MODULO TRANSPORTE");
		lblModuloTransporte.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblModuloTransporte.setBounds(101, 28, 362, 37);
		panel1.add(lblModuloTransporte);

		JSeparator separatortitulo = new JSeparator();
		separatortitulo.setBackground(Color.BLACK);
		separatortitulo.setBounds(46, 68, 417, 10);
		panel1.add(separatortitulo);

		label = new JLabel("");
		label.setIcon(new ImageIcon(InterfaceTrans.class.getResource("/FinalLaGestionTransport/truckmini.png")));
		label.setBounds(47, 11, 62, 54);
		panel1.add(label);

		label_logo = new JLabel("");
		label_logo.setIcon(new ImageIcon(InterfaceTrans.class.getResource("/FinalLaGestionTransport/mini-logo.png")));
		label_logo.setBounds(1058, 11, 207, 114);
		panel1.add(label_logo);
		getContentPane().add(separador); // sin esto no se veria nada, añadimos
											// al JFrame el JTabbedPane

		// ------------------------------------------------------------------------------------------------
		// --------------------------A partir de aquí el panel 2
		// ------------------------------------------
		// ------------------------------------------------------------------------------------------------
		panel2 = new JPanel();
		panel2.setBackground(Color.LIGHT_GRAY); // asi le damos color al panel1
		panel2.setLayout(null);

		separador.addTab("Conductores", null, panel2, "Separador1");

		btnAgregarCondutores = new JButton("MODIFICAR CONDUCTORES");
		btnAgregarCondutores.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
//				AddConductores verformulario2 = new AddConductores();
//				verformulario2.setVisible(true);
				
				try {
					Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler C:\\LaGestion\\Conductores.xls");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});

		tabla2 = new JTable();
		tabla21 = new DefaultTableModel();
		tabla2.setModel(tabla21);
		tabla2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabla2.setBackground(Color.LIGHT_GRAY);
		tabla2.setBounds(601, 189, 648, 400);
		// No queremos ver las lineas verticales
		tabla2.setShowVerticalLines(true);
		// No queremos ver las lineas verticales
		tabla2.setShowHorizontalLines(true);
		panel2.add(tabla2);

		btnAgregarCondutores.setBounds(384, 216, 207, 103);
		panel2.add(btnAgregarCondutores);

		labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(InterfaceTrans.class.getResource("/FinalLaGestionTransport/mini-logo.png")));
		labelLogo.setBounds(1042, 11, 207, 114);
		panel2.add(labelLogo);

		labelConductor = new JLabel("LISTADO CONDUCTORES");
		labelConductor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		labelConductor.setBounds(100, 33, 402, 37);
		panel2.add(labelConductor);

		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(InterfaceTrans.class.getResource("/FinalLaGestionTransport/truckmini.png")));
		label_2.setBounds(51, 16, 62, 54);
		panel2.add(label_2);

		separatorTitulo = new JSeparator();
		separatorTitulo.setBackground(Color.BLACK);
		separatorTitulo.setBounds(61, 72, 441, 10);
		panel2.add(separatorTitulo);

		// RELOJ
		hilo = new Thread(this);
		hilo.start();
		lblReloj = new JLabel("");
		lblReloj.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblReloj.setBounds(61, 189, 312, 201);
		panel2.add(lblReloj);

		// Label Turno
		lblTurno = new JLabel("HORARIO/TURNO");
		lblTurno.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblTurno.setBounds(61, 401, 186, 27);
		panel2.add(lblTurno);

		lblVerturno = new JLabel("");
		lblVerturno.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblVerturno.setForeground(Color.BLUE);
		lblVerturno.setBounds(61, 446, 233, 66);
		panel2.add(lblVerturno);
		
		btnVerConductores = new JButton("VER CONDUCTORES");
		btnVerConductores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
						String ruta = "C:\\LaGestion\\Conductores.xls";
				    	JFileChooser excel = new JFileChooser();
						excel.setSelectedFile(new File(ruta));
						File archivoexcel = null;
						archivoexcel = excel.getSelectedFile().getAbsoluteFile();

						try {
							
							Workbook leerEx = Workbook.getWorkbook(archivoexcel);
							
							for (int hoja = 0; hoja < leerEx.getNumberOfSheets(); hoja++) {

								Sheet hojap = leerEx.getSheet(hoja);
								int colum2 = hojap.getColumns();
								int filas1 = hojap.getRows();
								Object data[] = new Object[colum2];
								
								for (int fila = 0; fila < filas1; fila++) {
									for (int colum1 = 0; colum1 < colum2; colum1++) {
										if (fila == 0) {
											tabla21.addColumn(hojap.getCell(colum1, fila).getContents());
										}
//										System.out.println(hojap.getCell(colum1, fila).getContents());
										if (fila >= 1)
											data[colum1] = hojap.getCell(colum1, fila).getContents();
									}
									tabla21.addRow(data);
								}

							}

							// opcional
							tabla21.removeRow(0);
						} catch (Exception e) {
						   
						}
						// FIN DE LEER EXCEL
				
						
						btnVerConductores.setEnabled(false);
			}
		});
		btnVerConductores.setBounds(601, 141, 153, 37);
		panel2.add(btnVerConductores);

		// Separador
		getContentPane().add(separador); // sin esto no se veria nada, añadimos
											// al JFrame el JTabbedPane

	}
}
