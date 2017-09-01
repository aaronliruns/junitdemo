package com.testlab.demo.fake;

public class Developer {

    private final String psid;
    private final String name;

    public Developer(String psid, String name) {
        this.psid = psid;
        this.name = name;
    }

    public String getPsid() {
        return psid;
    }

    public String getName() {
        return name;
    }

    public void writeVeryComplicatedCode() {
        //TODO: Implement something complicated here
    }

    public void writeUnitTests() {

    }

    public void getSomeBeersAfterWork() {

    }
}
