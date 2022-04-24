package modelo;

public class Cronometro {
  
  private long tiempoInicio;
  private long tiempoFinal;
  private long tiempo;
  
  public Cronometro() {
	  this.tiempoInicio = System.currentTimeMillis();
  }
  
  public void finalizarCronometro() {
	  this.tiempoFinal = System.currentTimeMillis();
  }
  
  public long getTiempoInicio() {
	  return tiempoInicio;
  }
  
  public long getTiempoFinal() {
	  return tiempoFinal;
  }
  
  public long getTiempo() {
	  return tiempo;
  }
  
  public void tiempoTotal() {
	  this.tiempo = (getTiempoFinal() - getTiempoInicio())/1000;
  }
	
}
