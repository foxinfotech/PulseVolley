package com.foxinfotech.pulsevolley;

import java.io.Serializable;

public class Roles implements Serializable {
    // These data members name should not change this is using in gson for
    // login.json, event_push.json
    //Begin
    private String ROLE_ID;
    private String ROLE_NAME;
    private String ROLE_DESCRIPTION;
    //End

    // These data members field is used for  checkbox selection
    //Begin
    private String IS_SELECTED;
    //End

    public  Roles()
    {

    }
    public Roles(String roleName){
        this.ROLE_NAME=roleName;
    }
    public String getIS_SELECTED() {
        return IS_SELECTED;
    }

    public void setIS_SELECTED(String IS_SELECTED) {
        this.IS_SELECTED = IS_SELECTED;
    }

    public String getROLE_DESCRIPTION() {
        return ROLE_DESCRIPTION;
    }

    public void setROLE_DESCRIPTION(String ROLE_DESCRIPTION) {
        this.ROLE_DESCRIPTION = ROLE_DESCRIPTION;
    }

    public String getROLE_ID() {
        return ROLE_ID;
    }

    public void setROLE_ID(String ROLE_ID) {
        this.ROLE_ID = ROLE_ID;
    }

    public String getROLE_NAME() {
        return ROLE_NAME;
    }

    public void setROLE_NAME(String ROLE_NAME) {
        this.ROLE_NAME = ROLE_NAME;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)                return false;
        if(!(o instanceof Roles))     return false;

        Roles role= (Roles) o;
        return this.ROLE_NAME.equalsIgnoreCase(((Roles) o).ROLE_NAME);
    }
}
