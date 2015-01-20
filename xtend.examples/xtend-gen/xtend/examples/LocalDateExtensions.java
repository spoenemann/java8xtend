/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package xtend.examples;

import java.time.LocalDate;
import java.time.Month;

/**
 * Extension methods for building {@link LocalDate}s using operator overloading.
 * This allows to write date literals in the form day/month/year, e.g. 12/7/1995.
 * Don't use these extensions if you need normal integer division in the same class.
 */
@SuppressWarnings("all")
public final class LocalDateExtensions {
  public static LocalDate operator_divide(final int day, final int month) {
    return LocalDate.of(0, month, day);
  }
  
  public static LocalDate operator_divide(final LocalDate date, final int year) {
    Month _month = date.getMonth();
    int _dayOfMonth = date.getDayOfMonth();
    return LocalDate.of(year, _month, _dayOfMonth);
  }
}
