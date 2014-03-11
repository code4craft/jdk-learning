import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author code4crafter@gmail.com
 */
public class PriorityQueueTest {

    @Test
    public void testComparable() throws Exception {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.add(2);
        priorityQueue.add(1);
        priorityQueue.add(-1);
        //priorityQueue会将compareTo()较小的排到前面
        assertThat(priorityQueue.poll()).isEqualTo(-1);
        assertThat(priorityQueue.poll()).isEqualTo(1);
        assertThat(priorityQueue.poll()).isEqualTo(2);
    }

    private class Item {
        private int priority;

        private Item(int priority) {
            this.priority = priority;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Item item = (Item) o;

            if (priority != item.priority) return false;

            return true;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "priority=" + priority +
                    '}';
        }
    }

    @Test
    public void testComparator() throws Exception {
        PriorityQueue<Item> priorityQueue = new PriorityQueue<Item>(3, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1.priority < o2.priority) {
                    return -1;
                } else if (o1.priority > o2.priority) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        priorityQueue.add(new Item(2));
        priorityQueue.add(new Item(1));
        priorityQueue.add(new Item(-1));
        //priorityQueue会将compareTo()较小的排到前面
        assertThat(priorityQueue.poll()).isEqualTo(new Item(-1));
        assertThat(priorityQueue.poll()).isEqualTo(new Item(1));
        assertThat(priorityQueue.poll()).isEqualTo(new Item(2));
    }
}
