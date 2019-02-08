package com.parisesoftware.commons.specification

import com.parisesoftware.commons.specification.composite.AndNotSpecification
import com.parisesoftware.commons.specification.composite.AndSpecification
import com.parisesoftware.commons.specification.composite.OrNotSpecification
import com.parisesoftware.commons.specification.composite.OrSpecification

abstract class CompositeSpecification<T> implements ISpecification<T> {

    abstract boolean isSatisfiedBy(T object)

    @Override
    ISpecification<T> and(ISpecification<T> other) {
        return new AndSpecification(this, other)
    }

    @Override
    ISpecification<T> andNot(ISpecification<T> other) {
        return new AndNotSpecification<T>(this, other)
    }

    @Override
    ISpecification<T> or(ISpecification<T> other) {
        return new OrSpecification<T>(this, other)
    }

    @Override
    ISpecification<T> orNot(ISpecification<T> other) {
        return new OrNotSpecification<T>(this, other)
    }

}
