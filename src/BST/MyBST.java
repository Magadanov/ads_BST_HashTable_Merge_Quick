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

    private void delete(K key, Node root){
        Node current = root;
        int cmp = current.key.compareTo(key);
        if (cmp > 0){
            delete(current.left.key, current.left);
        } else if (cmp < 0) {
            delete(current.right.key, current.right);
        } else {
            if(current.left != null && current.right != null){
                // to find min element of right side
                Node MinRightCurrent = getRightMin(current.right);
                current.right = deleteRightMin(current.right);
                current.key = MinRightCurrent.key;
                current.value = MinRightCurrent.value;
                // to find max element of left side
//                Node MaxLeftCurrent = getLeftMax(current.left);
//                current.left = deleteLeftMax(current.left);
//                current.key = MaxLeftCurrent.key;
//                current.value = MaxLeftCurrent.value;
            } else if (current.left != null){
                Node MinRightCurrent = getRightMin(current.left);
                current.right = deleteRightMin(current.left);
                current.key = MinRightCurrent.key;
                current.value = MinRightCurrent.value;
            } else if (current.right != null){
                Node MinRightCurrent = getRightMin(current.right);
                current.right = deleteRightMin(current.right);
                current.key = MinRightCurrent.key;
                current.value = MinRightCurrent.value;
            } else {
                current.key = null;
                current.value = null;
            }
        }
    }

    private Node getRightMin(Node currentRight){
        if (currentRight.left == null){
            return currentRight;
        }
        return getRightMin(currentRight.left);
    }


    private Node deleteRightMin(Node currentRight){
        if (currentRight.left == null){
            if (currentRight.right != null) return currentRight.right;
            return null;
        }
        return deleteRightMin(currentRight.left);
    }

    private Node getLeftMax(Node currentLeft){
        if (currentLeft.right == null){
            return currentLeft;
        }
        return getLeftMax(currentLeft.right);
    }


    private Node deleteLeftMax(Node currentLeft){
        if (currentLeft.right == null){
            if (currentLeft.left != null) return currentLeft.left;
            return null;
        }
        return deleteLeftMax(currentLeft.right);
    }
}
