package intefaz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Actividad;
import modelo.Aplicacion;
import modelo.Proyecto;

public class PanelReporte extends JPanel{
	
	JTextField tiempoInvertido = new JTextField();
	JTextField promedioInvertido = new JTextField();
	
	public PanelReporte() {
		setLayout(null);
		JLabel tituloTiempoInvertido = new JLabel("Tiempo Total invertido: ");
		JLabel tituloTiempoPromedioInvertido = new JLabel("Tiempo promedio invertido:");
	
		tituloTiempoInvertido.setBounds(0, 0, 160, 30);
		tiempoInvertido.setBounds(140, 0, 150, 30);
		tituloTiempoPromedioInvertido.setBounds(0, 50, 160, 30);
		promedioInvertido.setBounds(160, 50, 130, 30);
		
		
		add(tituloTiempoInvertido);
		add(tiempoInvertido);
		add(tituloTiempoPromedioInvertido);
		add(promedioInvertido);
		
	}
	
	public void actualizarPanelReporte(Aplicacion aplicacion) {
		boolean comparacion;
		comparacion = false;
		Proyecto proyectoActual = aplicacion.getProyectoActual();
		if (proyectoActual.getActividades().isEmpty() == false) {
			HashMap<String,ArrayList<Actividad>> actividades = proyectoActual.getActividades();
			for (String i : actividades.keySet()) {
				ArrayList<Actividad> listaActividades = actividades.get(i);
				Iterator<Actividad> iterador = listaActividades.iterator();
				while (iterador.hasNext()) {
					Actividad actividad = iterador.next();
					if(actividad.getParticipante().equals(aplicacion.getParticipanteActual())) {
						comparacion = true;
					}
				
				}
			}
			
		}
		
		if (comparacion == true) {
			long valorTiempoInvertido = aplicacion.tiempoTotalInvertido();
			long valorPromedioInvertido = aplicacion.tiempoPromedio();
		
			tiempoInvertido.setText(String.valueOf(valorTiempoInvertido)+" s");
			promedioInvertido.setText(String.valueOf(valorPromedioInvertido)+" s");
		}
	}
	
	public void borrarPanelReporte() {
		tiempoInvertido.setText("");
		promedioInvertido.setText("");
	}

}
