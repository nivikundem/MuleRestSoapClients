
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.itf.vehicle.casefile;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.1.2
 * 2015-09-08T17:37:53.149+01:00
 * Generated source version: 3.1.2
 * 
 */

@javax.jws.WebService(
                      serviceName = "UploadProcessorService",
                      portName = "UploadProcessorPort",
                      targetNamespace = "http://casefile.Vehicle.itf.com/",
                      wsdlLocation = "file:/C:/JobSearch/Workspace/VehicleWS/WebContent/WEB-INF/Vehicle.wsdl",
                      endpointInterface = "com.itf.vehicle.casefile.DocumentUploadServicePortType")
                      
public class UploadProcessorPortImpl implements DocumentUploadServicePortType {

    private static final Logger LOG = Logger.getLogger(UploadProcessorPortImpl.class.getName());

    /* (non-Javadoc)
     * @see com.itf.vehicle.casefile.DocumentUploadServicePortType#vehicleExist(com.itf.vehicle.casefile.VehicleExistenceLookupRequest  vehicleExistenceLookupRequest )*
     */
    public com.itf.vehicle.casefile.VehicleExistsResponse vehicleExist(VehicleExistenceLookupRequest vehicleExistenceLookupRequest) { 
        LOG.info("Executing operation vehicleExist");
        System.out.println(vehicleExistenceLookupRequest);
        try {
            com.itf.vehicle.casefile.VehicleExistsResponse _return = new com.itf.vehicle.casefile.VehicleExistsResponse();
            _return.setVehicleExists(true);
            _return.setErrorLookingVehicle(true);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
