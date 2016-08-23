package com.rockstudios;

public enum DBSequences {

    ADMINUSER("AUSER"),
    USERS("USER"),
    CUSTOMER("CUST"),
	ORGANISATIONBRANCH("ORGB");
	
    private String sequenceName;

    DBSequences(final String sequenceCode) {
        sequenceName = sequenceCode;
    }

    public String getSequenceName() {
        return sequenceName;
    }

}
