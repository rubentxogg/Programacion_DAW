package com.productorconsumidor.main;

import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import com.github.javafaker.Faker;
import com.productorconsumidor.constantes.Constantes;
import com.productorconsumidor.tipos.Persona;


public class Main {

	public static void main(String args[]) throws InterruptedException {

		PC pc = new PC();

		// Creamos el hilo del productor
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
		
					try {
						pc.productor();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consumidor();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Comienzan ambos hilos (primero el consumidor, para que se vea cómo se espera)
		t2.start();
		t1.start();

	}

	public static class PC {
		Queue<Persona> colaPersonas = new PriorityQueue<Persona>();

		public void consumidor() throws InterruptedException {

			while (true) {
				synchronized (this) {

					// Si la cola está vacía se espera
					if (colaPersonas.size() == 0) {
						System.out.println(">>El consumidor se espera a que la cola tenga datos ......");
						//Suspende el  hilo hasta que algún otro hilo lo vuelva a invocar con el método notify()
						wait();
					}

					// retira a primera persona por prioridad
					Persona p = colaPersonas.poll();

					System.out.println(">>El consumidor ha consumido la persona : " + p);
					System.out.println(">>Estado de la cola: ");
					
					imprimeCola(colaPersonas);


					notify();
					// Duerme 10 segundos
					Thread.sleep(Constantes.TIEMPO_DORMIDO_CONSUMIDOR);
				

				}
			}
		}

		public void productor() throws InterruptedException {
			while (true) {
				synchronized (this) {

					if (colaPersonas.size() > Constantes.TAMANHO_COLA_MAXIMA_WAIT) {
						System.out.println("**El productor se espera a que la cola tenga menos de ......" + Constantes.TAMANHO_COLA_MAXIMA_WAIT);
						wait();
					}
					Faker faker = new Faker(new Locale("es"));				
					Persona p = new Persona( faker.lordOfTheRings().character(), new Random().nextInt(Constantes.MAXIMO+1));
					colaPersonas.add(p);

					System.out.println("**El productor  ha producido la persona : " + p);
					System.out.println("**Estado de la cola: ");

					imprimeCola(colaPersonas);

			

					notify();
					// duerme 2 segundos
					Thread.sleep(Constantes.TIEMPO_DORMIDO_PRODUCTOR);

				}
			}

		}
		
		private  void imprimeCola(Queue<Persona> colaPersonas) {
			for (Persona p : colaPersonas) {
				System.out.println(p.toString());
			}
		}
	}
}
