package ejercicio02;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();
        Polynomial pol3 = new Polynomial();
        
        int opcion;
        
        do{
            System.out.println("");
            System.out.println("------MENU------");
            System.out.println("1. Ingresar valores de polinomio");
            System.out.println("2. Mostrar polinomio");
            System.out.println("3. Mostrar grado de polinomio");
            System.out.println("4. Mostrar coeficiente dado el grado");
            System.out.println("5. Cambiar coeficiente dado el grado");
            System.out.println("6. Evaluar polinomio dado un numero");
            System.out.println("7. Sumar dos polinomios");
            System.out.println("8. Salir");
            System.out.println("Ingrese la opcion: ");
            opcion = input.nextInt();
            
            switch(opcion){
                case 1:
                    pol1.ingresarValores();
                    break;
                case 2:
                    pol1.mostrarPolinomio();
                    break;
                case 3:
                    System.out.println("El grado del polinomio es: " + pol1.getDegree() );
                    break;
                case 4:
                    int g;
                    System.out.println("Ingrese el grado: ");
                    g = input.nextInt();
                    System.out.println("El coeficiente del termino de grado " + g + " es " + pol1.getCoeficiente(g));
                    break;
                case 5:
                    int v;
                    System.out.println("Ingrese el grado: ");
                    g = input.nextInt();
                    System.out.println("Ingrese el nuevo valor que desea cambiar: ");
                    v = input.nextInt();
                    pol1.setCoeficient(g, v);
                    System.out.println("El coeficiente de grado " + g + " ha sido actualizado a " + v);
                    break;
                case 6:
                    int n;
                    System.out.println("Ingrese un numero: ");
                    n = input.nextInt();
                    System.out.println("El polinomio evaludo en " + n + " es: " + pol1.getValue(n));
                    break;
                case 7:
                    System.out.println("Ingresaremos valores del polinomio 2");
                    pol2.ingresarValores();
                    System.out.println("Polinomio 1:");
                    pol1.mostrarPolinomio();
                    System.out.println("Polinomio 2:");
                    pol2.mostrarPolinomio();
                    System.out.println("Suma de polinomios: ");
                    pol3 = pol1.suma(pol2);
                    pol3.mostrarPolinomio();
                    break;
                case 8:
                    System.out.println("Saliendo el programa");
                    break;
            } 
        }while(opcion!=8);
    }
}
