/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author kitty
 */
public class Materia {
    private int id;
    private String mat_sigla;
    private String mat_nombre;
    private int mat_semestre;
    private float mat_hteoricas;
    private float mat_hpracticas;
    private float mat_hsemestre;
    private float mat_creditos;
    private int mat_estado;
    private Conexion conexion;

    public Materia() {
        conexion = new Conexion();
    }

    public int insertar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("insert into Materia values (default, ?, ?, ?, ?, ?, ?, ?, ?)", new Object[]{getmat_sigla(),getmat_nombre(),getmat_hteoricas(),getmat_hpracticas(),getmat_hsemestre(),getmat_creditos(),getmat_estado()});
        ResultSet rs = conexion.obtener("select max(id)from materia", null);
        rs.next();
        int res = rs.getInt(1);
        conexion.desconectar();
        return res;
    }

    public void modificar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("update Materia set mat_sigla=?, mat_nombre=?,mat_semestre=?,mat_hteoricas=?, mat_hpracticas=?, mat_hsemestre=?, mat_creditos=?, mat_estado=? where id=?", new Object[]{getmat_sigla(),getmat_nombre(),getmat_hteoricas(),getmat_hpracticas(),getmat_hsemestre(),getmat_creditos(),getmat_estado(),getId()});
        conexion.desconectar();
    }

    public void eliminar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("delete from Materia where id=? ", new Object[]{getId()});
        conexion.desconectar();
    }

    public List<Object[]> listar() throws Exception {
        return listar("", null);
    }

    public List<Object[]> listar(String condicion, Object[] args) throws Exception {
        conexion.conectar();
        String sql = "select * from Materia" + ((!condicion.equals("")) ? " where " + condicion : "");
        ResultSet rs = conexion.obtener(sql, args);
        List<Object[]> l = new LinkedList<Object[]>();
        while (rs.next()) {
            l.add(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
        }
        conexion.desconectar();
        return l;
    }

    public Object[] obtener() throws Exception {
        conexion.conectar();
        List<Object[]> l = listar("id=?", new Object[]{getId()});
        if (l.size() > 0) {
            setId(Integer.parseInt(l.get(0)[0].toString()));
            setmat_sigla(l.get(0)[1].toString());
            setmat_nombre(l.get(0)[2].toString());
            setmat_semestre(Integer.parseInt(l.get(0)[3].toString()));
            setmat_hteoricas(Float.parseFloat(l.get(0)[4].toString()));
            setmat_hpracticas(Float.parseFloat(l.get(0)[5].toString()));
            setmat_hsemestre(Float.parseFloat(l.get(0)[6].toString()));
            setmat_creditos(Float.parseFloat(l.get(0)[7].toString()));
            setmat_estado(Integer.parseInt(l.get(0)[8].toString()));
            
            conexion.desconectar();
            return l.get(0);
        }
        conexion.desconectar();
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmat_sigla() {
        return mat_sigla;
    }
    public void setmat_sigla(String mat_sigla){
         this.mat_sigla=mat_sigla;
    }

    public String getmat_nombre() {
        return mat_nombre;
    }

    public void setmat_nombre(String mat_nombre) {
        this.mat_nombre = mat_nombre;

    }
    public int getmat_semestre() {
        return mat_semestre;
    }

    public void setmat_semestre(int mat_semestre) {
        this.mat_semestre = mat_semestre;

    }
      public float getmat_hteoricas() {
        return mat_hteoricas;
    }

    public void setmat_hteoricas(float mat_hteoricas) {
        this.mat_hteoricas = mat_hteoricas;
    }
    
      public float getmat_hpracticas() {
        return mat_hpracticas;
    }

    public void setmat_hpracticas(float mat_hpracticas) {
        this.mat_hpracticas = mat_hpracticas;
    }
          public float getmat_hsemestre() {
        return mat_hsemestre;
    }

    public void setmat_hsemestre(float mat_hsemestre) {
        this.mat_hsemestre = mat_hsemestre;
    }
          public float getmat_creditos() {
        return mat_creditos;
    }

    public void setmat_creditos(float mat_creditos) {
        this.mat_creditos = mat_creditos;
    }
          public int getmat_estado() {
        return mat_estado;
    }

    public void setmat_estado(int mat_estado) {
        this.mat_estado = mat_estado;
    }
}
