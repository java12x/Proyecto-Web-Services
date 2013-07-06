/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package WebServices;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

/**
 *
 * @author Javier
 */
import negocio.GDocente;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService()
public class WSDocente {
GDocente cd;

    @WebMethod(operationName = "insertarDocente")
    public void insertarCarrera(@WebParam(name = "doc_per_id") int doc_per_id, @WebParam(name = "doc_registro") String doc_registro, @WebParam(name = "doc_estado") int doc_estado){
        try {
            cd = new negocio.GDocente();
            cd.insertar(doc_per_id, doc_registro, doc_estado);
        } catch (Exception ex) {
            Logger.getLogger(WSDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @WebMethod(operationName = "modificarDocente")
    public void modificarCarrera(@WebParam(name = "id") int id,@WebParam(name = "doc_per_id") int doc_per_id, @WebParam(name = "doc_registro") String doc_registro, @WebParam(name = "doc_estado") int doc_estado){
        try {
            cd = new GDocente();
            cd.modificar(id, doc_per_id, doc_registro, doc_estado);
        } catch (Exception ex) {
            Logger.getLogger(WSDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "eliminarDocente")
    public void eliminarDocente(@WebParam(name = "id") int id){
        try {
            cd = new GDocente();
            cd.eliminar(id);
        } catch (Exception ex) {
            Logger.getLogger(WSDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "listarDocente")
    public List<Object[]> listarDocente() {
        try {
            cd = new GDocente();
            return cd.listar();
        } catch (Exception ex) {
            Logger.getLogger(WSDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "obtenerDocente")
    public Object[] obtenerDocente(@WebParam(name = "id") int id) {
        try {
            cd = new GDocente();
            return cd.obtener(id);
        } catch (Exception ex) {
            Logger.getLogger(WSDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
