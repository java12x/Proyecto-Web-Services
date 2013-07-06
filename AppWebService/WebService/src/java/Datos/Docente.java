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
public class Docente {
    
 private int id;
    private int doc_per_id;
    private String doc_registro;
    private int doc_estado;
    private Conexion conexion;

    public Docente() {
        conexion = new Conexion();
    }

    public int insertar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("insert into docente values (default, ?, ?, ?)", new Object[]{getdoc_per_id(),getdoc_registro(),getdoc_estado()});
        ResultSet rs = conexion.obtener("select max(id)from docente", null);
        rs.next();
        int res = rs.getInt(1);
        conexion.desconectar();
        return res;
    }

    public void modificar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("update docente set doc_per_id=?, doc_registro=?, doc_estado=? where id=?", new Object[]{getdoc_per_id(),getdoc_registro(),getdoc_estado(),getId()});
        conexion.desconectar();
    }

    public void eliminar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("delete from docente where id=? ", new Object[]{getId()});
        conexion.desconectar();
    }

    public List<Object[]> listar() throws Exception {
        return listar("", null);
    }

    public List<Object[]> listar(String condicion, Object[] args) throws Exception {
        conexion.conectar();
        String sql = "select * from docente" + ((!condicion.equals("")) ? " where " + condicion : "");
        ResultSet rs = conexion.obtener(sql, args);
        List<Object[]> l = new LinkedList<Object[]>();
        while (rs.next()) {
            l.add(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3)});
        }
        conexion.desconectar();
        return l;
    }

    public Object[] obtener() throws Exception {
        conexion.conectar();
        List<Object[]> l = listar("id=?", new Object[]{getId()});
        if (l.size() > 0) {
            setId(Integer.parseInt(l.get(0)[0].toString()));
            setdoc_per_id(Integer.parseInt(l.get(0)[1].toString()));
            setdoc_registro(l.get(0)[2].toString());
            setdoc_estado(Integer.parseInt(l.get(0)[3].toString()));
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

    public int getdoc_per_id() {
        return doc_per_id;
    }

    public void setdoc_per_id(int doc_per_id) {
        this.doc_per_id = doc_per_id;
    }

    public String getdoc_registro() {
        return doc_registro;
    }

    public void setdoc_registro(String doc_registro) {
        this.doc_registro = doc_registro;
    }

    public int getdoc_estado() {
        return doc_estado;
    }

    public void setdoc_estado(int doc_estado) {
        this.doc_estado = doc_estado;
    }

   
}

