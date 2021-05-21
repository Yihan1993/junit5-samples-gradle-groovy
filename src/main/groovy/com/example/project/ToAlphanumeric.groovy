package com.example.project
/**
 * toAlphanumeric converts text to strictly alphanumeric form.
 * Example: a_B-c.1 -> abc1
 */
class ToAlphanumeric {

    def converts(Map opts = [:]) {
        return opts.text.toLowerCase().replaceAll("[^a-z0-9]", "")
    }
}
