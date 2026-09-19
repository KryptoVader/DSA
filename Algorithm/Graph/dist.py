from collections import deque

def shortest_distance(graph, source, dest):
    q = deque([[source, 0]])
    visited = set([source])
    res = {source : 0}

    while q:
        element = q.popleft()
        vertex, dist = element[0], element[1]

        for neighbors in graph[vertex]:
            if neighbors not in visited:
                visited.add(neighbors)
                q.append([neighbors, dist+1])
                res[neighbors] = dist + 1

    if dest in res:
        return res[dest]
    return -1

graph = {
    'A': ['B', 'C'],
    'B': ['A', 'D', 'E'],
    'C': ['A', 'F'],
    'D': ['B'],
    'E': ['B', 'F'],
    'F': ['C', 'E', 'G'],
    'G': ['F'],
    'H': []
}
print(shortest_distance(graph, 'A', 'G'))  
print(shortest_distance(graph, 'A', 'C'))  
print(shortest_distance(graph, 'A', 'A')) 
print(shortest_distance(graph, 'A', 'H'))  