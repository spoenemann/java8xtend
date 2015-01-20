/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package xtend.examples;

import com.google.common.base.Objects;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import xtend.examples.LocalDateExtensions;
import xtend.examples.Person;

/**
 * Examples demonstrating the usage of Xtend with Java 8.
 * The examples have been taken from The Java Tutorials:
 * http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 */
@SuppressWarnings("all")
public class Demo {
  public static <X extends Object, Y extends Object> void processElements(final Iterable<X> source, final Predicate<X> tester, final Function<X, Y> mapper, final Consumer<Y> block) {
    for (final X p : source) {
      boolean _test = tester.test(p);
      if (_test) {
        final Y data = mapper.apply(p);
        block.accept(data);
      }
    }
  }
  
  public static void main(final String[] args) {
    LocalDate _divide = LocalDateExtensions.operator_divide(12, 7);
    LocalDate _divide_1 = LocalDateExtensions.operator_divide(_divide, 1995);
    Person _person = new Person("Carl", _divide_1, Person.Sex.MALE, "carl@example.com");
    LocalDate _divide_2 = LocalDateExtensions.operator_divide(5, 2);
    LocalDate _divide_3 = LocalDateExtensions.operator_divide(_divide_2, 1977);
    Person _person_1 = new Person("Carla", _divide_3, Person.Sex.FEMALE, "carla@example.com");
    LocalDate _divide_4 = LocalDateExtensions.operator_divide(20, 10);
    LocalDate _divide_5 = LocalDateExtensions.operator_divide(_divide_4, 2002);
    Person _person_2 = new Person("Rocco", _divide_5, Person.Sex.MALE, "rocco@example.com");
    LocalDate _divide_6 = LocalDateExtensions.operator_divide(1, 9);
    LocalDate _divide_7 = LocalDateExtensions.operator_divide(_divide_6, 1964);
    Person _person_3 = new Person("Frederic", _divide_7, Person.Sex.MALE, "frederic@example.com");
    LocalDate _divide_8 = LocalDateExtensions.operator_divide(22, 12);
    LocalDate _divide_9 = LocalDateExtensions.operator_divide(_divide_8, 1991);
    Person _person_4 = new Person("Tom", _divide_9, Person.Sex.MALE, "tom@example.com");
    LocalDate _divide_10 = LocalDateExtensions.operator_divide(15, 4);
    LocalDate _divide_11 = LocalDateExtensions.operator_divide(_divide_10, 1920);
    Person _person_5 = new Person("Brunhild", _divide_11, Person.Sex.FEMALE, "brunhild@example.com");
    final List<Person> roster = Collections.<Person>unmodifiableList(CollectionLiterals.<Person>newArrayList(_person, _person_1, _person_2, _person_3, _person_4, _person_5));
    final Predicate<Person> _function = (Person it) -> {
      boolean _and = false;
      boolean _and_1 = false;
      Person.Sex _gender = it.getGender();
      boolean _equals = Objects.equal(_gender, Person.Sex.MALE);
      if (!_equals) {
        _and_1 = false;
      } else {
        int _age = it.getAge();
        boolean _greaterEqualsThan = (_age >= 18);
        _and_1 = _greaterEqualsThan;
      }
      if (!_and_1) {
        _and = false;
      } else {
        int _age_1 = it.getAge();
        boolean _lessEqualsThan = (_age_1 <= 25);
        _and = _lessEqualsThan;
      }
      return _and;
    };
    final Function<Person, String> _function_1 = (Person it) -> {
      return it.getEmailAddress();
    };
    final Consumer<String> _function_2 = (String it) -> {
      InputOutput.<String>println(it);
    };
    Demo.<Person, String>processElements(roster, _function, _function_1, _function_2);
    InputOutput.<String>println("-----------------");
    Stream<Person> _stream = roster.stream();
    final Predicate<Person> _function_3 = (Person it) -> {
      boolean _and = false;
      boolean _and_1 = false;
      Person.Sex _gender = it.getGender();
      boolean _equals = Objects.equal(_gender, Person.Sex.MALE);
      if (!_equals) {
        _and_1 = false;
      } else {
        int _age = it.getAge();
        boolean _greaterEqualsThan = (_age >= 18);
        _and_1 = _greaterEqualsThan;
      }
      if (!_and_1) {
        _and = false;
      } else {
        int _age_1 = it.getAge();
        boolean _lessEqualsThan = (_age_1 <= 25);
        _and = _lessEqualsThan;
      }
      return _and;
    };
    Stream<Person> _filter = _stream.filter(_function_3);
    final Function<Person, String> _function_4 = (Person it) -> {
      return it.getEmailAddress();
    };
    Stream<String> _map = _filter.<String>map(_function_4);
    final Consumer<String> _function_5 = (String it) -> {
      InputOutput.<String>println(it);
    };
    _map.forEach(_function_5);
    InputOutput.<String>println("-----------------");
    final Function1<Person, Boolean> _function_6 = (Person it) -> {
      boolean _and = false;
      boolean _and_1 = false;
      Person.Sex _gender = it.getGender();
      boolean _equals = Objects.equal(_gender, Person.Sex.MALE);
      if (!_equals) {
        _and_1 = false;
      } else {
        int _age = it.getAge();
        boolean _greaterEqualsThan = (_age >= 18);
        _and_1 = _greaterEqualsThan;
      }
      if (!_and_1) {
        _and = false;
      } else {
        int _age_1 = it.getAge();
        boolean _lessEqualsThan = (_age_1 <= 25);
        _and = _lessEqualsThan;
      }
      return Boolean.valueOf(_and);
    };
    Iterable<Person> _filter_1 = IterableExtensions.<Person>filter(roster, _function_6);
    final Function1<Person, String> _function_7 = (Person it) -> {
      return it.getEmailAddress();
    };
    Iterable<String> _map_1 = IterableExtensions.<Person, String>map(_filter_1, _function_7);
    final Consumer<String> _function_8 = (String it) -> {
      InputOutput.<String>println(it);
    };
    _map_1.forEach(_function_8);
  }
}
