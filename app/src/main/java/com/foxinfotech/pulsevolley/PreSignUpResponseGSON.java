package com.foxinfotech.pulsevolley;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PreSignUpResponseGSON implements Serializable {

    // These data members name should not change this is using in gson for
    // get_catalog.json and Login.json
    //Begin
    // These data members name should not change this is using in gson for
    // sign_up.json
    //Begin
    private String RESULT;
    private ArrayList<Branch> BRANCHES;
    private List<Roles> ROLES;
    //End

    public ArrayList<Branch> getBRANCHES() {
        return BRANCHES;
    }

    public void setBRANCHES(ArrayList<Branch> BRANCHES) {
        this.BRANCHES = BRANCHES;
    }

    public List<Roles> getROLES() {
        return ROLES;
    }

    public void setROLES(List<Roles> ROLES) {
        this.ROLES = ROLES;
    }

    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }

}
