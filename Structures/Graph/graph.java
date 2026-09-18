package Graph;

import Hashmap.hashmap;
import List.DynamicList;

public class graph<T> {

    private hashmap<T, DynamicList<T>> v;
    private int edgeCount;

    public graph() {
        v = new hashmap<>(0);
        edgeCount = 0;
    }

    public void addVertex(T data) {
        if (data == null || v.containsKey(data)) {
            return;
        }

        v.put(data, new DynamicList<>());
    }

    public void addEdge(T u, T w) {
        if (u == null || w == null) {
            return;
        }

        if (!v.containsKey(u) || !v.containsKey(w)) {
            return;
        }

        DynamicList<T> uList = v.get(u);
        DynamicList<T> wList = v.get(w);

        if (!uList.contains(w)) {
            uList.add(w);
            wList.add(u);
            edgeCount++;
        }
    }

    public void removeEdge(T u, T w) {
        if (!v.containsKey(u) || !v.containsKey(w)) {
            return;
        }

        DynamicList<T> uList = v.get(u);
        DynamicList<T> wList = v.get(w);

        if (uList.contains(w)) {
            uList.remove(w);
            wList.remove(u);
            edgeCount--;
        }
    }

    public boolean hasEdge(T u, T w) {
        if (!v.containsKey(u) || !v.containsKey(w)) {
            return false;
        }

        return v.get(u).contains(w);
    }

    public int vertexCount() {
        return v.size();
    }

    public int edgeCount() {
        return edgeCount;
    }

    public DynamicList<T> neighbours(T vertex) {
        if (!v.containsKey(vertex)) {
            return null;
        }

        return v.get(vertex);
    }

    @Override
    public String toString() {
        return v.toString();
    }
}