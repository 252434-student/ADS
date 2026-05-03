import java.util.NoSuchElementException;

public class MyHashTable<K, V> {
    private class HashNode<K,V>{
        private K key;
        private V value;
        private HashNode<K,V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }
        public V getValue(){
            return this.value;
        }

        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<?, ?>[] chainArray;
    private int M = 11;
    private int size;


    private int hash(K key){
        return (key.hashCode() & 0x7fffffff)%size;
    }
    public void put(K key, V value){
        HashNode<?,?> tab[] = chainArray;
        if(value==null){
            throw new NullPointerException();
        }
        int index = hash(key);
        HashNode<K,V> node = (HashNode<K, V>) tab[index];
        for(; node != null; node = node.next){
            if((node.key.hashCode()==key.hashCode()) && node.key.equals(key)){
                node.value = value;
            }
        }
    }
    public V get(K key){
        HashNode<?,?> tab[] = chainArray;
        int index = hash(key);
        for(HashNode<?,?> h = tab[index]; h != null; h = h.next){
            if(h.key.hashCode()==key.hashCode() && h.key.equals(key)){
                return (V) h.value;
            }
        }
        return null;
    }
    public V remove(K key){
        HashNode<?,?> tab[] = chainArray;
        int index = hash(key);
        HashNode<K,V> h = (HashNode<K, V>) tab[index];
        for(HashNode<K,V> prev = null; h!=null; prev = h, h = h.next){
            if(h.key.hashCode()==key.hashCode() && h.key.equals(key)){
                if(prev != null){
                    prev.next = h.next;
                } else{
                    tab[index] = h.next;
                }
                V oldval = h.value;
                h.value = null;
                size--;
                return oldval;
            }
        }
        return null;
    }
    public boolean contains(V value){
        if(value == null){
            throw new NullPointerException();
        }
        HashNode<?,?> tab[] = chainArray;
        for(int i=0; i< tab.length;i++){
            if(tab[i].getValue() == value){
                return true;
            }
            else{
                continue;
            }
        }
        return false;
    }
    public K getKey(V value){
        if(value == null){
            throw new NullPointerException();
        }
        HashNode<?,?> tab[] = chainArray;
        for(int i=0; i< tab.length;i++){
            if(tab[i].getValue() == value){
                return (K) tab[i].getKey();
            }
            else{
                continue;
            }
        }
        throw new NoSuchElementException();
    }
}
