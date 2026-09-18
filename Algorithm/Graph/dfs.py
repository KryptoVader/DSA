def traverse(graph):
    visited = set()

    def dfs(graph, start, visited):
        stack = [start]
        visited.add(start)
        while len(stack) != 0:
            vertex = stack.pop()
            print(vertex)
            for ele in graph[vertex]:
                if ele not in visited:
                    stack.append(ele)
                    visited.add(ele)

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