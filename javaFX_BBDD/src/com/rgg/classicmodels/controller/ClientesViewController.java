package com.rgg.classicmodels.controller;

import java.sql.SQLException;
import java.util.List;

import com.rgg.classicmodels.dtos.ClienteDTO;
import com.rgg.classicmodels.model.ClientesModelo;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class ClientesViewController {
	
	@FXML
	private TextField textFieldTelefono;
	@FXML
	private TextField textFieldNombreCliente;
	@FXML
	private TextField textFieldPais;
	@FXML
	private TableView<ClienteDTO> tableviewClientes;
	@FXML
	private TableColumn<ClienteDTO, String> tableColumnNumero;
	@FXML
	private TableColumn<ClienteDTO, String> tableColumnNombre;
	@FXML
	private TableColumn<ClienteDTO, String> tableColumnTelefono;
	@FXML
	private Button buscar;
	@FXML
	private GridPane gridPane;

	// Referencia al TextArea del Scene principal
	private TextArea textAreaLog;
	
	public void setTextArea(TextArea t) {
		this.textAreaLog = t;
	}
	
	@FXML
	public void buscar(ActionEvent event) throws ClassNotFoundException, SQLException {
		
		textAreaLog.setText("Buscando clientes.....");
		
		ClientesModelo cm = new ClientesModelo();
		
		textAreaLog.setText("Búsqueda realizada......");
		
		List lista = cm.recuperaNombreTelefonoFiltraporNombreTfnoPais(textFieldNombreCliente.getText(), textFieldTelefono.getText(), textFieldPais.getText());
		
		tableColumnNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
		tableColumnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		tableColumnTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		tableviewClientes.setItems(FXCollections.observableList(lista));
	}
}
