package intefaz;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Actividad;
import modelo.Aplicacion;
import modelo.Proyecto;

public class PanelActividadActual extends JPanel{
	
	JTextField infoTipo = new JTextField();
	JTextField infoCreador = new JTextField();
	JTextField infoFechaI = new JTextField();
	JTextField infoCronometro = new JTextField();
	JTextField infoFechaF = new JTextField();
	JTextField infoInfo = new JTextField();
	
	public PanelActividadActual() {
		
		setLayout(null);
		
		JLabel tituloTipo = new JLabel("Tipo: ");
		JLabel tituloCreador = new JLabel("Creador: ");
		JLabel tituloFechaI = new JLabel("Fecha inicio: ");
		JLabel tituloFechaF = new JLabel("Fecha Fin: ");
		JLabel tituloCronometro = new JLabel("Tiempo: ");
		JLabel tituloInfo = new JLabel("Info: ");
		
		
		
		tituloTipo.setBounds(0, 0, 70, 30);
		infoTipo.setBounds(40, 0, 140, 30);
		tituloCreador.setBounds(200, 0, 70, 30);
		infoCreador.setBounds(260, 0, 180, 30);
		tituloFechaI.setBounds(0, 50, 100, 30);
		infoFechaI.setBounds(80, 50, 175, 30);
		tituloCronometro.setBounds(290, 50, 70, 30);
		infoCronometro.setBounds(350, 50, 90, 30);
		tituloFechaF.setBounds(0, 100, 100, 30);
		infoFechaF.setBounds(80, 100, 175, 30);
		tituloInfo.setBounds(0, 150, 70, 30);
		infoInfo.setBounds(40, 150, 400, 30);
		
		
		add(tituloTipo);
		add(infoTipo);
		add(tituloCreador);
		add(infoCreador);
		add(tituloFechaI);
		add(infoFechaI);
		add(tituloCronometro);
		add(infoCronometro);
		add(tituloFechaF);
		add(infoFechaF);
		add(tituloInfo);
		add(infoInfo);
	}
	
	public void actualizarActividadActual(Aplicacion aplicacion, String cadena) {
		
		
		String[] subCadena = cadena.split("\\*");
		String nombre = subCadena[0];
		String fechaI = subCadena[1];
		
		Proyecto proyectoActual = aplicacion.getProyectoActual();
		HashMap<String, ArrayList<Actividad>> actividades = proyectoActual.getActividades();
		ArrayList<Actividad> listaActividades = actividades.get(nombre);
		Iterator<Actividad> iterador = listaActividades.iterator();
		while (iterador.hasNext()) {
			Actividad actividad = iterador.next();
			String fechaComparacion = actividad.getFechaI().toString();
			if(fechaComparacion.equals(fechaI) == true) {
				infoTipo.setText(actividad.getTipo());
				infoCreador.setText(actividad.getParticipante().getNombre());
				infoFechaI.setText(fechaI);
				infoFechaF.setText(actividad.getFechaT().toString());
				infoCronometro.setText(String.valueOf(actividad.getTiempo())+" s");
				infoInfo.setText(actividad.getInfo());
			}
		}
		
	}
	
	public void borrarActividadActual() {
		infoTipo.setText("");;
		infoCreador.setText("");
		infoFechaI.setText("");
		infoFechaF.setText("");
		infoCronometro.setText("");
		infoInfo.setText("");
	}
	

}
