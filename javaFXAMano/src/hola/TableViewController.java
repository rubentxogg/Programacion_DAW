package hola;

import dtos.Persona;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelos.PersonasModelo;
import javafx.scene.control.Label;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class TableViewController {
	@FXML
	private Label id;
	@FXML
	private TextField campoId;
	@FXML
	private Label nombre;
	@FXML
	private TextField campoNombre;
	@FXML
	private Button buscar;
	@FXML
	private Button modificar;
	@FXML
	private TableView<Persona> tableView;
	@FXML
	private TableColumn<Persona, Integer> columnaId;
	@FXML
	private TableColumn<Persona, String> columnaNombre;

	ObservableList<Persona> list;
	
	public void buscaTodasPersonas() {
		list = new PersonasModelo().recuperaTodasPersonas();
		
		columnaId.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("id"));
		columnaNombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
		
		tableView.setItems(list);
	}
	
	public void clickEnFila() {
		if(tableView.getSelectionModel().getSelectedItem() != null) {
			Persona selectedPersona = tableView.getSelectionModel().getSelectedItem();
			columnaNombre.setText(selectedPersona.getNombre());
			campoId.setText(selectedPersona.getId().toString());
			campoNombre.setText(selectedPersona.getNombre());
		}
	}
	 
	public void modifica() {
		list.add(new Persona(6, "Pepito"));
	}
}
