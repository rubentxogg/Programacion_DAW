package com.rgg.hilos;

public class Hilo1 implements Runnable{

	@Override
	public void run() {
		
		for(int i=0; i<10; i++) {
			System.out.println("Hola soy el hilo 1");
		}
	}

}
