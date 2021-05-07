package com.rgg.hilos;

public class Hilo3 extends Thread{

	@Override
	public void run() {
		
		for(int i=0; i<10; i++) {
			System.out.println("Hola soy el hilo 3");
		}
	}
}
