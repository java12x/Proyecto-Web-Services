/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Datos.Gestion;
import java.util.List;

/**
 *
 * @author JAVA
 */
public class GGestion {
    
private Gestion c;

    public int insertar(int ges_anio,int ges_semestre,int ges_estado) throws Exception {
        c = new Gestion();
        c.setges_anio(ges_anio);
        c.setges_semestre(ges_semestre);
        c.setges_estado(ges_estado);
        return c.insertar();
    }

    public void modificar(int id, int ges_anio,int ges_semestre,int ges_estado) throws Exception {
        c = new Gestion();
        c.setId(id);
        c.setges_anio(ges_anio);
        c.setges_semestre(ges_semestre);
        c.setges_estado(ges_estado);
        c.modificar();
    }

    public void eliminar(int id) throws Exception {
        c = new Gestion();
        c.setId(id);
        c.eliminar();
    }

    public List<Object[]> listar() throws Exception {
        return listar("", null);
    }

    public List<Object[]> listar(String condicion, Object[] args) throws Exception {
        c = new Gestion();
        return c.listar();
    }

    public Object[] obtener(int id) throws Exception {
        c = new Gestion();
        c.setId(id);
        return c.obtener();
    }

    public String listarString() throws Exception {
        List<Object[]> lo = listar();
        String l = "";
        for (int i = 0; i < lo.size(); i++) {
            l += "ID=" + lo.get(i)[0].toString() + ", ";
            l += "ges_anio=" + lo.get(i)[1].toString() + ", ";
            l += "ges_semestre=" + lo.get(i)[2].toString() + ", ";
            l += "ges_estado=" + lo.get(i)[2].toString() + ", ";
            l += "\n";
        }
        return l;
    }
}
