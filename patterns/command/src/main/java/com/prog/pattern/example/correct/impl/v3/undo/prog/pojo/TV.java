package com.prog.pattern.example.correct.impl.v3.undo.prog.pojo;

public class TV {
	String location;
	int channel;

	public TV(String location) {
		this.location = location;
	}

	public void on() {
		System.out.println("TV is on");
	}

	public void off() {
		System.out.println("TV is off");
	}

	public void setInputChannel() {
		this.channel = 3;
		System.out.println("Channel is set for VCR");
	}
}
