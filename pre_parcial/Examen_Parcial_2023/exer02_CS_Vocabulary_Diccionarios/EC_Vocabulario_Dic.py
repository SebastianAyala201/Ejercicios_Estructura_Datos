def dar_intro():
    print("\n")
    print("|--------------Estudio de caso: VOCABULARIO--------------|")
    print("Este programa compara dos archivos de texto y analiza:")
    print("     -Numero de palabras por cada texto")
    print("     -Numero de coincidencias entre ambos textos")
    print("     -Porcentaje de coincidencias entre cada texto")

def get_palabras(file_name):
    with open(file_name, 'r') as file:
        palabras = {}
        for line in file:
            words = line.strip().lower().split()
            for word in words:
                word = ''.join(filter(str.isalpha, word))
                if word:
                    palabras[word] = palabras.get(word, 0) + 1
    return palabras

def get_coincidencias(palabras1, palabras2):
    coincidencias = {}
    for word in palabras1:
        if word in palabras2:
            coincidencias[word] = min(palabras1[word], palabras2[word])
    return coincidencias

def reportar_resultados(palabras1, palabras2, coincidencias):
    total_palabras1 = sum(palabras1.values())
    total_palabras2 = sum(palabras2.values())
    total_coincidencias = sum(coincidencias.values())

    print("Archivo #1 palabras =", total_palabras1)
    print("Archivo #2 palabras =", total_palabras2)
    print("Palabras en común =", total_coincidencias)

    pct1 = 100.0 * total_coincidencias / total_palabras1 if total_palabras1 > 0 else 0
    pct2 = 100.0 * total_coincidencias / total_palabras2 if total_palabras2 > 0 else 0

    print("% del archivo 1 en superposicion =", pct1)
    print("% del archivo 2 en superposicion =", pct2)

def main():
    dar_intro()
    print(get_palabras("test1.txt"))

if __name__ == "__main__":
    main()
