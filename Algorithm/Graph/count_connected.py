from collections import deque

def count_connected(graph):
    visited = set()
    count = 0
    def bfs(graph, start, visited):
        visited.add(start)
        q = deque([start])

        while q:
            vertex = q.popleft()

            for ele in graph[vertex]:
                if ele not in visited:
                    visited.add(ele)
                    q.append(ele)

    for ele in graph.keys():
        if ele not in visited:
            bfs(graph, ele, visited)
            count += 1

    return count