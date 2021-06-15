package modelos;

import dtos.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonasModelo {
	
	public ObservableList<Persona> recuperaTodasPersonas(){
		ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();
		listaPersonas.add(new Persona(1, "Kike"));
		listaPersonas.add(new Persona(2, "Esther"));
		listaPersonas.add(new Persona(3, "Juan"));
		listaPersonas.add(new Persona(4, "Pepe"));
		listaPersonas.add(new Persona(5, "Luisa"));
		return listaPersonas;
	}
}
