package hola;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
	
	@FXML 
	private Button aceptar;
	
	
	public void atiendeClickBoton(){
		
		System.out.println("Se ha pulsado el bot�n");
		System.out.println("Llamar� a la clase correspondiente para hacer el trabajo que corresponda....");
		aceptar.setText("No me vuelvas a tocar, madefaka");
		
	}

}