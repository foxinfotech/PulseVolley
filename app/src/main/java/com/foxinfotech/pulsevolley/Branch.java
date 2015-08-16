package com.foxinfotech.pulsevolley;

import java.io.Serializable;

public class Branch implements Serializable {

    // These data members name should not change this is using in gson for
    // login.json and event_push.json
    //Begin
    private String BRANCH_ID;
    private String BRANCH_NAME;
    private String BRANCH_CODE;
    private String BRANCH_LOCATION;
    private String BRANCH_ADDRESS;
    private String BRANCH_PHONE_NO;
    private String BRANCH_PINCODE;
    private String BRANCH_DESCRIPTION;
    private String CITY_ID;
    private String CITY_NAME;
    private String IS_SELECTED;

    //End

    public String getCITY_ID() {
        return CITY_ID;
    }

    public void setCITY_ID(String CITY_ID) {
        this.CITY_ID = CITY_ID;
    }

    public String getCITY_NAME() {
        return CITY_NAME;
    }

    public void setCITY_NAME(String CITY_NAME) {
        this.CITY_NAME = CITY_NAME;
    }

    public String getBRANCH_ID() {
        return BRANCH_ID;
    }

    public void setBRANCH_ID(String BRANCH_ID) {
        this.BRANCH_ID = BRANCH_ID;
    }

    public String getBRANCH_NAME() {
        return BRANCH_NAME;
    }

    public void setBRANCH_NAME(String BRANCH_NAME) {
        this.BRANCH_NAME = BRANCH_NAME;
    }


    public String getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    public void setBRANCH_CODE(String BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    public String getBRANCH_LOCATION() {
        return BRANCH_LOCATION;
    }

    public void setBRANCH_LOCATION(String BRANCH_LOCATION) {
        this.BRANCH_LOCATION = BRANCH_LOCATION;
    }

    public String getBRANCH_ADDRESS() {
        return BRANCH_ADDRESS;
    }

    public void setBRANCH_ADDRESS(String BRANCH_ADDRESS) {
        this.BRANCH_ADDRESS = BRANCH_ADDRESS;
    }

    public String getBRANCH_PHONE_NO() {
        return BRANCH_PHONE_NO;
    }

    public void setBRANCH_PHONE_NO(String BRANCH_PHONE_NO) {
        this.BRANCH_PHONE_NO = BRANCH_PHONE_NO;
    }

    public String getBRANCH_PINCODE() {
        return BRANCH_PINCODE;
    }

    public void setBRANCH_PINCODE(String BRANCH_PINCODE) {
        this.BRANCH_PINCODE = BRANCH_PINCODE;
    }

    public String getBRANCH_DESCRIPTION() {
        return BRANCH_DESCRIPTION;
    }

    public void setBRANCH_DESCRIPTION(String BRANCH_DESCRIPTION) {
        this.BRANCH_DESCRIPTION = BRANCH_DESCRIPTION;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)                return false;
        if(!(o instanceof Branch))     return false;

        Branch branch= (Branch) o;
        return this.BRANCH_ID.equalsIgnoreCase(((Branch) o).BRANCH_ID);
    }
    public String getIS_SELECTED() {
        return IS_SELECTED;
    }

    public void setIS_SELECTED(String IS_SELECTED) {
        this.IS_SELECTED = IS_SELECTED;
    }
}
