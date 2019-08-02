package com.solverpeng.example;

public class JpgPictureReadFactory implements PictureReadFactory {
    @Override
    public PictureRead getPictureRead() {
        return new JpgPictureRead();
    }
}
