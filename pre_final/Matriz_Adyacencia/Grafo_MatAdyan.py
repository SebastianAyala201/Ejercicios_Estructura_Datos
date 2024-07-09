def graph_to_adjacency_list(graph):
    adjacency_list = {}
    
    for node, edges in graph.items():
        adjacency_list[node] = list(edges.keys())
    
    return adjacency_list

# Grafo dirigido
graph_directed = {
    '1': {'2': 5, '4': 3, '5': 4},
    '2': {'3': 1, '6': 7, '9': 15},
    '3': {'6': 8, '8': 7},
    '4': {'3': 3, '8': 1, '5': 2},
    '5': {'8': 4, '10': 18},
    '6': {'7': 2, '9': 11},
    '7': {'9': 7, '10': 5},
    '8': {'7': 2, '10': 12},
    '9': {'10': 3, '11': 8},
    '10': {'11': 7},
    '11': {}
}

adjacency_list = graph_to_adjacency_list(graph_directed)
print(adjacency_list)
