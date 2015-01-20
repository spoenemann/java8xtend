/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package xtend.examples.data;

import java.time.LocalDate;
import java.time.Period;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Data structure for demonstrating the usage of Xtend with Java 8.
 * The examples have been taken from The Java Tutorials:
 * http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 */
@Data
@SuppressWarnings("all")
public class Person {
  public enum Sex {
    MALE,
    
    FEMALE;
  }
  
  private final String name;
  
  private final LocalDate birthday;
  
  private final Person.Sex gender;
  
  private final String emailAddress;
  
  public int getAge() {
    LocalDate _now = LocalDate.now();
    Period _between = Period.between(this.birthday, _now);
    return _between.getYears();
  }
  
  public String printPerson() {
    String _string = this.toString();
    return InputOutput.<String>println(_string);
  }
  
  public Person(final String name, final LocalDate birthday, final Person.Sex gender, final String emailAddress) {
    super();
    this.name = name;
    this.birthday = birthday;
    this.gender = gender;
    this.emailAddress = emailAddress;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.birthday== null) ? 0 : this.birthday.hashCode());
    result = prime * result + ((this.gender== null) ? 0 : this.gender.hashCode());
    result = prime * result + ((this.emailAddress== null) ? 0 : this.emailAddress.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    if (this.name == null) {
      if (other.name != null)
        return false;
    } else if (!this.name.equals(other.name))
      return false;
    if (this.birthday == null) {
      if (other.birthday != null)
        return false;
    } else if (!this.birthday.equals(other.birthday))
      return false;
    if (this.gender == null) {
      if (other.gender != null)
        return false;
    } else if (!this.gender.equals(other.gender))
      return false;
    if (this.emailAddress == null) {
      if (other.emailAddress != null)
        return false;
    } else if (!this.emailAddress.equals(other.emailAddress))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("name", this.name);
    b.add("birthday", this.birthday);
    b.add("gender", this.gender);
    b.add("emailAddress", this.emailAddress);
    return b.toString();
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  @Pure
  public LocalDate getBirthday() {
    return this.birthday;
  }
  
  @Pure
  public Person.Sex getGender() {
    return this.gender;
  }
  
  @Pure
  public String getEmailAddress() {
    return this.emailAddress;
  }
}
