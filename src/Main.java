import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();

        // Добавление элементов
        hashTable.add("one", 1);
        hashTable.add("two", 2);
        hashTable.add("three", 3);
        hashTable.add("four", 4);
        hashTable.add("nine", 9);
        hashTable.add("ten", 10);


        // Вывод размера и емкости
        System.out.println("Size: " + hashTable.size());
        System.out.println("Capacity: " + hashTable.capacity());



        hashTable.addOrReplace("two", 22);
        System.out.println("Updated value for key 'two': " + hashTable.getAllValuesForKey("two"));
        hashTable.add("two", 2);
        hashTable.add("five", 5);

        hashTable.add("eight", 8);
        hashTable.add("nn", 12);
        hashTable.add("csdc", 13);
        hashTable.add("dd", 14);
        hashTable.add("d", 15);
        hashTable.add("ва", 16);
        hashTable.add("аыа", 18);

        System.out.println(hashTable);
        System.out.println("Value for key 'two': " + hashTable.getAllValuesForKey("two"));
        System.out.println("Value for key 'one': " + hashTable.getAllValuesForKey("one"));
        hashTable.clear();
        System.out.println("Size after clearing: " + hashTable.size());

        hashTable.add("five", 5);
        hashTable.add("six", 6);

        // Итерация по элементам
        System.out.println("Iterator: ");
        Iterator<KeyValue<String, Integer>> iterator = hashTable.iterator();
        while (iterator.hasNext()) {
            KeyValue<String, Integer> entry = iterator.next();
            System.out.println(entry);
        }
    }
}
