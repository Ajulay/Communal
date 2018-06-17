package com.ajulay.controllers;

import org.junit.Assert;

import static org.junit.Assert.*;

public class ControllerTest {

    @org.junit.Test
    public void count() {
       Controller controller = new Controller();
       double actual = controller.count(2, 4, 4);
       double expected = 8.0;
        Assert.assertEquals(expected, actual, 0.001);
    }
}