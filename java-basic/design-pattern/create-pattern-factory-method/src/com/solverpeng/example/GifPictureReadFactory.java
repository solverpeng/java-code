package com.solverpeng.example;

public class GifPictureReadFactory implements PictureReadFactory {

    @Override
    public PictureRead getPictureRead() {
        return new GifPictureRead();
    }
}
