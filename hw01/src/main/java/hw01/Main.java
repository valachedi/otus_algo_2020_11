package hw01;

import hw01.components.test.FileResultChecker;
import hw01.components.test.FileResultCheckerImpl;
import hw01.components.test.LuckyTicketsTest;
import hw01.components.test.StringLengthCalculator;
import hw01.components.test.StringPairsFactory;
import hw01.components.test.StringResultCalculator;
import hw01.models.test.StringPair;

import hw01.components.luckytickets.LuckyTicketsCounter;

public class Main {
    private static String PATH_FILES_STRLEN = "test-files/0.String";
    private static String PATH_FILES_TICKETS = "test-files/1.Tickets";

    public static void main(String[] args) {
        testStringLength();
        luckyTickets();
    }

    public static void testStringLength() {
        System.out.println("\n[String length]");
        StringPairsFactory stringPairsFactory = new StringPairsFactory(PATH_FILES_STRLEN);
        StringResultCalculator stringResultCalculator = new StringLengthCalculator();
        FileResultChecker resultChecker = new FileResultCheckerImpl(stringResultCalculator);

        for(StringPair pair : stringPairsFactory.getStringPairs()) {
            if(resultChecker.isResultEqual(pair)) {
                System.out.println(pair + " + ");
            } else {
                System.out.println(pair + " - ");
            }
        }
    }

    public static void luckyTickets() {
        System.out.println("\n[Tickets]");
        StringPairsFactory stringPairsFactory = new StringPairsFactory(PATH_FILES_TICKETS);
        LuckyTicketsTest test = new LuckyTicketsTest();
        FileResultChecker resultChecker = new FileResultCheckerImpl(test);

        for(StringPair pair : stringPairsFactory.getStringPairs()) {
            if(resultChecker.isResultEqual(pair)) {
                System.out.println(pair + " + ");
            } else {
                System.out.println(pair + " - ");
            }
        }
    }
}
