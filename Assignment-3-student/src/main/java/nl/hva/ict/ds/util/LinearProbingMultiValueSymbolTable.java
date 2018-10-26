package nl.hva.ict.ds.util;

import nl.hva.ict.ds.Player;

import java.util.ArrayList;
import java.util.List;


public class LinearProbingMultiValueSymbolTable implements MultiValueSymbolTable<String, Player> {

    private int M;
    private String[] keys;
    private Player[] vals;

    private int collisions;

    public LinearProbingMultiValueSymbolTable(int arraySize) {
        M = arraySize;
        keys = new String[M];
        vals = new Player[M];
        collisions = 0;
    }
    // generates hash number
    private int hash(String key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public void put(String key, Player value) {
        int i;

        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            collisions++;
            if (keys[i] == null) {
                keys[i] = key;
                vals[i] = value;
                return;
            }
        }
        keys[i] = key;
        vals[i] = value;
    }

    @Override
    public List<Player> get(String key) {
        List<Player> playerList = new ArrayList<>();
        System.out.println("Collissions count: "+getCollisions());

        for (int i = 0; i < M; i++) {
            if (key.equals(keys[i])) {
                playerList.add(vals[i]);
            }
        }
        return playerList;
    }

    public int getCollisions() {
        return collisions;
    }
}
