package com.rgg.hilos;

public class Hilo2 implements Runnable{

	@Override
	public void run() {
		
		for(int i=0; i<10; i++) {
			System.out.println("Hola soy el hilo 2");
		}
	}
}
