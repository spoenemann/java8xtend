/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package xtend.examples.data;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Data structure for demonstrating the usage of Xtend with Java 8.
 * The examples have been taken from The Java Tutorials:
 * http://docs.oracle.com/javase/tutorial/collections/streams/QandE/questions.html
 */
@Data
@SuppressWarnings("all")
public class Track {
  private final int rating;
  
  public Track(final int rating) {
    super();
    this.rating = rating;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this.rating;
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
    Track other = (Track) obj;
    if (other.rating != this.rating)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("rating", this.rating);
    return b.toString();
  }
  
  @Pure
  public int getRating() {
    return this.rating;
  }
}
