package com.blogspot.javahowto;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.LinkedList;

public class CollectionManager {
    private Collection collection;

    public CollectionManager(Collection collection) {
        this.collection = collection;
    }

    /**
     * Finds all objects matching all criteria represented by annotations
     * @param annotationsToMatch one or multiple search qualifiers
     * @return a collection of objects that match all the search qualifiers
     */
    public Collection findBy(Annotation... annotationsToMatch) {
        Collection result = new LinkedList();
        for(Object obj : collection) {
            boolean matched = false;
            Annotation[] classAnnotations = obj.getClass().getAnnotations();
            for(Annotation an : annotationsToMatch) {
                if(contains(classAnnotations, an)) {
                    matched = true;
                } else {
                    matched = false;
                    break;
                }
            }
            if(matched)
                result.add(obj);
        }
        return result;
    }

    /**
     * Checks if an array of Annotations contains an individual Annotation
     * @param annotations an array of annotations
     * @param ann an individual annotation
     * @return true if ann is equal to at least one of the element in annotations array; false otherwise
     */
    private boolean contains(Annotation[] annotations, Annotation ann) {
        for(Annotation a : annotations) {
            if(a.equals(ann)) {
                return true;
            }
        }
        return false;
    }
}
