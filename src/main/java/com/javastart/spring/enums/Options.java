package com.javastart.spring.enums;

public enum Options {
    ADD_DEVICE(1),
    ADD_CATEGORY(2),
    ADD_CUSTOMER(3),
    RENT_DEVICE(4),
    REMOVE_DEVICE(5),
    REMOVE_CATEGORY(6),
    REMOVE_CUSTOMER(7),
    EXIT(8);

    private final int option;

    Options(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }

    public static Options chooseOption(int option){
        Options[] optionValues = Options.values();
        for (Options o : optionValues) {
            if (o.getOption() == option){
                return o;
            }
        }
        return null;
    }
}