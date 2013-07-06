/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Datos.Persona;
import java.util.List;

/**
 *
 * @author JAVA
 */
public class GPersona {
private Persona a;

    public int insertar(String ci,String nombres,String apellidos,String genero,String fechanac,String telefono, String telefonomovil,String email) throws Exception {
        a = new Persona();
       a.setper_ci(ci);
       a.setper_nombres(nombres);
       a.setper_apellidos(apellidos);
       a.setper_genero(genero);
       a.setper_fechanac(fechanac);
       a.setper_telefono(telefono);
       a.setper_telefonomovil(telefonomovil);
       a.setper_email(email);
        return a.insertar();
    }

    public void modificar(int id, String ci,String nombres,String apellidos,String genero,String fechanac,String telefono, String telefonomovil,String email) throws Exception {
        a = new Persona();
        a.setId(id);
       a.setper_ci(ci);
       a.setper_nombres(nombres);
       a.setper_apellidos(apellidos);
       a.setper_genero(genero);
       a.setper_fechanac(fechanac);
       a.setper_telefono(telefono);
       a.setper_telefonomovil(telefonomovil);
       a.setper_email(email);
        a.modificar();
    }

    public void eliminar(int id) throws Exception {
        a = new Persona();
        a.setId(id);
        a.eliminar();
    }

    public List<Object[]> listar() throws Exception {
        return listar("", null);
    }

    public List<Object[]> listar(String condicion, Object[] args) throws Exception {
        a = new Persona();
        return a.listar();
    }

    public Object[] obtener(int id) throws Exception {
        a = new Persona();
        a.setId(id);
        return a.obtener();
    }

    public String listarString() throws Exception {
        List<Object[]> lo = listar();
        String l = "";
        for (int i = 0; i < lo.size(); i++) {
            l += "ID=" + lo.get(i)[0].toString() + ", ";
            l += "ci=" + lo.get(i)[1].toString() + ", ";
            l += "nombres=" + lo.get(i)[2].toString() + ", ";
            l += "apellidos=" + lo.get(i)[3].toString() + ", ";
            l += "genero=" + lo.get(i)[4].toString() + ", ";
            l += "genero=" + lo.get(i)[5].toString() + ", ";
            l += "fechanac=" + lo.get(i)[6].toString() + ", ";
            l += "telefono=" + lo.get(i)[7].toString() + ", ";
            l += "telefonomovil=" + lo.get(i)[8].toString() + ", ";
            l += "email=" + lo.get(i)[9].toString() + ", ";
            l += "\n";
        }
        return l;
    }
}

