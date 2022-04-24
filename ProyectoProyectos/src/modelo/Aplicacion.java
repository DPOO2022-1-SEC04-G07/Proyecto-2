package modelo;

import java.util.Date;
import java.util.HashMap;

public class Aplicacion {
	
	private HashMap<String, Proyecto> proyectos;

	private Proyecto proyectoActual;
	
	private Participante participanteActual;

	public Aplicacion() {
		this.proyectos = new HashMap<String, Proyecto>();
		
	}
	
	public HashMap<String, Proyecto> getProyectos(){
		return proyectos;
	}
	
	public Proyecto getProyectoActual(){
		return proyectoActual;
	}
	
	public Participante getParticipanteActual(){
		return participanteActual;
	}
	
	public void setProyectos(HashMap<String, Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
	public void setProyectoActual(Proyecto proyectoActual) {
		this.proyectoActual= proyectoActual;
	}
	
	public void setParticipanteActual(Participante participante) {
		this.participanteActual = participante;
	}
	
	public void crearProyecto(String nombre, String descripcion,Date fechaI, String FechaF,String nombreDueno,String correo) {
		Proyecto proyecto = new Proyecto(nombre,descripcion,fechaI,FechaF,nombreDueno,correo);
		HashMap<String, Proyecto> proyectos = getProyectos();
		proyectos.put(nombre, proyecto);
		setProyectos(proyectos);
		setProyectoActual(proyecto);
		Proyecto proyectoActual = getProyectoActual();
		Participante participanteActual = proyectoActual.buscarParticipante(correo);
		setParticipanteActual(participanteActual);

	}

	public void addParticipante(String nombre,String correo) {
		Participante participante = new Participante(nombre,correo);
		Proyecto proyectoActual = getProyectoActual();
		proyectoActual.addParticipante(correo, participante);
		String nombreProyecto = proyectoActual.getNombre();
		HashMap<String,Proyecto> proyectos = getProyectos();
		proyectos.replace(nombreProyecto, proyectoActual);
		setProyectos(proyectos);
		setProyectoActual(proyectoActual);
	}
	
	public void addActividad(String nombre,String tipo, String info, Date fechaInicio, Date FechaFinal,Participante participante, long tiempo) {
		Actividad actividad = new Actividad(nombre,tipo,info,fechaInicio,FechaFinal,participante,tiempo);
		Proyecto proyectoActual = getProyectoActual();
		proyectoActual.addActividad(nombre, actividad);
		String nombreProyecto = proyectoActual.getNombre();
		HashMap<String, Proyecto> proyectos = getProyectos();
		proyectos.replace(nombreProyecto, proyectoActual);
		setProyectos(proyectos);
		setProyectoActual(proyectoActual);
	}
	
	public void continuarActividad(String nombre,String tipo, String info, Date fechaInicio, Date FechaFinal,Participante participante, long tiempo) {
		Actividad actividad = new Actividad(nombre,tipo,info,fechaInicio,FechaFinal,participante,tiempo);
		Proyecto proyectoActual = getProyectoActual();
		proyectoActual.continuarProyecto(nombre, actividad);
		String nombreProyecto = proyectoActual.getNombre();
		HashMap<String, Proyecto> proyectos = getProyectos();
		proyectos.replace(nombreProyecto, proyectoActual);
		setProyectos(proyectos);
		setProyectoActual(proyectoActual);
	}
	
	public long tiempoTotalInvertido(){
		Participante participanteActual = getParticipanteActual();
		Proyecto proyectoActual = getProyectoActual();
		long tiempoTotalInvertido = proyectoActual.tiempoTotalInvertido(participanteActual);
		return tiempoTotalInvertido;
	}
	
	public long tiempoPromedio(){
		Participante participanteActual = getParticipanteActual();
		Proyecto proyectoActual = getProyectoActual();
		long promedio = proyectoActual.tiempoPromedio(participanteActual);
		return promedio;
	}
	
	

}
