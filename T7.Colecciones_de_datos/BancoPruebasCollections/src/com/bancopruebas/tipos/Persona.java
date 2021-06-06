package com.bancopruebas.tipos;

public class Persona implements Comparable<Persona>{
	private Integer id;
	private String nombre;

	public Persona(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + "]";
	}

	@Override
	public int compareTo(Persona p) {
		// TODO Auto-generated method stub
		return p.getId().compareTo(p.getId());
	}

}
