/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package xtend.examples.data

import java.util.function.IntConsumer

/**
 * Data type used for the collection operation, taken from The Java Tutorials:
 * http://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
 */
class Averager implements IntConsumer {
	
    int total = 0
    int count = 0
        
    def average() {
        if (count > 0) (total as double) / count else 0
    }
    
    override accept(int i) {
    	total += i
    	count++
    }
    
    def combine(Averager other) {
        total += other.total
        count += other.count
    }
    
}