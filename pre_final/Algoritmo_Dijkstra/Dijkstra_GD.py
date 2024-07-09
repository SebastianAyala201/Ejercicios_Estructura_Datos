# Para grafos dirigidos


import heapq

def dijkstra_directed(graph, start):
    # Inicialización
    distances = {vertex: float('infinity') for vertex in graph}
    distances[start] = 0
    priority_queue = [(0, start)]
    visited = set()
    
    while priority_queue:
        current_distance, current_vertex = heapq.heappop(priority_queue)
        
        if current_vertex in visited:
            continue
        
        visited.add(current_vertex)
        
        for neighbor, weight in graph[current_vertex].items():
            distance = current_distance + weight
            
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(priority_queue, (distance, neighbor))
    
    return distances

# Ejemplo de uso
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

distances_directed = dijkstra_directed(graph_directed, '1')
print(distances_directed)
