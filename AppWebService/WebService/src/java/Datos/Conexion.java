package Datos;

import java.sql.*;

public class Conexion {

//    private static String driver = "org.postgresql.Driver";
//    private static String connectString = "jdbc:postgresql://localhost:5432/AdmMysql";
//    private static String user = "kitty";
//    private static String password = "123";
    public static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
    public static final String DRIVER_POSTGRES = "org.postgresql.Driver";
    private String driver;
    private int port;
    private String bd;
    private String hostname;
    private String user;
    private String password;
    private Connection con;
    private boolean enTranasccion;

    public Conexion() {
        this(Conexion.DRIVER_MYSQL, 3306, "uagrm", "127.0.0.1", "root", "root");
    }

    public Conexion(String driver, int port, String bd, String hostname, String user, String password) {
        this.driver = driver;
        this.port = port;
        this.bd = bd;
        this.hostname = hostname;
        this.user = user;
        this.password = password;
        this.enTranasccion = false;
        con = null;
    }

    public String getConnectionString() {
        if (getDriver().equals(Conexion.DRIVER_MYSQL)) {
            return "jdbc:mysql://" + getHostname() + ":" + getPort() + "/" + getBd();
        }
        if (getDriver().equals(Conexion.DRIVER_POSTGRES)) {
            return "jdbc:postgresql://" + getHostname() + ":" + getPort() + "/" + getBd();
        }
        return "";
    }

    public void conectar() throws Exception {
        if (isEnTranasccion() && con != null) {
            return;
        }
        try {
            Class.forName(getDriver());
            con = DriverManager.getConnection(getConnectionString(), getUser(), getPassword());
        } catch (ClassNotFoundException ex) {
            throw new Exception("Ocurrio un error al conectar con el servidor\n" + ex.getMessage());
        } catch (SQLException ex) {
            throw new Exception("Ocurrio un error al conectar con el servidor\n" + ex.getMessage());
        }
    }

    public void desconectar() {
        if (isEnTranasccion()) {
            return;
        }
        try {
            con.close();
            con = null;
        } catch (Exception ex) {
        }
    }

    private void prepStmt(PreparedStatement stmt, Object[] args) throws Exception {
        if (args == null) {
            return;
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Integer) {
                stmt.setInt(i + 1, (Integer) args[i]);
            }
            if (args[i] instanceof String) {
                stmt.setString(i + 1, args[i].toString());
            }
            if (args[i] instanceof Float) {
                stmt.setFloat(i + 1, Float.parseFloat(args[i].toString()));
            }
            if (args[i] instanceof Double) {
                stmt.setDouble(i + 1, Double.parseDouble(args[i].toString()));
            }
            if (args[i] instanceof java.util.Date) {
                stmt.setTimestamp(i + 1, new Timestamp(((java.util.Date) args[i]).getTime()));
            }
        }
    }

    public ResultSet obtener(String sql, Object[] args) throws Exception {
//        conectar();
        ResultSet rs;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            prepStmt(stmt, args);
            rs = stmt.executeQuery();
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error al obtener los datos");
        }
//        desconectar();
        return rs;
    }

    public void ejecutar(String sql, Object[] args) throws Exception {
//        conectar();
        try {
            PreparedStatement stmt;
            stmt = con.prepareStatement(sql);
            prepStmt(stmt, args);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception ex) {
            throw new Exception("Ocurrio un error al ejecutar los comandos");
        }
//        desconectar();
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isEnTranasccion() {
        return enTranasccion;
    }

    public void setEnTranasccion(boolean enTranasccion) throws Exception {
        this.enTranasccion = enTranasccion;
        if (!enTranasccion) {
            desconectar();
        } else {
            conectar();
        }
    }

    public static void main(String[] args) throws Exception {
        Conexion conexion = new Conexion(Conexion.DRIVER_MYSQL, 3306, "mysql", "localhost", "root", "usuario123");
        conexion.conectar();
        ResultSet rs = conexion.obtener("show databases", null);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        conexion.desconectar();
    }
}
