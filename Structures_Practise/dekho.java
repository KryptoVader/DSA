public class dekho {
public static void main(String[] args) throws CloneNotSupportedException {
        LinkedList<Integer> ll = new LinkedList<>();
        for(int i =10; i< 60; i+=10){
            ll.addLast(i);
        }
        System.out.println(ll);
        ll.addAt(2, 25);
        System.out.println(ll);
        ll.reverse();
        System.out.println(ll);
    }
}