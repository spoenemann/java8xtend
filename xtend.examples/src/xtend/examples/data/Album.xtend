/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package xtend.examples.data

import java.util.Collection
import org.eclipse.xtend.lib.annotations.Data

/**
 * Data structure for demonstrating the usage of Xtend with Java 8.
 * The examples have been taken from The Java Tutorials:
 * http://docs.oracle.com/javase/tutorial/collections/streams/QandE/questions.html
 */
@Data
class Album {
	
	String name
	
	Collection<Track> tracks
	
}