from collections import deque
def topological_sort(graph):
    indegree = {}
    q = deque()
    res = []
    for key, val in graph.items():
        if key not in indegree:
            indegree[key] = 0

        for ele in val:
            if ele not in indegree:
                indegree[ele] = 1
            else:
                indegree[ele] += 1

    for ele in indegree:
        if indegree[ele] == 0:
            q.append(ele)

    while q:
        vertex = q.popleft()
        res.append(vertex)

        for neighbors in graph[vertex]:
            indegree[neighbors] -= 1
            if indegree[neighbors] == 0:
                q.append(neighbors)
    return res

graph = {
    'A': ['B'],
    'B': ['C'],
    'C': ['A'],
    'D': []
}

print(topological_sort(graph))

if(len(graph) != len(topological_sort(graph))):
    print("Cycle Detected")
else:
    print("NO cycle found!!")