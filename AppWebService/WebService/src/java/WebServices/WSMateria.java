/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package WebServices;

import java.util.List;
import javax.jws.WebService;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.GMateria;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;
/**
 *
 * @author Javier
 */
@WebService()
public class WSMateria {
 GMateria ma;

    @WebMethod(operationName = "insertarMateria")
    public void insertarCarrera(@WebParam(name = "mat_sigla") String mat_sigla, @WebParam(name = "mat_nombre") String mat_nombre, @WebParam(name = "mat_semestre") String mat_semestre, @WebParam(name = "mathteoricas") float mathteoricas,@WebParam(name = "mathpracticas") float mathpracticas,@WebParam(name = "mathsemestre") float mathsemestre,@WebParam(name = "matcreditos") float mathcreditos,@WebParam(name = "matestado")int matestado){
        try {
           ma = new  GMateria();
            ma.insertar(mat_sigla, mat_nombre, matestado, mathteoricas, mathpracticas, mathsemestre, mathcreditos, matestado);
        } catch (Exception ex) {
            Logger.getLogger(WSCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @WebMethod(operationName = "modificarCarrera")
    public void modificarCarrera(@WebParam(name = "id") int id,@WebParam(name = "mat_sigla") String mat_sigla, @WebParam(name = "mat_nombre") String mat_nombre, @WebParam(name = "mat_semestre") String mat_semestre, @WebParam(name = "mathteoricas") float mathteoricas,@WebParam(name = "mathpracticas") float mathpracticas,@WebParam(name = "mathsemestre") float mathsemestre,@WebParam(name = "matcreditos") float mathcreditos,@WebParam(name = "matestado")int matestado){
        ma=new  GMateria();
        try {
            ma.modificar(id, mat_sigla, mat_nombre, matestado, mathteoricas, mathpracticas, mathsemestre, mathcreditos, matestado);
        } catch (Exception ex) {
            Logger.getLogger(WSCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "eliminarCarrera")
    public void eliminarCarrera(@WebParam(name = "id") int id){
        try {
           ma = new  GMateria();
           ma.eliminar(id);
        } catch (Exception ex) {
            Logger.getLogger(WSCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "listarCarrera")
    public List<Object[]> listarCarrera() {
        try {
           ma = new  GMateria();
            return ma.listar();
        } catch (Exception ex) {
            Logger.getLogger(WSCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "obtenerCarrera")
    public Object[] obtenerAula(@WebParam(name = "id") int id) {
        try {
            ma= new  GMateria();
            return ma.obtener(id);
        } catch (Exception ex) {
            Logger.getLogger(WSCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
return null;
    }
}
