package list;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<T> {
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;
    private int capability;
    private int size;
    private Map<String, DoubleLinkedNode<T>> allLinkedNode; //存储节点信息

    public LRUCache(int capability) throws Exception {
        if (capability < 1) {
            throw new IllegalAccessException("参数需大于0");
        }
        this.capability = capability;
        this.head = new DoubleLinkedNode();
        this.tail = new DoubleLinkedNode();
        head.next = tail;
        tail.previous = head;

        this.allLinkedNode = new HashMap();
    }

    public void add(String key,T val) {
        DoubleLinkedNode t = get(key);
        if (t == null) {
            addItem(key,val);
        }else{
            t.val = val;
        }
    }

    private void removeLastest() {
        DoubleLinkedNode previous = tail.previous;
        DoubleLinkedNode relation = previous.previous;
        tail.previous = relation;
        relation.next = tail;
        allLinkedNode.remove(previous.val);
    }

    private void remove2front(DoubleLinkedNode front) {
        if (front.previous == head) {
            return;
        }
        //改变到前面时，先改变原来节点的p,n指向
        DoubleLinkedNode previous = front.previous;
        DoubleLinkedNode next = front.next;
        previous.next = next;
        next.previous = previous;

        //改变为虚头节点的指向
        DoubleLinkedNode second = head.next;
        head.next = front;
        front.previous = head;
        front.next = second;
        if (previous == second) {
            previous.previous = front;
        }
    }

    void addItem(String key,T t) {
        //往链表中添加
        DoubleLinkedNode next = head.next;
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(next, head, t);
        head.next = newNode;
        next.previous = newNode;
        allLinkedNode.put(key, newNode);
        size++;
        if (size > capability) {
            removeLastest();
            size--;
        }
    }

    public DoubleLinkedNode<T> get(String key) {
        //如果没有此值返回null
        DoubleLinkedNode<T> doubleLinkedNode = allLinkedNode.get(key);
        if (doubleLinkedNode == null) {
            return null;
        } else {
            remove2front(doubleLinkedNode);
        }
        return doubleLinkedNode;

    }

    public void print() {
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
    }

    public static void main(String[] args) throws Exception {
        LRUCache<Integer> lru = new LRUCache<Integer>(2);
        lru.add("2",3);
        lru.add("2",1);
        lru.add("2",2);
        lru.add("2",1);
        lru.add("3",3);
        lru.print();
    }


}
