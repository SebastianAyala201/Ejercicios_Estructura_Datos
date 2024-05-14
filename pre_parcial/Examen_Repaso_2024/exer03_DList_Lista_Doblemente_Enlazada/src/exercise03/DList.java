package exercise03;

public class DList {
    //Atributos
    DNode header;
    DNode trailer;
    int size = 0;
    
    
    //Constructor
    public DList(){
        header = new DNode(null);
        trailer = new DNode(null);
        header.next = trailer;
        trailer.prev = header;
    }
    
    //Método: isBinary() -> Retorna una var booleana si elementos de la lista son binarios
    public boolean isBinary(){
        boolean p = true;
        DNode current = header.next; // Empezamos después del nodo ficticio
        while (current != trailer) { // Terminamos antes del nodo ficticio
            if(current.elem != 0 && current.elem !=1){
                p=false;
            }
            current = current.next;
        }
        return p;
    }
    
    // Método isEmpty() -> Verifica si la lista está vacía
    public boolean isEmpty(){
        return size == 0;
    }
    
    // Método para agregar un elemento al inicio de la lista
    public void agregarInicio(int elem) {
        DNode newNode = new DNode(elem);
        newNode.next = header.next;
        newNode.prev = header;
        header.next.prev = newNode;
        header.next = newNode;
        size++;
    }

    // Método para agregar un elemento al final de la lista
    public void agregarFinal(int elem) {
        DNode newNode = new DNode(elem);
        newNode.next = trailer;
        newNode.prev = trailer.prev;
        trailer.prev.next = newNode;
        trailer.prev = newNode;
        size++;
    }

    // Método para recorrer la lista desde el inicio hasta el final
    public void recorrerListaInicioFin() {
        DNode current = header.next; // Empezamos después del nodo ficticio
        System.out.print("Recorr. Inicio a Fin: ");
        while (current != trailer) { // Terminamos antes del nodo ficticio
            System.out.print(current.elem + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    // Método para recorrer la lista desde el fin hasta el inicio
    public void recorrerListaFinInicio() {
        DNode current = trailer.prev;// Empezamos después del nodo ficticio
        System.out.print("Recorr. Fin a Inicio: ");
        while (current != header) { // Terminamos antes del nodo ficticio
            System.out.print(current.elem + " ");
            current = current.prev;
        }
        System.out.println();
    }
    
    //Método para imprimir si la lista es binaria
    public void imprimirBinario(){
        if(isBinary()){
            System.out.println("La lista es binaria");
        }else{
            System.out.println("La lista no es binaria");
        }
    }
}
