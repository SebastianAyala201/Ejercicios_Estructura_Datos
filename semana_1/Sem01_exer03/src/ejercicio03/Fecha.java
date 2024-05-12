package ejercicio03;

public interface Fecha {
    int day();
    int month();
    String monthName();
    int year();
    int numDays(Date otherDate);
    boolean isLeapYear();
    int compareTo(Date otherDate);
    String str();

}
