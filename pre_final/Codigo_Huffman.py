import heapq

class Node:
    def __init__(self, char, freq):
        self.char = char
        self.freq = freq
        self.left = None
        self.right = None

    # Definir operadores de comparación para usar en el heap
    def __lt__(self, other):
        return self.freq < other.freq

def build_huffman_tree(frequencies):
    # Crear un min-heap con los nodos iniciales
    heap = [Node(char, freq) for char, freq in frequencies.items()]
    heapq.heapify(heap)
    
    # Iterar hasta que el heap contenga un solo nodo
    while len(heap) > 1:
        # Extraer los dos nodos con la menor frecuencia
        left = heapq.heappop(heap)
        right = heapq.heappop(heap)
        
        # Crear un nuevo nodo combinado
        merged = Node(None, left.freq + right.freq)
        merged.left = left
        merged.right = right
        
        # Añadir el nuevo nodo al heap
        heapq.heappush(heap, merged)
    
    # El nodo final es la raíz del árbol de Huffman
    return heap[0]

def print_huffman_tree(node, prefix=""):
    if node:
        if node.char is not None:
            print(f"'{node.char}': {prefix}")
        print_huffman_tree(node.left, prefix + "0")
        print_huffman_tree(node.right, prefix + "1")

# Definir la tabla de frecuencias
frequencies = {
    'A': 10,
    'B': 10,
    'C': 30,
    'D': 25,
    'E': 5,
    'F': 5,
    'G': 10,
    'T': 5
}

# Construir el árbol de Huffman
huffman_tree = build_huffman_tree(frequencies)

# Imprimir el árbol de Huffman
print_huffman_tree(huffman_tree)





