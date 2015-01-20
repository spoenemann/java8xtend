/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package xtend.examples

import java.time.LocalDate
import java.time.Period
import org.eclipse.xtend.lib.annotations.Data

/**
 * Data structure for demonstrating the usage of Xtend with Java 8.
 * The examples have been taken from The Java Tutorials:
 * http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 */
@Data
class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    def getAge() {
        Period.between(birthday, LocalDate.now).years
    }

    def printPerson() {
        println(toString)
    }
    
}