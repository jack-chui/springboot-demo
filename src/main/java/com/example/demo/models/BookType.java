package com.example.demo.models;

public enum BookType {
    NEW("NEW"),
    SECOND_HAND("SECOND_HAND");

    private String value;

    BookType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
