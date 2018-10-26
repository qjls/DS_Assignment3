package nl.hva.ict.ds.util;

import nl.hva.ict.ds.Player;



import java.util.ArrayList;
import java.util.List;

public class QuadraticProbingMultiValueSymbolTable implements MultiValueSymbolTable<String, Player> {
    private int N= 0;
    private Player[] players;
    private String[] keys;

    private int size; // initial size, collission variable




    /**
     * @param arraySize initial size for Table <keys array, players array>.
     */
    public QuadraticProbingMultiValueSymbolTable(int arraySize) {
        size = arraySize;
        players = new Player[size];
        keys = new String[size];

    }

    /**
     * @param key   the key to use.
     * @param value the value to be stored.
     */
    @Override
    public void put(String key, Player value) {

        int q = 0;
        if (isEmpty()){

            add(hash(key,q)%size,key,value);
        }else{
            AddToFilledArray(hash(key,q)%size, key, value,q);
        }
    }

    /**
     * Checks keys array to see if it has key and add to quadratic equivelant of that key.
     *
     * @param key original key value in string
     * @param value player object
     */
    private void AddToFilledArray(int index, String key, Player value, int q){
        int t;

        if (index>=(size/2)) {resize(size*2);} //resizes table incase index is larger than half the size.

        if (checkCollission(index, key)){
            q++;

            t = hash(key,q);
            AddToFilledArray(t%size, key,value, q);
        }else{
            add(index,key,value);
        }
    }
    /**
     * @param key the key for which the values must be returned.
     * @return list with matching keys
     */
    @Override
    public List<Player> get(String key) {
        List<Player> l = new ArrayList<>();

        for (int i = 0;  i<keys.length ; i++){
            if (keys[i]!=null){
                if (keys[i].equals(key)){
                    l.add(players[i]);
                }
            }
        }

        return l;
    }


    /**
     * Convert string value to a hash key value.
     * @param k key to hash
     * @return int index value from @param key.
     */
    private int hash(String k,int q){
        int i=0;
        if (q!=0){
            i = (int) Math.pow(q,2);
        }
        return  Math.abs(((k.hashCode()& 0x7fffffff) +(i)));
    }
    /**
     * Checks if Symbol table is empty.
     * @return true if Symbol table is empty, false if not empty.
     */
    public boolean isEmpty(){
            return size()==0;
    }

    /**
     * Returns amount of entries added to the table.
     * @return N in amount of entries added to the table.
     */
    public int size(){
        return N;
    }


    /**
     * Adds values to the respective arrays.
     * @param index is index value for each array.
     * @param key is string to be added to keys array.
     * @param value is object to be added to players array.
     */
    private void add (int index, String key, Player value){
            if(keys[index]==null){

                keys[index] = key;
                players[index] = value;
                N++;

            }else {
                index = hash(key, 1);
                add(index, key, value, 1);
            }
    }


    /**
     * Adds values to the respective arrays.
     * @param index is index value for each array.
     * @param key is string to be added to keys array.
     * @param value is object to be added to players array.
     * @param q is differentiato in quadratic formula.
     */
    private void add (int index, String key, Player value, int q){
        if ( q>0){

            if(keys[index]==null){

                keys[index] = key;
                players[index] = value;
                N++;
            }else {
                index = hash(key, q++);
                add(index, key, value, q);
            }
        }
    }


    /**
     * Checks if there's a value at the given index;
     * @param index is key to check in keys array.
     * @return true if index is not empty, else returns false.
     */
    private boolean checkCollission(int index, String key) {
        if(keys[index]!=null){

            System.out.println("Collission for @oldkey: "+keys[index]+ " , @newkey: "+ key+ "@index: "+ index);
            return true;
        }else {
            return false;
        }
    }

    /**
     * Resizes the arrays and symbol-table.
     * @param size is the new size to be used;
     */
    private void resize(int size){
        QuadraticProbingMultiValueSymbolTable q = new QuadraticProbingMultiValueSymbolTable(size);

       for (int i = 0; i<keys.length; i++){
            if(keys[i] !=null){
                q.put(keys[i],players[i]);
            }
        }

        this.keys=q.keys;
        this.players = q.players;
        this.size = q.size;
    }

}
