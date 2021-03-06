package com.crossing.bridgecrossingws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.2
 * 2015-09-10T16:49:40.146+01:00
 * Generated source version: 3.1.2
 * 
 */
@WebService(targetNamespace = "http://www.crossing.com/BridgeCrossingWS/", name = "BridgeCrossingWS")
@XmlSeeAlso({ObjectFactory.class})
public interface BridgeCrossingWS {

    @WebResult(name = "out", targetNamespace = "")
    @RequestWrapper(localName = "sendCrossingDetails", targetNamespace = "http://www.crossing.com/BridgeCrossingWS/", className = "com.crossing.bridgecrossingws.SendCrossingDetails")
    @WebMethod(action = "urn:SendCrossingDetails")
    @ResponseWrapper(localName = "sendCrossingDetailsResponse", targetNamespace = "http://www.crossing.com/BridgeCrossingWS/", className = "com.crossing.bridgecrossingws.SendCrossingDetailsResponse")
    public java.lang.String sendCrossingDetails(
        @WebParam(name = "vrn", targetNamespace = "")
        java.lang.String vrn,
        @WebParam(name = "gateno", targetNamespace = "")
        java.lang.String gateno,
        @WebParam(name = "direction", targetNamespace = "")
        java.lang.String direction
    );
}
