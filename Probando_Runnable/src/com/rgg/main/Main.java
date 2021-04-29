package com.rgg.main;

import com.rgg.hilos.Hilo1;
import com.rgg.hilos.Hilo2;
import com.rgg.hilos.Hilo3;
import com.rgg.hilos.Hilo4;

public class Main {

	public static void main(String[] args) {
		Hilo1 h1 = new Hilo1();
		Hilo2 h2 = new Hilo2();
		
		new Thread(h1).start();
		new Thread(h2).start();
		
		Hilo3 h3 = new Hilo3();
		Hilo4 h4 = new Hilo4();
		
		h3.start();
		h4.start();
	}
}
