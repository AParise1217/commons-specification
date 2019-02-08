package com.parisesoftware.commons.specification.leaf.impl

import com.parisesoftware.commons.specification.ISpecification
import spock.lang.Specification

class EqualToSpecificationTest extends Specification {

    def "isSatisfyingValue(): should properly evaluate different strings"() {

        given: 'a sample value'
        String testString = 'Yarn'

        and: 'a new EqualToSpec is instantiated with the sample value'
        EqualToSpecification<String> equalsSpec =
                new EqualToSpecification<String>('Strings are the same', testString)

        when: 'the EqualToSpec\'s isSatisfyingValue method is invoked with a different String'
        String differentString = 'NPM'
        boolean resultant = equalsSpec.isSatisfyingValue(differentString)

        then: 'we verify that the Strings are actually different'
        testString != differentString

        and: 'the resultant of isSatisfyingValue() is false'
        !resultant
    }

    def "isSatisfiedBy(): should properly evaluate the same strings"() {

        given: 'a sample value'
        String testString = 'Yarn'

        and: 'a new EqualToSpec is instantiated with the sample value'
        ISpecification<String> equalsSpec =
                new EqualToSpecification<String>('Strings are the same', testString)

        when: 'the EqualToSpec\'s isSatisfyingValue method is invoked with the same String'
        boolean resultant = equalsSpec.isSatisfyingValue(testString)

        then: 'we verify that the Strings are actually equal'
        testString == testString

        and: 'the resultant of isSatisfyingValue() is true'
        resultant
    }

    def "isSatisfiedBy(): should properly evaluate when used in an AND NOT Spec"() {

        given: 'a new EqualToSpec for checking if a String equals Yarn'
        ISpecification equalsYarn = new EqualToSpecification<String>('value', 'Yarn')

        and: 'another EqualToSpec for checking if a String equals NPM'
        ISpecification equalsNPM = new EqualToSpecification<String>('value', 'NPM')

        and: 'another Spec is instantiated, which verifies if a String equals Yarn and not NPM'
        ISpecification equalsYarnAndNotNPM = equalsYarn.andNot(equalsNPM)

        when: 'we assert if the EqualsYarnNotNPM spec is satisfied by Yarn'
        boolean resultant = equalsYarnAndNotNPM.isSatisfiedBy('Yarn')

        then: 'the resultant of isSatisfyingValue() is true'
        resultant
    }

    def "isSatisfiedBy(): should properly evaluate when used in an OR"() {

        given: 'a new EqualToSpec for checking if a String equals Yarn'
        ISpecification equalsYarn = new EqualToSpecification<String>('value', 'Yarn')

        and: 'another EqualToSpec for checking if a String equals NPM'
        ISpecification equalsNPM = new EqualToSpecification<String>('value', 'NPM')

        and: 'another Spec is instantiated, which verifies if a String equals Yarn and not NPM'
        ISpecification equalsYarnOrNPM = equalsYarn.or(equalsNPM)

        when: 'we assert if the EqualsYarnOrNPM spec is satisfied by Yarn'
        boolean resultant1 = equalsYarnOrNPM.isSatisfiedBy('Yarn')

        and: 'we assert if the EqualsYarnOrNPM spec is satisfied by NPM'
        boolean resultant2 = equalsYarnOrNPM.isSatisfiedBy('NPM')

        then: 'the first resultant of isSatisfyingValue() is true'
        resultant1

        and: 'the second resultant of isSatisfyingValue() is true'
        resultant2
    }

}
