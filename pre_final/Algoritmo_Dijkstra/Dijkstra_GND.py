import heapq

def dijkstra_simple(graph, start):
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
graph_simple = {
    '1': {'2': 35, '3': 30},
    '2': {'1': 35, '2': 12, '4': 18, '6': 39},
    '3': {'1': 30, '2': 12, '5': 15},
    '4': {'2': 18, '5': 12, '6': 16},
    '5': {'3': 15, '4': 12, '6': 30},
    '6': {'2': 39, '4': 16, '5': 30}
}

distances_simple = dijkstra_simple(graph_simple, '1')
print(distances_simple)




"""
    //Ejercicio de practica 2024
    '1': {'2': 35, '3': 30},
    '2': {'1': 35, '2': 12, '4': 18, '6': 39},
    '3': {'1': 30, '2': 12, '5': 15},
    '4': {'2': 18, '5': 12, '6': 16},
    '5': {'3': 15, '4': 12, '6': 30},
    '6': {'2': 39, '4': 16, '5': 30}

    //Ejercicio de youtube
    'S': {'B': 4, 'C': 2},
    'B': {'S': 4, 'C': 1, 'D': 5},
    'C': {'S': 2, 'B': 1, 'D': 8, 'E': 10},
    'D': {'B': 5, 'C': 8, 'E': 2},
    'E': {'C': 10, 'D': 2, 'T': 2},
    'T': {'D': 10, 'E': 2}
"""