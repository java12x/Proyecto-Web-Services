
package WServices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the WServices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ObtenerCarrera_QNAME = new QName("http://WebServices/", "obtenerCarrera");
    private final static QName _EliminarCarrera_QNAME = new QName("http://WebServices/", "eliminarCarrera");
    private final static QName _ListarCarrera_QNAME = new QName("http://WebServices/", "listarCarrera");
    private final static QName _ModificarCarrera_QNAME = new QName("http://WebServices/", "modificarCarrera");
    private final static QName _EliminarCarreraResponse_QNAME = new QName("http://WebServices/", "eliminarCarreraResponse");
    private final static QName _InsertarCarreraResponse_QNAME = new QName("http://WebServices/", "insertarCarreraResponse");
    private final static QName _ListarCarreraResponse_QNAME = new QName("http://WebServices/", "listarCarreraResponse");
    private final static QName _ObtenerCarreraResponse_QNAME = new QName("http://WebServices/", "obtenerCarreraResponse");
    private final static QName _ModificarCarreraResponse_QNAME = new QName("http://WebServices/", "modificarCarreraResponse");
    private final static QName _InsertarCarrera_QNAME = new QName("http://WebServices/", "insertarCarrera");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: WServices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertarCarrera }
     * 
     */
    public InsertarCarrera createInsertarCarrera() {
        return new InsertarCarrera();
    }

    /**
     * Create an instance of {@link ObtenerCarreraResponse }
     * 
     */
    public ObtenerCarreraResponse createObtenerCarreraResponse() {
        return new ObtenerCarreraResponse();
    }

    /**
     * Create an instance of {@link EliminarCarrera }
     * 
     */
    public EliminarCarrera createEliminarCarrera() {
        return new EliminarCarrera();
    }

    /**
     * Create an instance of {@link AnyTypeArray }
     * 
     */
    public AnyTypeArray createAnyTypeArray() {
        return new AnyTypeArray();
    }

    /**
     * Create an instance of {@link ModificarCarrera }
     * 
     */
    public ModificarCarrera createModificarCarrera() {
        return new ModificarCarrera();
    }

    /**
     * Create an instance of {@link ModificarCarreraResponse }
     * 
     */
    public ModificarCarreraResponse createModificarCarreraResponse() {
        return new ModificarCarreraResponse();
    }

    /**
     * Create an instance of {@link EliminarCarreraResponse }
     * 
     */
    public EliminarCarreraResponse createEliminarCarreraResponse() {
        return new EliminarCarreraResponse();
    }

    /**
     * Create an instance of {@link InsertarCarreraResponse }
     * 
     */
    public InsertarCarreraResponse createInsertarCarreraResponse() {
        return new InsertarCarreraResponse();
    }

    /**
     * Create an instance of {@link ObtenerCarrera }
     * 
     */
    public ObtenerCarrera createObtenerCarrera() {
        return new ObtenerCarrera();
    }

    /**
     * Create an instance of {@link ListarCarreraResponse }
     * 
     */
    public ListarCarreraResponse createListarCarreraResponse() {
        return new ListarCarreraResponse();
    }

    /**
     * Create an instance of {@link ListarCarrera }
     * 
     */
    public ListarCarrera createListarCarrera() {
        return new ListarCarrera();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerCarrera }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "obtenerCarrera")
    public JAXBElement<ObtenerCarrera> createObtenerCarrera(ObtenerCarrera value) {
        return new JAXBElement<ObtenerCarrera>(_ObtenerCarrera_QNAME, ObtenerCarrera.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarCarrera }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "eliminarCarrera")
    public JAXBElement<EliminarCarrera> createEliminarCarrera(EliminarCarrera value) {
        return new JAXBElement<EliminarCarrera>(_EliminarCarrera_QNAME, EliminarCarrera.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarCarrera }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "listarCarrera")
    public JAXBElement<ListarCarrera> createListarCarrera(ListarCarrera value) {
        return new JAXBElement<ListarCarrera>(_ListarCarrera_QNAME, ListarCarrera.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarCarrera }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "modificarCarrera")
    public JAXBElement<ModificarCarrera> createModificarCarrera(ModificarCarrera value) {
        return new JAXBElement<ModificarCarrera>(_ModificarCarrera_QNAME, ModificarCarrera.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarCarreraResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "eliminarCarreraResponse")
    public JAXBElement<EliminarCarreraResponse> createEliminarCarreraResponse(EliminarCarreraResponse value) {
        return new JAXBElement<EliminarCarreraResponse>(_EliminarCarreraResponse_QNAME, EliminarCarreraResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarCarreraResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "insertarCarreraResponse")
    public JAXBElement<InsertarCarreraResponse> createInsertarCarreraResponse(InsertarCarreraResponse value) {
        return new JAXBElement<InsertarCarreraResponse>(_InsertarCarreraResponse_QNAME, InsertarCarreraResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarCarreraResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "listarCarreraResponse")
    public JAXBElement<ListarCarreraResponse> createListarCarreraResponse(ListarCarreraResponse value) {
        return new JAXBElement<ListarCarreraResponse>(_ListarCarreraResponse_QNAME, ListarCarreraResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerCarreraResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "obtenerCarreraResponse")
    public JAXBElement<ObtenerCarreraResponse> createObtenerCarreraResponse(ObtenerCarreraResponse value) {
        return new JAXBElement<ObtenerCarreraResponse>(_ObtenerCarreraResponse_QNAME, ObtenerCarreraResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarCarreraResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "modificarCarreraResponse")
    public JAXBElement<ModificarCarreraResponse> createModificarCarreraResponse(ModificarCarreraResponse value) {
        return new JAXBElement<ModificarCarreraResponse>(_ModificarCarreraResponse_QNAME, ModificarCarreraResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarCarrera }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "insertarCarrera")
    public JAXBElement<InsertarCarrera> createInsertarCarrera(InsertarCarrera value) {
        return new JAXBElement<InsertarCarrera>(_InsertarCarrera_QNAME, InsertarCarrera.class, null, value);
    }

}
