package com.parisesoftware.commons.specification.leaf.impl

import com.parisesoftware.commons.specification.leaf.ValueBoundSpecification
import org.apache.commons.lang3.builder.CompareToBuilder

abstract class CompareToSpecification<T> extends ValueBoundSpecification<T> {

    private final int comparatorAsInt

    CompareToSpecification(String attributeName, T value, int comparatorAsInt) {
        super(attributeName, value)
        this.comparatorAsInt = comparatorAsInt
    }

    @Override
    protected boolean isSatisfyingValue(Object value) {
        return new CompareToBuilder().append(this.value, value).toComparison() == comparatorAsInt
    }

}
