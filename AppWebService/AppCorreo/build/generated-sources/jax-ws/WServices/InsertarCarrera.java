
package WServices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for insertarCarrera complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="insertarCarrera">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="car_nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="car_descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="car_estado" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarCarrera", propOrder = {
    "carNombre",
    "carDescripcion",
    "carEstado"
})
public class InsertarCarrera {

    @XmlElement(name = "car_nombre")
    protected String carNombre;
    @XmlElement(name = "car_descripcion")
    protected String carDescripcion;
    @XmlElement(name = "car_estado")
    protected int carEstado;

    /**
     * Gets the value of the carNombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarNombre() {
        return carNombre;
    }

    /**
     * Sets the value of the carNombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarNombre(String value) {
        this.carNombre = value;
    }

    /**
     * Gets the value of the carDescripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarDescripcion() {
        return carDescripcion;
    }

    /**
     * Sets the value of the carDescripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarDescripcion(String value) {
        this.carDescripcion = value;
    }

    /**
     * Gets the value of the carEstado property.
     * 
     */
    public int getCarEstado() {
        return carEstado;
    }

    /**
     * Sets the value of the carEstado property.
     * 
     */
    public void setCarEstado(int value) {
        this.carEstado = value;
    }

}
