/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package xtend.examples

import java.time.LocalDate

/**
 * Extension methods for building {@link LocalDate}s using operator overloading.
 * This allows to write date literals in the form day/month/year, e.g. 12/7/1995.
 * Don't use these extensions if you need normal integer division in the same class.
 */
final class LocalDateExtensions {
	
	static def /(int day, int month) {
		LocalDate.of(0, month, day)
	}
	
	static def /(LocalDate date, int year) {
		LocalDate.of(year, date.month, date.dayOfMonth)
	}
	
}