package hw01.components.test;

import hw01.models.test.StringPair;

public class FileResultCheckerImpl implements FileResultChecker {
    private StringResultCalculator stringResultCalculator;


    public FileResultCheckerImpl(StringResultCalculator stringResultCalculator) {
        this.stringResultCalculator = stringResultCalculator;
    }


    public boolean isResultEqual(StringPair pair) {
        String calculationResult = stringResultCalculator.calculate(pair.getStringIn());
        return calculationResult.equals(pair.getStringOut());
    }
}
