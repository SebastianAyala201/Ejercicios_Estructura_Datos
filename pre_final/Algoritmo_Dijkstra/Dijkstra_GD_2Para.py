# Para grafos dirigidos con nodo inicial y final

import heapq

def dijkstra_directed(graph, start, end):
    # Inicialización
    distances = {vertex: float('infinity') for vertex in graph}
    previous_vertices = {vertex: None for vertex in graph}
    distances[start] = 0
    priority_queue = [(0, start)]
    visited = set()
    
    while priority_queue:
        current_distance, current_vertex = heapq.heappop(priority_queue)
        
        if current_vertex in visited:
            continue
        
        visited.add(current_vertex)
        
        if current_vertex == end:
            break
        
        for neighbor, weight in graph[current_vertex].items():
            distance = current_distance + weight
            
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                previous_vertices[neighbor] = current_vertex
                heapq.heappush(priority_queue, (distance, neighbor))
    
    # Reconstruir el camino desde el final al inicio
    path = []
    current_vertex = end
    while current_vertex is not None:
        path.append(current_vertex)
        current_vertex = previous_vertices[current_vertex]
    path = path[::-1]  # Invertir el camino
    
    return path, distances[end]

# Ejemplo de uso
graph_directed = {
    'A': {'B': 1, 'C': 4},
    'B': {'C': 2, 'D': 5},
    'C': {'D': 1},
    'A': {'B': 1, 'C': 4},
    'B': {'C': 2, 'D': 5},
    'C': {'D': 1},
    'D': {}
}

path_directed, distance_directed = dijkstra_directed(graph_directed, 'A', 'D')
print(f"Camino más corto: {path_directed}")
print(f"Distancia: {distance_directed}")
