package vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import modelo.Actividad;
import modelo.Aplicacion;
import modelo.Cronometro;
import modelo.Participante;
import modelo.Proyecto;

public class VistaConsola {
	
	public static void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación");
		System.out.println("1. Crear proyecto");
		System.out.println("2. Proyecto seleccionado actual");
		System.out.println("3. Abrir proyecto");
		System.out.println("4. AÃ±adir participante al proyecto");
		System.out.println("5. Crear Actividad");
		System.out.println("6. Continuar Actividad");
		System.out.println("7. Generar Reporte de tiempos");
		System.out.println("8. Salir de la aplicación");
	}

	public static void main(String[] args) 
	{
		System.out.println("Bienvenido a la aplicaciÃ³n de proyectos");
		Aplicacion aplicacion = new Aplicacion();
		Scanner sc= new Scanner(System.in); 

		boolean continuar = true;
		while (continuar == true)
		{
			try
			{
				mostrarMenu();
				System.out.println("Seleccione una opcion: ");
				int opcionSeleccionada = sc.nextInt();
				if (opcionSeleccionada == 1) 
				{
			
					sc.nextLine();
					
					System.out.println("\nCreando proyecto...");
					System.out.println("\nIngrese el Titulo del proyecto: ");
					String nombre = sc.nextLine();
					
					System.out.println("\nIngrese la descripcion del proyecto: ");
					String descripcion = sc.nextLine();
					
					System.out.println("\nFecha Inicio: ");
					Date objDate = new Date();
					System.out.println(objDate.toString());
					
					System.out.println("\nFecha Entrega en formato (MM-DD-AAAA): ");
					String fechaFinal = sc.nextLine();
					
					System.out.println("\nIngrese el nombre del dueÃ±o del proyecto: ");
					String nombreD = sc.nextLine();
					
					System.out.println("\nIngrese el correo electronico del dueÃ±o del proyecto:");
					String correo = sc.nextLine();
					
					aplicacion.crearProyecto(nombre, descripcion, objDate, fechaFinal, nombreD, correo);
				}
				else if (opcionSeleccionada == 2) {
					Proyecto proyectoActual = aplicacion.getProyectoActual();
					System.out.println("\nNombre proyecto actual: " + proyectoActual.getNombre());
					System.out.println("Descripcion: " + proyectoActual.getInfo());
				}
				else if (opcionSeleccionada == 3) {
					System.out.print("Buscando proyectos...\n");
					HashMap<String, Proyecto> proyectos = aplicacion.getProyectos();
					int numero = 1;
					ArrayList<String> orden = new ArrayList<String>();
					for(String i : proyectos.keySet()) {
						orden.add(i);
						System.out.println(numero+". Nombre: "+ i);
						numero+=1;
					}
					System.out.println("\nEscriba el nÃºmero del proyecto seleccionado: ");
					int opcion = sc.nextInt();
					int indice = opcion-1 ;
					String nombre = orden.get(indice);
					Proyecto proyecto = proyectos.get(nombre);
					
					sc.nextLine();
					System.out.println("El proyecto seleccionado es: ");
					String info = proyecto.getInfo();
					System.out.println("Nombre: " + nombre + "   DescrpciÃ³n: " + info );
					System.out.println("\nÂ¿Desea continuar? (Si o No):");
					String opcion2 = sc.nextLine();
					if (opcion2.equals("Si")) {
						aplicacion.setProyectoActual(proyecto);
					}
				}
				else if (opcionSeleccionada == 4) {
					sc.nextLine();
					System.out.println("\nLista actual de participantes: ");
					int numero = 1;
					Proyecto proyectoActual = aplicacion.getProyectoActual();
					HashMap<String, Participante> participantes = proyectoActual.getParticipantes();
					for(String correo : participantes.keySet()) {
						Participante participante = participantes.get(correo);
						System.out.println(numero+". Nombre: "+participante.getNombre()+"   Correo: "+correo);
						numero+=1;
					}
					System.out.println("\n¿Desea continuar? (Si o No):");
					String opcion = sc.nextLine();
					if (opcion.equals("Si")) {
						System.out.println("\nCreando participante...");
						System.out.println("\nIngrese el nombre; ");
						String nombre = sc.nextLine();
						System.out.println("\nIngrese el correo; ");
						String correo = sc.nextLine();
						aplicacion.addParticipante(nombre,correo);
						System.out.println("Participante agregado existosamente.");
					}
				}
				else if (opcionSeleccionada == 5) {
					String correo;
					Cronometro cronometro = new Cronometro();
					sc.nextLine();
					System.out.println("\nCreando actividad...");
					System.out.println("\nFecha Inicio: ");
					Date fechaInicio = new Date();
					System.out.println(fechaInicio.toString());
					Proyecto proyectoActual = aplicacion.getProyectoActual();
					HashMap<String, Participante> participantes = proyectoActual.getParticipantes();
					System.out.println("Lista de participantes: \n");
					int numero = 1;
					ArrayList<String> orden = new ArrayList<String>();
					for(String correoMapa : participantes.keySet()) {
						Participante participante = participantes.get(correoMapa);
						orden.add(correoMapa);
						System.out.println(numero+". Nombre: "+participante.getNombre()+"   Correo: "+correoMapa);
						numero+=1;
					}
					System.out.println("\nSeleccione un participante escribiendo su número, si desea agregar un nuevo participante digite 0: ");
					int seleccion = sc.nextInt();
					if (seleccion == 0 ) {
						System.out.println("\nIngrese el nombre del creador de la actividad: ");
						String nombre = sc.nextLine();
						System.out.println("\nIngrese el correo del creador de la actividad: ");
						correo = sc.nextLine();
						aplicacion.addParticipante(nombre, correo);
					}
					else {
						correo = orden.get(seleccion-1);
					}
					
					sc.nextLine();
					Participante participante = proyectoActual.buscarParticipante(correo);
					System.out.println("\nIngrese el nombre de la actividad: ");
					String nombre = sc.nextLine();
					System.out.println("\nIngrese el tipo de actividad: ");
					String tipo = sc.nextLine();
					System.out.println("\nIngrese una breve descripción de la actividad: ");
					String info = sc.nextLine();
					System.out.println("\nFecha Terminado: ");
					Date fechaFinal = new Date();
					System.out.println(fechaFinal.toString());
					cronometro.finalizarCronometro();
					cronometro.tiempoTotal();
					long tiempo = cronometro.getTiempo();
					
					aplicacion.addActividad(nombre, tipo, info, fechaInicio, fechaFinal, participante, tiempo);
				}
				
				else if (opcionSeleccionada == 6){
					sc.nextLine();
					Cronometro cronometro = new Cronometro();
					Date fechaInicio = new Date();
					Proyecto proyectoActual = aplicacion.getProyectoActual();
					HashMap<String, ArrayList<Actividad>> actividades = proyectoActual.getActividades();
					ArrayList<String> orden = new ArrayList<String>();
					int numero = 1;
					for(String nombre : actividades.keySet()) {
						System.out.println(numero+". Nombre: " + nombre);
						orden.add(nombre);
					}
					System.out.println("\nSeleccione una actividad escribiendo su numero: ");
					int seleccion = sc.nextInt();
					String nombre = orden.get(seleccion-1);
					ArrayList<Actividad> actividad = actividades.get(nombre);
					Actividad trabajo = actividad.get(0);
					String tipo = trabajo.getTipo();
					Participante participante = trabajo.getParticipante();
					sc.nextLine();
					System.out.println("\nIngrese una breve descripción de la actividad: ");
					String info = sc.nextLine();
					Date fechaFinal = new Date();
					System.out.println(fechaFinal.toString());
					cronometro.finalizarCronometro();
					cronometro.tiempoTotal();
					long tiempo = cronometro.getTiempo();
					
					aplicacion.continuarActividad(nombre, tipo, info, fechaInicio, fechaFinal, participante, tiempo);
					
					
					}
				
				else if (opcionSeleccionada == 7) {
					System.out.println("\nImprimiendo Reporte");
					long tiempoTotalInvertido = aplicacion.tiempoTotalInvertido();
					long promedio = aplicacion.tiempoPromedio();
					System.out.println("\nEl tiempo total invertido es: " + tiempoTotalInvertido);
					System.out.println("El tiempo promedio es: " + promedio);
				}
				
				else if (opcionSeleccionada == 8)
				{
					System.out.println("\nSaliendo de la aplicaciÃ³n ...");
					continuar = false;
					sc.close();
				}
				else
				{
					System.out.println("Por favor seleccione una opciÃ³n vÃ¡lida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los nÃºmeros de las opciones.");
			}
		}
	}
}

