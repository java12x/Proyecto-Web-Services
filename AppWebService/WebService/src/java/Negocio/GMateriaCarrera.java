/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Datos.MateriaCarrera;
import java.util.List;

/**
 *
 * @author kitty
 */
public class GMateriaCarrera {
   private MateriaCarrera d;

    public int insertar(int matC_mat_id, int matC_car_id) throws Exception {
        d = new MateriaCarrera();
        d.setmatC_mat_id(matC_mat_id);
        d.setmatC_car_id(matC_car_id);
        return d.insertar();
    }

    public void modificar(int id,  int matC_mat_id, int matC_car_id) throws Exception {
        d = new MateriaCarrera();
        d.setmatC_mat_id(matC_mat_id);
        d.setmatC_car_id(matC_car_id);;
        d.modificar();
    }

    public void eliminar(int id) throws Exception {
        d = new MateriaCarrera();
        d.setId(id);
        d.eliminar();
    }

    public List<Object[]> listar() throws Exception {
        return listar("", null);
    }

    public List<Object[]> listar(String condicion, Object[] args) throws Exception {
        d = new MateriaCarrera();
        return d.listar();
    }

    public Object[] obtener(int id) throws Exception {
        d = new MateriaCarrera();
        d.setId(id);
        return d.obtener();
    }

    public String listarString() throws Exception {
        List<Object[]> lo = listar();
        String l = "";
        for (int i = 0; i < lo.size(); i++) {
            l += "ID=" + lo.get(i)[0].toString() + ", ";
            l += "Materia=" + lo.get(i)[1].toString() + ", ";
            l += "Carrera=" + lo.get(i)[2].toString() + ", ";
            l += "\n";
        }
        return l;
    }  
}
