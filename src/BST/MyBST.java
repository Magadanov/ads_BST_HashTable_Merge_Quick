package BST;

public class MyBST<K extends Comparable<K>, V> {
    private Node root;

    private class Node{
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value){
        Node node = new Node(key, value);
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            while (current != null) {
                int cmp = current.key.compareTo(key);
                if (cmp > 0) {
                    if (current.left == null){
                        current.left = node;
                        break;
                    }
                    current = current.left;
                } else {
                    if (current.right == null){
                        current.right = node;
                        break;
                    }
                    current = current.right;
                }
            }
        }
    }

    public V get(K key) {
        Node current = root;
        while (current != null){
            int cmp = current.key.compareTo(key);
            if (cmp == 0) {
                return current.value;
            }
            if (cmp > 0) {
                current = current.left;
            } else current = current.right;
        }
        return null;
    }

    public void delete(K key){
        Node current = root;
        int cmp = current.key.compareTo(key);
        while (cmp != 0){
            if (cmp > 0){
                current = current.left;
            } else current = current.right;
        }
        System.out.println(current.value);
    }
//    public void delete(K key){
//        Node current = root;
//        delete(key, root);
//    }
//
//    private void delete(K key, Node root){
//        Node current = this.root;
//        int cmp = current.key.compareTo(key);
//        if (cmp > 0){
//            delete(current.left.key, current.left);
//        } else if (cmp < 0) {
//            delete(current.left.key, current.right);
//        } else {
//            if(current.left != null && current.right != null){
////                root = null;
//                System.out.println("ok1");
//            } else if (current.left != null){
//                System.out.println("ok2");
//            } else if (current.right != null){
//                System.out.println("ok3");
//            } else {
//                current = null;
//            }
//        }
//    }

}
