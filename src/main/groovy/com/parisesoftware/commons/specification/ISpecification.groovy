package com.parisesoftware.commons.specification

interface ISpecification<T> {


    boolean isSatisfiedBy(T object)


    ISpecification<T> and(ISpecification<T> other)


    ISpecification<T> andNot(ISpecification<T> other)


    ISpecification<T> or(ISpecification<T> other)


    ISpecification<T> orNot(ISpecification<T> other)


}
