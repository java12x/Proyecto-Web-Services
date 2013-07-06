/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Datos.Carrera;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author H
 */
public class GCarrera {

    private Carrera d;

    public int insertar(String car_nombre, String car_descripcion,int car_estado) throws Exception {
        d = new Carrera();
        d.setcar_nombre(car_nombre);
        d.setcar_descripcion(car_descripcion);
        d.setcar_estado(car_estado);
        return d.insertar();
    }

    public void modificar(int id,String car_nombre, String car_descripcion,int car_estado) throws Exception {
        d = new Carrera();
        d.setId(id);
        d.setcar_nombre(car_nombre);
        d.setcar_descripcion(car_descripcion);
        d.setcar_estado(car_estado);
        d.modificar();
    }

    public void eliminar(int id) throws Exception {
        d = new Carrera();
        d.setId(id);
        d.eliminar();
    }

    public List<Object[]> listar() throws Exception {
        return listar("", null);
    }

    public List<Object[]> listar(String condicion, Object[] args) throws Exception {
        d = new Carrera();
        return d.listar();
    }

    public Object[] obtener(int id) throws Exception {
        d = new Carrera();
        d.setId(id);
        return d.obtener();
    }

    public String listarString() throws Exception {
        List<Object[]> lo = listar();
        String l = "";
        for (int i = 0; i < lo.size(); i++) {
            l += "ID=" + lo.get(i)[0].toString() + ", ";
            l += "car_nombre=" + lo.get(i)[1].toString() + ", ";
            l += "car_descripcion=" + lo.get(i)[2].toString() + ", ";
            l += "car_estado=" + lo.get(i)[3].toString() + ", ";
            l += "\n";
        }
        return l;
    }
}