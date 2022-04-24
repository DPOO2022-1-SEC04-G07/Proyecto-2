package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class Proyecto {

	private String nombre;
	
	private String info;
	
	private Date fechaInicial;
	
	private String fechaFinal;
	
	private HashMap<String, Participante> participantes;
	
	private HashMap<String, ArrayList<Actividad>> actividades;
	
	public Proyecto(String elNombre, String laInfo, Date fechaI, String fechaF, String nombre, String correo) {
		this.nombre = elNombre;
		this.info = laInfo;
		this.fechaInicial = fechaI;
		this.fechaFinal = fechaF;
		Participante dueño = new Participante(nombre,correo);
		HashMap<String, Participante> participantes = new HashMap<String, Participante>();
		participantes.put(correo, dueño);
		HashMap<String, ArrayList<Actividad>> actividades = new HashMap<String,ArrayList<Actividad>>();
		this.actividades = actividades;
		this.participantes = participantes;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getInfo(){
		return info;
	}
	
	public Date getFechaInicial(){
		return fechaInicial;
	}
	
	public String getFechaFinal(){
		return fechaFinal;
	}
	
	public HashMap<String, Participante> getParticipantes(){
		return participantes;
	}
	
	public HashMap<String, ArrayList<Actividad>> getActividades(){
		return actividades;
	}
	
	public Participante buscarParticipante(String correo) {
		HashMap<String, Participante> participantes = getParticipantes();
		return participantes.get(correo);
	}
	
	public void setParticipantes(HashMap<String, Participante> participantes) {
		this.participantes = participantes;
	}
	
	public void setActividades(HashMap<String, ArrayList<Actividad>> actividades) {
		this.actividades = actividades;
	}
	
	public void addParticipante(String correo, Participante participante) {
		HashMap<String, Participante> participantes = getParticipantes();
		participantes.put(correo, participante);
		setParticipantes(participantes);
	}
	
	public void addActividad(String nombreActividad, Actividad actividad) {
		HashMap<String, ArrayList<Actividad>> actividades = getActividades();
		ArrayList<Actividad> trabajos = new ArrayList<Actividad>();
		trabajos.add(actividad);
		actividades.put(nombreActividad,trabajos);
		setActividades(actividades);
	}
		
	public void continuarProyecto(String nombre, Actividad actividad) {
		HashMap<String, ArrayList<Actividad>> actividades = getActividades();
		ArrayList<Actividad> trabajos = actividades.get(nombre);
		trabajos.add(actividad);
		actividades.replace(nombre, trabajos);
		setActividades(actividades);
	}
	
	public long tiempoTotalInvertido(Participante participante) {
		HashMap<String, ArrayList<Actividad>> actividades = getActividades();
		long tiempoInvertido = 0;
		for(String nombre : actividades.keySet()) {
			ArrayList<Actividad> actividad = actividades.get(nombre);
			Iterator<Actividad> iterator = actividad.iterator();
			while(iterator.hasNext()) {
				Actividad trabajo = iterator.next();
				Participante participanteActividad = trabajo.getParticipante();
				if (participante.equals(participanteActividad)){
					long tiempoActividad = trabajo.getTiempo();
					tiempoInvertido += tiempoActividad;
				}
			}
		}
		return tiempoInvertido;
	}
	
	public long tiempoPromedio(Participante participante) {
		HashMap<String, ArrayList<Actividad>> actividades = getActividades();
		long tiempoInvertido = 0;
		long tareas = 0;
		for(String nombre : actividades.keySet()) {
			ArrayList<Actividad> actividad = actividades.get(nombre);
			Iterator<Actividad> iterator = actividad.iterator();
			while(iterator.hasNext()) {
				Actividad trabajo = iterator.next();
				Participante participanteActividad = trabajo.getParticipante();
				if (participante.equals(participanteActividad)){
					long tiempoActividad = trabajo.getTiempo();
					tiempoInvertido += tiempoActividad;
					tareas+=1;
				}
			}
		}
		return tiempoInvertido/tareas;
	}
}
