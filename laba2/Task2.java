import java.util.Random;
import java.util.LinkedList;
import java.lang.*;

class Hashtable {
    private Integer[] intArray;
    private LinkedList<Integer>[] intLinkedList;
    private int size;

    public Hashtable(int size){
        this.size = size;
        intArray = new Integer[size];
        intLinkedList = new LinkedList[size];
    }

    private int hash(int key){
        return key % size;
    }

    private int simple_rehash(int i){
        return (i + 1) % size;
    }

    private int fake_rehash(int i, Random random){
        return (i + Math.abs(random.nextInt(size))) % size;
    }

    public int size(){
        return size;
    }

    public Integer get(int i){
        return intArray[i];
    }


    public void insert_chain(int key){
        Integer item = new Integer(key);
        int i = hash(key);

        if(intLinkedList[i] == null){
            intLinkedList[i] = new LinkedList<Integer>();
        }
        intLinkedList[i].add(item);
    }

    public void insert_simple(int key){
        Integer item = new Integer(key);
        int i = hash(key);

        while(intArray[i] != null){
            i = simple_rehash(i);
        }
        intArray[i] = item;
    }

    public void insert_fake(int key){
        Integer item = new Integer(key);
        int i = hash(key);
        Random random = new Random(i);

        while(intArray[i] != null){
            i = fake_rehash(i, random);
        }
        intArray[i] = item;
    }

    public boolean search_fake(int key){
        int i = hash(key);
        Random random = new Random(i);

        while(intArray[i] != null && intArray[i] != key){
            i = fake_rehash(i, random);
        }
        if(intArray[i] == null){
            return false;
        }
        return true;
    }

    public boolean search_simple(int key){
        int i = hash(key);

        while(intArray[i] != null && intArray[i] != key){
            i = simple_rehash(i);
        }
        if(intArray[i] == null){
            return false;
        }
        return true;
    }

    public boolean search_chain(int key){
        int i = hash(key);

        if(intLinkedList[i] == null){
            return false;
        }
        else{
            if(intLinkedList[i].contains(key)){
                return true;
            }else{
                return false;
            }
        }
    }

    public void delete_chain(int key){
        int i = hash(key);

        if(intLinkedList[i] != null){
            if(intLinkedList[i].contains(key)){
                intLinkedList[i].remove(key);
            }
        }
    }

    public void delete_simple(int key){
        int i = hash(key);

        while(intArray[i] != null && intArray[i] != key){
            i = simple_rehash(i);
        }
        intArray[i] = null;
    }

    public void delete_fake(int key){
        int i = hash(key);
        Random rand = new Random(i);

        while(intArray[i] != null && intArray[i] != key){
            i = fake_rehash(i, rand);
        }
        intArray[i] = null;
    }

}