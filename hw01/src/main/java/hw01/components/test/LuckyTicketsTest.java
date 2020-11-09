package hw01.components.test;

import hw01.components.luckytickets.LuckyTicketsCounter;

public class LuckyTicketsTest implements StringResultCalculator {
    public String calculate(String line) {
        LuckyTicketsCounter luckyTicketsCounter = new LuckyTicketsCounter(Integer.valueOf(line));
        return String.valueOf(luckyTicketsCounter.count());
    }
}
