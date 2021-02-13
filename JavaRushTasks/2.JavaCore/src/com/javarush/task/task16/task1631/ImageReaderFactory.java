package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import java.io.Reader;

public class ImageReaderFactory  {

    public static void main(String[] args) {
        System.out.println(getImageReader(null));
    }

    public static ImageReader getImageReader (ImageTypes types) throws IllegalArgumentException {
        if (types == null) throw new IllegalArgumentException();

        switch (types) {
            case BMP:
                return new BmpReader();
            case JPG:
                return new JpgReader();
            case PNG:
                return new PngReader();
            default:
                throw new IllegalArgumentException();
        }
    }


}
