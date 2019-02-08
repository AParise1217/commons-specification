package com.parisesoftware.commons.specification.leaf

import com.parisesoftware.commons.specification.LeafSpecification

abstract class ValueBoundSpecification<T> extends LeafSpecification<T> {

    String attributeName

    T value

    ValueBoundSpecification(String attributeName, T value) {
        this.attributeName = attributeName
        this.value = value
    }

    @Override
    final boolean isSatisfiedBy(T object) {
        return isSatisfyingValue(object[this.attributeName])
    }

    protected abstract boolean isSatisfyingValue(Object value)

}
