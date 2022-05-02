package modelo;

import java.util.Date;


public class Actividad {

	private String nombre;
	
	private String tipo;
	
	private Date fechaRealizacion;
	
	private Date fechaTerminar;
	
	private Participante participante;
	
	private String info;
	
	private long tiempo;
	
	public Actividad(String elNombre, String tipo, String laInfo, Date fechaI, Date fechaF, Participante participante, long tiempo) {
			this.nombre = elNombre;
			this.tipo = tipo;
			this.info = laInfo;
			this.fechaRealizacion = fechaI;
			this.fechaTerminar = fechaF;
			this.tiempo = tiempo;
			this.participante = participante;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	public String getTipo()
	{
		return tipo;
	}
	
	public String getInfo()
	{
		return info;
	}
	
	public Date getFechaI() {
		return fechaRealizacion;
	}
	
	public Date getFechaT()
	{
		return fechaTerminar;
	}
	
	public Participante getParticipante()
	{
		return participante;
	}
	
	public long getTiempo() 
	{
		return tiempo;
	}
	
}
