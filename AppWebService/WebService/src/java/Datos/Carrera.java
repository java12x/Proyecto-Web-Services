/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Datos.Conexion;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author JAVA
 */
public class Carrera {

    private int id;
    private String car_nombre;
    private String car_descripcion ;
    private int car_estado ;
    private Conexion conexion;

    public Carrera() {
        conexion = new Conexion();
    }

    public int insertar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("insert into carrera values (default, ?, ?, ?)", new Object[]{getcar_nombre(),getcar_descripcion(),getcar_estado()});
        ResultSet rs = conexion.obtener("select max(id)from carrera", null);
        rs.next();
        int res = rs.getInt(1);
        conexion.desconectar();
        return res;
    }

    public void modificar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("update carrera set car_nombre=?, car_descripcion=?, car_estado=? where id=?", new Object[]{getcar_nombre(),getcar_descripcion(),getcar_estado(), getId()});
        conexion.desconectar();
    }

    public void eliminar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("delete from carrera where id=? ", new Object[]{getId()});
        conexion.desconectar();
    }

    public List<Object[]> listar() throws Exception {
        return listar("", null);
    }

    public List<Object[]> listar(String condicion, Object[] args) throws Exception {
        conexion.conectar();
        String sql = "select * from carrera" + ((!condicion.equals("")) ? " where " + condicion : "");
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
            setcar_nombre((l.get(0)[1].toString()));
            setcar_descripcion(l.get(0)[2].toString());
            setcar_estado(Integer.parseInt(l.get(0)[3].toString()));
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

    public String getcar_nombre() {
        return car_nombre;
    }

    public void setcar_nombre(String car_nombre) {
        this.car_nombre = car_nombre;
    }

    public String getcar_descripcion() {
        return car_descripcion;
    }

    public void setcar_descripcion(String car_descripcion) {
        this.car_descripcion = car_descripcion;
    }

    public int getcar_estado() {
        return car_estado;
    }

    public void setcar_estado(int car_estado) {
        this.car_estado=car_estado;
    }

}

