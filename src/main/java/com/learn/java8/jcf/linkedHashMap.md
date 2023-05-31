# LinkedHashMap

如果研究JDK源码会发现，在LinkedHashMap中，其不仅提供了用于创建Map的常见构造器，
还提供了一个 LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) 构造器，
其增加了我们对accessOrder字段的控制，该字段用于控制遍历的顺序，其在其它构造器中默认为false，即是按照条目entry插入顺序进行遍历

以get方法为例来说明accessOrder字段的作用，可以看到当我们通过get方法访问Map中的某个entry时，如果accessOrder为true时，
会将该条目entry移动到链表的最后。与之类似地，当使用put方法对已有的entry进行修改时，同样可以也会调用afterNodeAccess方法

````java
ublic class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V>{
    ...   
    public V get(Object key) {
        Node<K,V> e;
        if ((e = getNode(hash(key), key)) == null)
            return null;
        if (accessOrder)
            afterNodeAccess(e);
        return e.value;
    }
    /**
     * Aaron Zhu: 将当前元素移动到链表的最后位置
     */
    void afterNodeAccess(Node<K,V> e) { 
        LinkedHashMap.Entry<K,V> last;
        if (accessOrder && (last = tail) != e) {
            LinkedHashMap.Entry<K,V> p =
                (LinkedHashMap.Entry<K,V>)e, b = p.before, a = p.after;
            p.after = null;
            if (b == null)
                head = a;
            else
                b.after = a;
            if (a != null)
                a.before = b;
            else
                last = b;
            if (last == null)
                head = p;
            else {
                p.before = last;
                last.after = p;
            }
            tail = p;
            ++modCount;
        }
    }
    ...
}
````

这样当我们对其进行遍历即会发现，最近被访问过的元素反而会最后输出。当然很多人会对此感到奇怪，为什么最近使用的entry不是放到表头而是放在表尾，
毕竟曾经被访问过的条目entry应该优先被遍历啊。其实是因为Map中添加新元素是添加到链表的表尾。那么对于这个链表而言，表头的元素就是存在其中时间最久的。
如果这是一个容量有限的Map时，就可以通过移除表头的条目来释放空间以添加新的条目。一般地，我们认为对于曾经被访问过的条目entry，其下一次依然被访问的概率会较大，
故将其移动到表尾将存在时间置零。当然JDK中认为Map的容量是无限的，所以其虽然提供了一个removeEldestEntry方法来判定是否需要移除存在时间最久的条目，
但是该方法结果恒为false，即不移除。

### LinkedHashSet
LinkedHashSet与LinkedHashMap的关系就如同HashSet与HashMap一样。LinkedHashSet内部依然是利用LinkHashMap来实现的，
通过key来存储元素，而value则是无效的。值得一提的是，LinkedHashSet只支持按插入顺序进行遍历，即accessOrder字段恒为false，不可修改

### LRU算法
一般情况下，内存空间是有限的昂贵的，我们不可能将所有数据全部装进内存中，当内存需要添加新数据而空间已满的情况下，
我们就需要通过合适的内存管理算法策略来淘汰一些数据释放以内存空间。
这里我们介绍一种常见的内存管理策略——LRU（Least Recently Used，最近最少使用）算法，
其依据就是较长时间未被使用的数据其下一次被访问到的概率较低，故我们可以优先淘汰此部分的数据来释放内存
上文我们介绍了LinkedHashMap的accessOrder字段，其为true可以将被访问的数据移动到链表的表尾。
这里我们就可以基于此特性来实现一个应用LRU策略的缓存。我们重载removeEldestEntry方法，当发现缓存空间已满时，即删除表头数据来释放空间

````java

/**
 * 基于LinkedHashMap的 LRU Cache 实现
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private int cacheSize;  // 缓存容量

    public LRUCache(int cacheSize) {
        super(16,0.75f, true);
        this.cacheSize = cacheSize;
    }

    /**
     * 超过Cache容量即会移除最近最少被使用的元素
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > cacheSize;
    }
}
````

