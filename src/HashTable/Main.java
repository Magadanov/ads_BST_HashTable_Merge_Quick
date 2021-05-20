package HashTable;

public class Main {

    public static void main(String[] args) {
        // write your code here
        MyHashTable<Integer, Integer> myHashTable = new MyHashTable<>();
        myHashTable.put(0, 11);
        myHashTable.put(1, 61);
        myHashTable.put(2, 41);
        myHashTable.put(3, 21);
        myHashTable.put(4, 31);
        myHashTable.put(5, 81);
        myHashTable.put(6, 91);
        myHashTable.put(10, 10);
        myHashTable.put(11, 30);
        myHashTable.put(12, 40);
        myHashTable.put(13, 20);
        myHashTable.put(14, 30);
        myHashTable.put(15, 80);
        myHashTable.put(16, 90);
        myHashTable.put(20, 90);
        System.out.println(myHashTable.remove(4));
        System.out.println(myHashTable.contains(31));
    }
}