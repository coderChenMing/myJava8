package com.learn.java8.util;

/**
 * 双向链表
 */
public class LinkedList<E> {
    int size;
    Node<E> first;
    Node<E> last;

    public static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (null != prev) {
                sb.append(prev.item);
            } else {
                sb.append("null");
            }
            sb.append("_").append(item).append("_");
            if (null != next) {
                sb.append(next.item);
            } else {
                sb.append("null");
            }

            return sb.toString();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E item) {
        return indexOfE(item) != -1;
    }

    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    public void add(E item) {
        add(size, item);
    }

    public void add(int index, E item) {
        // 一般位置
        // index==0 size==0
        if (index == size) {
            // 从最后添加元素
            Node<E> oldLast = last;
            last = new Node<>(oldLast, item, null);
            if (oldLast == null) {
                // index==size==0 走这个分支
                first = last;
            } else {
                // 从index==size==0 之后一直走这个分支
                oldLast.next = last;
            }
        } else {
            Node<E> next = index(index);
            Node<E> prev = next.prev;
            Node<E> newNode = new Node<>(prev, item, next);
            next.prev = newNode;
            if (prev == null) {
                first = newNode;
            } else {
                prev.next = newNode;
            }
        }
        size++;
        // 临界位置
    }

    public Node<E> index(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
        Node<E> node = null;
        if (index < (size >> 2)) {
            // 从前向后找
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            //从后向前找
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
                sb.append(" , ");
            }
            sb.append(node);
            node = node.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    public E remove(int index) {
        Node<E> node = index(index);
        E oldItem = node.item;
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;
        return oldItem;
    }

    public void remove(E item) {
        remove(indexOfE(item));
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

    public E get(int index) {
        return index(index).item;
    }
}
