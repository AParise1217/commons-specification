package com.parisesoftware.commons.specification.leaf.impl

import com.parisesoftware.commons.specification.leaf.ValueBoundSpecification
import org.apache.commons.lang3.StringUtils

class EqualToSpecification<T> extends ValueBoundSpecification<T> {

    EqualToSpecification(String attributeName, T value) {
        super(attributeName, value)
    }

    @Override
    protected boolean isSatisfyingValue(Object value) {

        if (isString(value) && isString(this.value)) {
            String valueAsString = new String(value as String)
            return StringUtils.equals(this.value as CharSequence, valueAsString)
        }

        return Objects.equals(this.value, value)
    }

    private boolean isString(Object value) {
        return (
                value instanceof char[]
                        || value instanceof CharSequence
                        || value instanceof String
        )
    }

}
