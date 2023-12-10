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

        // Получение значения по ключу
        System.out.println("Value for key 'two': " + hashTable.get("two"));

        // Замена значения по ключу
        hashTable.addOrReplace("two", 22);
        System.out.println("Updated value for key 'two': " + hashTable.get("two"));
        hashTable.add("two", 2);
        hashTable.add("five", 5);

        hashTable.add("eight", 8);

        // Проверка наличия ключа
        System.out.println("Contains key 'five': " + hashTable.containsKey("five"));

        // Удаление элемента по ключу
        hashTable.remove("four");
        System.out.println("Size after removal: " + hashTable.size());

        // Вывод всех ключей и значений

        System.out.println(hashTable);

        // Очистка таблицы
        hashTable.clear();
        System.out.println("Size after clearing: " + hashTable.size());

        // Добавление элементов после очистки
        hashTable.add("five", 5);
        hashTable.add("six", 6);

        // Итерация по элементам
        System.out.println("Iterating through elements:");
        Iterator<KeyValue<String, Integer>> iterator = hashTable.iterator();
        while (iterator.hasNext()) {
            KeyValue<String, Integer> entry = iterator.next();
            System.out.println(entry);
        }
    }
}
