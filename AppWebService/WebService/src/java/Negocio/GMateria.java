/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Datos.Materia;
import java.util.List;

/**
 *
 * @author kitty
 */
public class GMateria {
    private Materia a;

    public int insertar(String mat_sigla,String mat_nombre,int mat_semestre,float mathteoricas,float mat_hpracticas,float mat_hsemestre,float mat_creditos,int mat_estado) throws Exception {
       a = new Materia();
       a.setmat_sigla(mat_sigla);
       a.setmat_nombre(mat_nombre);
       a.setmat_semestre(mat_semestre);
       a.setmat_hteoricas(mathteoricas);
       a.setmat_hpracticas(mat_hpracticas);
       a.setmat_hsemestre(mat_hsemestre);
       a.setmat_creditos(mat_creditos);
       a.setmat_estado(mat_estado);
        return a.insertar();
    }

    public void modificar(int id, String mat_sigla,String mat_nombre,int mat_semestre,float mathteoricas,float mat_hpracticas,float mat_hsemestre,float mat_creditos,int mat_estado) throws Exception {
        a = new Materia();
        a.setId(id);
         a.setmat_sigla(mat_sigla);
       a.setmat_nombre(mat_nombre);
       a.setmat_semestre(mat_semestre);
       a.setmat_hteoricas(mathteoricas);
       a.setmat_hpracticas(mat_hpracticas);
       a.setmat_hsemestre(mat_hsemestre);
       a.setmat_creditos(mat_creditos);
       a.setmat_estado(mat_estado);
        a.modificar();
    }

    public void eliminar(int id) throws Exception {
        a = new Materia();
        a.setId(id);
        a.eliminar();
    }

    public List<Object[]> listar() throws Exception {
        return listar("", null);
    }

    public List<Object[]> listar(String condicion, Object[] args) throws Exception {
       a = new Materia();
        return a.listar();
    }

    public Object[] obtener(int id) throws Exception {
       a = new Materia();
        a.setId(id);
        return a.obtener();
    }

    public String listarString() throws Exception {
        List<Object[]> lo = listar();
        String l = "";
        for (int i = 0; i < lo.size(); i++) {
            l += "ID=" + lo.get(i)[0].toString() + ", ";
            l += "Sigla=" + lo.get(i)[1].toString() + ", ";
            l += "nombre=" + lo.get(i)[2].toString() + ", ";
            l += "Semestre=" + lo.get(i)[3].toString() + ", ";
            l += "HorasTeoricas=" + lo.get(i)[4].toString() + ", ";
            l += "HorasPracticas=" + lo.get(i)[5].toString() + ", ";
            l += "HorasSemestre=" + lo.get(i)[6].toString() + ", ";
            l += "Creditos=" + lo.get(i)[7].toString() + ", ";
            l += "Estado=" + lo.get(i)[8].toString() + ", ";
            l += "\n";
        }
        return l;
    }
}
