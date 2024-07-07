import heapq

def dijkstra_simple(graph, start, end):
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
graph_simple = {
    'S': {'B': 4, 'C': 2},
    'B': {'S': 4, 'C': 1, 'D': 5},
    'C': {'S': 2, 'B': 1, 'D': 8, 'E': 10},
    'D': {'B': 5, 'C': 8, 'E': 2},
    'E': {'C': 10, 'D': 2, 'T': 2},
    'T': {'D': 10, 'E': 2}
}

path_simple, distance_simple = dijkstra_simple(graph_simple, 'S', 'T')
print(f"Camino más corto: {path_simple}")
print(f"Distancia: {distance_simple}")

"""
    //Ejercicio de practica 2024
    '1': {'2': 35, '3': 30},
    '2': {'1': 1, '3': 2, '4': 5, '6': 5},
    '3': {'1': 4, '2': 2, '5': 1},
    '4': {'2': 5, '5': 1, '6': 5},
    '5': {'4': 5, '6': 1},
    '6': {'2': 5, '4': 1, '5': 5}
"""