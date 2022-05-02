package intefaz;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import modelo.Aplicacion;
import modelo.Participante;
import modelo.Proyecto;

public class PanelProyectoActal extends JPanel  {
	
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	JTextField infoFechaI = new JTextField();
	JTextField infoFechaF = new JTextField();
	JList<String> infoParticipantes = new JList<String>(listModel);
	JScrollPane sp = new JScrollPane();

	
	public PanelProyectoActal(Aplicacion aplicacion) {
		
				
		setLayout(null);
		setSize(new Dimension(600,300));
		
		JLabel descripcion = new JLabel("Descripción: ");
		JLabel fechaI = new JLabel ("Fecha Inicial: ");
		JLabel fechaF =new JLabel ("Fecha Final: ");
		JLabel participantes = new JLabel ("Participantes: ");
		
		sp.setViewportView(infoParticipantes);
	    infoParticipantes.setLayoutOrientation(JList.VERTICAL);
		
		descripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		infoParticipantes.setPreferredSize(new Dimension(180,120));
		
		descripcion.setBounds(0, 20, 240, 30);
		fechaI.setBounds(0,60,100,30);
		fechaF.setBounds(0,100,100,30);
		participantes.setBounds(0, 140, 100, 30);
		
		infoFechaI.setBounds(80, 60, 175, 30);
		infoFechaF.setBounds(80, 100, 175, 30);
		sp.setBounds(85, 140, 180, 120);
		
		add(descripcion);
		add(fechaI);
		add(fechaF);
		add(participantes);
		add(infoFechaI);
		add(infoFechaF);
		add(infoParticipantes);
		add(sp);
	}
	
	public void actualizarPanel(Aplicacion aplicacion) {
		listModel.clear();
		Proyecto proyectoActual = aplicacion.getProyectoActual();
		HashMap<String, Participante> participantes = proyectoActual.getParticipantes();
		for (String p : participantes.keySet()) {
			Participante participante = participantes.get(p);
			String nombre = participante.getNombre();
			String cadena = nombre + ": " + p ;
			listModel.addElement(cadena);
			
			
		}


		infoFechaI.setText(proyectoActual.getFechaInicial().toString());
		infoFechaF.setText(proyectoActual.getFechaFinal());
		sp.setViewportView(infoParticipantes);
	}
}
