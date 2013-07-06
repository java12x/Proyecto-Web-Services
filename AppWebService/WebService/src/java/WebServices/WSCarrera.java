/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package WebServices;


/**
 *
 * @author Javier
 */
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.GCarrera;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService()
public class WSCarrera {

 GCarrera ca;

    @WebMethod(operationName = "insertarCarrera")
    public int insertarCarrera(@WebParam(name = "car_nombre") String car_nombre, @WebParam(name = "car_descripcion") String car_descripcion, @WebParam(name = "car_estado") int car_estado){
        try {
            ca = new GCarrera();
            return ca.insertar(car_nombre, car_descripcion, car_estado);
        } catch (Exception ex) {
            Logger.getLogger(WSCarrera.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    @WebMethod(operationName = "modificarCarrera")
    public void modificarCarrera(@WebParam(name = "id") int id,@WebParam(name = "car_nombre") String car_nombre, @WebParam(name = "car_descripcion") String car_descripcion, @WebParam(name = "car_estado") int car_estado){
        ca=new GCarrera();
        try {
            ca.modificar(id, car_nombre, car_descripcion, car_estado);
        } catch (Exception ex) {
            Logger.getLogger(WSCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "eliminarCarrera")
    public void eliminarCarrera(@WebParam(name = "id") int id){
        try {
            ca = new GCarrera();
            ca.eliminar(id);
        } catch (Exception ex) {
            Logger.getLogger(WSCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "listarCarrera")
    public List<Object[]> listarCarrera() {
        try {
            ca = new GCarrera();
            return ca.listar();
        } catch (Exception ex) {
            Logger.getLogger(WSCarrera.class.getName()).log(Level.SEVERE, null, ex);

        }
         return null;
    }

    @WebMethod(operationName = "obtenerCarrera")
    public Object[] obtenerCarrera(@WebParam(name = "id") int id) {
        try {
            ca = new GCarrera();
            return ca.obtener(id);
        } catch (Exception ex) {
            Logger.getLogger(WSCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
