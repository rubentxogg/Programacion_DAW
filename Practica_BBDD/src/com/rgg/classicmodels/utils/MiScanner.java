package com.rgg.classicmodels.utils;

import java.util.Scanner;

public class MiScanner {
	private static Scanner sc;
	
	/**
	 * @return
	 */
	public static Scanner getInstance() {
		if (sc == null) {
			sc = new Scanner (System.in);
		}
		return sc;
	}
}
