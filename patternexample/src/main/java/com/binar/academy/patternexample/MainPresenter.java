package com.binar.academy.patternexample;

/**
 * Created by herisulistiyanto on 11/14/17.
 */

public class MainPresenter {

    private final MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void sumInput(int inputA, int inputB) {
        view.executeSum((inputA + inputB));
    }

    public void multiplyInput(int inputA, int inputB) {
        view.executeMultiply((inputA * inputB));
    }

    public void subInput(int inputA, int inputB) {
        view.executeSubstract((inputA - inputB));
    }
}
