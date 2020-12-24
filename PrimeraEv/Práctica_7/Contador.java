import java.util.Scanner;

/**
* @author Rubén García García
* Práctica 7 de programación
*/

public class Contador{
	
	// Atributos
	private int cont;

	// Métodos contructor por defecto
	public Contador(){

	}

	// Método constructor con argumento de tipo integer
	public Contador(int cont){
		this.cont = cont;

		if(cont < 0){ // Si el contador es un número negativo el valor será 0
			this.cont = 0;
		}
		else{
			this.cont = cont; // Si se introduce un valor válido se guardará en cont
		}
	}

	// Método constructor que acepta un objeto de tipo contador como argumento
	public Contador(Contador c){
		cont = c.getCont();
	}

	// Método get
	public int getCont(){
		return cont;
	}

	// Método set
	public void setCont(int cont){
		this.cont = cont;
	}

	// Método incrCont
	public void incrementar(){
		cont++;
	}

	// Método incrDatoCont
	public void incrementar(int cont){
		this.cont += cont;
	}

	// Método decrCont
	public void decrementar(){
		cont--;

		if(cont < 0){
			cont = 0;
		}
	}

	// Método decrDatoCont
	public void decrementar(int cont){
		this.cont -= cont;
	}

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
        //Scanner es una clase creada para registar las teclas que introduce el usuario.

        //Utilizar el constructor por defecto
        Contador contador1 = new Contador();
      
        int n;
        System.out.println("Introduce valor para inicializar el contador: ");
        n = sc.nextInt();
       
        //asignar un valor al contador
        contador1.setCont(n);
        //incrementar el contador
        contador1.incrementar();
        //mostrar el valor actual
        System.out.println(contador1.getCont());
       
        contador1.incrementar();
        contador1.incrementar();
        contador1.incrementar(5);
       
        //mostrar el valor actual
        System.out.println(contador1.getCont());
       
        //restar 1 al valor del contador
        contador1.decrementar();
        contador1.decrementar(7);
       
        //mostrar el valor actual
        System.out.println(contador1.getCont());

        //crear un nuevo objeto Contador con valor inicial 10
        Contador contador2 = new Contador(10);
       
        //incrementar y decrementar el contador2 y mostrar su valor
        contador2.incrementar();
        System.out.println(contador2.getCont());
        contador2.decrementar();
        System.out.println(contador2.getCont());

        //crear un objeto Contador utilizando el constructor copia
        //se crea el objeto contador3 como copia de contador2
        Contador contador3 = new Contador(contador2);

        //mostrar el valor de contador3
        System.out.println(contador3.getCont());

        sc.close(); // Se borra la memoria de la clase Scanner
	}
}