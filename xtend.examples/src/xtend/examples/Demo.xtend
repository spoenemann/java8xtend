/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package xtend.examples

import java.util.function.Consumer
import java.util.function.Function
import java.util.function.Predicate

import static xtend.examples.Person.Sex.*

import static extension xtend.examples.LocalDateExtensions.*

/**
 * Examples demonstrating the usage of Xtend with Java 8.
 * The examples have been taken from The Java Tutorials:
 * http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 */
class Demo {
	
	static def <X, Y> void processElements(
		    Iterable<X> source,
		    Predicate<X> tester,
		    Function <X, Y> mapper,
		    Consumer<Y> block) {
	    for (X p : source) {
	        if (tester.test(p)) {
	            val data = mapper.apply(p)
	            block.accept(data)
	        }
	    }
	}
	
	def static void main(String[] args) {
		val roster = #[
			new Person('Carl', 12/7/1995, MALE, 'carl@example.com'),
			new Person('Carla', 5/2/1977, FEMALE, 'carla@example.com'),
			new Person('Rocco', 20/10/2002, MALE, 'rocco@example.com'),
			new Person('Frederic', 1/9/1964, MALE, 'frederic@example.com'),
			new Person('Tom', 22/12/1991, MALE, 'tom@example.com'),
			new Person('Brunhild', 15/4/1920, FEMALE, 'brunhild@example.com')
		]
		
		// The Java Tutorials: Lambda Expressions, Approach 8
		roster.processElements(
		    [gender == MALE && age >= 18 && age <= 25],
		    [emailAddress],
		    [println(it)]
		)

		println('-----------------')

		// The Java Tutorials: Lambda Expressions, Approach 9
		roster
			.stream
		    .filter[gender == MALE && age >= 18 && age <= 25]
		    .map[emailAddress]
		    .forEach[println(it)]
		
		println('-----------------')
		
		// Using the Xtend library
		roster
			.filter[gender == MALE && age >= 18 && age <= 25]
			.map[emailAddress]
			.forEach[println(it)]
	}
	
}