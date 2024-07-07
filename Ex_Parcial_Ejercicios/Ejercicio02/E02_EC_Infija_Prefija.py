import re

def dar_intro():
    print("\n")
    print("|--------------Transformador de expresiones--------------|")
    print("Este programa transforma una expresion infija a prefija:")

# Función para verificar si un token es un operador
def es_operador(token):
    operadores = {'+', '-', '*', '/', '^'}
    return token in operadores

# Función para transformar tokens de una expresión infija a posfija
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
    tokens = re.findall(r'\d+|\(|\)|\+|\-|\*|\/|\^', expresion)
    return tokens

# Función para evaluar una expresión prefija
def evaluar_expresion_prefija(expresion_prefija):
    pila = []

    for token in reversed(expresion_prefija):
        if token.isdigit():  # Si es un número, lo agregamos a la pila
            pila.append(int(token))
        else:  # Si es un operador, combinamos los dos operandos más cercanos
            operando1 = pila.pop()
            operando2 = pila.pop()
            if token == '+':
                resultado = operando1 + operando2
            elif token == '-':
                resultado = operando1 - operando2
            elif token == '*':
                resultado = operando1 * operando2
            elif token == '/':
                resultado = operando1 / operando2
            elif token == '^':
                resultado = operando1 ** operando2
            pila.append(resultado)

    return pila.pop()  # El resultado final estará en la cima de la pila

def main():
    dar_intro()
    ex_infija = input("Ingrese una expresión infija: ")
    tokens_infija = tokenize(ex_infija)
    resultado_prefijo = Transformer(tokens_infija)
    print("Expresión prefija:", ' '.join(resultado_prefijo))
    
    resultado_evaluado = evaluar_expresion_prefija(resultado_prefijo)
    print("Resultado de la expresión prefija evaluada:", resultado_evaluado)

if __name__ == "__main__":
    main()
