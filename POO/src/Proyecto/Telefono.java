/*
Integrantes del equipo:
-Carrasco Medina Carlos Iván
-Escalante Guadarrama Jorge Eduardo
-García Rosales Edgar Alan
Programación Orientada a Objetos 24/03/2022
Declaracion de la clase Telefono.java contiene atributos tipo, clave, numero.
Métodos: get y set para los atributos y toString.
*/
public class Telefono{//Encabezado de la clase
	//Atributos
	private String clave;
	private char tipo;
	private String numero;
	//Constructor con los 3 parametros para los atributos 
	public Telefono(char tipo, String clave, String numero) {
		this.tipo = tipo;
		this.clave = clave;
		this.numero = numero;
	}
	//Método toString
	@Override
	public String toString(){
		return "\t" +tipo+"\t" +clave +"\t" +numero;
	}
	//Metodos get y set
	//Obtiene el tipo de telefono (Fijo "F" o Móvil "M")
	public char getTipo() {
		return this.tipo;
	}
	//Cambia el tipo de telefono
	public void setTipo(char tipo) {
		this.tipo= tipo;
	}
	//Obtiene la clave del país +xx
	public String getClave() {
		return this.clave;
	}
	//Cambia el tipo de clave
	public void setClave(String clave){
		this.clave = clave;
	}
	//Obtenie el numero del telefono
	public String getNumero(){
		return this.numero;
	}
	//Cambia el numero de telefono
	public void setNumero(String numero){
		this.numero = numero;
	}
}
