package com.redolf.kubernetes.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {

    @BeforeEach
    void setUp() {
        System.out.println("Running setUp in product controller");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running tearDown in product controller");
    }
}