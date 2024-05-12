package ejercicio03;

public class Main {
    public static void main(String[] args){
        Date day1 = new Date(25,"Mayo",2004);
        Date day2 = new Date(25,"Diciembre",2004);
        
        System.out.println("Dia: "+ day1.day());
        System.out.println("Mes: "+ day1.month());
        System.out.println("Mes (Nombre) : "+ day1.monthName());
        System.out.println("Anio : "+ day1.year());
        System.out.println("El anio es bisiesto: " + day1.isLeapYear());
        System.out.println("La diferencia de dias entre: \n" + day1.str() 
                + "\n"+ day2.str() +"\nes: " + day1.numDays(day2));
        if(day1.compareTo(day2)==0){
            System.out.println("Las fechas son iguales");
        }
        else if(day1.compareTo(day2)==1){
            System.out.println("La fecha: " + day1.str() + " es posterior a " + day2.str());
        }
        else{
            System.out.println("La fecha: " + day1.str() + " es anterior a " + day2.str());
        }
        System.out.println("La fecha en formato es: " + day1.str());
    }
    
}
