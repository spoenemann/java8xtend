/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package xtend.examples;

import org.eclipse.xtext.xbase.lib.InputOutput;

/**
 * Lambda expressions example from The Java Tutorials:
 * http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 */
@SuppressWarnings("all")
public class Calculator {
  public interface IntegerMath {
    public abstract int operation(final int a, final int b);
  }
  
  public int operateBinary(final int a, final int b, final Calculator.IntegerMath op) {
    return op.operation(a, b);
  }
  
  public String demo() {
    String _xblockexpression = null;
    {
      final Calculator.IntegerMath _function = (int $0, int $1) -> {
        return ($0 + $1);
      };
      final Calculator.IntegerMath addition = _function;
      final Calculator.IntegerMath _function_1 = (int $0, int $1) -> {
        return ($0 - $1);
      };
      final Calculator.IntegerMath subtraction = _function_1;
      int _operateBinary = this.operateBinary(40, 2, addition);
      String _plus = ("40 + 2 = " + Integer.valueOf(_operateBinary));
      InputOutput.<String>println(_plus);
      int _operateBinary_1 = this.operateBinary(20, 10, subtraction);
      String _plus_1 = ("20 - 10 = " + Integer.valueOf(_operateBinary_1));
      _xblockexpression = InputOutput.<String>println(_plus_1);
    }
    return _xblockexpression;
  }
}
