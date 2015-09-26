package FinalLaGestionTransport;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

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

import com.toedter.calendar.JDateChooser;
import Bbdd.Disparador;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.Component;

@SuppressWarnings("serial")
public class InterfaceTrans extends InterfazComun implements Runnable {

	private JTabbedPane separador;
	private JPanel panel1, panel2;
	private JTextField cajaId_Transporte, cajaId_Cliente, cajaId_Producto, cajaTipo_Viaje;
	private JLabel lblId_Transporte, lblId_Cliente, lblId_Producto, lblTipo_Viaje, lblFechaEnvio, lblFechaRecepcion;
	private JButton guardar, borrar;
	private JScrollPane sp, scrollPane;
	private JTable tabla;
	private JTable tabla2;
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
	private JButton btnQuitar;
	private JLabel labelLogo;

	// Reloj
	private JLabel lblReloj;
	private String dia, mes, año, hora, minutos, segundos;
	private Calendar calendario = new GregorianCalendar();
	Thread hilo;
	private JSeparator separatorTitulo;
	private JLabel lblTurno;
	// Fin Reloj

	// ---------------------------------------------------------
	// --------------- A partir de aqui metodo del JFileChooser
	// -----------------
	// ---------------------------------------------------------

	private static void archivotrans() throws Throwable {

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
	
	//---------------------------
	// METODOS -- CONSTRUCTORES -- RELOJ
	//--------------------------
	public InterfaceTrans(int x, int y, int p, int p1) { // Constructor
		setBounds(x, y, p, p1);
	} // fin constructor

	public void actualiza() { //MEtodo para actualizar la hora

		Date fechaHoraActual = new Date();
		calendario.setTime(fechaHoraActual);

		hora = String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
		minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE): "0" + calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND): "0\n\n" + calendario.get(Calendar.SECOND);
		
		dia = calendario.get(Calendar.DATE) > 9 ? "" + calendario.get(Calendar.DATE): "0" + calendario.get(Calendar.DATE);
		mes = calendario.get(Calendar.MONTH) > 9 ? "" + calendario.get(Calendar.MONTH): "0" + calendario.get(Calendar.MONTH);
		año = calendario.get(Calendar.YEAR) > 9 ? "" + calendario.get(Calendar.YEAR): "0" + calendario.get(Calendar.YEAR);
		
	}

	@Override
	public void run() { //
		Thread ct = Thread.currentThread();
		while (ct == hilo) {
			try {
				actualiza();
				int mesE;
				mesE = Integer.valueOf(mes) + 1;

				lblReloj.setText("<html><center>" + dia + " / " + mesE + " / " + año + "<br><br>" + hora + ":" + minutos+ ":" + segundos); //Salida por pantalla reloj

				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				System.out.println(ex.getMessage());
			}

		}
		
		

	}

	static void creaFrame() {// Metodo que agrega un muestra un Frame con reloj incluido
		
	InterfaceTrans reloj = new InterfaceTrans(0, 0, 0, 0);// Instancia de nuestra clase Reloj
												// (0,0,0,0 ya que el layout es x defecto)
	
	// Sino aquí es donde dan locación y tamaño
	reloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);// Centrado// del texto
	reloj.setFont(new java.awt.Font("Arial", 1, 18));// tipo de letra y tamaño
	
	JFrame ventana = new JFrame();// Instancia de la clase JFrame
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Botón de cerrar
	ventana.setBounds(0, 0, 200, 100);// Tamaño
	ventana.getContentPane().add(reloj);// Agregado del reloj
	ventana.setLocationRelativeTo(null);// Lo centramos en la pantalla
	ventana.setVisible(true);// Lo hacemos visible

}

	private void setHorizontalAlignment(int center) {} // Sin este metodo no funciona el Reloj
	//----------------------
	// FIN METODOS RELOJ
	//----------------------
	
	///----------
	/// Horarios
	///----------
	
	
	
	///***************************

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public InterfaceTrans() {

		setTitle("Pantalla Principal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setSize(1280, 720); //Tamaño
		setLocationRelativeTo(null);// Centrar ventana
		
		// donde se ejecute el programa
		setResizable(true);
		setVisible(true);

		// Quito la visibilidad de los elementos del padre que no necesito
		super.contentPane.setVisible(false); // para que se vea mi Panel en vez del gris heredado
		super.menu2.setVisible(false);
		super.tb1.setVisible(false);

		// Añado a la barra los elementos que si necesito

		abrir = new JMenuItem("Abrir...   Alt+B");
		abrir.setMnemonic('B');
		abrir.setIcon(new ImageIcon(InterfaceTrans.class.getResource(""))); // "" para colocar un icono
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
		String filas[][] = { { " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" },
				{ " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" },
				{ " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" },
				{ " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" },
				{ " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" },
				{ " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" },
				{ " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" } };

		String columnas[] = { " N\u00BA Transporte ", " ID Cliente ", " ID Producto ", " Tipo Viaje ", " Fecha Envio ",
				" Fecha Recogida " };

		tabla = new JTable(filas, columnas);
		// No queremos ver las lineas verticales
		tabla.setShowVerticalLines(true);
		// No queremos ver las lineas verticales
		tabla.setShowHorizontalLines(true);
		// se puede seleccionar mas de una fila
		tabla.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabla.setVisible(true);

		sp = new JScrollPane(tabla); // Necesita un Scrol para que se vean las
										// columnas
		sp.setBounds(608, 182, 616, 337);

		// ---------------------------------------------------------
		// -------A partir de aqui el tabbedPaned-------------------
		// ---------------------------------------------------------

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

				// Aqui es donde pondre el codigo que almacene en la base de
				// datos
				// lo que se introduzca en los campos
			}

		});

		borrar = new JButton("Borrar");
		borrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { // usado para dejar las cajas de texto vacías

				cajaId_Transporte.setText(null);
				cajaId_Cliente.setText(null);
				cajaId_Producto.setText(null);
				cajaTipo_Viaje.setText(null);
				dateRecep.setCalendar(null);
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
		borrar.setBounds(435, 423, 85, 30);

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

		separador.addTab("Gestion  de Transporte", null, panel1, "Separador1"); // Añadimos el Panel1 al separador

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
		getContentPane().add(separador); // sin esto no se veria nada, añadimos al JFrame el JTabbedPane

		// ------------------------------------------------------------------------------------------------
		// --------------------------A partir de aquí el panel 2
		// ------------------------------------------
		// ------------------------------------------------------------------------------------------------
		panel2 = new JPanel();
		panel2.setBackground(Color.LIGHT_GRAY); // asi le damos color al panel1
		panel2.setLayout(null);

		separador.addTab("Conductores", null, panel2, "Separador1");

		btnAgregarCondutores = new JButton("ALTA CONDUTORES");
		btnAgregarCondutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAgregarCondutores.setBounds(420, 216, 171, 52);
		panel2.add(btnAgregarCondutores);

		String filas2[][] = { { " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" },
				{ " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" },
				{ " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" },
				{ " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" },
				{ " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" },
				{ " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" },
				{ " ", " ", " ", "", "", "" }, { " ", " ", " ", "", "", "" } };

		String columnas2[] = { " N\u00BA Conductor ", " Empresa ", " Telefono ", " Horario ", " Nombre ",
				" Matricula" };

		tabla2 = new JTable(filas2, columnas2);
		// No queremos ver las lineas verticales
		
		tabla2.setShowVerticalLines(true);
		// No queremos ver las lineas verticales
		
		tabla2.setShowHorizontalLines(true);
		// se puede seleccionar mas de una fila
		tabla2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabla2.setVisible(true);

		scrollPane = new JScrollPane(tabla2);
		scrollPane.setBounds(601, 146, 616, 337);
		panel2.add(scrollPane);

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

		btnQuitar = new JButton("BAJA CONDUCTORES");
		btnQuitar.setBounds(420, 284, 171, 52);
		panel2.add(btnQuitar);

		//RELOJ
		hilo = new Thread(this);
		hilo.start();
		lblReloj = new JLabel("");
		lblReloj.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblReloj.setBounds(61, 189, 312, 201);
		panel2.add(lblReloj);
		
		lblTurno = new JLabel("");
		lblTurno.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblTurno.setBounds(118, 401, 146, 27);
		panel2.add(lblTurno);

		//Separador
		getContentPane().add(separador); // sin esto no se veria nada, añadimos al JFrame el JTabbedPane

	}
	

}
