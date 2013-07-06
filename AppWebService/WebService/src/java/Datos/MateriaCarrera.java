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
public class MateriaCarrera {
   private int id;
    private int matC_mat_id;
    private int matC_car_id;
    private Conexion conexion;

    public MateriaCarrera() {
        conexion = new Conexion();
    }

    public int insertar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("insert into materiacarrera values (default, ?, ?)", new Object[]{getmatC_mat_id(),getmatC_car_id()});
        ResultSet rs = conexion.obtener("select max(id)from materiacarrera", null);
        rs.next();
        int res = rs.getInt(1);
        conexion.desconectar();
        return res;
    }

    public void modificar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("update materiacarrera set matC_mat_id=?, matC_car_id=? where id=?", new Object[]{getmatC_mat_id(),getmatC_car_id(),getId()});
        conexion.desconectar();
    }

    public void eliminar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("delete from materiacarrera where id=? ", new Object[]{getId()});
        conexion.desconectar();
    }

    public List<Object[]> listar() throws Exception {
        return listar("", null);
    }

    public List<Object[]> listar(String condicion, Object[] args) throws Exception {
        conexion.conectar();
        String sql = "select * from materiacarrera" + ((!condicion.equals("")) ? " where " + condicion : "");
        ResultSet rs = conexion.obtener(sql, args);
        List<Object[]> l = new LinkedList<Object[]>();
        while (rs.next()) {
            l.add(new Object[]{rs.getInt(1), rs.getString(2)});
        }
        conexion.desconectar();
        return l;
    }

    public Object[] obtener() throws Exception {
        conexion.conectar();
        List<Object[]> l = listar("id=?", new Object[]{getId()});
        if (l.size() > 0) {
            setId(Integer.parseInt(l.get(0)[0].toString()));
            setmatC_mat_id(Integer.parseInt(l.get(0)[1].toString()));
            setmatC_car_id(Integer.parseInt(l.get(0)[2].toString()));
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

    public int getmatC_mat_id() {
        return matC_mat_id;
    }
    public void setmatC_mat_id(int matC_mat_id){
         this.matC_mat_id=matC_mat_id;
    }

     public int getmatC_car_id() {
        return matC_car_id;
    }
    public void setmatC_car_id(int matC_car_id){
         this.matC_car_id=matC_car_id;
    }
    
}
