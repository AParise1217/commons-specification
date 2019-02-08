package com.parisesoftware.commons.specification.composite

import com.parisesoftware.commons.specification.CompositeSpecification
import com.parisesoftware.commons.specification.ISpecification

/**
 * !OR Specification
 */
class OrNotSpecification<T> extends CompositeSpecification<T> {

    private ISpecification<T> left
    private ISpecification<T> right

    OrNotSpecification(ISpecification<T> left, ISpecification<T> right) {
        this.left = left
        this.right = right
    }

    @Override
    boolean isSatisfiedBy(T object) {
        return !(this.left.isSatisfiedBy(object) || right.isSatisfiedBy(object))
    }

}
