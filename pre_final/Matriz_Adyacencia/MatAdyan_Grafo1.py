def adjacency_matrix_to_dict(adj_matrix):
    graph_dict = {}
    num_nodes = len(adj_matrix)
    
    for i in range(num_nodes):
        node = str(i + 1)  # Convertir el índice a un nodo etiquetado con un número (empezando en 1)
        graph_dict[node] = {}
        for j in range(num_nodes):
            if adj_matrix[i][j] != 0:
                neighbor = str(j + 1)  # Convertir el índice a un nodo etiquetado con un número (empezando en 1)
                graph_dict[node][neighbor] = adj_matrix[i][j]
    
    return graph_dict

# Ejemplo de uso
adj_matrix = [
    [0, 5, 0, 3, 4, 0, 0, 0, 0, 0, 0],
    [0, 0, 1, 0, 0, 7, 0, 0, 15, 0, 0],
    [0, 0, 0, 0, 0, 8, 0, 7, 0, 0, 0],
    [0, 0, 3, 0, 2, 0, 0, 1, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 0],
    [0, 0, 0, 0, 0, 0, 2, 0, 11, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 7, 5, 0],
    [0, 0, 0, 0, 0, 0, 2, 0, 0, 12, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 8],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
]

graph_dict = adjacency_matrix_to_dict(adj_matrix)
print(graph_dict)
