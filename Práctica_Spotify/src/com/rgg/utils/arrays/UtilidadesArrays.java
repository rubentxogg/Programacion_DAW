package com.rgg.utils.arrays;

public class UtilidadesArrays {

//	/**
//	 * @param array
//	 */
//	public static void imprimeArray(int[] array) {
//		for(int elemento: array) {
//			System.out.println(elemento);
//		}
//	}
//	
//	/**
//	 * @param array
//	 */
//	public static void imprimeArray(String[] array) {
//		for(String elemento: array) {
//			System.out.println(elemento);
//		}
//	}
//	
//	/**
//	 * @param array
//	 */
//	public static void imprimeArray(Double[] array) {
//		for(Double elemento: array) {
//			System.out.println(elemento);
//		}
//	}
//	
	/**
	 * Imprime un array de cualquier tipo
	 * @param <E>
	 * @param array
	 */
	public <E> void imprimeArray(E[] array) {
		for(E elemento: array) {
			System.out.println(elemento);
		}
	}
}
