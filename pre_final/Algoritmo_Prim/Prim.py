import heapq

def prim_mst(graph):
    start_vertex = next(iter(graph))  # Empezamos desde un nodo arbitrario
    mst = []
    visited = set([start_vertex])
    edges = [(weight, start_vertex, to) for to, weight in graph[start_vertex].items()]
    heapq.heapify(edges)
    
    while edges:
        weight, frm, to = heapq.heappop(edges)
        if to not in visited:
            visited.add(to)
            mst.append((frm, to, weight))
            for to_next, weight in graph[to].items():
                if to_next not in visited:
                    heapq.heappush(edges, (weight, to, to_next))
    
    return mst

# Ejemplo de uso
graph = {
    '1': {'3': 4, '2': 3},
    '2': {'1': 3, '4': 5, '6': 8},
    '3': {'1': 4, '4': 2},
    '4': {'2': 5, '3': 2, '5': 2, '7': 6},
    '5': {'4': 2, '6': 3, '7': 4},
    '6': {'2': 8, '5': 3, '8': 4},
    '7': {'4': 6, '5': 4, '8': 3, '9': 4},
    '8': {'6': 4, '7': 3, '10': 5},
    '9': {'7': 4, '10': 6},
    '10': {'8': 5, '9': 6}
}

mst = prim_mst(graph)
print("Aristas del MST y sus pesos:")
for edge in mst:
    print(f"{edge[0]} - {edge[1]}: {edge[2]}")

# Cálculo del peso total del MST
total_weight = sum(edge[2] for edge in mst)
print(f"Peso total del MST: {total_weight}")

"""
    //Ejercicio de Examen Final 2023
    '1': {'3': 4, '2': 3},
    '2': {'1': 3, '4': 5, '6': 8},
    '3': {'1': 4, '4': 2},
    '4': {'2': 5, '3': 2, '5': 2, '7': 6},
    '5': {'4': 2, '6': 3, '7': 4},
    '6': {'2': 8, '5': 3, '8': 4},
    '7': {'4': 6, '5': 4, '8': 3, '9': 4},
    '8': {'6': 4, '7': 3, '10': 5},
    '9': {'7': 4, '10': 6},
    '10': {'8': 5, '9': 6}
"""