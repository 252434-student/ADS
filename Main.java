import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BST<Integer, String> bst = new BST<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter int ans string pair of values: ");
        bst.put(sc.nextInt(), sc.nextLine());
        bst.put(1,"apple");
        bst.put(21,"broth");
        bst.put(3,"milk");
        bst.put(8,"banan");
        bst.display();
        System.out.println("Value assigned to key 1 is: "+bst.get(1));
        bst.remove(21);
    }
}