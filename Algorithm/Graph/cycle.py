from collections import deque

def has_cycle(graph):
    visited = set()

    def bfs(graph, start):
        visited.add(start)
        q = deque([start])
        parent = {start : None}
        while q:
            vertex = q.popleft()

            for ele in graph[vertex]:
                if ele not in visited:
                    visited.add(ele)
                    q.append(ele)
                    parent[ele] = vertex
                else:
                    if ele != parent[vertex]:
                        return True

        return False

    for ele in graph.keys():
        if ele not in visited:
            if bfs(graph, ele):
                return True

    return False