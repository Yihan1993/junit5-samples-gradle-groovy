package com.example.project

public class Calculator implements ICaculator {

	@Override
	public int add(int a, int b) {
		return a + b
	}

	@Override
	public int divide(int a, int b) {
		return a / b
	}

	@Override
	public int multiply(int a, int b) {
		return a * b
	}

	@Override
	public int substract(int a, int b) {
		return a - b
	}
}