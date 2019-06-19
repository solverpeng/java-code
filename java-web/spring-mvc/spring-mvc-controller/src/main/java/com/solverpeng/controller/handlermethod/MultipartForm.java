package com.solverpeng.controller.handlermethod;

import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

public class MultipartForm {
    private String name;

    private MultipartFile file;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultipartForm that = (MultipartForm) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(file, that.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, file);
    }

    @Override
    public String toString() {
        return "MultipartForm{" +
                "name='" + name + '\'' +
                ", file=" + file +
                '}';
    }
}
