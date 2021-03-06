package com.prog.pattern.example.correct.impl.v2.prog.pojo.add;

import com.prog.pattern.example.correct.impl.v2.prog.pojo.Beverage;

public class Mocha extends CondimentDecorator {
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}
 
	public double cost() {
		return .20 + beverage.cost();
	}
}
