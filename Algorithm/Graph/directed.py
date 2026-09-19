def directed(graph):
    visited = set()
    rec_stack = set()

    def dfs(vertex):
        visited.add(vertex)
        rec_stack.add(vertex)

        for neighbor in graph[vertex]:
            if neighbor in rec_stack:
                return True

            if neighbor not in visited:
                if dfs(neighbor):
                    return True

        rec_stack.remove(vertex)
        return False

    for ele in graph:
        if ele not in visited:
            if dfs(ele):
                return True

    return False