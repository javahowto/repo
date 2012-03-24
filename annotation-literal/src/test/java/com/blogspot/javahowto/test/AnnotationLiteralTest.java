package com.blogspot.javahowto.test;

import com.blogspot.javahowto.*;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class AnnotationLiteralTest {
    private static List mixed = new LinkedList();
    private static CollectionManager collectionManager;

    @BeforeClass
    public static void setUp() throws Exception {
        for (int i = 0; i < 2; i++) {
            mixed.add(new Bag());
            mixed.add(new Basket());
        }
        collectionManager = new CollectionManager(mixed);
    }

    @Test
    public void testContainsGold() throws Exception {
        System.out.printf("contains Gold: %s%n%n", findBy("Gold"));
    }

    @Test
    public void testContainsFruit() throws Exception {
        System.out.printf("contains Fruit: %s%n%n", findBy("Fruit"));
    }

    @Test
    public void testContainsFruitGold() throws Exception {
        System.out.printf("contains Gold and Fruit: %s%n%n", findBy("Gold", "Fruit"));
    }

    /**
     * Finds all objects matching all criteria
     * @param criteria one or multiple search qualifiers
     * @return a collection of objects that match all the search qualifiers
     */
    private Collection findBy(final String... criteria) {
        Contains[] qualifiers = new Contains[criteria.length];
        for (int i = 0; i < criteria.length; i++) {
            final String s = criteria[i];
            Contains containsQualifier = new ContainsQualifier() {
                @Override
                public String value() {
                    return s;
                }
            };
            qualifiers[i] = containsQualifier;
        }
        return collectionManager.findBy(qualifiers);
    }
}
