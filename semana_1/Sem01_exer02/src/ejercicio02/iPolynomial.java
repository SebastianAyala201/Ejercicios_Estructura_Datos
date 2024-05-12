package ejercicio02;

public interface iPolynomial {
    public int getDegree();
    public int getCoeficiente(int n);
    public void setCoeficient(int n, int newValue);
    public int getValue(int x);
    public Polynomial suma(Polynomial p);
}
