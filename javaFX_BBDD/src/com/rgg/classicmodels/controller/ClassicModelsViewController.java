package com.rgg.classicmodels.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.MenuItem;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import javafx.scene.control.TextArea;

import javafx.scene.layout.BorderPane;

public class ClassicModelsViewController {
	@FXML
	private BorderPane borderPane;
	@FXML
	private MenuItem itemGestionInventario;
	@FXML
	private TextArea textAreaLog;
	@FXML
	private Label textInicio;

	// Event Listener on MenuItem[#itemGestionInventario].onAction
	@FXML
	public void menuItemGestionClientes(ActionEvent event) throws IOException {

		// Borramos el texto que presentamos al arrancar la aplicación
		borderPane.getChildren().remove(textInicio);

		// Cargamos el stage
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/clientesView.fxml"));
		Parent raiz = loader.load();

		// Buscamos el nodo
		Node node = raiz.lookup("#tableviewClientes");
		borderPane.setRight(node);
		node = raiz.lookup("#scrollPane");
		borderPane.setCenter(node);
		
		// Obtenemos el controller asociado a esa scene
		ClientesViewController controller = loader.getController();
		// Le pasamos al controller la variable de referencia para que desde el otro controller se pueda manejar este TextArea
		controller.setTextArea(this.textAreaLog);
	}
}
