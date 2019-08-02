package com.solverpeng.example;

public enum PictureReadNameEnum {
    GIF("GIF"),
    JPG("JPG");

    private String pictureReadName;

    PictureReadNameEnum(String pictureReadName) {
        this.pictureReadName = pictureReadName;
    }

    public String getPictureReadName() {
        return pictureReadName;
    }
}
