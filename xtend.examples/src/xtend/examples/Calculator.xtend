/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package xtend.examples

/**
 * Lambda expressions example from The Java Tutorials:
 * http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 */
class Calculator {
  
    interface IntegerMath {
        def int operation(int a, int b)
    }
  
    def operateBinary(int a, int b, IntegerMath op) {
        op.operation(a, b)
    }
 
    def demo() {
        val IntegerMath addition = [$0 + $1]
        val IntegerMath subtraction = [$0 - $1]
        
        println("40 + 2 = " +
            operateBinary(40, 2, addition))
        println("20 - 10 = " +
            operateBinary(20, 10, subtraction))
    }
}