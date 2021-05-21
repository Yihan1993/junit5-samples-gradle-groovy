package com.example.project
import static org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test


class ToAlphanumericTest {
    @Test
    void test() {
        // call toAlphanumeric and check result
        def toAlphanumeric = new ToAlphanumeric()
        def result = toAlphanumeric.converts(text: "a_B-c.1")
        assertEquals ("abc1", result)
    }
}