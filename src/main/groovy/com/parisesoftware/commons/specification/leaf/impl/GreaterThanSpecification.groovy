package com.parisesoftware.commons.specification.leaf.impl

class GreaterThanSpecification<T> extends CompareToSpecification<T> {

    private static final int GREATER_THAN_COMPARATOR = 1

    GreaterThanSpecification(String attributeName, T value) {
        super(attributeName, value, GREATER_THAN_COMPARATOR)
    }

}
