package com.company.collections;

import java.util.*;

/**
 * Created by gk on 7/3/2017.
 */
public class ListCollections {

    public static <T extends Collection> void iterateListByForEachLoop(T elements) {
        if (elements != null && !elements.isEmpty()) {
            for (Object element : elements) {
                System.out.println(element);
            }
        }
    }

    public static <T extends List> List<T> removeDuplicatesFromListByHashSet(T elements) {
        if (elements != null && !elements.isEmpty()) {
            HashSet<T> setOfElementsWithoutDuplications = new HashSet<>(elements);
            ArrayList<T> listOfElementsWthoutDuplications = new ArrayList<>(setOfElementsWithoutDuplications);
            return listOfElementsWthoutDuplications;
        }
        return Collections.emptyList();
    }

    public static <T extends List> List<T> removeDuplicateFromListByLinkedHashSet(T elements) {
        if (elements != null && !elements.isEmpty()) {
            LinkedHashSet<T> setOfElementsWithoutDuplications = new LinkedHashSet<>(elements);
            ArrayList<T> listOfElementsWthoutDuplications = new ArrayList<>(setOfElementsWithoutDuplications);
            return listOfElementsWthoutDuplications;
        }
        return Collections.emptyList();
    }

    public static <T> void countDuplicationsInCollection(Collection<T> elements){
        HashMap<T, Integer> counterElementsMap = new HashMap<>();
        Set<Map.Entry<T, Integer>> keyValue = counterElementsMap.entrySet();
        for ( T element : elements) {
            if(!counterElementsMap.containsKey(element)){
                counterElementsMap.put(element, 1);
            }else {
                counterElementsMap.put(element, counterElementsMap.get(element) + 1);
            }
        }
        for (Map.Entry<T, Integer> entry : keyValue){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // TODO: 7/3/2017 write this method
    public static <T> void countDuplicationsInCollectionJava8(Collection<T> elements){
    }
}
