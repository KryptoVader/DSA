package Graph;

import Hashmap.hashmap;
import List.DynamicList;

public class graph<T> {

    private hashmap<T, DynamicList<T>> vertices;
    private int edges;

    public graph() {
        vertices = new hashmap<>(8);
        edges = 0;
    }

    public void addVertex(T data) {
        if (data == null || vertices.containsKey(data)) {
            return;
        }

        vertices.put(data, new DynamicList<>());
    }

    public void addEdge(T u, T v) {

        if (u == null || v == null) {
            return;
        }

        if (!vertices.containsKey(u) || !vertices.containsKey(v)) {
            return;
        }

        DynamicList<T> uNeighbours = vertices.get(u);
        DynamicList<T> vNeighbours = vertices.get(v);

        if (uNeighbours.contains(v)) {
            return;
        }

        uNeighbours.add(v);
        vNeighbours.add(u);

        edges++;
    }

    public void removeEdge(T u, T v) {

        if (!vertices.containsKey(u) || !vertices.containsKey(v)) {
            return;
        }

        DynamicList<T> uNeighbours = vertices.get(u);
        DynamicList<T> vNeighbours = vertices.get(v);

        if (!uNeighbours.contains(v)) {
            return;
        }

        uNeighbours.remove(v);
        vNeighbours.remove(u);

        edges--;
    }

    public boolean hasEdge(T u, T v) {

        if (!vertices.containsKey(u) || !vertices.containsKey(v)) {
            return false;
        }

        return vertices.get(u).contains(v);
    }

    public int vertexCount() {
        return vertices.size();
    }

    public int edgeCount() {
        return edges;
    }

    public DynamicList<T> neighbours(T vertex) {

        if (!vertices.containsKey(vertex)) {
            return null;
        }

        return vertices.get(vertex);
    }

    @Override
    public String toString() {
        return vertices.toString();
    }
}