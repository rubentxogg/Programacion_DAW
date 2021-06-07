package com.productorconsumidor.tipos;



public class Persona  implements Comparable<Persona>{
	private String nombre;
	private Integer edad;
	
	
	public Persona(String nombre, Integer edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}
	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		return o.getEdad().compareTo(this.getEdad());
	}
	
	

}
