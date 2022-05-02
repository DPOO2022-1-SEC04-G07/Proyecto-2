package intefaz;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Aplicacion;
import modelo.Participante;

public class PanelParticipante extends JPanel{
	
	JTextField nombre = new JTextField();
	
	public PanelParticipante() {
		setLayout(null);
		JLabel tituloParticipanteActual= new JLabel("Participante actual: ");
		JLabel tituloNombre = new JLabel ("Nombre: ");
		
		tituloParticipanteActual.setBounds(0, 0, 150, 30);
		tituloNombre.setBounds(0,50,70,30);
		nombre.setBounds(80, 50, 150, 30);
		
		add(tituloParticipanteActual);
		add(tituloNombre);
		add(nombre);
		
	}

	public void actualizarNombre(Aplicacion aplicacion) {
		Participante participanteActual = aplicacion.getParticipanteActual();
		nombre.setText(participanteActual.getNombre());
	}
	
}
