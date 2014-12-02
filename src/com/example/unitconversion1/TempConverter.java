package com.example.unitconversion1;

public class TempConverter {
	public static final int UNIT_CELSIUS = 0;
	public static final int UNIT_FARENHEIT = 1;
	public static final int UNIT_KELVIN = 2;

	private static double fromKelvin(double val, int unit) {
		switch(unit) {
			case UNIT_CELSIUS:
				return val - 273.15d;
			case UNIT_FARENHEIT:
				return val * 9/5 - 459.67d;
			case UNIT_KELVIN:
			default:
				return val;
		}
	}

	private static double toKelvin(double val, int unit) {
		switch(unit) {
			case UNIT_CELSIUS:
				return val + 273.15d;
			case UNIT_FARENHEIT:
				return (val + 459.67d) * 5/9;
			case UNIT_KELVIN:
			default:
				return val;
		}
	}

	public static double convert(double val, int from, int to) {
		System.out.println(val);
		System.out.println(from);
		System.out.println(to);

		return fromKelvin(toKelvin(val, from), to);
	}
}
