package intefaz;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import modelo.Actividad;
import modelo.Aplicacion;
import modelo.Proyecto;

public class PanelActividades extends JPanel {
	
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	JList<String> infoActividades = new JList<String>(listModel);
	JScrollPane sp = new JScrollPane();
	
	public PanelActividades() {
		setLayout(null);
		
		JLabel tituloActividades = new JLabel("Actividades",SwingConstants.CENTER);
		
		sp.setViewportView(infoActividades);
	    infoActividades.setLayoutOrientation(JList.VERTICAL);
	    
	    infoActividades.setPreferredSize(new Dimension(400,90));
		
		tituloActividades.setBounds(0, 0, 450, 30);
		sp.setBounds(0, 30, 450, 60);
		
		add(tituloActividades);
		add(sp);
	}
	
	public void actualizarActividad(Aplicacion aplicacion) {
		listModel.clear();
		Proyecto proyectoActual = aplicacion.getProyectoActual();
		HashMap<String,ArrayList<Actividad>> actividades = proyectoActual.getActividades();
		for(String i : actividades.keySet()) {
			ArrayList<Actividad> listaActividad = actividades.get(i);
			Iterator<Actividad> iterador = listaActividad.iterator();
			
			while(iterador.hasNext()) {
				Actividad trabajo = iterador.next();
				String cadena = trabajo.getNombre() + " - " + trabajo.getTipo() + " - " +trabajo.getParticipante().getCorreo()+" - "+trabajo.getFechaI().toString();
				listModel.addElement(cadena);
			}
		}
		sp.setViewportView(infoActividades);
	}
	
}
