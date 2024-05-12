package ejercicio1;
import java.util.Scanner;
import java.util.ArrayList;


public class Postre{
    private String nombre;
    private ArrayList<String> ingredientes;
    
    //Constructor
    public Postre(String nombre) {
        this.nombre = nombre;
        this.ingredientes = new ArrayList<>();
    }
    
    
    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    //
}
