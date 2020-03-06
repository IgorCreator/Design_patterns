package com.prog.pattern.example.correct.impl.v2.test.simple;

public class SoldState implements State {
    private GumBallMachine gumBallMachine;

    public SoldState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    @Override
    public void dispense() {
        gumBallMachine.releaseBall();
        if (gumBallMachine.getQtyOfBalls() > 0) {
            gumBallMachine.setState(gumBallMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs!");
            gumBallMachine.setState(gumBallMachine.getSoldOutState());
        }
    }

    @Override
    public String toString() {
        return "delivering a gumball";
    }
}
