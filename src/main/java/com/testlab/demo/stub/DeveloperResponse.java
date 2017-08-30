package com.testlab.demo.stub;

import com.testlab.demo.dummy.Developer;

public class DeveloperResponse {
    private final String errorMessage;
    private final Developer developer;

    public DeveloperResponse(String errorMessage, Developer developer) {
        this.errorMessage = errorMessage;
        this.developer = developer;
    }
    public boolean isSuccess(){
        return null == errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Developer getDeveloper() {
        return developer;
    }
}