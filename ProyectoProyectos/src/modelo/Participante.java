package modelo;

public class Participante {

	private String nombre;
	
	private String correo;
	
	
	public Participante(String elNombre, String elCorreo)
	{
		this.nombre = elNombre;
		this.correo = elCorreo;
	}
	
	
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getCorreo()
	{
		return correo;
	}
	
}
