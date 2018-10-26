package nl.hva.ict.ds.util;

import nl.hva.ict.ds.Player;

import java.util.List;
// Quin
public class DoubleHashingMultiValueSymbolTable implements MultiValueSymbolTable<String, Player> {

    private int M; // number of key value pairs in the symbol table
    private String[] keys;
    private Player[] vals;
    private final int size; // size of linear probing table
    private int collisions;

    public DoubleHashingMultiValueSymbolTable(int arraySize){
        size = arraySize;
        keys = new String[arraySize];
        vals = new Player[arraySize];
        collisions= 0;
    }

    @Override
    public void put(String key, Player value) {
        if (key == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }
        if (value == null) {
            delete(key);
            return;
        }
    }

    @Override
    public List<Player> get(String key) {
        return null;
    }

    private void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
