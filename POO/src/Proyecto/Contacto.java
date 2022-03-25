/*
Integrantes del equipo:
-Carrasco Medina Carlos Iván
-Escalante Guadarrama Jorge Eduardo
-García Rosales Edgar Alan
Programación Orientada a Objetos 24/03/2022
Este programa usa a clase Persona y la clase Telefono para usarla como
un contacto el metodo toString de este y el get de la variable de clase Telefono
y la variable de clase Persona.
*/
public class Contacto{//Encabezado de la clase Contacto
	//Declaración de los atributos
	private static int noContactos;
	int noT = 0;
	private Persona info;
	private Telefono telefono;
	private Telefono telefono2[];
	//Constructor con  persona y telefono
	public Contacto(Persona info, Telefono telefono){
		this.info = info;
		this.telefono = telefono;
		noContactos++;
		this.noT = 1;
	}	
	//Consctructor con persona y 2 telefonos
	public Contacto(Persona info, Telefono[] telefono2){
		this.info = info;
		this.telefono2 = telefono2;
		noContactos++;
		this.noT = 2;
	}
	//Metodo toString de Contacto
	@Override
	public String toString(){
		String devolver = "";
		if(noT == 1){//Si el noTelefono es 1
			devolver = info +"" +telefono;
		}
		else{//Si no
			devolver = info +"" +telefono2[0];
			for(int i = 1; i<telefono2.length; i++){
				devolver = devolver +"\n \t \t \t \t \t " +telefono2[i];
			}
		}
		return devolver;//Retorna el string
	}
	//Metodos get para info (Informacion de la persona) y para llamar el telefono1
	public Persona getInfo(){
		return this.info;
	}
	public Telefono getTelefono(){
		return this.telefono;
	}
	public Telefono getTelefono(int i){
		return this.telefono2[i];
	}
	public int getTamanoT(){
		return this.telefono2.length;
	}
	//Metodos get y set para el numero de contacto (noContactos)
	public static int getNoContactos(){
		return noContactos;
	}
	public static void setNoContactos(int numero){
		noContactos = numero;
	}
	//Metodo get para noT (Numero de telefonos)
	public int getNoT(){
		return noT;
	}
}
