package intefaz;

import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Aplicacion;
import modelo.Proyecto;

public class PanelDescripcion extends JPanel{

	JTextField infoDescripcion = new JTextField();
	
	public PanelDescripcion(Aplicacion aplicacion) {
		setLayout(null);
		infoDescripcion.setBounds(0, 20, 450, 60);
		
		add(infoDescripcion);
	}
	
	public void actualizarDescripcion(Aplicacion aplicacion) {
		Proyecto proyectoActual = aplicacion.getProyectoActual();
		infoDescripcion.setText(proyectoActual.getInfo());
	}
}
