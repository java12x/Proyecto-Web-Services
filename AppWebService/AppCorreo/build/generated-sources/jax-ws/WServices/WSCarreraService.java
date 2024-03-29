
package WServices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-hudson-752-
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WSCarreraService", targetNamespace = "http://WebServices/", wsdlLocation = "http://localhost:40672/WebService/WSCarreraService?wsdl")
public class WSCarreraService
    extends Service
{

    private final static URL WSCARRERASERVICE_WSDL_LOCATION;
    private final static WebServiceException WSCARRERASERVICE_EXCEPTION;
    private final static QName WSCARRERASERVICE_QNAME = new QName("http://WebServices/", "WSCarreraService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:40672/WebService/WSCarreraService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSCARRERASERVICE_WSDL_LOCATION = url;
        WSCARRERASERVICE_EXCEPTION = e;
    }

    public WSCarreraService() {
        super(__getWsdlLocation(), WSCARRERASERVICE_QNAME);
    }

    public WSCarreraService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSCARRERASERVICE_QNAME, features);
    }

    public WSCarreraService(URL wsdlLocation) {
        super(wsdlLocation, WSCARRERASERVICE_QNAME);
    }

    public WSCarreraService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSCARRERASERVICE_QNAME, features);
    }

    public WSCarreraService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSCarreraService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSCarrera
     */
    @WebEndpoint(name = "WSCarreraPort")
    public WSCarrera getWSCarreraPort() {
        return super.getPort(new QName("http://WebServices/", "WSCarreraPort"), WSCarrera.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSCarrera
     */
    @WebEndpoint(name = "WSCarreraPort")
    public WSCarrera getWSCarreraPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://WebServices/", "WSCarreraPort"), WSCarrera.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSCARRERASERVICE_EXCEPTION!= null) {
            throw WSCARRERASERVICE_EXCEPTION;
        }
        return WSCARRERASERVICE_WSDL_LOCATION;
    }

}
