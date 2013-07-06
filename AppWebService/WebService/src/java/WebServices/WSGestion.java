/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package WebServices;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;
import negocio.GGestion;

/**
 *
 * @author Javier
 */
@WebService()
public class WSGestion {
GGestion g;

    @WebMethod(operationName = "insertarGestion")
    public void insertarGestion(@WebParam(name = "ges_anio") int ges_anio, @WebParam(name = "ges_semestre")int ges_semestre, @WebParam(name = "ges_estado") int ges_estado){
        try {
            g = new GGestion();
            g.insertar(ges_anio, ges_semestre, ges_estado);
        } catch (Exception ex) {
            Logger.getLogger(WSGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @WebMethod(operationName = "modificarGestion")
    public void modificarGestion(@WebParam(name = "id") int id,@WebParam(name = "ges_anio") int ges_anio, @WebParam(name = "ges_semestre") int ges_semestre, @WebParam(name = "ges_estado") int ges_estado){
        try {
            g = new GGestion();
            g.modificar(id, ges_anio, ges_semestre, ges_estado);
        } catch (Exception ex) {
            Logger.getLogger(WSGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "eliminarGestion")
    public void eliminarGestion(@WebParam(name = "id") int id){
        try {
            g = new GGestion();
            g.eliminar(id);
        } catch (Exception ex) {
            Logger.getLogger(WSGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "listarGestion")
    public List<Object[]>  listarGestion() {
        try {
            g = new GGestion();
            return g.listar();
        } catch (Exception ex) {
            Logger.getLogger(WSGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "obtenerGestion")
    public Object[] obtenerGestion(@WebParam(name = "id") int id) {
        try {
            g = new GGestion();
            return g.obtener(id);
        } catch (Exception ex) {
            Logger.getLogger(WSGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
