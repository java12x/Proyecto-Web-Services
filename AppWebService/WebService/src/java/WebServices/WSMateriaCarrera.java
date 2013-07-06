/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package WebServices;

import javax.jws.WebService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.GMateriaCarrera;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;
/**
 *
 * @author Javier
 */
@WebService()
public class WSMateriaCarrera {
 GMateriaCarrera ca;

    @WebMethod(operationName = "insertarCarrera")
    public void insertarMateriaCarrera(@WebParam(name = " matC_mat_id")int  matC_mat_id, @WebParam(name = "matC_car_id") int matC_car_id){
        try {
            ca = new  GMateriaCarrera();
            ca.insertar(matC_mat_id, matC_car_id);
        } catch (Exception ex) {
            Logger.getLogger(WSMateriaCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @WebMethod(operationName = "modificarCarrera")
    public void modificarMateriaCarrera(@WebParam(name = "id") int id,@WebParam(name = " matC_mat_id")int  matC_mat_id, @WebParam(name = "matC_car_id") int matC_car_id){
        ca=new  GMateriaCarrera();
        try {
            ca.modificar(id, matC_mat_id, matC_car_id);
        } catch (Exception ex) {
            Logger.getLogger(WSMateriaCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "eliminarCarrera")
    public void eliminarMateriaCarrera(@WebParam(name = "id") int id){
        try {
            ca = new  GMateriaCarrera();
            ca.eliminar(id);
        } catch (Exception ex) {
            Logger.getLogger(WSMateriaCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "listarMateriaCarrera")
    public List<Object[]> listarMateriaCarrera() {
        try {
            ca = new  GMateriaCarrera();
            return ca.listar();
        } catch (Exception ex) {
            Logger.getLogger(WSMateriaCarrera.class.getName()).log(Level.SEVERE, null, ex);

        }
         return null;
    }

    @WebMethod(operationName = "obtenerMateriaCarrera")
    public Object[] obtenerMateriaCarrera(@WebParam(name = "id") int id) {
        try {
            ca = new  GMateriaCarrera();
            return ca.obtener(id);
        } catch (Exception ex) {
            Logger.getLogger(WSMateriaCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
