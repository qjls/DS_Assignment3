package nl.hva.ict.ds.util;

import nl.hva.ict.ds.Player;

import java.util.List;

public class QuadraticProbingMultiValueSymbolTable implements MultiValueSymbolTable<String, Player> {

    /**
     * @param arraySize
     */
    public QuadraticProbingMultiValueSymbolTable(int arraySize) {

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
