public class BST<K extends Comparable<K>, V> {
    private Node root;
    private class Node{
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V val){
            this.key = key;
            this.value = val;
        }
    }
    public void put(K key, V val){
        root = puter(root, key, val);
    }
    private Node puter(Node root,K key, V val){
        if(root == null){
            root = new Node(key, val);
            return root;
        }
        else if(key.compareTo(root.key)<0){
            root.left = puter(root.left, key, val);
        }
        else if(key.compareTo(root.key)>0){
            root.right = puter(root.right, key, val);
        }
        return root;
    }
    public void display(){
        displayer(root);
    }
    private void displayer(Node root){
        if(root != null){
            displayer(root.left);
            System.out.println(root.value);
            displayer(root.right);
        }
    }
    public V get(K key){
        return getter(root, key);
    }
    private V getter(Node root, K key){
        if(root == null){
            return null;
        }
        else if(root.key.compareTo(key)==0){
            return root.value;
        }
        else if(root.key.compareTo(key)>0){
            return getter(root.left, key);
        }
        else if(root.key.compareTo(key)<0){
            return getter(root.right, key);
        }
        return root.value;
    }
    public void remove(K key){
        if(get(key)==null){
            System.out.println("This value does not exist");
        }
        else{
            remover(root, key);
        }
    }
    private Node remover(Node root, K key){
        if(root == null){
            return root;
        }
        else if(root.key.compareTo(key)>0){
            remover(root.left, key);
        }
        else if(root.key.compareTo(key)<0){
            remover(root.right, key);
        }
        else{
            if(root.left==null && root.right==null){
                root = null;
            }
            else if(root.right != null){
                root = successor(root);
                root.right = remover(root.right, root.key);
            }
            else{
                root = predecessor(root);
                root.left = remover(root.left, root.key);
            }
        }
        return root;
    }
    private Node successor(Node root){
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    private Node predecessor(Node root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root;
    }
}
