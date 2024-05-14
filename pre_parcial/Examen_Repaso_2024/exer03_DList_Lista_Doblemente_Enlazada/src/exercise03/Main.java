package exercise03;

public class Main {
    public static void main(String[] args){
        DList listaDobEnlz = new DList();
        
        System.out.println("1. agregamos algunos valores a nuestra lista");
        
        listaDobEnlz.agregarFinal(1);
        listaDobEnlz.agregarFinal(1);
        listaDobEnlz.agregarInicio(1);
        listaDobEnlz.agregarInicio(0);
        listaDobEnlz.agregarFinal(1);
        listaDobEnlz.agregarFinal(0);
        listaDobEnlz.agregarFinal(0);
        
        System.out.println("");
        System.out.println("2. Imprimimos la lista por ambos recorridos: ");
        listaDobEnlz.recorrerListaInicioFin(); // Salida esperada: 0 1 1
        listaDobEnlz.recorrerListaFinInicio(); // Salida esperada: 1 1 0
        
        System.out.println("");
        System.out.println("3. Verificamos si la lista es binaria");
        listaDobEnlz.imprimirBinario(); // Salida esperada: La lista es binaria

        System.out.println("");
        
        System.out.println("");
        System.out.println("4. Agregamos un valor mas e imprimimos la lista actualizada");
        listaDobEnlz.agregarFinal(2); // Agregar un elemento no binario
        listaDobEnlz.recorrerListaInicioFin(); // Salida esperada: 0 1 1 2
        
        System.out.println("");
        System.out.println("Verificamos si la nueva lista es binaria");
        listaDobEnlz.imprimirBinario(); // Salida esperada: La lista no es binaria
    }
}
