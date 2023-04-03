package com.learn.java8.util;

public class LinkedList2<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    public void add(E item) {
        add(size, item);
    }

    public void add(int index, E item) {
        //获取指定索引位置节点
        if (index == size) {
            Node<E> oldLast = last;
            last = new Node<>(oldLast, item, null);
            if (oldLast == null) {
                // 添加第一个节点
                first = last;
            } else {
                // 尾节点添加
                oldLast.next = last;
            }
        } else {
            Node<E> node = this.node(index);
            Node<E> prev = node.prev;
            Node<E> newNode = new Node<>(prev, item, node);

            if (null != prev) {
                prev.next = newNode;
            } else {
                // 头节点
                first = newNode;
            }
        }
        size++;

    }

    public int indexOfE(E item) {
        Node<E> node = first;
        if (null != item) {
            for (int i = 0; i < size; i++) {
                if (item.equals(node.item)) return i;
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (null == (node.item)) return i;
                node = node.next;
            }
        }
        return -1;
    }

    public void remove(E item) {
        remove(indexOfE(item));
    }

    public E remove(int index) {

        Node<E> node = node(index);
        E oldItem = node.item;
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev != null) {
            prev.next = next;
        }else{
            first = next;
        }

        if (next != null) {
            next.prev = prev;
        }else{
            last = prev;
        }
        size--;
        return oldItem;
    }

    public Node<E> node4Ele(E item) {
        Node<E> node = first;
        if (null != item) {
            for (int i = 0; i < size; i++) {
                if (item.equals(node.item)) {
                    return node;
                }
                node = node.next;
            }
        }else{
            for (int i = 0; i < size; i++) {
                if (null==node.item) {
                    return node;
                }
                node = node.next;
            }
        }
        return null;
    }

    private Node<E> node(int index) {
        // 双向链表，两头遍历
        Node<E> node = null;
        if (index < (size >> 1)) {
            // 从前向后遍历
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            // 从后向前遍历
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(node);
            node = node.next;
        }
        sb.append("] ");
        return sb.toString();
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (prev != null) {
                sb.append(prev.item);
            } else {
                sb.append("null");
            }
            sb.append("_").append(item).append("_");

            if (next != null) {
                sb.append(next.item);
            } else {
                sb.append("null");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        LinkedList2<Integer> list2 = new LinkedList2<>();
        list2.add(11);
        list2.add(1);
        list2.add(1, 33);
        list2.add(14);
        System.out.println(list2);
        list2.remove(Integer.valueOf(33));

        System.out.println(list2);
    }
}
