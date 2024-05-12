package ejercicio1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class TiendaPostres {
    //Atributos
    private ArrayList<Postre> postres;
    //Constructor
    public TiendaPostres() {
        postres = new ArrayList<>();
    }
    String nombre;
    Scanner input = new Scanner(System.in);
    
    //OrdenarDatos
    public void ordenarDatos(){
        
    }
    //InsertarPostre
    public void insertarPostre(){
        System.out.println("Ingrese el nombre del postre a insertar: ");
        nombre = input.nextLine();
        postres.add(new Postre(nombre));
        Collections.sort(postres, Comparator.comparing(Postre::getNombre));
    }
    //Mostrar postres
    public void mostrarPostres(){
        System.out.println("");
        System.out.println("Postres");
        for(Postre postre : postres){
            System.out.println("-"+postre.getNombre());
        }
    }
    //Buscar postre para insertar ingredientes
    public void buscarPostre(){
        boolean encontrado = false;
        System.out.println("Ingrese el nombre del postre: ");
        nombre = input.nextLine();
        for(Postre postre : postres){
            if(postre.getNombre().equals(nombre)){
                encontrado = true;
                insertarIngrediente(postre);
                continuarAgregandoIngredientes(postre);
            }
        }
        if(encontrado==false){
            System.out.println("Su postre no ha sido encontrado");
        }
    }
    
    //Continuar insertando ingredietes
    public void continuarAgregandoIngredientes(Postre postre){
        String answ;
        System.out.println("Deseas agregar otro ingrediente (y/n)");
        answ = input.nextLine();
        if(answ.equals("y")){
            insertarIngrediente(postre);
            continuarAgregandoIngredientes(postre);
        }
    }
    
    //Insertar ingrediente
    public void insertarIngrediente(Postre postre){
        System.out.println("Ingrese el nombre del ingrediente a insertar: ");
        nombre = input.nextLine();
        postre.getIngredientes().add(nombre);
        Collections.sort(postre.getIngredientes());
    }
    
    //Mostrar ingredientes
    public void mostrarIngredientes(){
        boolean encontrado = false;
        System.out.println("Ingrese el nombre del postre: ");
        nombre = input.nextLine();
        for(Postre postre : postres){
            if(postre.getNombre().equals(nombre)){
                encontrado = true;
                System.out.println("Ingredientes del postre " + postre.getNombre() + ":");
                for(String ingrediente : postre.getIngredientes()){
                    System.out.println("- " + ingrediente);
                }
                
            }
        }
        if(encontrado==false){
            System.out.println("Su postre no ha sido encontrado");
        }
    }
    
    //Eliminar un postre
    public void eliminarPostre(){
        boolean encontrado = false;
        System.out.println("Ingrese el nombre del postre a eliminar: ");
        nombre = input.nextLine();
        for(Postre postre : postres){
            if(postre.getNombre().equals(nombre)){
                encontrado = true;
                postres.remove(postre);
                break;
            }
        }
        if(encontrado==false){
            System.out.println("Su postre no ha sido encontrado");
        }
    }
    
    public void eliminarIngredPostre(){
        boolean encontrado = false;
        System.out.println("Ingrese el nombre del postre: ");
        nombre = input.nextLine();
        for(Postre postre : postres){
            if(postre.getNombre().equals(nombre)){
                encontrado = true;
                System.out.println("Ingrese el ingrediente de " + postre.getNombre() + " a eliminar: ");
                nombre = input.nextLine();
                postre.getIngredientes().remove(nombre);
            }
        }
        if(!encontrado){
            System.out.println("Su postre no ha sido encontrado");
        }
    }
}
