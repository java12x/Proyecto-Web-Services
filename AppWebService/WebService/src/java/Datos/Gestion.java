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
 * @author JAVA
 */
public class Gestion {
    private int id;
    private int ges_anio;
    private int ges_semestre;
    private int ges_estado;
    private Conexion conexion;

    public Gestion() {
        conexion = new Conexion();
    }

    public int insertar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("insert into gestion values (default, ?, ?, ?)", new Object[]{getges_anio(),getges_semestre(),getges_estado()});
        ResultSet rs = conexion.obtener("select max(id)from gestion", null);
        rs.next();
        int res = rs.getInt(1);
        conexion.desconectar();
        return res;
    }

    public void modificar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("update gestion set ges_anio=?, ges_semestre=?, ges_estado=? where id=?", new Object[]{getges_anio(),getges_semestre(),getges_estado(),getId()});
        conexion.desconectar();
    }

    public void eliminar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("delete from gestion where id=? ", new Object[]{getId()});
        conexion.desconectar();
    }

    public List<Object[]> listar() throws Exception {
        return listar("", null);
    }

    public List<Object[]> listar(String condicion, Object[] args) throws Exception {
        conexion.conectar();
        String sql = "select * from gestion" + ((!condicion.equals("")) ? " where " + condicion : "");
        ResultSet rs = conexion.obtener(sql, args);
        List<Object[]> l = new LinkedList<Object[]>();
        while (rs.next()) {
            l.add(new Object[]{rs.getInt(1), rs.getString(2),rs.getString(3)});
        }
        conexion.desconectar();
        return l;
    }

    public Object[] obtener() throws Exception {
        conexion.conectar();
        List<Object[]> l = listar("id=?", new Object[]{getId()});
        if (l.size() > 0) {
            setId(Integer.parseInt(l.get(0)[0].toString()));
            setges_anio(Integer.parseInt(l.get(0)[1].toString()));
            setges_semestre(Integer.parseInt(l.get(0)[2].toString()));
            setges_estado(Integer.parseInt(l.get(0)[3].toString()));
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

    public int getges_anio() {
        return ges_anio;
    }
    public void setges_anio(int ges_anio){
         this.ges_anio=ges_anio;
    }

    public int getges_semestre() {
        return ges_semestre;
    }

    public void setges_semestre(int ges_semestre) {
        this.ges_semestre = ges_semestre;
    }
     public int getges_estado() {
        return ges_estado;
    }

    public void setges_estado(int ges_estado) {
        this.ges_estado = ges_estado;
    }

}
