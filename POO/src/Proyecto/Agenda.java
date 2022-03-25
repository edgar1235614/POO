/*
Integrantes del equipo:
-Carrasco Medina Carlos Iván
-Escalante Guadarrama Jorge Eduardo
-García Rosales Edgar Alan
Programación Orientada a Objetos 24/02/2022
Este programa usa la clase Contacto para usarla como
una agenda de contactos donde se puede agregar contactos, borrarlos,
ver una lista de todos ellos o buscar un contacto por alias o nombre.
*/
package Proyecto;
import java.util.*;
import java.util.ArrayList;
public class Agenda{
	public static void main(String[] args){
		//Inicio de variales y arreglos
		int buscar;
		Persona datosP [] = new Persona[10000];
		Telefono datosT [] = new Telefono[10000];
		
		//Datos por defecto de la clase personas
		datosP[0] = new Persona("Pedro", "Sanchez", "pepe", 'H');
		datosP[1] = new Persona("Marifer", "Lopez", "Fer", 'M');
		datosP[2] = new Persona("Carl", "Jackson", "Cj", 'H');
		datosP[3] = new Persona("Maria", "Hernandez", "Mari", 'M');
		datosP[4] = new Persona("Elizabeth", "Medina", "Eliza", 'M');
		
		//Datos por defecto de la clase telefono
		datosT[0] = new Telefono('M', 52, "309389185");
		datosT[1] = new Telefono('M', 93, "615732222");
		datosT[2] = new Telefono('F', 49, "308159562"); 
		datosT[3] = new Telefono('F', 52, "580258109");
		datosT[4] = new Telefono('M', 32, "696202398"); 
		
		//Creación de ArraysList para hacer una lista de contactos
		ArrayList<Contacto> lista = new ArrayList<Contacto>();
		
		for(int i = 0; i<5; i++){
			Contacto contactos = new Contacto(datosP[i], datosT[i]);
			lista.add(contactos);
			System.out.println(lista.get(i).toString());
		}
		
		do{
			//Selección de la accion a realizar a continuacion
			System.out.println("==========================================================================================");
			System.out.println ("¿Qué acción desea realizar? \n [1- Agregar contacto \t \t ] \n [2- Listado por tipo de Teléfono ] \n [3- Buscar contacto \t \t ] \n [4- Mostrar directorio \t \t ] \n [5- Borrar contacto \t \t ] \n [6- Ordenar \t \t \t ] \n [7- Salir \t \t \t ]");
			buscar=Keyboard.readInt();

			//Introducir nuevo contacto
			switch (buscar){
				case 1:
					//Metodo Agregar contacto en la lista
					Contacto.setNoContactos(agregarContacto(lista));
				break;
				case 2:
					//Metodo Imprimir lista por tipo Telefono
					ImprimirPorTel(lista);
				break;
				case 3:
					//Metodo Buscar persona de la lista
					buscarPersona(lista);
				break;
				case 4:
					//Metodo Imprimir lista
					imprimirDirectorio(lista);
				break;
				case 5:
					//Metodo Eliminar persona de la lista
					Contacto.setNoContactos(eliminarPersona(lista));
					imprimirDirectorio(lista);
				break; 
				case 6:
					//Metodo Ordenar lista
					lista = ordenarLista(lista);
				break;
			}
		}while(buscar != 7);
	}
	
	//Metodo para agregar una persona con una o dos personas.
	public static int agregarContacto(ArrayList lista){
		System.out.println("==========================================================================================");
		String nombre, apellido, alias, numero;
		char sexo, tipoT;
		int clave;
		//Recolección de datos para realizar la lista para el uso de la clase Persona
		System.out.println ("Introduzca el nombre de la persona: ");
		nombre=Keyboard.readString();
		
		System.out.println ("Introduzca el apellido de la persona: ");
		apellido=Keyboard.readString();	
		
		System.out.println ("Introduzca el alias de la persona: ");
		alias=Keyboard.readString();
		
		do{
			System.out.println ("Introduzca el sexo de la persona (H-Hombre, M-Mujer): ");
			sexo=Keyboard.readChar();
			if((sexo != 'H') && (sexo != 'M')){ //Compara si no es H y M para continuar
				System.out.println ("SOLO SE PERMITE H O M"); //Si lo es escribe este mensaje
			}
		}while((sexo != 'H') && (sexo != 'M')); //Valida si el sexo es diferente a H y M, si es asi se repite el ciclo 
		
		//Guardar en una variable de la clase persona
		Persona datosAP = new Persona(nombre, apellido, alias, sexo);
		
		int noTelefono;
		System.out.println ("Introduzca el numero de teléfonos que tiene la persona: ");
		noTelefono=Keyboard.readInt();
		Telefono datosAT[] = new Telefono[noTelefono];
		if(noTelefono < 1){
			Telefono datosATele = new Telefono('X', 00, "XXXXXXXXXX"); //Datos Agregar Telefono
			Contacto contactos = new Contacto(datosAP, datosATele);
			lista.add(contactos);
		}
		else if(noTelefono == 1){	
			do{	
				System.out.println ("Introduzca el tipo de teléfono de la persona (M-Movil, F-Fijo): ");
				tipoT=Keyboard.readChar();
				if((tipoT != 'M') && (tipoT != 'F')){ //Compara si no es M o F para continuar
					System.out.println ("SOLO SE PERMITE M O F"); //Si no lo es escribe este mensaje
				}
			}while((tipoT != 'M') && (tipoT != 'F'));
		
			do{
				System.out.println ("Introduzca la clave del teléfono de la persona: ");
				clave=Keyboard.readInt();
				if((clave > 999) || (clave < 0)){													//Compara si no es 10 para continuar
					System.out.println ("El número de digitos no cumple con los requisitos"); //Si no lo es escribe este mensaje
				}
			}while((clave > 999) || (clave < 0));
			
			do{
				System.out.println ("Introduzca el numero de telefono de la persona: ");
				numero=Keyboard.readString();
				if(numero.length() != 10){															//Compara si no es 10 para continuar
					System.out.println ("El numero de digitos no cumple con los requisitos"); //Si no lo es escribe este mensaje
				}
			}while(numero.length() != 10);
			
			//Se guarda en una variable de la clase Telefono
			Telefono datosATele = new Telefono(tipoT, clave, numero); //Datos Agregar Telefono
			
			Contacto contactos = new Contacto(datosAP, datosATele);
			lista.add(contactos);
		}
		else{
			for(int i = 0; i<noTelefono; i++){
				do{	
					System.out.println ("Introduzca el tipo de teléfono de la persona (M-Movil, F-Fijo): ");
					tipoT=Keyboard.readChar();
					if((tipoT != 'M') && (tipoT != 'F')){ //Compara si no es M o F para continuar
						System.out.println ("SOLO SE PERMITE M O F"); //Si lo es escribe este mensaje
					}
				}while((tipoT != 'M') && (tipoT != 'F'));
				
				System.out.println ("Introduzca la clave de teléfono de la persona: ");
				clave=Keyboard.readInt();
				
				System.out.println ("Introduzca el numero de teléfono de la persona: ");
				numero=Keyboard.readString();
				
				//Se guarda en una variable de la clase Telefono
				datosAT[i] = new Telefono(tipoT, clave, numero); //Datos Agregar Telefono
			}
			Contacto contactos = new Contacto(datosAP, datosAT);
			lista.add(contactos);	
		}
		return Contacto.getNoContactos();
	}
	
	//metodo para imprimir por tipo de telefono
	public static void ImprimirPorTel(ArrayList <Contacto>lista){
		System.out.println("==========================================================================================");
		char buscaTel;
		do{	
			System.out.println ("Introduzca el tipo de telefono que desee buscar (M-Movil, F-Fijo)");
			buscaTel=Keyboard.readChar();
			if((buscaTel != 'M') && (buscaTel != 'F')){					//Compara si no es M o F para continuar
				System.out.println ("SOLO SE PERMITE M O F");		//si lo es escribe este mensaje
			}
		}while((buscaTel != 'M') && (buscaTel != 'F'));

		//comprueba si hay personas con el tipo de telefono
		int comprobar = 0;			
		if(buscaTel == 'M'){
			System.out.println("===================================Telefono Movil=========================================");
		}
		else{
			System.out.println("===================================Telefono Fijo==========================================");
		}
		for(int i = 0; i<Contacto.getNoContactos() ;i++){ 
			if(lista.get(i).getNoT() == 1){
				if(lista.get(i).getTelefono().getTipo() == buscaTel){
					comprobar++;
					System.out.println(lista.get(i).toString());
				}
			}
			else{
				comprobar = 3;
				for(int j = 0; j < lista.get(i).getTamanoT(); j++){
					if(lista.get(i).getTelefono(j).getTipo() == buscaTel){
						if(comprobar == 3){
							comprobar++;
							System.out.println(lista.get(i).getInfo().toString() +lista.get(i).getTelefono(j).toString());
						}
						else{
							System.out.println("\t \t \t \t \t " +lista.get(i).getTelefono(j));
						}
					}
				}
			}
		}
		if(comprobar == 0){
			System.out.println("Ninguna persona tiene ese tipo de teléfono");
		}
	}
	
	//metodo para buscar persona
	public static void buscarPersona(ArrayList <Contacto>lista){
		System.out.println("==========================================================================================");
		String buscaNombre;
		System.out.println ("Introduzca el nombre o alias de la persona que desee buscar: ");
		buscaNombre = Keyboard.readString();
		
		//comprueba si hay personas con el mismo nombre o alias
		int comprobar = 0;	
		for(int i = 0; i<Contacto.getNoContactos() ;i++){     //uso de equals para comparar String de buscaNombre y el nombre de la lista
			if(buscaNombre.equalsIgnoreCase(lista.get(i).getInfo().getNombre()) || (buscaNombre.equalsIgnoreCase(lista.get(i).getInfo().getAlias()))){
				System.out.println(lista.get(i).toString());
				comprobar = 2;
			}
			else if((i == (Contacto.getNoContactos()-1)) && (comprobar == 0)){
				System.out.println("Ningún nombre coincide: ");
			}
		}
	}

	//metodo para imprimir el directorio
	public static void imprimirDirectorio(ArrayList lista){
		System.out.println("==========================================================================================");
		for(int i = 0; i<Contacto.getNoContactos(); i++){
			System.out.println(lista.get(i).toString());
		}
	}
	
	//metodo para eliminar un contacto del directorio
	public static int eliminarPersona(ArrayList lista){
		System.out.println("==========================================================================================");
		int borrar;
		for(int i = 0; i<Contacto.getNoContactos(); i++){
			System.out.println((i+1) +".- " +lista.get(i).toString());
		}
		System.out.println("Introduzca el numero del contacto que desea eliminar: ");
		borrar = Keyboard.readInt();
		
		lista.remove(borrar-1);
		Contacto.setNoContactos(Contacto.getNoContactos() - 1);
		
		return Contacto.getNoContactos();
	}
	
	public static ArrayList ordenarLista(ArrayList <Contacto>lista){
		System.out.println("==========================================================================================");
		//se crea otro ArrayList para usarlo para ordenar 
		ArrayList<Contacto> listaOrdenar = new ArrayList<Contacto>();
		String nombres[] = new String[Contacto.getNoContactos()];
		
		//seleccion de filtro para ordenar
		int filtroOrdenar;
		do{
			System.out.println("¿Como desea filtrar [1- Nombre] [2- Apellido] [3- Alias]?");
			filtroOrdenar = Keyboard.readInt();
		}while((filtroOrdenar > 3) || (filtroOrdenar < 1));
		
		//se guardan los nombres en un arreglo String
		switch (filtroOrdenar){
			case 1:
				for(int i = 0; i<Contacto.getNoContactos(); i++){
					nombres[i] = lista.get(i).getInfo().getNombre();
				}
			break;
			case 2:
				for(int i = 0; i<Contacto.getNoContactos(); i++){
					nombres[i] = lista.get(i).getInfo().getApellido();
				}
			break;
			case 3:
				for(int i = 0; i<Contacto.getNoContactos(); i++){
					nombres[i] = lista.get(i).getInfo().getAlias();
				}
			break;
		}
		//se usa un sort para ordenar los nombres
		Arrays.sort(nombres);
		
		//nuevo orden
		switch(filtroOrdenar){
			case 1:
				for(int i = 0; i<Contacto.getNoContactos() ;i++){
					for(int j = 0; j<Contacto.getNoContactos() ;j++){
						if(nombres[i].equals(lista.get(j).getInfo().getNombre())){
							System.out.println(lista.get(j).toString());
							listaOrdenar.add(lista.get(j));
						}
					}
				}
			break;
			case 2:
				for(int i = 0; i<Contacto.getNoContactos() ;i++){
					for(int j = 0; j<Contacto.getNoContactos() ;j++){
						if(nombres[i].equals(lista.get(j).getInfo().getApellido())){
							System.out.println(lista.get(j).toString());
							listaOrdenar.add(lista.get(j));
						}
					}
				}
			break;
			case 3:
				for(int i = 0; i<Contacto.getNoContactos() ;i++){
					for(int j = 0; j<Contacto.getNoContactos() ;j++){
						if(nombres[i].equals(lista.get(j).getInfo().getAlias())){
							System.out.println(lista.get(j).toString());
							listaOrdenar.add(lista.get(j));
						}
					}
				}
			break;
			}
		return listaOrdenar;
	}
}

