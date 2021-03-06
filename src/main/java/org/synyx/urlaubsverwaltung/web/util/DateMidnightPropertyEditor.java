/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.synyx.urlaubsverwaltung.web.util;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import org.springframework.util.StringUtils;

import org.synyx.urlaubsverwaltung.DateFormat;

import java.beans.PropertyEditorSupport;

import java.util.Locale;


/**
 * @author  Aljona Murygina
 */
public class DateMidnightPropertyEditor extends PropertyEditorSupport {

    private final DateTimeFormatter formatter;

    public DateMidnightPropertyEditor(Locale locale) { // NOSONAR - Locale should stay here for the future

        // TODO: not so nice....
        this.formatter = DateTimeFormat.forPattern(DateFormat.PATTERN);
    }

    // Date to String
    @Override
    public String getAsText() {

        if (this.getValue() == null) {
            return "";
        }

        return formatter.print((ReadableInstant) this.getValue());
    }


    // String to Date
    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        if (!StringUtils.hasText(text)) {
            this.setValue(null);
        } else {
            DateTime dateTime = formatter.parseDateTime(text);

            this.setValue(dateTime.toDateMidnight());
        }
    }
}
