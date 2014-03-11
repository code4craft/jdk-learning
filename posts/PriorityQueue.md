PriorityQueue
======
今天在oschina上看到有人讨论优先级队列，于是就想到了JDK中的`PriorityQueue`。PriorityQueue是JDK 1.5加入的特性，它基于一个[二项堆](http://en.wikipedia.org/wiki/Binary_heap)实现，能够保证在插入和删除时有比较好的时间复杂度。

## 使用

PriorityQueue有两种使用方式，可以放入实现了`Comparable`接口的对象，或者在构建函数中指定`Comparator`。

```java
    @Test
    public void test() throws Exception {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.add(2);
        priorityQueue.add(1);
        priorityQueue.add(-1);
        //priorityQueue会将compareTo()较小的排到前面
        assertThat(priorityQueue.poll()).isEqualTo(-1);
        assertThat(priorityQueue.poll()).isEqualTo(1);
        assertThat(priorityQueue.poll()).isEqualTo(2);
    }
```

PriorityQueue的核心是`siftUp`和`siftDown`。这两个会对元素进行排序。

如果元素



参考:

* [http://en.wikipedia.org/wiki/Binary_heap](http://en.wikipedia.org/wiki/Binary_heap)
