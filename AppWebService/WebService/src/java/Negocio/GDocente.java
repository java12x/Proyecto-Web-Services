/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Datos.Docente;
import java.util.List;

/**
 *
 * @author JAVA
 */
public class GDocente {
    
 private Docente e;

    public int insertar(int doc_per_id,String doc_registro, int doc_estado) throws Exception {
        e = new Docente();
     e.setdoc_per_id(doc_per_id);
     e.setdoc_registro(doc_registro);
     e.setdoc_estado(doc_estado);
        return e.insertar();
    }

    public void modificar(int id, int doc_per_id,String doc_registro, int doc_estado) throws Exception {
        e = new Docente();
      e.setdoc_per_id(doc_per_id);
      e.setdoc_registro(doc_registro);
      e.setdoc_estado(doc_estado);
        e.modificar();
    }

    public void eliminar(int id) throws Exception {
        e = new Docente();
        e.setId(id);
        e.eliminar();
    }

    public List<Object[]> listar() throws Exception {
        return listar("", null);
    }

    public List<Object[]> listar(String condicion, Object[] args) throws Exception {
        e = new Docente();
        return e.listar();
    }

    public Object[] obtener(int id) throws Exception {
        e = new Docente();
        e.setId(id);
        return e.obtener();
    }

    public String listarString() throws Exception {
        List<Object[]> lo = listar();
        String l = "";
        for (int i = 0; i < lo.size(); i++) {
            l += "ID=" + lo.get(i)[0].toString() + ", ";
            l += "doc_per_id=" + lo.get(i)[1].toString() + ", ";
            l += "doc_registro=" + lo.get(i)[2].toString() + ", ";
            l += "doc_estado=" + lo.get(i)[3].toString() + ", ";
            l += "\n";
        }
        return l;
    }
}
