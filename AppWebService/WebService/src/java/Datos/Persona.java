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
public class Persona {
    
private int id;
    private String per_ci;
    private String per_nombres;
    private String per_apellidos;
    private String per_genero;
    private String per_fechanac;
    private String per_telefono;
    private String per_telefonomovil;
    private String per_email;
    private Conexion conexion;

    public Persona() {
        conexion = new Conexion();
    }

    public int insertar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("insert into persona values (default, ?, ?, ?, ?, ?, ?, ?, ?)", new Object[]{getper_ci(),getper_nombres(),getper_apellidos(),getper_genero(),getper_fechanac(),getper_telefono(),getper_telefonomovil(),getper_email()});
        ResultSet rs = conexion.obtener("select max(id)from persona", null);
        rs.next();
        int res = rs.getInt(1);
        conexion.desconectar();
        return res;
    }

    public void modificar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("update persona set ci=?, nombres=?, apellidos=?, genero=?, fechanac=?, telefono=?, telefonomovil=?, email=? where id=?", new Object[]{getper_ci(),getper_nombres(),getper_apellidos(),getper_genero(),getper_fechanac(),getper_telefono(),getper_telefonomovil(),getper_email(),getId()});
        conexion.desconectar();
    }

    public void eliminar() throws Exception {
        conexion.conectar();
        conexion.ejecutar("delete from persona where id=? ", new Object[]{getId()});
        conexion.desconectar();
    }

    public List<Object[]> listar() throws Exception {
        return listar("", null);
    }

    public List<Object[]> listar(String condicion, Object[] args) throws Exception {
        conexion.conectar();
        String sql = "select * from persona" + ((!condicion.equals("")) ? " where " + condicion : "");
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
            setper_ci(l.get(0)[1].toString());
            setper_nombres(l.get(0)[2].toString());
            setper_apellidos(l.get(0)[3].toString());
            setper_genero(l.get(0)[4].toString());
            setper_fechanac(l.get(0)[5].toString());
            setper_telefono(l.get(0)[6].toString());
            setper_telefonomovil(l.get(0)[7].toString());
            setper_email(l.get(0)[8].toString());
            
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

    public String getper_ci() {
        return per_ci;
    }
    public void setper_ci(String per_ci){
         this.per_ci=per_ci;
    }

    public String getper_nombres() {
        return per_nombres;
    }

    public void setper_nombres(String per_nombres) {
        this.per_nombres = per_nombres;

    }
    public String getper_apellidos() {
        return per_apellidos;
    }

    public void setper_apellidos(String per_apellidos) {
        this.per_apellidos = per_apellidos;

    }
      public String getper_genero() {
        return per_genero;
    }

    public void setper_genero(String per_genero) {
        this.per_genero = per_genero;
    }
         public String getper_fechanac() {
        return per_fechanac;
    }

    public void setper_fechanac(String per_fechanac) {
        this.per_fechanac = per_fechanac;
    }
       public String getper_telefono() {
        return per_telefono;
    }

    public void setper_telefono(String per_telefono) {
        this.per_telefono = per_telefono;
    }
          public String getper_telefonomovil() {
        return per_telefonomovil;
    }

    public void setper_telefonomovil(String per_telefonomovil) {
        this.per_telefonomovil = per_telefonomovil;
    }
          public String getper_email() {
        return per_email;
    }

    public void setper_email(String per_email) {
        this.per_email = per_email;
    }
  
    
}

