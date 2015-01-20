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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import xtend.examples.Calculator;
import xtend.examples.LocalDateExtensions;
import xtend.examples.data.Album;
import xtend.examples.data.Averager;
import xtend.examples.data.Person;
import xtend.examples.data.Track;

/**
 * Examples demonstrating the usage of Xtend with Java 8.
 * The examples have been taken from The Java Tutorials:
 * http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 * http://docs.oracle.com/javase/tutorial/collections/streams/index.html
 */
@SuppressWarnings("all")
public class Demo {
  public static void main(final String[] args) {
    InputOutput.<String>println("---The Java Tutorials: Lambda Expressions, Calculator example");
    Calculator _calculator = new Calculator();
    _calculator.demo();
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
    InputOutput.<String>println("---The Java Tutorials: Lambda Expressions, Approach 8");
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
    InputOutput.<String>println("---The Java Tutorials: Lambda Expressions, Approach 9");
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
    InputOutput.<String>println("---Same result using the Xtend library");
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
    InputOutput.<String>println("---The Java Tutorials: Aggregate Operations");
    Stream<Person> _stream_1 = roster.stream();
    final Predicate<Person> _function_9 = (Person it) -> {
      Person.Sex _gender = it.getGender();
      return Objects.equal(_gender, Person.Sex.MALE);
    };
    Stream<Person> _filter_2 = _stream_1.filter(_function_9);
    final ToIntFunction<Person> _function_10 = (Person it) -> {
      return it.getAge();
    };
    IntStream _mapToInt = _filter_2.mapToInt(_function_10);
    OptionalDouble _average = _mapToInt.average();
    final double average = _average.getAsDouble();
    InputOutput.<String>println(("average = " + Double.valueOf(average)));
    InputOutput.<String>println("---The Java Tutorials: Aggregate Operations, The Stream.reduce Method");
    Stream<Person> _stream_2 = roster.stream();
    final Function<Person, Integer> _function_11 = (Person it) -> {
      return Integer.valueOf(it.getAge());
    };
    Stream<Integer> _map_2 = _stream_2.<Integer>map(_function_11);
    final BinaryOperator<Integer> _function_12 = (Integer $0, Integer $1) -> {
      return Integer.valueOf((($0).intValue() + ($1).intValue()));
    };
    final Integer totalAgeReduce = _map_2.reduce(
      Integer.valueOf(0), _function_12);
    InputOutput.<String>println(("totalAgeReduce = " + totalAgeReduce));
    InputOutput.<String>println("---The Java Tutorials: Aggregate Operations, The Stream.collect Method");
    Stream<Person> _stream_3 = roster.stream();
    final Predicate<Person> _function_13 = (Person it) -> {
      Person.Sex _gender = it.getGender();
      return Objects.equal(_gender, Person.Sex.MALE);
    };
    Stream<Person> _filter_3 = _stream_3.filter(_function_13);
    final Function<Person, Integer> _function_14 = (Person it) -> {
      return Integer.valueOf(it.getAge());
    };
    Stream<Integer> _map_3 = _filter_3.<Integer>map(_function_14);
    final Supplier<Averager> _function_15 = () -> {
      return new Averager();
    };
    final BiConsumer<Averager, Integer> _function_16 = (Averager avg, Integer i) -> {
      avg.accept((i).intValue());
    };
    final BiConsumer<Averager, Averager> _function_17 = (Averager avg1, Averager avg2) -> {
      avg1.combine(avg2);
    };
    final Averager averageCollect = _map_3.<Averager>collect(_function_15, _function_16, _function_17);
    double _average_1 = averageCollect.average();
    String _plus = ("averageCollect = " + Double.valueOf(_average_1));
    InputOutput.<String>println(_plus);
    Stream<Person> _stream_4 = roster.stream();
    final Predicate<Person> _function_18 = (Person it) -> {
      Person.Sex _gender = it.getGender();
      return Objects.equal(_gender, Person.Sex.MALE);
    };
    Stream<Person> _filter_4 = _stream_4.filter(_function_18);
    final Function<Person, String> _function_19 = (Person it) -> {
      return it.getName();
    };
    Stream<String> _map_4 = _filter_4.<String>map(_function_19);
    Collector<String, ?, List<String>> _list = Collectors.<String>toList();
    final List<String> namesOfMaleMembersCollect = _map_4.collect(_list);
    InputOutput.<String>println(("namesOfMaleMembersCollect = " + namesOfMaleMembersCollect));
    Stream<Person> _stream_5 = roster.stream();
    final Function<Person, Person.Sex> _function_20 = (Person it) -> {
      return it.getGender();
    };
    final Function<Person, String> _function_21 = (Person p) -> {
      return p.getName();
    };
    Collector<String, ?, List<String>> _list_1 = Collectors.<String>toList();
    Collector<Person, ?, List<String>> _mapping = Collectors.mapping(_function_21, _list_1);
    Collector<Person, ?, Map<Person.Sex, List<String>>> _groupingBy = Collectors.groupingBy(_function_20, _mapping);
    final Map<Person.Sex, List<String>> namesByGender = _stream_5.collect(_groupingBy);
    InputOutput.<String>println(("namesByGender = " + namesByGender));
    Stream<Person> _stream_6 = roster.stream();
    final Function<Person, Person.Sex> _function_22 = (Person it) -> {
      return it.getGender();
    };
    final Function<Person, Integer> _function_23 = (Person it) -> {
      return Integer.valueOf(it.getAge());
    };
    final BinaryOperator<Integer> _function_24 = (Integer $0, Integer $1) -> {
      return Integer.valueOf((($0).intValue() + ($1).intValue()));
    };
    Collector<Person, ?, Integer> _reducing = Collectors.<Person, Integer>reducing(
      Integer.valueOf(0), _function_23, _function_24);
    Collector<Person, ?, Map<Person.Sex, Integer>> _groupingBy_1 = Collectors.groupingBy(_function_22, _reducing);
    final Map<Person.Sex, Integer> totalAgeByGender = _stream_6.collect(_groupingBy_1);
    InputOutput.<String>println(("totalAgeByGender = " + totalAgeByGender));
    Stream<Person> _stream_7 = roster.stream();
    final Function<Person, Person.Sex> _function_25 = (Person it) -> {
      return it.getGender();
    };
    final ToIntFunction<Person> _function_26 = (Person it) -> {
      return it.getAge();
    };
    Collector<Person, ?, Double> _averagingInt = Collectors.<Person>averagingInt(_function_26);
    Collector<Person, ?, Map<Person.Sex, Double>> _groupingBy_2 = Collectors.groupingBy(_function_25, _averagingInt);
    final Map<Person.Sex, Double> averageAgeByGender = _stream_7.collect(_groupingBy_2);
    InputOutput.<String>println(("averageAgeByGender = " + averageAgeByGender));
    InputOutput.<String>println("---Same result using Xtend library");
    final Function1<Person, Boolean> _function_27 = (Person it) -> {
      Person.Sex _gender = it.getGender();
      return Boolean.valueOf(Objects.equal(_gender, Person.Sex.MALE));
    };
    Iterable<Person> _filter_5 = IterableExtensions.<Person>filter(roster, _function_27);
    final Function1<Person, String> _function_28 = (Person it) -> {
      return it.getName();
    };
    Iterable<String> _map_5 = IterableExtensions.<Person, String>map(_filter_5, _function_28);
    final List<String> namesOfMaleMembersXtend = IterableExtensions.<String>toList(_map_5);
    InputOutput.<String>println(("namesOfMaleMembersXtend = " + namesOfMaleMembersXtend));
    final ArrayList<Album> albums = CollectionLiterals.<Album>newArrayList();
    final Function1<Album, Boolean> _function_29 = (Album it) -> {
      Collection<Track> _tracks = it.getTracks();
      final Function1<Track, Boolean> _function_30 = (Track it_1) -> {
        int _rating = it_1.getRating();
        return Boolean.valueOf((_rating >= 4));
      };
      return Boolean.valueOf(IterableExtensions.<Track>exists(_tracks, _function_30));
    };
    Iterable<Album> _filter_6 = IterableExtensions.<Album>filter(albums, _function_29);
    final Function1<Album, String> _function_30 = (Album it) -> {
      return it.getName();
    };
    final List<Album> favs1 = IterableExtensions.<Album, String>sortBy(_filter_6, _function_30);
    Stream<Album> _stream_8 = albums.stream();
    final Predicate<Album> _function_31 = (Album it) -> {
      Collection<Track> _tracks = it.getTracks();
      Stream<Track> _stream_9 = _tracks.stream();
      final Predicate<Track> _function_32 = (Track it_1) -> {
        int _rating = it_1.getRating();
        return (_rating >= 4);
      };
      return _stream_9.anyMatch(_function_32);
    };
    Stream<Album> _filter_7 = _stream_8.filter(_function_31);
    final Function<Album, String> _function_32 = (Album it) -> {
      return it.getName();
    };
    Comparator<Album> _comparing = Comparator.<Album, String>comparing(_function_32);
    Stream<Album> _sorted = _filter_7.sorted(_comparing);
    Collector<Album, ?, List<Album>> _list_2 = Collectors.<Album>toList();
    final List<Album> favs2 = _sorted.collect(_list_2);
    Demo.use(favs1, favs2);
  }
  
  /**
   * Processor method used by one of the examples.
   */
  public static <X extends Object, Y extends Object> void processElements(final Iterable<X> source, final Predicate<X> tester, final Function<X, Y> mapper, final Consumer<Y> block) {
    for (final X p : source) {
      boolean _test = tester.test(p);
      if (_test) {
        final Y data = mapper.apply(p);
        block.accept(data);
      }
    }
  }
  
  /**
   * A pseudo processor for marking the given objects as used.
   */
  private static Object use(final Object... x) {
    return null;
  }
}
