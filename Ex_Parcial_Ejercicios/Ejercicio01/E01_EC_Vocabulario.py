# Función para introducir el programa
def dar_intro():
    print("Este programa compara dos archivos de texto")
    print("e informa el numero de palabras en")
    print("común y el porcentaje de coincidencias\n")

# Función para obtener las palabras únicas de un texto
def get_palabras(file_name):
    with open(file_name, 'r') as file:
        palabras = set()
        for line in file:
            words = line.strip().lower().split()
            for word in words:
                word = ''.join(filter(str.isalpha, word))
                if word:
                    palabras.add(word)
    return palabras

# Función para obtener las coincidencias entre dos conjuntos de palabras
def get_coincidencias(palabras1, palabras2):
    coincidencias = palabras1.intersection(palabras2)
    return coincidencias

# Función para reportar los resultados
def reportar_resultados(palabras1, palabras2, coincidencias):
    total_palabras1 = len(palabras1)
    total_palabras2 = len(palabras2)
    total_coincidencias = len(coincidencias)

    print("Archivo #1 palabras =", total_palabras1)
    print("Archivo #2 palabras =", total_palabras2)
    print("Palabras en común =", total_coincidencias)

    pct1 = 100.0 * total_coincidencias / total_palabras1 if total_palabras1 > 0 else 0
    pct2 = 100.0 * total_coincidencias / total_palabras2 if total_palabras2 > 0 else 0

    print("% del archivo 1 en superposicion =", pct1)
    print("% del archivo 2 en superposicion =", pct2)

def main():
    dar_intro()

    # Importamos los archivos, es importante especificar la dirección de la ruta
    palabras1 = get_palabras("C:/Users/LENOVO/Documents/EstructuraDatos/Ex_Parcial_Ejercicios/Ejercicio01/archivo1.txt")
    palabras2 = get_palabras("C:/Users/LENOVO/Documents/EstructuraDatos/Ex_Parcial_Ejercicios/Ejercicio01/archivo2.txt")

    # Continuar solo si ambos textos tienen palabras
    if palabras1 and palabras2:  
        coincidencias = get_coincidencias(palabras1, palabras2)
        reportar_resultados(palabras1, palabras2, coincidencias)

if __name__ == "__main__":
    main()
