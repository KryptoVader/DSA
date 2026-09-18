from collections import deque

def traverse(graph):
    visited = set()
    def bfs(graph, start, visited):
        q = deque([start])
        visited.add(start)
        while len(q) != 0:
            vertex = q.popleft()
            print(vertex)
            for ele in graph[vertex]:
                if ele not in visited:
                    visited.add(ele)
                    q.append(ele)

    for ele in graph.keys():
        if ele not in visited:
            bfs(graph, ele, visited)

graph = {
    0: [1],
    1: [0],
    2: [3],
    3: [2]
}

traverse(graph)