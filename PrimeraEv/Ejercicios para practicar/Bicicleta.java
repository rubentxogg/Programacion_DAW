/**
* Práctica de programación
* @author Rubén García García
*/

class Bicicleta{

	// Atributos
	int velocidadActual;
	int platoActual;
	int pinonActual;

	// Método acelerar: dobla la velocidad actual
	void acelerar(){
		velocidadActual *= 2; // Multiplicamos * 2 la velocidad actual
	}

	// Método frenar: reduce la velocidad actual a la mitad
	void frenar(){
		velocidadActual /= 2;
	}

	/**
	* Este método nos permite camgiar el valor del atributo platoActual
	* @param platoActual Valor del plato actual
	*/
	void cambiarPlato(int platoActual){
		this.platoActual = platoActual; // Apuntamos a la variable del atributo y cambiamos su valor con el argumento introducido
	}

	/**
	* Este método nos permite camgiar el valor del atributo pinonActual
	* @param pinonActual Valor del piñón actual
	*/
	void cambiarPinon(int pinonActual){
		this.pinonActual = pinonActual; // Apuntamos a la variable del atributo y cambiamos su valor con el argumento introducido
	}

	// Método cambiarPinon
	void cambiarPinon(){ 
		pinonActual = 1; // Cambiamos el piñón a 1, que es el valor por defecto que le queremos dar
	}

	// Método cambiarPlato
	void cambiarPlato(){
		platoActual = 1; // Cambiamos el plato a 1 (valor por defecto)
	}

	/**
	* Método constructor que inicializa todos los atributos
	* @param velocidadActual Velocidad actual que lleva la bicicleta
	* @param platoActual Plato actual de la bicicleta
	* @param pinonActual Piñón actual de la bicicleta
	*/
	Bicicleta(int velocidadActual, int platoActual, int pinonActual){
		this.velocidadActual = velocidadActual;
		this.platoActual = platoActual;
		this.pinonActual = pinonActual;
	}

	// Método constructor por defecto
	Bicicleta(){
		velocidadActual = 0; // Inicicializo el atributo a 0 por defecto
		platoActual = 1; // Inicicializo el atributo a 1 por defecto
		pinonActual = 1; // Inicicializo el atributo a 1 por defecto
	}

	// Métodos get y set

	/**
	* Método set de velocidadActual
	* @param velocidadActual Cambiamos el valor de velocidadActual
	*/
	void setVelocidadActual(int velocidadActual){
		this.velocidadActual = velocidadActual;
	}

	/**
	* Método get de velocidadActual
	* @return Devuelve el valor de velocidadActual
	*/
	int getVelocidadActual(){
		return velocidadActual;
	}

	/**
	* Método set de platoActual
	* @param platoActual Cambiamos el valor de platoActual
	*/
	void setPlatoActual(int platoActual){
		this.platoActual = platoActual;
	}

	/**
	* Método get de platoActual
	* @return Devuelve el valor de platoActual
	*/
	int getPlatoActual(){
		return platoActual;
	}

	/**
	* Método set de pinonActual
	* @param pinonActual Cambiamos el valor de pinonActual
	*/
	void setPinonActual(int pinonActual){
		this.pinonActual = pinonActual;
	}

	/**
	* Método get de pinonActual
	* @return Devuelve el valor de pinonActual
	*/
	int getPinonActual(){
		return pinonActual;
	}

	/**
	* Método toString
	* @return Devuelve los datos de la bicicleta (velocidad actual, plato y piñón)
	*/
	public String toString(){
		return "Velocidad actual de la bicicleta: "+velocidadActual+"\nPlato: "+platoActual+"\nPiñón: "+pinonActual;
	}


	// Método main
	public static void main(String[] args){
		Bicicleta miBicicleta = new Bicicleta(30,4,4); // Creando el objeto miBicicleta
		Bicicleta tuBicicleta = new Bicicleta(70,6,5); // Creando el objeto tuBicicleta

		miBicicleta.acelerar();
		System.out.println(miBicicleta.velocidadActual);

		miBicicleta.acelerar();
		System.out.println(miBicicleta.velocidadActual);

		miBicicleta.frenar();
		System.out.println(miBicicleta.velocidadActual);

		System.out.println(miBicicleta.toString());
	}

}