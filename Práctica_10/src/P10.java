/**
 * @author Rubentxo
 * Práctica 10 de programación
 */
public class P10{
	
	/*
	 * Ejemplo de uso de StringBuilder
	 * Separador de millares
	 */
//	public static void main(String[] args) {
//        String s = "1234567890";      
//        s = separarMiles(s);
//        System.out.println(s);
//    }
//	
//	public static String separarMiles(String s){
//		 
//        //creamos un StringBuilder a partir del String s                                                          
//        StringBuilder aux = new StringBuilder(s);
//  
//        //le damos la vuelta
//        aux.reverse();
//  
//        //variable que indica donde insertar el siguiente punto                                                   
//        int posicion = 3;
//  
//        //mientras no lleguemos al final del número
//        while(posicion < aux.length()){
//            //insertamos un punto en la posición
//            aux.insert(posicion,'.');
//            //siguiente posición donde insertar
//            posicion+=4;
//        }
//        //le damos de nuevo la vuelta
//        aux.reverse();
//  
//        //el StringBuilder se pasa a String y se devuelve                                                         
//        return aux.toString();
//    }
	
	public static void main(String[] args) {
        String s = "cadena";
        long t1, t2;
        int n = 100000;
       
        System.out.println("----------------------------------------------------------------------");
        System.out.print("Concatenar " + n + " cadenas con String: "); // String
        t1 = System.currentTimeMillis();
        concatenar(s,n);
        t2 = System.currentTimeMillis();
        System.out.println((t2-t1) + " milisegundos");
        long tiempo1 = t2-t1;
        
        System.out.println("----------------------------------------------------------------------");
        System.out.print("Concatenar " + n + " cadenas con StringBuilder: "); // StringBuilder
        t1 = System.currentTimeMillis();
        concatenar1(s,n);
        t2 = System.currentTimeMillis();
        System.out.println((t2-t1) + " milisegundos");
        long tiempo2 = t2-t1;
       
        System.out.println("----------------------------------------------------------------------");
        System.out.print("Concatenar " + n + " cadenas con StringBuilder Optimizado: "); // StringBuilder optimizado                   
        t1 = System.currentTimeMillis();
        concatenar2(s,n);
        t2 = System.currentTimeMillis();
        System.out.println((t2-t1) + " milisegundos");
        long tiempo3 = t2-t1;
       
        System.out.println("----------------------------------------------------------------------");
        System.out.print("Concatenar "+ n + " cadenas con StringBuffer: "); // StringBuffer
        t1 = System.currentTimeMillis();
        concatenar3(s,n);
        t2 = System.currentTimeMillis();
        System.out.println((t2-t1) + " milisegundos");
        long tiempo4 = t2-t1;
        
        System.out.println("----------------------------------------------------------------------");
        System.out.print("Concatenar "+ n + " cadenas con StringBuffer Optimizado: "); // StringBuffer optimizado
        t1 = System.currentTimeMillis();
        concatenar4(s,n);
        t2 = System.currentTimeMillis();
        System.out.println((t2-t1) + " milisegundos");
        long tiempo5 = t2-t1;
        System.out.println("----------------------------------------------------------------------");
        
        // Comprobando qué clase o clases son las más rápidas
        if(tiempo1 < tiempo2 | tiempo1 < tiempo3 | tiempo1 <  tiempo4 | tiempo1 < tiempo5) {
        	System.out.println("La clase String es la más rápida");
        }
        else if(tiempo2 < tiempo1 | tiempo2 < tiempo3 | tiempo2 <  tiempo4 | tiempo2 < tiempo5) {
        	System.out.println("La clase StringBuilder es la más rápida");
        }
        else if(tiempo3 < tiempo1 | tiempo3 < tiempo2 | tiempo3 <  tiempo4 | tiempo3 < tiempo5) {
        	System.out.println("La clase StringBuilder optimizada es la más rápida");
        }
        else if(tiempo4 < tiempo1 | tiempo4 < tiempo2 | tiempo4 <  tiempo3 | tiempo4 < tiempo5) {
        	System.out.println("La clase StringBuffer es más rápida");
        }
        else if(tiempo5 < tiempo1 | tiempo5 < tiempo2 | tiempo5 <  tiempo3 | tiempo5 < tiempo4) {
        	System.out.println("La clase StringBuffer optimizada es la más rápida");
        }
        
    }
        
	
	// Método que concatena n cadenas usando la clase StringBuffer
	public static String concatenar3(String s, int n) {
		StringBuffer resultado = new StringBuffer(s);
		for(int i=1;i<n;i++) {
			resultado.append(s);
		}
		return resultado.toString();
	}
	
	// Método que concatena n cadenas usando la clase StringBuffer optimizado
		public static String concatenar4(String s, int n) {
			StringBuffer resultado = new StringBuffer(s.length() * n);
			for(int i=1;i<n;i++) {
				resultado.append(s);
			}
			return resultado.toString();
		}

    //método que concatena n cadenas usando la clase String
    public static String concatenar(String s, int n) {
        String resultado = s;
        for (int i = 1; i < n; i++) {
            resultado = resultado + s;
        }
        return resultado;
    }

    //método que concatena n cadenas usando la clase StringBuilder                                                
    public static String concatenar1(String s, int n) {
        StringBuilder resultado = new StringBuilder(s);
        for (int i = 1; i < n; i++) {
            resultado.append(s);
        }
        return resultado.toString();
    }

    //método optimizado que concatena n cadenas usando la clase StringBuilder
    //se crea un StringBuilder inicial con el tamaño total del String resultante                                  
    public static String concatenar2(String s, int n) {
        StringBuilder resultado = new StringBuilder(s.length() * n);
        for (int i = 0; i < n; i++) {
            resultado.append(s);
        }
        return resultado.toString();
    }
    
	
}
