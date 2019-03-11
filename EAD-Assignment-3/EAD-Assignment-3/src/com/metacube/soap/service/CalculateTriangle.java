package com.metacube.soap.service;

public class CalculateTriangle {
	
	/*
	 * calculates the area of the triangle
	 * @param requires the length of sides
	 * @returns the area of the triangle
	 */
	
	public double areaOfTriagle(double sideA, double sideB, double sideC)
	{
		double s,area;
		s=perimeterOfTriangle(sideA, sideB, sideC)/2;
		area = Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
		return area;
	}
	

	/*
	 * calculates the perimeter of the triangle
	 * @param requires the length of sides
	 * @returns the perimeter of the triangle
	 */
	public double perimeterOfTriangle(double sideA, double sideB, double sideC)
	{
		return sideA+sideB+sideC;
	}

}
