public class HashSet {
    private static final int INITIAL_CAPACITY = 16;
    private Object[] buckets;
    private int size;

    public HashSet() {
        buckets = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    private int hash(Object key) {
        return key.hashCode() % buckets.length;
    }

    /**
     * Метод add().
     * Добавляет элемент в HashSet, если его там еще нет.
     * @param key элемент для добавления
     */

    public void add(Object key) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = key;
            size++;
        }
    }

    /**
     * Метод contains().
     * Проверяет, содержит ли HashSet указанный элемент.
     * @param key элемент для проверки наличия
     * @return true, если HashSet содержит указанный элемент, иначе false
     */

    public boolean contains(Object key) {
        int index = hash(key);
        return buckets[index] != null && buckets[index].equals(key);
    }

    /**
     * Метод remove().
     * Удаляет элемент из HashSet.
     * @param key элемент для удаления
     */

    public void remove(Object key) {
        int index = hash(key);
        if (buckets[index] != null && buckets[index].equals(key)) {
            buckets[index] = null;
            size--;
        }
    }

    /**
     * Метод size().
     * Возвращает количество элементов в HashSet.
     * @return количество элементов в HashSet
     */

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("apple");
        set.add("banana");
        set.add("apple");

        System.out.println("Set size: " + set.size());
        System.out.println("Set contains 'apple': " + set.contains("apple"));
        System.out.println("Set contains 'banana': " + set.contains("banana"));

        set.remove("apple");
        System.out.println("After removing 'apple', set contains 'apple': " + set.contains("apple"));
    }
}