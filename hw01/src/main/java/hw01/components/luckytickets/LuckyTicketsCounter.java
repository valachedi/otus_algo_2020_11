package hw01.components.luckytickets;

import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;
import hw01.components.test.StringResultCalculator;

public class LuckyTicketsCounter {
    private int ticketHalfLength;


    public LuckyTicketsCounter(int ticketHalfLength) {
        this.ticketHalfLength = ticketHalfLength;
    }


    public BigInteger count() {
        int calculatingLength = 1;
        List<Integer> numbers = new ArrayList<>(9*1+1);
        int maxNumber = 9;

        for(int n = 0; n <= maxNumber; n++) {
            numbers.add(1);
        }

        while(calculatingLength < ticketHalfLength) {
            List<Integer> numbersPrev = new ArrayList<Integer>(numbers.size());
            for (Integer val : numbers) numbersPrev.add(val);
            numbers.clear();

            maxNumber += 9;

            for(int n = 0; n <= maxNumber; n++) {
                int prevSum = 0;

                for(int prevn = Math.max(0, n - 9); prevn <= Math.min(n, numbersPrev.size() - 1); prevn++) {
                    prevSum += numbersPrev.get(prevn);
                }

                numbers.add(n, prevSum);
            }

            calculatingLength++;
        }

        BigInteger result = BigInteger.valueOf(0);

        for(Integer eachNumber : numbers) {
            BigInteger eachBigNumber = BigInteger.valueOf(eachNumber);
            result = result.add(eachBigNumber.pow(2));
        }


        return result;
    }
}
