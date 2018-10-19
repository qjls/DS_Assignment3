package nl.hva.ict.ds.util;

import nl.hva.ict.ds.Player;

import java.util.ArrayList;
import java.util.List;

public class QuadraticProbingMultiValueSymbolTable implements MultiValueSymbolTable<String, Player> {
    private int N;
    private Player[] players;
    private String[] keys;
    private List<Player> list;
    private int size;

    /**
     * @param arraySize
     */
    public QuadraticProbingMultiValueSymbolTable(int arraySize) {
        N=0;
        size = arraySize;
        players = new Player[size^2];
        keys = new String[size^2];

        list = new ArrayList<>();
    }

    /**
     * @param key   the key to use.
     * @param value the value to be stored.
     */
    @Override
    public void put(String key, Player value) {
        int hashedkey = hashing(key);
        if (keys.length==0){
            keys[N++] = key;
            players[N++]= value;
            list.set(N++, value);
        }else{
            AddToFilledArray(hashedkey, key, value);
        }
    }

    /**
     * Checks keys array to see if it has key and add to quadratic equivelant of that key.
     * @param hashedkey  hashed version of the key
     * @param key original key value in string
     * @param value player object
     */
    private void AddToFilledArray(int hashedkey, String key, Player value){
        for (int i = hashedkey; i <keys.length; i++) {
            if (hasKey(i)){
                N++;
                //check if key is present use get method
                String t = new  String(Integer.toString(i));
                int k = hashing(t);
                keys[k] = key;
                players[k] = value;
                list.set(k,value);

            }else{
                keys[i] = key;
                players[i] = value;
                list.set(i,value);
            }


        }
    }
    /**
     * @param key the key for which the values must be returned.
     * @return list with matching keys
     */
    @Override
    public List<Player> get(String key) {
        List<Player> l = new ArrayList<>();

        for (String k: keys){
            if(k == key){
                l.add(players[hashing(key)]);
            }
        }

        return l;
    }

    private int hashing (String key){
        return  (key.hashCode()+N*N%size);
    }

    /** Note* try recursion
     * @param key to check in keys array
     * @return true if key is found in array
     */
    private boolean hasKey(int key){
        for (String ikey : keys){
            if (ikey.equals(key)){
                return true;
            }
        }
        return false;
    }

    //method for detecting collissions
}
