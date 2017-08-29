package com.testlab.demo.dummy;

import java.math.BigDecimal;

public class Assessment {

    private final Developer developer;
    private final String language;
    private final BigDecimal rating;

    public Assessment(Developer developer, String language, BigDecimal rating) {
        this.developer = developer;
        this.language = language;
        this.rating = rating;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public String getLanguage() {
        return language;
    }

    public BigDecimal getRating() {
        return rating;
    }
}
