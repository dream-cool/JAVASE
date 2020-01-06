package com;

public class LinkList <E>{

    private Node first;

    private Node last;

    private int size;

    public boolean add(E element){
        if (first == null){
            Node<E> temp = new Node<E>(null, null, element);
            temp.element = element;
            last = first = temp;
            size++;
            return true;
        } else {
            Node<E> temp = new Node<E>(null, null, element);
            last.next = temp;
            temp.prev = last;
            temp.next = null;
            last = temp;
            size++;
            return true;
        }
    }

    public boolean add (int  index, E element){
        if (index < 0 || index > size ){
            System.out.println("下标索引不正确");
            return false;
        }
        if (index == 0 ){
            return this.addFirst(element);
        }
        if (index == size-1){
            return this.addLast(element);
        }
        if (first==null){
            System.out.println("链表为空");
            return false;
        } else {
            int idx = 1;
            for (Node<E> temp= first.next; temp!=null ; temp=temp.next ){
                if (index == idx) {
                    Node<E> node = new Node<E>(null, null, element);
                    node.prev = temp.prev;
                    node.next = temp;
                    temp.prev.next=node;
                    temp.prev=node;
                    size++;
                    return true;
                }
                idx++;
            }
        }
        return false;
    }

    public E remove (E element){
        if (element == null){
            System.out.println("不能为空");
            return null;
        }
        if (first==null){
            System.out.println("链表为空");
            return null;
        } else {
            for (Node<E> temp= first; temp!=null ; temp=temp.next ){
                if (temp.element.hashCode() == element.hashCode()){
                    if (temp.element.equals(element)) {
                        if (temp == first && temp == last){
                            first = last = null;
                            return temp.element;
                        }
                        if (temp == last){
                            last.prev.next = null;
                            last = last.prev;
                        } else if (temp == first){
                            first.next.prev=null;
                            first=first.next;
                        } else {
                            temp.next.prev = temp.prev;
                            temp.prev.next = temp.next;
                        }
                        size--;
                        return temp.element;
                    }
                }
            }
            System.out.println("链表中没有该对象");
        }
        return null;
    }

    public boolean set (int  index, E element){
        if (index < 0 || index > size ){
            throw new ArrayIndexOutOfBoundsException("下标索引不正确");
        }
        if (first==null){
            System.out.println("链表为空");
            return false;
        } else {
            int idx = 0;
            for (Node<E> temp= first; temp!=null ; temp=temp.next ){
                if (index == idx) {
                    temp.element = element;
                    return true;
                }
                idx++;
            }
        }
        return false;
    }

    public E remove (int  index){
        if (index < 0 || index > size ){
            System.out.println("下标索引不正确");
            return null;
        }
        if (first==null){
            System.out.println("链表为空");
            return null;
        } else {
            int idx = 0;
            for (Node<E> temp= first; temp!=null ; temp=temp.next ){
                if (index == idx) {
                    if (temp == last){
                        last.prev.next = null;
                        last = last.prev;
                    } else if (temp == first){
                        first.next.prev=null;
                        first=first.next;
                    } else {
                        temp.next.prev = temp.prev;
                        temp.prev.next = temp.next;
                    }
                    size--;
                    return temp.element;
                }
                idx++;
            }
        }
        return null;
    }

    public E searchByIndex (int index){
        if (index < 0 || index > size ){
            System.out.println("下标索引不正确");
            return null;
        }
        if (first==null){
            System.out.println("链表为空");
            return null;
        } else {
            int idx = 0;
            for (Node<E> temp= first; temp!=null ; temp=temp.next){
                if (idx == index){
                    return temp.element;
                }
                idx++;
            }
        }
        return null;
    }

    public int getIndex (E element){
        if (first==null){
            System.out.println("链表为空");
            return -1;
        } else {
            int idx=0;
            for (Node<E> temp= first; temp!=null ; temp=temp.next ){
                if (temp.element.hashCode() == element.hashCode()){
                    if (temp.element.equals(element)) {
                        return idx;
                    }
                }
                idx++;
            }
            System.out.println("链表中没有该对象");
        }
        return -1;
    }

    public boolean addFirst(E element){
        if (first == null){
            Node<E> temp = new Node<E>(null, null, element);
            temp.element = element;
            last = first = temp;
            size++;
            return true;
        } else {
            Node<E> temp = new Node<E>(null, null, element);
            first.prev = temp;
            temp.next = first;
            first = temp;
            size++;
            return true;
        }
    }

    public boolean addLast(E element){
        if (first == null){
            Node<E> temp = new Node<E>(null, null, element);
            temp.element = element;
            last = first = temp;
            size++;
            return true;
        } else {
            Node<E> temp = new Node<E>(null, null, element);
            last.next = temp;
            temp.prev = last;
            last = temp;
            size++;
            return true;
        }
    }

    public boolean addAll(LinkList linkedList){
        if (!(linkedList instanceof LinkList)){
            System.out.println("添加类型不匹配");
            return false;
        }
        if (linkedList.first==null){
            System.out.println("添加的列表为空");
            return false;
        }
        if (first == null){
            first = linkedList.first;
            size = linkedList.size;
            return true;
        } else {
            last.next = linkedList.first;
            linkedList.first.prev = last;
            last = linkedList.last;
            size=size+linkedList.size;
            return true;
        }
    }

    public E removeFirst (){
        if (first==null){
            System.out.println("链表为空");
            return null;
        } else {
            Node<E> temp = first;
            first.next.prev=null;
            first=first.next;
            first = null;
            size--;
            return temp.element;
        }
    }

    public E removeLast (){
        if (first==null){
            System.out.println("链表为空");
            return null;
        } else {
            Node<E> temp = last;
            last.prev.next = null;
            last = last.prev;
            size--;
            return temp.element;
        }
    }

    public boolean contains(E element){
        if (first == null){
            System.out.println("链表为空");
            return false;
        } else {
            for (Node<E> temp= first; temp!=null ; temp=temp.next ){
                if (temp.element.hashCode() == element.hashCode()){
                    if (temp.element.equals(element)){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public E[] toArrays( E[] a ){
        if (a.length < size){
            a = (E[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        }
        if (first == null){
            System.out.println("链表为空");
            return null;
        } else {
            int index = 0;
            Object[] objects = a;
            for (Node<E> temp = first ; temp != null ; temp = temp.next){
                objects[index++] = temp.element;
            }
            if (a.length > size){
                a[size] = null;
            }
            return a;
        }
    }

    public void clear(){
        for (Node<E> temp = first; temp!=null ; temp = temp.next ){
            temp.prev = null;
            temp.next = null;
            temp.element = null;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (first == null){
            return null;
        } else {
            sb.append("{");
            for (Node<E> temp= first; temp!=null ; temp=temp.next ){
                String s =temp.element.toString();
                sb.append(s).append(", ");
            }
            sb.setCharAt(sb.length()-1,'}');
        }
        return String.valueOf(sb);
    }

    public Node<E> getFirst() {
        return first;
    }

    public void setFirst(Node<E> first) {
        this.first = first;
    }

    public Node<E> getLast() {
        return last;
    }

    public void setLast(Node<E> last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
