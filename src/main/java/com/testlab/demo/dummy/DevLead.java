package com.testlab.demo.dummy;

import java.math.BigDecimal;
import java.util.List;

public class DevLead {

    public Result assess(List<Assessment> assessments) {

        BigDecimal aggregate = BigDecimal.ZERO;

        for (Assessment appraisal : assessments) {
            aggregate = aggregate.add(appraisal.getRating());
        }

        BigDecimal average = calculateAverage(aggregate, assessments.size());

        if (average.compareTo(new BigDecimal("90.0")) > 0) {
            return Result.Excellent;
        }
        if (average.compareTo(new BigDecimal("60.0")) > 0) {
            return Result.Good;
        }

        return Result.Poor;
    }

    private BigDecimal calculateAverage(BigDecimal sum, int num) {
        BigDecimal average = new BigDecimal(sum.doubleValue() / num);
        return average;
    }

}
