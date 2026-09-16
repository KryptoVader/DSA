package Tree;

import java.util.ArrayDeque;

public class BinaryTree<T> {
    private static class Node<T> {
        private Node<T> left;
        private T data;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setLeft(Node<T> n) {
            this.left = n;
        }

        public void setRight(Node<T> n) {
            this.right = n;
        }

        public T getData() {
            return this.data;
        }

        public Node<T> getLeft() {
            return this.left;
        }

        public Node<T> getRight() {
            return this.right;
        }
    }

    private Node<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(T data) {
        if (data == null) {
            System.out.println("Invalid");
            return;
        }

        if (this.root == null) {
            this.root = new Node<T>(data);
            return;
        }

        var ptr = this.root;
        ArrayDeque<Node<T>> q = new ArrayDeque<>();
        q.addLast(ptr);
        while (!q.isEmpty()) {
            ptr = q.removeFirst();
            if (ptr.getLeft() == null) {
                ptr.setLeft(new Node<T>(data));
                return;
            }

            else if (ptr.getRight() == null) {
                ptr.setRight(new Node<T>(data));
                return;
            }
            q.addLast(ptr.getLeft());
            q.addLast(ptr.getRight());
        }
    }

    @Override
    public String toString() {
        if (this.root == null)
            return "[]";

        var ptr = this.root;
        ArrayDeque<Node<T>> q = new ArrayDeque<>();
        q.addLast(ptr);
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean first = true;

        while (!q.isEmpty()) {
            ptr = q.removeFirst();
            if (!first)
                sb.append(", ");

            sb.append(ptr.getData());
            first = false;
            if (ptr.getLeft() != null)
                q.addLast(ptr.getLeft());

            if (ptr.getRight() != null)
                q.addLast(ptr.getRight());
        }
        sb.append(']');
        return sb.toString();
    }

    public int height() {
        return this.height(this.root);
    }

    private int height(Node<T> root) {
        if (root == null) {
            return -1;
        }

        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }

    public int count() {
        if (this.root == null) {
            return 0;
        }
        var ptr = this.root;
        ArrayDeque<Node<T>> q = new ArrayDeque<>();
        q.addFirst(ptr);
        int res = 0;
        while (!q.isEmpty()) {
            ptr = q.removeFirst();
            res++;
            if (ptr.getLeft() != null) {
                q.addLast(ptr.getLeft());
            }

            if (ptr.getRight() != null) {
                q.addLast(ptr.getRight());
            }
        }
        return res;
    }

    public int leafCount() {
        if (this.root == null) {
            return 0;
        }

        var ptr = this.root;
        ArrayDeque<Node<T>> q = new ArrayDeque<>();
        q.addFirst(ptr);
        int res = 0;
        while (!q.isEmpty()) {
            ptr = q.removeFirst();

            if (ptr.getLeft() == null && ptr.getRight() == null) {
                res++;
            }

            if (ptr.getLeft() != null) {
                q.addLast(ptr.getLeft());
            }

            if (ptr.getRight() != null) {
                q.addLast(ptr.getRight());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.insert(10);
        bt.insert(50);
        bt.insert(5);
        bt.insert(30);
        bt.insert(1);
        bt.insert(99);
        System.out.println(bt);
        System.out.println(bt.height());
        System.out.println(bt.count());
        System.out.println(bt.leafCount());
    }
}