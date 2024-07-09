import networkx as nx
import matplotlib.pyplot as plt

def adj_matrix_to_graph(adj_matrix):
    G = nx.DiGraph()  # Grafo dirigido
    
    for i in range(len(adj_matrix)):
        for j in range(len(adj_matrix[i])):
            if adj_matrix[i][j] != 0:
                G.add_edge(i, j)
    
    return G

# Ejemplo de uso
adj_matrix = [
    [0, 1, 1, 1, 0],
    [1, 0, 1, 0, 1],
    [1, 1, 0, 1, 1],
    [0, 1, 1, 0, 1],
    [0, 1, 1, 0, 0]
]

graph = adj_matrix_to_graph(adj_matrix)

# Dibujar el grafo
nx.draw(graph, with_labels=True, node_color='lightblue', edge_color='gray', node_size=2000, font_size=15)
plt.show()
