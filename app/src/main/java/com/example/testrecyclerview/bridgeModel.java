package com.example.testrecyclerview;

public class bridgeModel{
    String bridgePartName;
    String BridgePartAbbreviation;
    String BridgePartAbbreviationSmall;
    String description;
    int image;


    public bridgeModel(String bridgePartName, String bridgePartAbbreviation, String bridgePartAbbreviationSmall, int image, String description) {
        this.bridgePartName = bridgePartName;
        BridgePartAbbreviation = bridgePartAbbreviation;
        BridgePartAbbreviationSmall = bridgePartAbbreviationSmall;
        this.image = image;
        this.description = description;
    }

    public String getBridgePartName() {
        return bridgePartName;
    }

    public String getBridgePartAbbreviation() {
        return BridgePartAbbreviation;
    }

    public String getBridgePartAbbreviationSmall() {
        return BridgePartAbbreviationSmall;
    }

    public int getImage() {
        return image;
    }
//getters
    public String getDescription(){return description;}
}
