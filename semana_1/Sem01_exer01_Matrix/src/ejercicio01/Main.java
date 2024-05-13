package ejercicio01;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Matrix matriz1 = new Matrix();
        Matrix matriz2 = new Matrix();
        
        int opcion;
        do{
            System.out.println("|------MENU------");
            System.out.println("1.- Crear matriz de ceros");
            System.out.println("2.- LLenar la matriz con numeros aleatorios");
            System.out.println("3.- Mostrar la matriz");
            System.out.println("4.- Mostrar la matriz transpuesta");
            System.out.println("5.- Sumar matriz con otra matriz");
            System.out.println("6.- Restar  matriz con otra matriz");
            System.out.println("7.- Comprobar igualdad de las matrices");
            System.out.println("8.- Generar matriz identidad");
            System.out.println("9.- Salir");
            System.out.println("Ingrese la opcion: ");
            opcion = input.nextInt();
            switch(opcion){
                case 1:
                    matriz1.constructorMatrix();
                    break;
                case 2:
                    matriz1.matrizaleatoria();
                    break;
                case 3:
                    matriz1.show();
                    break;
                case 4:
                    matriz1.transpose();
                    break;
                case 5:
                    matriz1.plus(matriz2);
                    break;    
                case 6:
                    matriz1.minus(matriz2);
                    break;
                case 7:
                    matriz1.equal(matriz2);
                    break;
                case 8:
                    matriz1.matrizIdentidad();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                    
            }
        }while(opcion!=9);
        input.close();
    }
    
}
