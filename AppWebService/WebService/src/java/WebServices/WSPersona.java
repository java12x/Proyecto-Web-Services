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
import negocio.GPersona;

/**
 *
 * @author Javier
 */
@WebService()
public class WSPersona {
GPersona g;

    @WebMethod(operationName = "insertarPersona")
    public void insertarPersona(@WebParam(name = "ci") String ci, @WebParam(name = "nombres")String nombres, @WebParam(name = "apellidos") String apellidos,@WebParam(name = "generos") String generos,@WebParam(name = "fechanac") String fechanac,@WebParam(name = "telefono") String telefono,@WebParam(name = "telefonomovil") String telefonomovil,@WebParam(name = "email") String email){
        try {
            g = new GPersona();
            g.insertar(ci, nombres, apellidos, generos, fechanac, telefono, telefonomovil, email);
        } catch (Exception ex) {
            Logger.getLogger(WSPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @WebMethod(operationName = "modificarPersona")
    public void modificarPersona(@WebParam(name = "id") int id,@WebParam(name = "ci") String ci, @WebParam(name = "nombres")String nombres, @WebParam(name = "apellidos") String apellidos,@WebParam(name = "generos") String generos,@WebParam(name = "fechanac") String fechanac,@WebParam(name = "telefono") String telefono,@WebParam(name = "telefonomovil") String telefonomovil,@WebParam(name = "email") String email){
        try {
            g = new GPersona();
            g.modificar(id, ci, nombres, apellidos, generos, fechanac, telefono, telefonomovil, email);
        } catch (Exception ex) {
            Logger.getLogger(WSPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "eliminarPersona")
    public void eliminarGestion(@WebParam(name = "id") int id){
        try {
            g = new GPersona();
            g.eliminar(id);
        } catch (Exception ex) {
            Logger.getLogger(WSPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "listarPersona")
    public List<Object[]>  listarPersona() {
        try {
            g = new GPersona();
            return g.listar();
        } catch (Exception ex) {
            Logger.getLogger(WSPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "obtenerPersona")
    public Object[] obtenerGestion(@WebParam(name = "id") int id) {
        try {
            g = new GPersona();
            return g.obtener(id);
        } catch (Exception ex) {
            Logger.getLogger(WSPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
