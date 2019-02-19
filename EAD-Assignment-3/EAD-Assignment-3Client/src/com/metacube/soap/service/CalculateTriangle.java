/**
 * CalculateTriangle.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.metacube.soap.service;

public interface CalculateTriangle extends java.rmi.Remote {
    public double areaOfTriagle(double sideA, double sideB, double sideC) throws java.rmi.RemoteException;
    public double perimeterOfTriangle(double sideA, double sideB, double sideC) throws java.rmi.RemoteException;
}
