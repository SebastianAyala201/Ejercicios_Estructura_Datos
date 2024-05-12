class Postre:
    def __init__(self, nombre):
        self.nombre = nombre
        self.ingredientes = []

class TiendaPostres:
    def __init__(self):
        self.postres = []

    def ordenar_datos(self):
        pass

    def insertar_postre(self):
        nombre = input("Ingrese el nombre del postre a insertar: ")
        postre = Postre(nombre)
        self.postres.append(postre)
        self.postres.sort(key=lambda x: x.nombre)

    def mostrar_postres(self):
        print("\nPostres")
        for postre in self.postres:
            print("-", postre.nombre)

    def buscar_postre(self):
        encontrado = False
        nombre = input("Ingrese el nombre del postre: ")
        for postre in self.postres:
            if postre.nombre == nombre:
                encontrado = True
                self.insertar_ingrediente(postre)
                self.continuar_agregando_ingredientes(postre)
        if not encontrado:
            print("Su postre no ha sido encontrado")

    def continuar_agregando_ingredientes(self, postre):
        answ = input("Deseas agregar otro ingrediente (y/n): ")
        if answ.lower() == "y":
            self.insertar_ingrediente(postre)
            self.continuar_agregando_ingredientes(postre)

    def insertar_ingrediente(self, postre):
        nombre = input("Ingrese el nombre del ingrediente a insertar: ")
        postre.ingredientes.append(nombre)
        postre.ingredientes.sort()

    def mostrar_ingredientes(self):
        encontrado = False
        nombre = input("Ingrese el nombre del postre: ")
        for postre in self.postres:
            if postre.nombre == nombre:
                encontrado = True
                print("Ingredientes del postre", postre.nombre + ":")
                for ingrediente in postre.ingredientes:
                    print("-", ingrediente)
        if not encontrado:
            print("Su postre no ha sido encontrado")

    def eliminar_postre(self):
        encontrado = False
        nombre = input("Ingrese el nombre del postre a eliminar: ")
        for postre in self.postres:
            if postre.nombre == nombre:
                encontrado = True
                self.postres.remove(postre)
                break
        if not encontrado:
            print("Su postre no ha sido encontrado")

    def eliminar_ingred_postre(self):
        encontrado = False
        nombre = input("Ingrese el nombre del postre: ")
        for postre in self.postres:
            if postre.nombre == nombre:
                encontrado = True
                ingrediente = input("Ingrese el ingrediente de " + postre.nombre + " a eliminar: ")
                if ingrediente in postre.ingredientes:
                    postre.ingredientes.remove(ingrediente)
                else:
                    print("El ingrediente especificado no está en la lista de ingredientes.")
        if not encontrado:
            print("Su postre no ha sido encontrado")

def main():
    tienda_mamita = TiendaPostres()
    while True:
        print("\n--------MENU--------")
        print("1. Ingresar postre")
        print("2. Ingresar ingredientes")
        print("3. Mostrar postres")
        print("4. Mostrar ingredientes de postre")
        print("5. Eliminar un postre")
        print("6. Eliminar ingrediente de un postre")
        print("7. Salir")
        opc = input("Ingrese una opcion: ")
        if opc == "1":
            tienda_mamita.insertar_postre()
        elif opc == "2":
            tienda_mamita.buscar_postre()
        elif opc == "3":
            tienda_mamita.mostrar_postres()
        elif opc == "4":
            tienda_mamita.mostrar_ingredientes()
        elif opc == "5":
            tienda_mamita.eliminar_postre()
        elif opc == "6":
            tienda_mamita.eliminar_ingred_postre()
        elif opc == "7":
            break
        else:
            print("Opción no válida, por favor ingrese un número del 1 al 7.")

if __name__ == "__main__":
    main()
