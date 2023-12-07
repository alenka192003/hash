import java.util.Iterator;
import java.util.LinkedList;
public class HashTable<K, V> implements Iterable<KeyValue<K, V>> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.80d;
    private LinkedList<KeyValue<K, V>>[] table;
    private int size;
    private int capacity;
    public HashTable() {
        this.table = new LinkedList[INITIAL_CAPACITY];
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
    }
    public void add(K key, V value) {
        growIfNeeded();
        int slotNumber = findSlotNumber(key);
        if (table[slotNumber] == null) {
            table[slotNumber] = new LinkedList<>();
        }
        table[slotNumber].add(new KeyValue<>(key, value));
        size++;
    }
    private int findSlotNumber(K key) {return key.hashCode() % capacity;}
    private void growIfNeeded() {if ((double) size / capacity > LOAD_FACTOR) {grow();}}
    private void grow() {
        capacity *= 2;
        LinkedList<KeyValue<K, V>>[] newTable = new LinkedList[capacity];

        for (LinkedList<KeyValue<K, V>> list : table) {
            if (list != null) {
                for (KeyValue<K, V> entry : list) {
                    int newSlotNumber = entry.getKey().hashCode() % capacity;
                    if (newTable[newSlotNumber] == null) {
                        newTable[newSlotNumber] = new LinkedList<>();
                    }
                    newTable[newSlotNumber].add(entry);
                }
            }
        }
        table = newTable;
    }
    public int size() {return size;}
    public int capacity() {return capacity;}
    public boolean addOrReplace(K key, V value) {
        int slotNumber = findSlotNumber(key);
        LinkedList<KeyValue<K, V>> list = table[slotNumber];

        if (list != null) {
            for (KeyValue<K, V> entry : list) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    return true;
                }
            }
        }
        add(key, value);
        return false;
    }

    public V get(K key) {
        int slotNumber = findSlotNumber(key);
        LinkedList<KeyValue<K, V>> list = table[slotNumber];

        if (list != null) {
            for (KeyValue<K, V> entry : list) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public KeyValue<K, V> find(K key) {
        int slotNumber = findSlotNumber(key);
        LinkedList<KeyValue<K, V>> list = table[slotNumber];

        if (list != null) {
            for (KeyValue<K, V> entry : list) {
                if (entry.getKey().equals(key)) {
                    return entry;
                }
            }
        }
        return null;
    }

    public boolean containsKey(K key) {return find(key) != null;}

    public boolean remove(K key) {
        int slotNumber = findSlotNumber(key);
        LinkedList<KeyValue<K, V>> list = table[slotNumber];

        if (list != null) {
            Iterator<KeyValue<K, V>> iterator = list.iterator();
            while (iterator.hasNext()) {
                KeyValue<K, V> entry = iterator.next();
                if (entry.getKey().equals(key)) {
                    iterator.remove();
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    public void clear() {
        table = new LinkedList[INITIAL_CAPACITY];
        size = 0;
        capacity = INITIAL_CAPACITY;
    }

    public Iterable<K> keys() {
        LinkedList<K> keys = new LinkedList<>();
        for (LinkedList<KeyValue<K, V>> list : table) {
            if (list != null) {
                for (KeyValue<K, V> entry : list) {
                    keys.add(entry.getKey());
                }
            }
        }
        return keys;
    }

    public Iterable<V> values() {
        LinkedList<V> values = new LinkedList<>();
        for (LinkedList<KeyValue<K, V>> list : table) {
            if (list != null) {
                for (KeyValue<K, V> entry : list) {
                    values.add(entry.getValue());
                }
            }
        }
        return values;
    }

    @Override
    public Iterator<KeyValue<K, V>> iterator() {
        LinkedList<KeyValue<K, V>> allEntries = new LinkedList<>();
        for (LinkedList<KeyValue<K, V>> list : table) {
            if (list != null) {
                allEntries.addAll(list);
            }
        }
        return allEntries.iterator();
    }
}
