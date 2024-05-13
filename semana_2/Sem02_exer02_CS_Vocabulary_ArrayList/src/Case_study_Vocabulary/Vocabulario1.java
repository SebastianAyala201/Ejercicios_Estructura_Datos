package Case_study_Vocabulary;

/*

package tarea_semana2;

import java.util.*;
import java.io.*;

public class Vocabulario1 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in1 = new Scanner(new File("test1.txt"));
    Scanner in2 = new Scanner(new File("test2.txt"));
    ArrayList<String> lista1 = getPalabras(in1);
    ArrayList<String> lista2 = getPalabras(in2);
    System.out.println("lista1 = " + lista1);
    System.out.println("lista2 = " + lista2);
    ArrayList <String> comun = getCoincidencias (lista1, lista2);
    System.out.println("Coincidencias = " + comun);

    }
    public static ArrayList<String> getPalabras(Scanner input) {
      // lee todas las palabras y los ordena 
      ArrayList<String> palabras = new ArrayList<String>();
      while (input.hasNext()) {
        String next = input.next().toLowerCase();
        palabras.add(next);
        }
        Collections.sort(palabras);
        // agregue palabras únicas a la nueva lista y la devuelve 
        ArrayList<String> result = new ArrayList<String>();
        if (palabras.size() > 0) {
          result.add(palabras.get(0));
          for (int i = 1; i < palabras.size(); i++) {
            if (!palabras.get(i).equals(palabras.get(i-1))) {
              result.add(palabras.get(i));
            }
          }
        }
        return result;
    }
    
    public static ArrayList<String> getCoincidencias (ArrayList<String> list1, ArrayList<String> list2){
        // Creamos una lista para las coincidencias
        ArrayList<String> coincidencias = new ArrayList<String>();
        for (int i = 0; i < list1.size(); i++) {
            for(int j=0;j<list2.size();j++){
                if (list1.get(i).equals(list2.get(j))) {
                coincidencias.add(list1.get(i));
                i++;
            }
            }
          }
        return coincidencias;
    }
}

*/