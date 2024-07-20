package com.bytbuddies.employeeManagement_springBoot_backend.Util;

public enum UtilEnums {
    
    ORG_ADMIN("303d6c62-e132-49fb-8e83-cc7e877a23c1"),
    HR_ADMIN("b35774e0-eeef-45a4-a8f3-0ddfa676ba28"),
    TEAM_LEAD("58c83b60-6ec8-4efb-bd18-3fc46003568f"),
    IT_ADMIN("0b8ea92e-ad81-44e2-9c86-20a241b33fe1"),
    DEVELOPER("27dee5e2-91bd-40e3-86a6-d12254a668eb"),
    CANDIDATE("02ec1d76-188a-43c2-99c7-e1183b550047"),
    MANAGER("8815a4e2-8e13-404c-bb92-ddb03647f867");

    private final String value;
    private UtilEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
