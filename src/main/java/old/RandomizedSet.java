package old;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {

    Map<Integer, Integer> valToIdx;
    List<Integer> list;

    public RandomizedSet() {
        valToIdx = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(valToIdx.containsKey(val)) {
            return false;
        }

        valToIdx.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!valToIdx.containsKey(val)) {
            return false;
        }

        int idx = valToIdx.get(val);
        valToIdx.remove(val);

        if(idx == list.size() - 1) {
            list.remove(list.size() - 1);
        } else {
            int tempVal = list.get(list.size() - 1);
            list.set(idx, tempVal);
            valToIdx.put(tempVal, idx);
            list.remove(list.size() - 1);
        }
        return true;
    }

    public int getRandom() {
        int rand = (int) (Math.random() * list.size());
        return list.get(rand);
    }




}
