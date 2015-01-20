/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package xtend.examples

import java.util.Comparator
import java.util.function.Consumer
import java.util.function.Function
import java.util.function.Predicate
import java.util.stream.Collectors
import xtend.examples.data.Album
import xtend.examples.data.Averager
import xtend.examples.data.Person

import static xtend.examples.data.Person.Sex.*

import static extension xtend.examples.LocalDateExtensions.*

/**
 * Examples demonstrating the usage of Xtend with Java 8.
 * The examples have been taken from The Java Tutorials:
 * http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 * http://docs.oracle.com/javase/tutorial/collections/streams/index.html
 */
class Demo {
	
	def static void main(String[] args) {
		
		println('---The Java Tutorials: Lambda Expressions, Calculator example')
		new Calculator().demo
		
		val roster = #[
			new Person('Carl', 12/7/1995, MALE, 'carl@example.com'),
			new Person('Carla', 5/2/1977, FEMALE, 'carla@example.com'),
			new Person('Rocco', 20/10/2002, MALE, 'rocco@example.com'),
			new Person('Frederic', 1/9/1964, MALE, 'frederic@example.com'),
			new Person('Tom', 22/12/1991, MALE, 'tom@example.com'),
			new Person('Brunhild', 15/4/1920, FEMALE, 'brunhild@example.com')
		]
		
		println('---The Java Tutorials: Lambda Expressions, Approach 8')
		roster.processElements(
		    [gender == MALE && age >= 18 && age <= 25],
		    [emailAddress],
		    [println(it)]
		)

		println('---The Java Tutorials: Lambda Expressions, Approach 9')
		roster
			.stream
		    .filter[gender == MALE && age >= 18 && age <= 25]
		    .map[emailAddress]
		    .forEach[println(it)]
		
		println('---Same result using the Xtend library')
		roster
			.filter[gender == MALE && age >= 18 && age <= 25]
			.map[emailAddress]
			.forEach[println(it)]
		
		println('---The Java Tutorials: Aggregate Operations')
		val average = roster
		    .stream
		    .filter[gender == MALE]
		    .mapToInt[age]
		    .average
		    .getAsDouble
		println('average = ' + average)
		
		println('---The Java Tutorials: Aggregate Operations, The Stream.reduce Method')
		val totalAgeReduce = roster
		   .stream
		   .map[age]
		   .reduce(
		       0,
		       [$0 + $1])
		println('totalAgeReduce = ' + totalAgeReduce)
		
		println('---The Java Tutorials: Aggregate Operations, The Stream.collect Method')
		val averageCollect = roster
			.stream
		    .filter[gender == MALE]
		    .map[age]
		    .collect(
		    	[new Averager],
		    	[avg, i | avg.accept(i)],          // alternative: [$0.accept($1)]
		    	[avg1, avg2 | avg1.combine(avg2)]) // alternative: [$0.combine($1)]
		println('averageCollect = ' + averageCollect.average)
		val namesOfMaleMembersCollect = roster
		    .stream
		    .filter[gender == MALE]
		    .map[name]
		    .collect(Collectors.toList)
		println('namesOfMaleMembersCollect = ' + namesOfMaleMembersCollect)
		val namesByGender = roster
	        .stream
	        .collect(
	            Collectors.groupingBy(
	                [gender],
	                Collectors.mapping(
	                    [Person p | p.name],
	                    Collectors.toList)))
		println('namesByGender = ' + namesByGender)
		val totalAgeByGender = roster
	        .stream
	        .collect(
	            Collectors.groupingBy(
	                [gender],                      
	                Collectors.<Person, Integer>reducing(
	                    0,
	                    [age],
	                    [$0 + $1])))
		println('totalAgeByGender = ' + totalAgeByGender)
		val averageAgeByGender = roster
		    .stream
		    .collect(
		        Collectors.groupingBy(
		            [gender],                      
		            Collectors.<Person>averagingInt[age]))
		println('averageAgeByGender = ' + averageAgeByGender)
		
		println('---Same result using Xtend library')
		val namesOfMaleMembersXtend = roster
		    .filter[gender == MALE]
		    .map[name]
		    .toList
		println('namesOfMaleMembersXtend = ' + namesOfMaleMembersXtend)
		
		// Exercise 2
		val albums = <Album>newArrayList
		val favs1 = albums.filter[tracks.exists[rating >= 4]].sortBy[name]
		val favs2 = albums.stream.filter[tracks.stream.anyMatch[rating >= 4]]
				.sorted(Comparator.<Album, String>comparing[name])
				.collect(Collectors.toList)
		use(favs1, favs2)
	}
	
	/**
	 * Processor method used by one of the examples.
	 */
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
	
	/**
	 * A pseudo processor for marking the given objects as used.
	 */
	private static def use(Object... x) {}
	
}