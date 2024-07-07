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
    'A': {'B': 1, 'C': 4},
    'B': {'A': 1, 'C': 2, 'D': 5},
    'C': {'A': 4, 'B': 2, 'D': 1},
    'D': {'B': 5, 'C': 1}
}

mst = prim_mst(graph)
print("Aristas del MST y sus pesos:")
for edge in mst:
    print(f"{edge[0]} - {edge[1]}: {edge[2]}")

# Cálculo del peso total del MST
total_weight = sum(edge[2] for edge in mst)
print(f"Peso total del MST: {total_weight}")
