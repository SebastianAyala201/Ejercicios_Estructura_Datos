package ejercicio03;

public class Date implements Fecha{
    //Atributos
    private int day;
    private String month;
    private int year;
    //Constructor
    public Date(int day, String month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    //Métodos
    //M1: day()
    public int day() {
        return day;
    }
    //M2: month()
    public int month() {
        int month_num=0;
        if(month == "Enero"){
            month_num = 1;
        } else if(month == "Febrero"){
            month_num = 2;
        } else if(month == "Marzo"){
            month_num = 3;
        } else if(month == "Abril"){
            month_num = 4;
        } else if(month == "Mayo"){
            month_num = 5;
        } else if(month == "Junio"){
            month_num = 6;
        } else if(month == "Julio"){
            month_num = 7;
        } else if(month == "Agosto"){
            month_num = 8;
        } else if(month == "Septiembre"){
            month_num = 9;
        } else if(month == "Octubre"){
            month_num = 10;
        } else if(month == "Noviembre"){
            month_num = 11;
        } else if(month == "Diciembre"){
            month_num = 12;
        }
        return month_num;
    }
    //M3: monthName()
    public String monthName() {
        return month;
    }
    //M4: year()
    public int year() {
        return year;
    }
    //M5:numDays(otherDate)
    public int numDays(Date otherDate){
        int numday1,numday2,dif;
        dif = (Math.abs(year-otherDate.year)*360 + Math.abs(month()-otherDate.month())*30 +  Math.abs(day - otherDate.day));
        return dif;
    }
    //M6: isLeapYear():
    public boolean isLeapYear(){
        boolean anio_bis = false;
        if((year%4==0 && !(year%100==0)) || year%400==0){
            anio_bis = true;
        }
        return anio_bis;
    }
    //M7:compareTo(otherDate):
    public int compareTo(Date otherDate){
        int comp;
        if(numDays(otherDate) == 0){
            comp = 0;
        }
        else if( ((year-otherDate.year)*360 + (month()-otherDate.month())*30 + (day - otherDate.day)) > 0 ){
            comp = 1;
        }else{
            comp = -1;
        }
        return comp;
    }
    //M8: str()
    public String str(){
        String fecha_format;
        fecha_format =day+"/"+month()+"/"+year;
        return fecha_format;
    }
}
