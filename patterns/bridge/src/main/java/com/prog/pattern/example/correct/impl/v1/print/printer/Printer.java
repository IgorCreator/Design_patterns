package com.prog.pattern.example.correct.impl.v1.print.printer;

import com.prog.pattern.example.correct.impl.v1.print.foramatter.Formatter;

import java.util.List;

public abstract class Printer {

	public String print(Formatter formatter) {
	 return formatter.format(getHeader(), getDetails());
	}

	protected abstract String getHeader();
	protected abstract List<Detail> getDetails();

}
