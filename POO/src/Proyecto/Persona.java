/*  
Integrantes del equipo:
-Carrasco Medina Carlos Iván
-Escalante Guadarrama Jorge Eduardo
-García Rosales Edgar Alan
Programación Orientada a Objetos 24/03/2022
Declaración de la clase Persona.java contiene atributos nombre, 
sexo y edad. Metodos: get/set para los atributos y toString.
*/
public class Persona{//Encabezado de la clase Persona
	//Atributos
	private String nombre, apellido, alias;
	private char sexo;
	//Constructor con los 3 parametros para los atributos  
	public Persona(String nombre, String apellido, String alias, char sexo){
		this.nombre = nombre;
		this.apellido  = apellido;
		this.alias = alias;
		this.sexo  = sexo;
	}
	//Metodo toString
	@Override
	public String toString(){
		return nombre+" \t \t" +apellido+" \t" +alias +" \t" +sexo;
	}
	//Metodos get y set
	//Obtiene el nombre de la persona
	public String getNombre(){
		return this.nombre;
	}
	//Cambia el nombre de la persona
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	//Obtiene el apellido de la persona
	public String getApellido(){
		return this.apellido;
	}
	//Cambia el apellido de la persona
	public void setApellido(String apellido){
		this.apellido = apellido;
	}
	//Obtiene el alias de la persona
	public String getAlias(){
		return this.alias;
	}
	//Cambia el nombre de la persona
	public void setAlias(String alias){
		this.alias = alias;
	}
	//Obtiene el sexo de la persona 
	public char getSexo(){
		return this.sexo;
	}
	//Cambia el sexo de la persona
	public void setSexo(char sexo){
		this.sexo = sexo;
	}
}	
