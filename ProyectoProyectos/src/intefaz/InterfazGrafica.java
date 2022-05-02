package intefaz;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Actividad;
import modelo.Aplicacion;
import modelo.Cronometro;
import modelo.Participante;
import modelo.Proyecto;

public class InterfazGrafica extends JFrame implements ActionListener, ItemListener {
	
	
	JComboBox<String> listaDesplegableProyectos = new JComboBox<String>();
	JButton botonCrearProyecto = new JButton("Crear Proyecto");
	Aplicacion aplicacion = new Aplicacion();
	JButton botonAddParticipante = new JButton("Añadir participante");
	JButton botonAddActividad = new JButton("Crear actividad");
	JComboBox<String> listaDesplegableActividades = new JComboBox<String>();
	JButton botonContinuarActividad = new JButton("Continuar actividad");
	JComboBox<String> listaDesplegableParticipantes = new JComboBox<String>();
	
	
	
	public InterfazGrafica() {
		setLayout(null);
		
		setTitle("Aplicación Proyectos");
		setSize(new Dimension(800,800));
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel tituloPA = new JLabel("Proyecto Actual");
		PanelProyectoActal infoProyectoActual = new PanelProyectoActal(aplicacion);
		PanelDescripcion infoPanelDescripcion = new PanelDescripcion(aplicacion);
		PanelActividades infoPanelActividades = new PanelActividades();
		PanelActividadActual infoPanelActividadActual = new PanelActividadActual();
		PanelParticipante infoPanelParticipante = new PanelParticipante();
		PanelReporte infoPanelReporte = new PanelReporte();
		
		JLabel tituloActividadActual = new JLabel("Actividad actual: ");
		JLabel tituloCorreo = new JLabel("Correo: ");
		
		
		
		listaDesplegableProyectos.setPrototypeDisplayValue("default huknbjombtext here");
		listaDesplegableActividades.setPrototypeDisplayValue("hytvvfvvbhbununununununjkkjsijsijsijisji");
		listaDesplegableParticipantes.setPrototypeDisplayValue("default huknbjombtext here");

		tituloPA.setBounds(20, 20, 130, 30);
		listaDesplegableProyectos.setBounds(150, 20, 170, 30);
		botonCrearProyecto.setBounds(370, 20, 170, 30);
		infoProyectoActual.setBounds(20,50,270,270);
		infoPanelDescripcion.setBounds(290, 60, 450, 80);
		botonAddParticipante.setBounds(60, 325, 170, 30);
		infoPanelActividades.setBounds(300,150,450,90);
		botonAddActividad.setBounds(450,250,170,30);
		tituloActividadActual.setBounds(325,300 , 130, 30);
		listaDesplegableActividades.setBounds(435, 300, 300, 30);
		infoPanelActividadActual.setBounds(325,350 , 500, 180);
		botonContinuarActividad.setBounds(450,540,170,30);
		infoPanelParticipante.setBounds(20, 370, 250, 80);
		tituloCorreo.setBounds(20, 460, 70, 30);
		listaDesplegableParticipantes.setBounds(100,460,170,30);
		infoPanelReporte.setBounds(20,540,290,90);
		
		add(tituloPA);
		add(botonCrearProyecto);
		add(listaDesplegableProyectos);
		add(infoProyectoActual);
		add(infoPanelDescripcion);
		add(botonAddParticipante);
		add(infoPanelActividades);
		add(botonAddActividad);
		add(tituloActividadActual);
		add(listaDesplegableActividades);
		add(infoPanelActividadActual);
		add(botonContinuarActividad);
		add(infoPanelParticipante);
		add(tituloCorreo);
		add(listaDesplegableParticipantes);
		add(infoPanelReporte);
		
		botonCrearProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == botonCrearProyecto) {
					
					Date fechaI = new Date();
					String nombre = JOptionPane.showInputDialog("Ingrese el nombre del proyecto: ");
					String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion del proyecto: ");
					String fechaF = JOptionPane.showInputDialog("Ingrese la fecha estimada de finalización: ");
					String nombreD = JOptionPane.showInputDialog("Ingrese el nombre del dueño del proyecto: ");
					String correo = JOptionPane.showInputDialog("Ingrese el correo del dueño del proyecto: ");
					aplicacion.crearProyecto(nombre, descripcion, fechaI, fechaF, nombreD, correo);
					
					listaDesplegableProyectos.addItem(nombre);
					listaDesplegableProyectos.setSelectedItem(nombre);
					infoPanelActividadActual.borrarActividadActual();
					actualizarComboboxParticipantes(aplicacion);
					infoPanelReporte.borrarPanelReporte();

	
					}}});
		
		botonAddParticipante.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == botonAddParticipante) {
					String nombre = JOptionPane.showInputDialog("Ingrese el nombre del nuevo participante: ");
					String correo = JOptionPane.showInputDialog("Ingrese el correo del nuevo participante: ");
					aplicacion.addParticipante(nombre, correo);
					infoProyectoActual.actualizarPanel(aplicacion);
					actualizarComboboxParticipantes(aplicacion);
				

				
				}
			}
		});
		
		botonAddActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == botonAddActividad) {
					Cronometro cronometro = new Cronometro();
					HashMap<String,Participante> participantes = aplicacion.getProyectoActual().getParticipantes();
					Participante participante;
					Date fechaInicio = new Date();
					
					String correo = JOptionPane.showInputDialog("Ingrese el correo del participante: ");
					if(participantes.containsKey(correo)) {
						participante = participantes.get(correo);
					}
					else {
						String nombreParticipante = JOptionPane.showInputDialog("Ingrese el nombre del nuevo participante:");
						aplicacion.addParticipante(nombreParticipante, correo);
						infoProyectoActual.actualizarPanel(aplicacion);
						participantes = aplicacion.getProyectoActual().getParticipantes();
						participante = participantes.get(correo);
						actualizarComboboxParticipantes(aplicacion);
					}
					String nombreActividad = JOptionPane.showInputDialog("Ingrese el nombre de la actividad: ");
					String tipoActividad = JOptionPane.showInputDialog("Ingrese el tipo de actividad: ");
					String infoActividad = JOptionPane.showInputDialog("Ingrese una breve descripcion de la actividad: ");
					
					cronometro.finalizarCronometro();
					cronometro.tiempoTotal();
					long tiempo = cronometro.getTiempo();
					Date fechaFinal = new Date();
					aplicacion.addActividad(nombreActividad, tipoActividad, infoActividad, fechaInicio, fechaFinal, participante, tiempo);
					infoPanelActividades.actualizarActividad(aplicacion);
					actualizarComboboxActividades(aplicacion);
					infoPanelReporte.actualizarPanelReporte(aplicacion);
					
				
				}
			}
		});
		
		botonContinuarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==botonContinuarActividad) {
					Cronometro cronometro = new Cronometro();
					Date fechaInicio = new Date();
					Proyecto proyectoActual = aplicacion.getProyectoActual();
					HashMap<String, ArrayList<Actividad>> actividades = proyectoActual.getActividades();
					String cadena = listaDesplegableActividades.getSelectedItem().toString();
					String[] split = cadena.split("\\*");
					
					String nombre = split[0];
					ArrayList<Actividad> actividad = actividades.get(nombre);
					Actividad trabajo = actividad.get(0);
					String tipo = trabajo.getTipo();
					Participante participante = trabajo.getParticipante();
					String info = JOptionPane.showInputDialog("Ingrese una breve descripción de la actividad: ");
					Date fechaFinal = new Date();
					cronometro.finalizarCronometro();
					cronometro.tiempoTotal();
					long tiempo = cronometro.getTiempo();
					aplicacion.continuarActividad(nombre, tipo, info, fechaInicio, fechaFinal, participante, tiempo);
					infoPanelActividades.actualizarActividad(aplicacion);
					actualizarComboboxActividades(aplicacion);
					infoPanelReporte.actualizarPanelReporte(aplicacion);
				}
			}
		});
		
		listaDesplegableProyectos.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getID()==ItemEvent.ITEM_STATE_CHANGED) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					String nombre = (String) listaDesplegableProyectos.getSelectedItem();
					aplicacion.setProyectoActualporNombre(nombre);
					aplicacion.setPrimerParticipanteProyecto();
					infoProyectoActual.actualizarPanel(aplicacion);
					infoPanelDescripcion.actualizarDescripcion(aplicacion);
					infoPanelActividades.actualizarActividad(aplicacion);
					actualizarComboboxActividades(aplicacion);
					actualizarComboboxParticipantes(aplicacion);
			}
			
		}
		}
		});
		
		listaDesplegableActividades.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED) {
					String cadena = listaDesplegableActividades.getSelectedItem().toString();
					infoPanelActividadActual.actualizarActividadActual(aplicacion, cadena);
				}
			}
		});
		
		listaDesplegableParticipantes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED) {
					String correo = listaDesplegableParticipantes.getSelectedItem().toString();
					aplicacion.setParticipanteActualporCorreo(correo);
					infoPanelParticipante.actualizarNombre(aplicacion);
					infoPanelReporte.actualizarPanelReporte(aplicacion);
				}
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new InterfazGrafica();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}

	public void actualizarComboboxActividades(Aplicacion aplicacion){
		
		listaDesplegableActividades.removeAllItems();
		
		Proyecto proyectoActual = aplicacion.getProyectoActual();
		HashMap<String, ArrayList<Actividad>> actividades = proyectoActual.getActividades();
		for(String i : actividades.keySet()) {
			ArrayList<Actividad> listaActividades = actividades.get(i);
			Iterator<Actividad> iterador = listaActividades.iterator();
			while(iterador.hasNext()) {
				Actividad actividad = iterador.next();
				String cadena = actividad.getNombre() + "*"+actividad.getFechaI().toString();
				listaDesplegableActividades.addItem(cadena);
				listaDesplegableActividades.setSelectedItem(cadena);
				
			}
		}
	}
	
	public void actualizarComboboxParticipantes(Aplicacion aplicacion) {
		listaDesplegableParticipantes.removeAllItems();
		
		Proyecto proyectoActual = aplicacion.getProyectoActual();
		HashMap<String, Participante> participantes = proyectoActual.getParticipantes();
		for(String i : participantes.keySet()) {
			listaDesplegableParticipantes.addItem(i);
			listaDesplegableParticipantes.setSelectedItem(i);
		}
	}
	

}
	

