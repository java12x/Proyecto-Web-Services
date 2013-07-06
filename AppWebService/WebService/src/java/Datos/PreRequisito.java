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
public class PreRequisito {
  private int id;
    private int req_mat_id;
    private int req_matC_id;
    private Conexion conexion;

    public PreRequisito() {
        conexion = new Conexion();
    }

    public int insertar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("insert into PreRequisito values (default, ?, ?)", new Object[]{getreq_mat_id(),getreq_matC_id()});
        ResultSet rs = conexion.obtener("select max(id)from PreRequisito", null);
        rs.next();
        int res = rs.getInt(1);
        conexion.desconectar();
        return res;
    }

    public void modificar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("update PreRequisito set req_mat_id=?, req_matC_id=? where id=?", new Object[]{getreq_mat_id(),getreq_matC_id(),getId()});
        conexion.desconectar();
    }

    public void eliminar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("delete from PreRequisito where id=? ", new Object[]{getId()});
        conexion.desconectar();
    }

    public List<Object[]> listar() throws Exception {
        return listar("", null);
    }

    public List<Object[]> listar(String condicion, Object[] args) throws Exception {
        conexion.conectar();
        String sql = "select * from PreRequisito" + ((!condicion.equals("")) ? " where " + condicion : "");
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
            setreq_mat_id(Integer.parseInt(l.get(0)[1].toString()));
            setreq_matC_id(Integer.parseInt(l.get(0)[2].toString()));
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

    public int getreq_mat_id() {
        return req_mat_id;
    }
    public void setreq_mat_id(int req_mat_id){
         this.req_mat_id=req_mat_id;
    }

     public int getreq_matC_id() {
        return req_matC_id;
    }
    public void setreq_matC_id(int req_matC_id){
         this.req_matC_id=req_matC_id;
    }
      
}
