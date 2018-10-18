package nl.hva.ict.ds.util;

import nl.hva.ict.ds.Player;

import java.util.List;
// Quin
public class DoubleHashingMultiValueSymbolTable implements MultiValueSymbolTable<String, Player> {


    /**
     * @param arraySize
     */
    public DoubleHashingMultiValueSymbolTable(int arraySize) {
        //size must be larger
    }

    /**
     * @param key   the key to use.
     * @param value the value to be stored.
     */
    @Override
    public void put(String key, Player value) {

    }

    /**
     * @param key the key for which the values must be returned.
     * @return
     */
    @Override
    public List<Player> get(String key) {
        return null;
    }

    //method for detecting collissions
}
