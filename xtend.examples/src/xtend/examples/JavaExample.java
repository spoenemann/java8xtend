/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package xtend.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import xtend.examples.data.Album;
import xtend.examples.data.Track;

/**
 * Selected Java code examples found in The Java Tutorial:
 * http://docs.oracle.com/javase/tutorial/collections/streams/QandE/answers.html
 */
public class JavaExample {
	
	public static List<Album> example1(List<Album> albums) {
		List<Album> favs = new ArrayList<>();
		for (Album a : albums) {
		    boolean hasFavorite = false;
		    for (Track t : a.getTracks()) {
		        if (t.getRating() >= 4) {
		            hasFavorite = true;
		            break;
		        }
		    }
		    if (hasFavorite)
		        favs.add(a);
		}
		Collections.sort(favs, new Comparator<Album>() {
		                           public int compare(Album a1, Album a2) {
		                               return a1.getName().compareTo(a2.getName());
		                           }});
		return favs;
	}
	
	public static List<Album> example2(List<Album> albums) {
		List<Album> sortedFavs = albums.stream()
		        .filter(a -> a.getTracks().stream().anyMatch(t -> (t.getRating() >= 4)))
		        .sorted(Comparator.comparing(a -> a.getName()))
		        .collect(Collectors.toList());
		return sortedFavs;
	}

}
