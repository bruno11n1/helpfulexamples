package com.company.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by gk on 7/3/2017.
 */
public class ListCollectionsTest {
    private String[] elementsArray;

    private String[] elementsArrayWithDuplicates;
    private List<String> elements;
    private List<String> elementsWithDuplications;
    @Before
    public void init() {
        elementsArray = new String[]{"ANDROID", "JSP", "JAVA", "STRUTS", "HADOOP", "JSF"};
        elementsArrayWithDuplicates = new String[]{"ANDROID", "JSP", "JAVA", "STRUTS", "HADOOP", "JSF", "ANDROID", "JSP", "JAVA", "STRUTS", "HADOOP", "JSF", "ANDROID", "JSP", "JAVA", "STRUTS", "HADOOP", "JSF"};
        elements = new ArrayList<>(Arrays.asList(elementsArray));
        elementsWithDuplications = new ArrayList<String>(Arrays.asList(elementsArrayWithDuplicates));

    }

    @Test
    public void shouldIterateListByForEachLoop() throws Exception {
        ListCollections.iterateListByForEachLoop(elements);
    }
    @Test
    public void shouldRemoveDuplicatesFromListByHashSet() throws Exception {
        assertEquals(Collections.emptyList(), ListCollections.removeDuplicatesFromListByHashSet(null));
    }

    @Test
    public void shouldRemoveDuplicatesFromListByLinkedHashSet() throws Exception {
        assertEquals(elements, ListCollections.removeDuplicateFromListByLinkedHashSet(elementsWithDuplications));
    }

    @Test
    public void shouldCountDuplicationsInCollection() throws Exception {
        ListCollections.countDuplicationsInCollection(elementsWithDuplications);
    }

    @Test
    public void shouldCountDuplicationsInCollectionJava8() throws Exception {
        ListCollections.countDuplicationsInCollectionJava8(elementsWithDuplications);
    }



}