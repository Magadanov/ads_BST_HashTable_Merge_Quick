package BST;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyBST<Integer, Integer> myBST = new MyBST<Integer, Integer>();
        myBST.put(5,10);
        myBST.put(4,50);
        myBST.put(6,80);
        myBST.put(3,20);
        myBST.put(9,40);
        myBST.delete(3);
    }
}
