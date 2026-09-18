def traverse(graph):
    visited = set()

    def dfs(graph, start, visited):
        visited.add(start)
        print(start)
        for ele in graph[start]:
            if ele not in visited:
                dfs(graph, ele, visited)

    for ele in graph.keys():
        if ele not in visited:
            dfs(graph, ele, visited)

graph = {
    0: [1, 2],
    1: [0, 3],
    2: [0, 4],
    3: [1, 4],
    4: [2, 3]
}

traverse(graph)