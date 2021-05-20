package HashTable;

public class MyHashTable<K, V> {

    public class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    public HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        this.chainArray = new HashNode[M];
    }

    public MyHashTable(int M){
        this.chainArray = new HashNode[M];
    }

    public int hash(K key){
        return (Math.abs(key.hashCode()) & 0x7fffffff) % chainArray.length;
    }

    public void put(K key, V value) {
        HashNode<K, V> Node = new HashNode<>(key, value);
        int index = hash(key);

        if (chainArray[index] == null){
            chainArray[index] = Node;
        } else {
            HashNode<K, V> hashNode = chainArray[index];
            while (hashNode.next != null)
                hashNode = hashNode.next;
            hashNode.next = Node;
        }
        size++;
    }

    public V get(K key) {
        int index = hash(key);

        HashNode<K, V> hashNode = chainArray[index];

        while (chainArray[index] != null) {
            if (hashNode.key.equals(key)) {
                return hashNode.value;
            }
            hashNode = hashNode.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);;
        V removingValue = get(key);
        while (chainArray[index] != null) {
            if (chainArray[index].key.equals(key)){
                if (chainArray[index].next == null){
                    chainArray[index] = null;
                } else {
                    chainArray[index] = chainArray[index].next;
                }
                break;
            }
            chainArray[index] = chainArray[index].next;
        }
        size--;
        return removingValue;
    }

    public boolean contains(V value) {
        for (int i = 0; i < chainArray.length; i++) {
            while (chainArray[i] != null) {
                if (chainArray[i].value.equals(value)){
                    return true;
                }
                chainArray[i] = chainArray[i].next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < chainArray.length; i++) {
            while (chainArray[i] != null) {
                if (chainArray[i].value.equals(value)){
                    return chainArray[i].key;
                }
                chainArray[i] = chainArray[i].next;
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }
}
