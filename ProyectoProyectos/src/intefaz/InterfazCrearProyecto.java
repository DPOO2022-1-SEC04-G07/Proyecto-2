package intefaz;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InterfazCrearProyecto extends JFrame implements ActionListener {
	
private String nombre;
	
	private String info;
	
	private Date fechaInicial;
	
	private String fechaFinal;
	
	private String nombreD;
	
	private String correo;
	
	public String getNombre() {
		return nombre;
	}
	
	public String getInfo() {
		return info;
	}
	
	public Date getFechaInicial() {
		return fechaInicial;
	}
	
	public String getFechaFinal() {
		return fechaFinal;
	}
	
	public String getNombreD() {
		return nombreD;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public void setInfo(String info) {
		this.info=info;
	}
	
	public void setFechaInicial(Date fechaI) {
		this.fechaInicial=fechaI;
	}
	
	public void setFechaFinal(String fechaF) {
		this.fechaFinal = fechaF;
	}
	
	public void setNombreD(String nombreD) {
		this.nombreD = nombreD;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	JButton botonContinuar = new JButton("Continuar");
	JTextField nombreTexto = new JTextField();
	JTextField descripcionTexto = new JTextField();
	JTextField fechaFTexto = new JTextField();
	JTextField nombreDTexto = new JTextField();
	JTextField correoTexto = new JTextField();
	
	public InterfazCrearProyecto() {
		DateFormat df = new SimpleDateFormat();
		
		setSize(new Dimension(500,500));
		setTitle("Crear Proyecto");
		setResizable(true);
		setLayout(null);
		
		JLabel tituloNombre = new JLabel("Ingrese el nombre proyecto: ");
		JLabel tituloDescripcion = new JLabel("Ingrese la descripción: ");
		JLabel tituloFechaI = new JLabel("Fecha inicio: ");
		JLabel tituloFechaF = new JLabel("Ingrese fecha estimada finalización: ");
		JLabel tituloNombreD = new JLabel("Ingrese el nombre del dueño: ");
		JLabel tituloCorreo = new JLabel("Ingrese el correo del dueño: ");
		
		
		Date fechaInicio = new Date();
		setFechaInicial(fechaInicio);
		String cadena = df.format(fechaInicio);
		JTextField fechaI = new JTextField(cadena);
	
		
		tituloNombre.setBounds(50, 50, 200, 30);
		nombreTexto.setBounds(250, 50, 200, 30);
		
		tituloDescripcion.setBounds(70,100,200,30);
		descripcionTexto.setBounds(250,100,200,60);
		
		tituloFechaI.setBounds(100, 180, 200, 30);
		fechaI.setBounds(250, 180, 200, 30);
		fechaI.setEditable(false);
		
		tituloFechaF.setBounds(30,230,230,30);
		fechaFTexto.setBounds(250, 230, 200, 30);
		
		tituloNombreD.setBounds(50, 280, 200, 30);
		nombreDTexto.setBounds(250, 280, 200, 30);
		
		tituloCorreo.setBounds(50,330,200,30);
		correoTexto.setBounds(250, 330, 200, 30);
		
		botonContinuar.setBounds(225, 400, 100, 40);
		botonContinuar.addActionListener(this);
		
		add(tituloNombre);
		add(nombreTexto);
		add(tituloDescripcion);
		add(descripcionTexto);
		add(tituloFechaI);
		add(fechaI);
		add(tituloFechaF);
		add(fechaFTexto);
		add(tituloNombreD);
		add(nombreDTexto);
		add(tituloCorreo);
		add(correoTexto);
		add(botonContinuar);
		
		botonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == botonContinuar) {
					String nombreInfo = nombreTexto.getText();
					String descripcionInfo = descripcionTexto.getText();
					String fechaFInfo = fechaFTexto.getText();
					String nombreDInfo = nombreDTexto.getText();
					String correoInfo = correoTexto.getText();
					
					setNombre(nombreInfo);
					setInfo(descripcionInfo);
					setFechaFinal(fechaFInfo);
					setNombreD(nombreDInfo);
					setCorreo(correoInfo);
					
					setVisible(false);
				
					
		}}});
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*if (e.getSource() == botonContinuar) {
			String nombreInfo = nombreTexto.getText();
			String descripcionInfo = descripcionTexto.getText();
			String fechaFInfo = fechaFTexto.getText();
			String nombreDInfo = nombreDTexto.getText();
			String correoInfo = correoTexto.getText();
			
			setNombre(nombreInfo);
			setInfo(descripcionInfo);
			setFechaFinal(fechaFInfo);
			setNombreD(nombreDInfo);
			setCorreo(correoInfo);
			System.out.println(getCorreo());
			setVisible(false);
		}
		
	}*/

}
}
