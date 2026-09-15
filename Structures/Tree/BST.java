package Tree;
import java.util.ArrayDeque;
import java.util.Stack;

public class BST<T extends Comparable<T>>{
    private static class Node<T>{
        private Node<T> left;
        private T data;
        private Node<T> right;

        public Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void setData(T data){
            this.data = data;
        }

        public void setLeft(Node<T> n){
            this.left = n;
        }

        public void setRight(Node<T> n){
            this.right = n;
        }

        public T getData(){
            return this.data;
        }

        public Node<T> getLeft(){
            return this.left;
        }

        public Node<T> getRight(){
            return this.right;
        }
    }

    private Node<T> root;

    public BST(){
        this.root = null;
    }

    public void insert(T data){
        if(data == null){
            System.err.println("Invalid Data");
            return;
        } 

        if(this.root == null){
            this.root = new Node<T>(data);
            return;
        }

        var ptr = this.root;
        while(ptr != null){
            if(data.compareTo(ptr.getData()) < 0){
                if(ptr.getLeft() != null){
                    ptr = ptr.getLeft();
                    continue;
                }

                ptr.setLeft(new Node<T>(data));
                return;
            }
            else{
                if(ptr.getRight() != null){
                    ptr = ptr.getRight();
                    continue;
                }

                ptr.setRight(new Node<T>(data));
                return;
            }
        }
    }

    @Override
    public String toString() {
        return toString(this.root, 0);
    }

    private String toString(Node<T> node, int level) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(toString(node.getRight(), level + 1));
        sb.append("    ".repeat(level)).append(node.getData()).append("\n");
        sb.append(toString(node.getLeft(), level + 1));
        return sb.toString();
    }

    public boolean search(T data){
        if(data == null){
            System.err.println("Invalid Data");
            return false;
        } 

        if(this.root == null){
            return false;
        }

        var ptr = this.root;
        while(ptr != null){
            if(data.compareTo(ptr.getData()) == 0){
                return true;
            }

            else if(data.compareTo(ptr.getData()) < 0){
                ptr = ptr.getLeft();
                continue;
            }
            else{
                ptr = ptr.getRight();
            }
        }
        return false;
    }

    public void Inorder(){
        this.Inorder(this.root);
    }

    private void Inorder(Node<T> root){
        Stack<Node<T>> s = new Stack<>();
        var ptr = root;
        while(ptr != null || !s.isEmpty()){
            while(ptr != null){
                s.push(ptr);
                ptr = ptr.getLeft();
            }
            ptr = s.pop();
            System.out.print(ptr.getData() + " ");
            ptr = ptr.getRight();
        }
    }

    public void Preorder(){
        this.Preorder(this.root);
    }

    private void Preorder(Node<T> root){
        Stack<Node<T>> s = new Stack<>();
        var ptr = root;
        s.push(root);
        while(!s.isEmpty()){
            ptr = s.pop();
            System.out.print(ptr.getData() + " ");
            if(ptr.getRight() != null)
                s.push(ptr.getRight());
            
            if(ptr.getLeft() != null)
                s.push(ptr.getLeft());
        }
    }

    public void Postorder(){
        this.Postorder(this.root);
    }

    private void Postorder(Node<T> root){
        Stack<Node<T>> s = new Stack<>();
        Stack<Node<T>> s1 = new Stack<>();
        var ptr = root;
        s.push(root);
        while(!s.isEmpty()){
            ptr = s.pop();
            s1.push(ptr);
            if(ptr.getLeft() != null)
                s.push(ptr.getLeft());
            if(ptr.getRight() != null)
                s.push(ptr.getRight());
        }

        while(!s1.empty()){
            System.out.print(s1.pop().getData() + " ");
        }
        return;
    }

    public void Level(){
        this.Level(this.root);
    }

    private void Level(Node<T> root){
        ArrayDeque<Node<T>> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            var ptr = q.getFirst();
            System.out.print(ptr.getData() + " ");
            q.addLast(ptr.getLeft());
            q.addLast(ptr.getRight());
        }
    }

    public static void main(String[] args) {
        BST<Integer> b = new BST<>();
        int[] arr = {8, 3, 10, 1, 6, 14, 4, 7, 13};

        for(int ele: arr){
            b.insert(ele);
        }
        b.Level();
    }
}