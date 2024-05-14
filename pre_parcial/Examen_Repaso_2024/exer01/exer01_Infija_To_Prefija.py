import re

def dar_intro():
    print("\n")
    print("|--------------Transformador de expresiones--------------|")
    print("Este programa transforma una expresion infija a prefija:")

#Función para verificar si un token es un operador
def es_operador(token):
    operadores = {'+', '-', '*', '/', '^'}
    return token in operadores

#Función para transformar tokens de una expresión infija a posfija
def Transformer(tokens):
    epre = []
    pila = []

    prioExpr = {'^':4,'*':2,'/':2,'+':1,'-':1,'(':5}
    prioPila = {'^':3,'*':2,'/':2,'+':1,'-':1,'(':0,')': 0}

    for token in reversed(tokens):
        if token == ')':
            pila.append(token)
        elif token == '(' :
            while pila and pila[-1] != ')':
                epre.append(pila.pop())
            pila.pop()
        elif not(es_operador(token)):
            epre.append(token)
        else:
            while( pila and prioExpr[token] < prioPila[pila[-1]]):
                epre.append(pila.pop())
            pila.append(token)        

    while pila:
            epre.append(pila.pop())
    
    epre.reverse()
    return epre

# Función para tokenizar una expresión infija
def tokenize(expresion):
    tokens = re.findall(r'\d+|\(|\)|\+|\-|\*|\/', expresion)
    return tokens



def main():
    dar_intro()
    ex_infija = input("Ingrese una expresión infija: ")
    tokens_infija = tokenize(ex_infija)
    resultado = Transformer(tokens_infija)
    print("Expresión prefija: ",' '.join(resultado))


if __name__ == "__main__":
    main()