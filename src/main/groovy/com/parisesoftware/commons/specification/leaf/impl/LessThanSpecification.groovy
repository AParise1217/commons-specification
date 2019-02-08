package com.parisesoftware.commons.specification.leaf.impl

class LessThanSpecification<T> extends CompareToSpecification<T> {

    private static final int LESS_THAN_COMPARATOR = -1

    LessThanSpecification(String attributeName, T value) {
        super(attributeName, value, LESS_THAN_COMPARATOR)
    }

}
