# Imprime la introducción del programa
def dar_intro():
    print("\n")
    print("|--------------Estudio de caso: VOCABULARIO--------------|")
    print("Este programa compara dos archivos de texto y analiza:")
    print("     -Numero de palabras por cada texto")
    print("     -Numero de coincidencias entre ambos textos")
    print("     -Porcentaje de coincidencias entre cada texto")

# Retorna el numero de palabras que hay por cada archivo
def get_palabras(file_name):
    # Abre el archivo y cuenta las palabras
    with open(file_name, 'r') as file:
        palabras = {}
        for line in file:
            # Convierte a minúsculas y separa las palabras
            words = line.strip().lower().split()
            for word in words:
                # Filtra caracteres no alfabéticos
                word = ''.join(filter(str.isalpha, word))
                if word:
                    # Cuenta la palabra
                    palabras[word] = palabras.get(word, 0) + 1
    return palabras

# Retorna el numero de coincidencias que hay entre las listas de palabras únicas de dos archivos
def get_coincidencias(palabras1, palabras2):
    coincidencias = {}
    for word in palabras1:
        if word in palabras2:
            # Toma la menor cantidad de apariciones de cada palabra común
            coincidencias[word] = min(palabras1[word], palabras2[word])
    return coincidencias

# Imprime un reporte con los resultados encontrados 
def reportar_resultados(palabras1, palabras2, coincidencias):
    # Calcula el total de palabras en cada texto
    total_palabras1 = sum(palabras1.values())
    total_palabras2 = sum(palabras2.values())
    total_coincidencias = sum(coincidencias.values())

    # Imprime los resultados de los conteos
    print("Archivo #1 palabras =", total_palabras1)
    print("Archivo #2 palabras =", total_palabras2)
    print("Palabras en común =", total_coincidencias)

    # Calcula y imprime los porcentajes de coincidencias
    pct1 = 100.0 * total_coincidencias / total_palabras1 if total_palabras1 > 0 else 0
    pct2 = 100.0 * total_coincidencias / total_palabras2 if total_palabras2 > 0 else 0

    print("% del archivo 1 en superposicion =", pct1)
    print("% del archivo 2 en superposicion =", pct2)

# Muestra la introducción y procesa los archivos de texto
def main():
    dar_intro()
    palabras1 = get_palabras("test1.txt")
    palabras2 = get_palabras("test2.txt")

    coincidencias = get_coincidencias(palabras1, palabras2)

    reportar_resultados(palabras1, palabras2, coincidencias)

if __name__ == "__main__":
    main()
