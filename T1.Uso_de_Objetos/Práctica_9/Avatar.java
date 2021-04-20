/**
 * Pr�ctica 9 de programaci�n
 */

/**
 * @author Rubentxo
 *
 */
import java.util.Scanner;

class Avatar {
	
	// Atributos
	private int mana = 10;
	private static int contadorAvatares = 0;
	private String name;
	
	// M�todo que acepta el nombre del avatar
		public Avatar(String name) {
			this.name = name;
			contadorAvatares++;
		}

		/**
		 * @return Devuelve mana
		 */
		public int getMana() {
			return mana;
		}

		/**
		 * @param mana Cambia el valor de mana
		 */
		public void setMana(int mana) {
			this.mana = mana;
		}

		/**
		 * @return Devuelve name
		 */
		public String getName() {
			return name;
		}
		
		/**
		 *  M�todo restarMana
		 * @return Devuelve 3, 2 o 1 en funci�n del mana que tengamos
		 */
		public int restarMana() {
			mana--;
			
			if(mana > 5) {
				return 3;
			}
			else if(mana > 1 && mana < 5) {
				return 2;
			}
			else {
				return 1;
			}
		}
		
		/**
		 * M�todo restarMana que resta el valor que le pasamos a mana
		 * @param valor Guarda un valor
		 * @return Devuelve valor
		 */
		public int restarMana(int valor) {
			mana -= valor;
			
			if(mana > 5) {
				return 3;
			}
			else if(mana > 1 && mana < 5) {
				return 2;
			}
			else {
				return 1;
			}
		}
		
		/**
		 *  
		 * @return Devuelve contadorAvatares
		 */
		public static int contarAvatares() {
			return contadorAvatares;
		}

		@Override
		public String toString() {
			return " \nMana: "+mana+"\nname: "+name;
		}
		
}

class Programa{
	
	// M�todo main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca el nombre del primer avatar: ");
		String avatar1 = sc.nextLine();
		
		System.out.print("Introduzca el nombre del segundo avatar: ");
		String avatar2 = sc.nextLine();
		
		Avatar av1 = new Avatar(avatar1);
		Avatar av2 = new Avatar(avatar2);
		
		while(true) {
			System.out.println("\n1. Mostrar n�mero de avatares \n2. Quitar man� \n3. Mostrar datos \n4. Salir");
			
			int dato = sc.nextInt();
			
			if(dato == 1) {
				System.out.println(Avatar.contarAvatares());
			}
			else if(dato == 2) {
				System.out.println("�Qu� avatar quiere modificar? "+("1."+av1.getName()+" 2."+av2.getName()));
				
				dato = sc.nextInt();
				
				if(dato == 1) {
					System.out.println("�Qu� opci�n desea? \n1.Restar una unidad de man� \n2.Restar un valor espec�fico");
					
					int opc = sc.nextInt();
					
					if(opc == 1) {
						av1.restarMana();
						System.out.println("El man� actual es: "+av1.getMana());
					}
					else if(opc == 2) {
						System.out.println("�Qu� valor desea restar?");
						int valor = sc.nextInt();
						av1.restarMana(valor);
						System.out.println("El man� actual es: "+av1.getMana());
					}
				}
				else if(dato == 2) {
					System.out.println("�Qu� opci�n desea? \n1.Restar una unidad de man� \n2.Restar un valor espec�fico");
					
					int opc = sc.nextInt();
					
					if(opc == 1) {
						av2.restarMana();
						System.out.println("El man� actual es: "+av2.getMana());
					}
					else if(opc == 2) {
						System.out.println("�Qu� valor desea restar?");
						int valor = sc.nextInt();
						av2.restarMana(valor);
						System.out.println("El man� actual es: "+av2.getMana());
					}
				}
				else {
					System.out.println("Ha introducido una opci�n incorrecta, vuelva a intentarlo");
				}
			}
			else if(dato == 4) {
				break;
			}
			else if(dato == 3) {
				System.out.println("�De qu� avatar desea ver los datos? \n"+"1."+av1.getName()+" 2."+av2.getName());
				int opc = sc.nextInt();
				if(opc == 1) {
					System.out.println("**Datos del primer avatar**");
					System.out.println(av1.toString());
				}
				else if(opc == 2) {
					System.out.println("**Datos del segundo avatar**");
					System.out.println(av2.toString());
				}
				else {
					System.out.println("Ha introducido una opci�n incorrecta, vuelva a intentarlo");
				}
			}
			else { 
				System.out.println("Ha introducido una opci�n incorrecta, vuelva a intentarlo");
			}
		
		} 
		sc.close();
	}
	
}


