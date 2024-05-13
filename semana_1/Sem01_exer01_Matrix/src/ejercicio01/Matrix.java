package ejercicio01;
import java.util.Scanner;
import java.util.Random;

public class Matrix {
    private int[][] arreglo;
    private int m;
    private int n;
    
    Scanner input = new Scanner(System.in);
    //Constructor
    public Matrix() {    
    }
    
    //Getters and Setters

    public int[][] getArreglo() {
        return arreglo;
    }
    

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }
    

    //M1: Constructor de matriz de ceros
    public void constructorMatrix() {
        System.out.println("Ingrese el numero de filas: ");
        m = input.nextInt();
        System.out.println("Ingrese el numero de columnas: ");
        n = input.nextInt();
        arreglo = new int[m][n];
        System.out.println("La matriz ha sido creada");
    }
    //M2: Inicializar valores aleatorios en una matriz  
  public void matrizaleatoria(){
      Random rand = new Random();
      for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
              arreglo[i][j]= rand.nextInt(11);
          }
      }
  }
    
    //M3: show() -> Mostrar valores de una matriz
    public void show(){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(arreglo[i][j]+"\t");
            }
            System.out.println("");
        }
    }
    
    //M4: show() -> Mostrar valores de una matriz
    public void transpose(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arreglo[j][i]+"\t");
            }
            System.out.println("");
        }
    }
    
    //M5: plus() -> Suma de matrices
    public void plus(Matrix matriz_suma){
        System.out.println("Completa las dimensiones de la nueva matriz generada");
        matriz_suma.constructorMatrix();
        matriz_suma.matrizaleatoria();
        if(n==matriz_suma.getN() && m==matriz_suma.getM()){
            System.out.println("Matriz 1:");
            show();
            System.out.println("Matriz 2");
            matriz_suma.show();
            int[][] arreglo_dos = matriz_suma.getArreglo();
            System.out.println("La suma es: ");
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    System.out.print(arreglo[i][j]+ arreglo_dos[i][j]+ "\t");
                }
                System.out.println("");
            }
        }else{
            System.out.println("Error,las matrices tienen dimensiones diferentes");    
        }
    }
    
    //M6: minus() -> Diferencia de matrices
    public void minus(Matrix matriz_dif){
        System.out.println("Completa las dimensiones de la nueva matriz generada");
        matriz_dif.constructorMatrix();
        matriz_dif.matrizaleatoria();
        if(n==matriz_dif.getN() && m==matriz_dif.getM()){
            System.out.println("Matriz 1:");
            show();
            System.out.println("Matriz 2");
            matriz_dif.show();
            int[][] arreglo_dos = matriz_dif.getArreglo();
            System.out.println("La diferencia es: ");
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    System.out.print(arreglo[i][j]- arreglo_dos[i][j]+ "\t");
                }
                System.out.println("");
            }
        }else{
            System.out.println("Error,las matrices tienen dimensiones diferentes");    
        }
    }
    
    //M7: equal() -> Comparar si dos matrices son iguales
    public void equal(Matrix matriz_dif){
        boolean p=true;
        System.out.println("Completa las dimensiones de la nueva matriz generada");
        matriz_dif.constructorMatrix();
        if(n==matriz_dif.getN() && m==matriz_dif.getM()){
            System.out.println("Matriz 1:");
            show();
            System.out.println("Matriz 2");
            matriz_dif.show();
            int[][] arreglo_dos = matriz_dif.getArreglo();
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(arreglo[i][j] != arreglo_dos[i][j]){
                        p=false;
                    }
                }
            }
            if(p){
                System.out.println("La matriz 1 es igual a la matriz 2");
            }
            else{
                System.out.println("Las matrices son diferentes");
            }
        }else{
            System.out.println("Error,las matrices tienen dimensiones diferentes");    
        }
    }
    
    //M8 matrizIdentidad() -> Devuelve la matriz identidad
    
    public void matrizIdentidad(){
        if(n==m){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arreglo[i][j]=0;
                    if(i==j){
                        arreglo[i][j]=1;
                    }
                }
            }
            show();
        }else{
            System.out.println("No se puede generar la matriz identidad, ya que filas != columnas");
        }
    }
}
