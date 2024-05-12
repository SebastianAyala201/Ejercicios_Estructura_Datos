package ejercicio1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int opc;
        Scanner input = new Scanner(System.in);
        TiendaPostres tiendaMamita = new TiendaPostres();
        do{
            System.out.println("");
            System.out.println("--------MENU--------");
            System.out.println("1. Ingresar postre");
            System.out.println("2. Ingresar ingredientes");
            System.out.println("3. Mostrar postres");
            System.out.println("4. Mostrar ingredientes de postre");
            System.out.println("5. Eliminar un postre");
            System.out.println("6. Eliminar ingrediente de un postre");
            System.out.println("7. Salir");
            System.out.println("Ingrese una opcion: ");
            opc = input.nextInt();
            switch(opc){
                case 1:
                        tiendaMamita.insertarPostre();
                        break;
                case 2:
                        tiendaMamita.buscarPostre();
                        break;
                case 3:
                        tiendaMamita.mostrarPostres();
                        break;
                case 4:
                        tiendaMamita.mostrarIngredientes();
                        break;
                case 5:
                        tiendaMamita.eliminarPostre();
                case 6:
                        tiendaMamita.eliminarIngredPostre();
                case 7:
                        break; 
            }
        }while(opc!=7);
    }
}
