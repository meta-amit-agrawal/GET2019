package com.metacube.soap.service;

public class CalculateTriangleProxy implements com.metacube.soap.service.CalculateTriangle {
  private String _endpoint = null;
  private com.metacube.soap.service.CalculateTriangle calculateTriangle = null;
  
  public CalculateTriangleProxy() {
    _initCalculateTriangleProxy();
  }
  
  public CalculateTriangleProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalculateTriangleProxy();
  }
  
  private void _initCalculateTriangleProxy() {
    try {
      calculateTriangle = (new com.metacube.soap.service.CalculateTriangleServiceLocator()).getCalculateTriangle();
      if (calculateTriangle != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calculateTriangle)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calculateTriangle)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calculateTriangle != null)
      ((javax.xml.rpc.Stub)calculateTriangle)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.metacube.soap.service.CalculateTriangle getCalculateTriangle() {
    if (calculateTriangle == null)
      _initCalculateTriangleProxy();
    return calculateTriangle;
  }
  
  public double areaOfTriagle(double sideA, double sideB, double sideC) throws java.rmi.RemoteException{
    if (calculateTriangle == null)
      _initCalculateTriangleProxy();
    return calculateTriangle.areaOfTriagle(sideA, sideB, sideC);
  }
  
  public double perimeterOfTriangle(double sideA, double sideB, double sideC) throws java.rmi.RemoteException{
    if (calculateTriangle == null)
      _initCalculateTriangleProxy();
    return calculateTriangle.perimeterOfTriangle(sideA, sideB, sideC);
  }
  
  
}