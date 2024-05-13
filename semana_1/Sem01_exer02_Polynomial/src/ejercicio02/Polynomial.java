package ejercicio02;

import java.util.ArrayList;
import java.util.Scanner;

public class Polynomial implements iPolynomial{
    //Atributos
    private int numCoef;
    private ArrayList<Integer> coeficientes;
    Scanner input = new Scanner(System.in);
    
    //Constructor
    public Polynomial(){
        coeficientes = new ArrayList<>();
    }
    
    //Getters y Setters
    public int getNumCoef() {
        return numCoef;
    }
    public void setNumCoef(int numCoef) {
        this.numCoef = numCoef;
    }
    public ArrayList<Integer> getCoeficientes() {
        return coeficientes;
    }
    public void setCoeficientes(ArrayList<Integer> coeficientes) {
        this.coeficientes = coeficientes;
    }
    
    
    //Métodos
    //M1: Ingresar valores
    public void ingresarValores(){
        int cont=2,num;
        System.out.println("Ingrese el numero de coeficientes de tu polinomio: ");
        numCoef = input.nextInt();
        System.out.println("Coeficiente 1 (T.I) : ");
        num = input.nextInt();
        coeficientes.add(num);
        for(int i=1;i<numCoef;i++){
            System.out.println("Coeficiente "+ cont + ": ");
            num = input.nextInt();
            coeficientes.add(num);
            cont++;
        }
        System.out.println("Los valores han sido ingresados");
    }
    
    //M2: Mostrar Polinomio
    public void mostrarPolinomio(){
        for(int i=numCoef-1;i>0;i--){
            if(! (coeficientes.get(i) == 0)){
                System.out.print(coeficientes.get(i) + "x^" + i + " + ");
            }
        }
        System.out.println(coeficientes.get(0));
    }
    
    //M3: Retornar grado del polinomio
    @Override
    public int getDegree(){
        return numCoef-1;
    }
    
    //M4: Obtener coeficiente, dado el grado
    @Override
    public int getCoeficiente(int n) {
        return coeficientes.get(n);
    }

    //M5: Actualizar valor de coeficiente, dado el grado
    @Override
    public void setCoeficient(int n, int newValue) {
        coeficientes.set(n,newValue);
    }
    
    //M6: Evaluar polinomio dado un numero
    @Override
    public int getValue(int x) {
        int resul = 0;
        for(int i=0;i<numCoef;i++){
            resul += coeficientes.get(i) * Math.pow(x, i);
        }
        return resul;
    }
    
    //M7: Sumar dos polinomios
    @Override
    public Polynomial suma(Polynomial p) {
        Polynomial polsuma = new Polynomial();
        int coef1,coef2,sumaCoef;
        int maxNumCoef = Math.max(this.getNumCoef(), p.getNumCoef() ); // Obtener el grado máximo de los dos polinomios
        
        polsuma.setNumCoef(maxNumCoef);
        
        // Sumar coeficientes de ambos polinomios hasta el grado máximo
        for (int i = 0; i < polsuma.getNumCoef() ; i++) {
            
            if(i < this.getNumCoef() ){
                coef1 = this.getCoeficiente(i);
            }else{
                coef1 = 0;
            }
            
            if(i <  p.getNumCoef() ){
                coef2 = p.getCoeficiente(i);
            }else{
                coef2 = 0;
            }
            
            sumaCoef = coef1 + coef2; // Sumar coeficientes

            polsuma.getCoeficientes().add(sumaCoef); // Agregar coeficiente sumado al polinomio resultante
        }

        return polsuma;
    }





}