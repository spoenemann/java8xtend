/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package xtend.examples.data;

import java.util.function.IntConsumer;

/**
 * Data type used for the collection operation, taken from The Java Tutorials:
 * http://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
 */
@SuppressWarnings("all")
public class Averager implements IntConsumer {
  private int total = 0;
  
  private int count = 0;
  
  public double average() {
    double _xifexpression = (double) 0;
    if ((this.count > 0)) {
      _xifexpression = (((double) this.total) / this.count);
    } else {
      _xifexpression = 0;
    }
    return _xifexpression;
  }
  
  @Override
  public void accept(final int i) {
    int _tal = this.total;
    this.total = (_tal + i);
    this.count++;
  }
  
  public int combine(final Averager other) {
    int _xblockexpression = (int) 0;
    {
      int _tal = this.total;
      this.total = (_tal + other.total);
      int _count = this.count;
      _xblockexpression = this.count = (_count + other.count);
    }
    return _xblockexpression;
  }
}
