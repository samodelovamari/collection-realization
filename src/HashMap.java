public class HashMap {
    private static final int INITIAL_CAPACITY = 16;
    private Entry[] buckets;

    public HashMap() {
        buckets = new Entry[INITIAL_CAPACITY];
    }

    private int hash(Object key) {
        return key.hashCode() % buckets.length;
    }

    /**
     * Метод put().
     * Добавляет значение в HashMap с указанным ключом.
     * @param key ключ, по которому необходимо добавить значение
     * @param value значение для добавления
     */


    public void put(Object key, Object value) {
        int index = hash(key);
        Entry entry = new Entry(key, value);
        if (buckets[index] == null) {
            buckets[index] = entry;
        } else {
            Entry current = buckets[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = entry;
        }
    }

    /**
     * Метод get().
     * Получает значение из HashMap по указанному ключу.
     * @param key ключ, по которому необходимо получить значение
     * @return значение, соответствующее указанному ключу, или null, если ключ не найден
     */


    public Object get(Object key) {
        int index = hash(key);
        Entry current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Метод remove().
     * Удаляет значение из HashMap по указанному ключу.
     * @param key ключ, по которому необходимо удалить значение
     */

    public void remove(Object key) {
        int index = hash(key);
        Entry current = buckets[index];
        Entry prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    private static class Entry {
        Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key1", "newvalue1");

        System.out.println("Value for key 'key1': " + map.get("key1"));
        System.out.println("Value for key 'key2': " + map.get("key2"));

        map.remove("key1");
        System.out.println("After removing key 'key1', value for key 'key1': " + map.get("key1"));
    }
}