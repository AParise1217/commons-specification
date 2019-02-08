package com.parisesoftware.commons.specification

class NegationSpecification<T> extends CompositeSpecification<T> {

    private ISpecification<T> other

    NegationSpecification(ISpecification<T> other) {
        this.other = other
    }

    @Override
    boolean isSatisfiedBy(T object) {
        return !this.other.isSatisfiedBy(object)
    }

}
