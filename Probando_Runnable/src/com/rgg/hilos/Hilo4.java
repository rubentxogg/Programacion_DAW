package com.rgg.hilos;

public class Hilo4 extends Thread{
	
	@Override
	public void run() {
		
		for(int i=0; i<10; i++) {
			System.out.println("Hola soy el hilo 4");
		}
	}
}
