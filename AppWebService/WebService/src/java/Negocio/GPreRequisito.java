/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Datos.PreRequisito;
import java.util.List;

/**
 *
 * @author kitty
 */
public class GPreRequisito {
    private PreRequisito d;

    public int insertar(int req_mat_id, int req_matC_id) throws Exception {
        d = new PreRequisito();
        d.setreq_mat_id(req_mat_id);
        d.setreq_matC_id(req_matC_id);
        return d.insertar();
    }

    public void modificar(int id,  int req_mat_id, int req_matC_id) throws Exception {
        d = new PreRequisito();
        d.setreq_mat_id(req_mat_id);
        d.setreq_matC_id(req_matC_id);
        d.modificar();
    }

    public void eliminar(int id) throws Exception {
        d = new PreRequisito();
        d.setId(id);
        d.eliminar();
    }

    public List<Object[]> listar() throws Exception {
        return listar("", null);
    }

    public List<Object[]> listar(String condicion, Object[] args) throws Exception {
         d = new PreRequisito();
        return d.listar();
    }

    public Object[] obtener(int id) throws Exception {
         d = new PreRequisito();
        d.setId(id);
        return d.obtener();
    }

    public String listarString() throws Exception {
        List<Object[]> lo = listar();
        String l = "";
        for (int i = 0; i < lo.size(); i++) {
            l += "ID=" + lo.get(i)[0].toString() + ", ";
            l += "RequisitoMateria=" + lo.get(i)[1].toString() + ", ";
            l += "RequisitoCarrera=" + lo.get(i)[2].toString() + ", ";
            l += "\n";
        }
        return l;
    }   
}
