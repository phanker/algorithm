package list;

public class DoubleLinkedNode<T> {
    DoubleLinkedNode next;
    DoubleLinkedNode previous;

    T val;

    DoubleLinkedNode(DoubleLinkedNode next,DoubleLinkedNode previous,T val){
        this.val = val;
        this.next = next;
        this.previous = previous;
    }

    DoubleLinkedNode(){

    }

    DoubleLinkedNode(T t){
        this.val = t;
    }


}
