/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proceso;

import java.util.logging.Level;
import java.util.logging.Logger;
//import negocio.GCarrera;
//import negocio.GPersona;
//import negocio.GDocente;
//import negocio.GGestion;
//import negocio.GMateriaCarrera;
//import negocio.GPreRequisito;
//import negocio.GMateria;

/**
 *
 * @author Daniela
 */
public class Procesar {

    private String texto;

    public Procesar(String texto) {
        this.texto = texto.trim();
    }

    public String procesar() {
        try {
            String[] s = texto.split(" ");
            if (texto.trim().toUpperCase().equals("AYUDA")) {
                return ayuda();
            }
            if (s.length < 3) {
                return "Formato no válido, para obtener ayuda, escriba el comando ayuda";
            } else {
                if (!s[0].trim().toUpperCase().equals("GESTIONAR")) {
                    return "Formato no válido, para obtener ayuda, escriba el comando ayuda";
                }
                String tipo = s[1].trim().toUpperCase();
                if (!(tipo.equals("A") || tipo.equals("B") || tipo.equals("M") || tipo.equals("L"))) {
                    return "Formato no válido, para obtener ayuda, escriba el comando ayuda";
                }
                String tabla = s[2].trim().toUpperCase();

                if (!(tabla.equals("PERSONA")
                        || !tabla.equals("DOCENTE")
                        || !tabla.equals("CARRERA")
                        || !tabla.equals("MATERIACARRERA")
                        || !tabla.equals("GESTION")
                        || !tabla.equals("PREREQUISITO")
                        || !tabla.equals("MATERIA"))) {
                    return "Formato no válido, para obtener ayuda, escriba el comando ayuda";
                }
                if (tipo.equals("L")) {
                    return listar(tabla);
                }
                String campos = "";
                for (int i = 3; i < s.length; i++) {
                    campos += s[i] + " ";
                }
                campos = campos.replace("=2C", ",");
                String p[] = campos.split(",");
                if (tipo.equals("B")) {
                    return eliminar(tabla, Integer.parseInt(p[0].trim()));
                }
                if (tipo.equals("A")) {
                    return insertar(tabla, p);
                }
                if (tipo.equals("M")) {
                    return modificar(tabla, p);
                }
            }
        } catch (Exception ex) {
            return "Formato no válido, para obtener ayuda, escriba el comando ayuda";
        }
        return "";
    }

    private String ayuda() {
        return "Estos son los comandos para la Ayuda";
    }

    private String listar(String tabla) {
//        if (tabla.equals("PERSONA")) {
//            GPersona gp = new GPersona();
//            try {
//                return "Listado de Personas\n" + gp.listarString();
//            } catch (Exception ex) {
//                return "Articulos: Ocurrio un error al listar";
//            }
//        }
//           if (tabla.equals("DOCENTE")) {
//            GDocente gd = new GDocente();
//            try {
//                return "Listado de Docente\n" + gd.listarString();
//            } catch (Exception ex) {
//                return "CLientes: Ocurrio un error al listar";
//            }
//        }
//             if (tabla.equals("CARRERA")) {
//            GCarrera gc = new GCarrera();
//            try {
//                return "Listado de carrera\n" + gc.listarString();
//            } catch (Exception ex) {
//                return "pedidos: Ocurrio un error al listar";
//            }
//        }
//             if (tabla.equals("MATERIACARRERA")) {
//            GMateriaCarrera gde = new GMateriaCarrera();
//            try {
//                return "Listado de MateriCcarrera\n" + gde.listarString();
//            } catch (Exception ex) {
//                return "Detalle: Ocurrio un error al listar";
//            }
//        }
//               if (tabla.equals("GESTION")) {
//            GGestion g = new GGestion();
//            try {
//                return "Listado de Gestion\n" + g.listarString();
//            } catch (Exception ex) {
//                return "control: Ocurrio un error al listar";
//            }
//        }
//            if (tabla.equals("PREREQUISITO")) {
//            GPreRequisito grq = new GPreRequisito();
//            try {
//                return "Listado de prerequisito\n" + grq.listarString();
//            } catch (Exception ex) {
//                return "control: Ocurrio un error al listar";
//            }
//        }
//                if (tabla.equals("MATERIA")) {
//            GMateria gmt = new GMateria();
//            try {
//                return "Listado de Materia\n" + gmt.listarString();
//            } catch (Exception ex) {
//                return "control: Ocurrio un error al listar";
//            }
//        }

        return "";
    }

    private String eliminar(String tabla, int id) {
//        if (tabla.equals("PERSONA")){
//            GPersona gp = new GPersona();
//
//            try {
//                gp.eliminar(id);
//            } catch (Exception ex) {
//                return "Ocurrio un error al eliminar el registro";
//
//            }
//        }
//          if (tabla.equals("DOCENTE")){
//           GDocente gd = new GDocente();
//
//            try {
//                gd.eliminar(id);
//            } catch (Exception ex) {
//                return "Ocurrio un error al eliminar el registro";
//
//            }
//        }
//           if (tabla.equals("CARRERA")){
//           GCarrera gc = new GCarrera();
//
//            try {
//                gc.eliminar(id);
//            } catch (Exception ex) {
//                return "Ocurrio un error al eliminar el registro";
//
//            }
//        }
//              if (tabla.equals("MATERIACARRERA")){
//           GMateriaCarrera gm = new GMateriaCarrera();
//
//            try {
//                gm.eliminar(id);
//            } catch (Exception ex) {
//                return "Ocurrio un error al eliminar el registro";
//
//            }
//        }
//               if (tabla.equals("GESTION")){
//           GGestion g = new GGestion();
//
//            try {
//                g.eliminar(id);
//            } catch (Exception ex) {
//                return "Ocurrio un error al eliminar el registro";
//
//            }
//        }
//              if (tabla.equals("PREREQUISITO")){
//           GPreRequisito grq = new GPreRequisito();
//
//            try {
//                grq.eliminar(id);
//            } catch (Exception ex) {
//                return "Ocurrio un error al eliminar el registro";
//
//            }
//        }
//                    if (tabla.equals("MATERIA")){
//           GMateria gmt = new GMateria();
//
//            try {
//                gmt.eliminar(id);
//            } catch (Exception ex) {
//                return "Ocurrio un error al eliminar el registro";
//
//            }
//        }
        return "";

    }

    private String insertar(String tabla, String[] campos) {
        int id = 0;
//        if (tabla.equals("PERSONA")) {
//            GPersona gp = new GPersona();
//            if (campos.length != 8) {
//                return "Parametros incorrectos";
//            }
//            try {
//                id = gp.insertar(campos[0].trim(), campos[1].trim(), campos[2].trim(), campos[3].trim(), campos[4].trim(), campos[5].trim(), campos[6].trim(), campos[7].trim());
//
//            } catch (Exception ex) {
//                return "Ocurrio un error al insertar el registro";
//            }
//        }
//        if (tabla.equals("DOCENTE")) {
//            GDocente gd = new GDocente();
//            if (campos.length != 3) {
//                return "Parametros incorrectos";
//            }
//            try {
//                id = gd.insertar(Integer.parseInt(campos[0].trim()), campos[1].trim(), Integer.parseInt(campos[2].trim()));
//
//            } catch (Exception ex) {
//                return "Ocurrio un error al insertar el registro";
//            }
//        }
        if (tabla.equals("CARRERA")) {

            //GCarrera gc = new GCarrera();
            if (campos.length != 3) {
                return "Parametros incorrectos";
            }
            try {
                //id = gc.insertar(campos[0].trim(), campos[1].trim(), ));

                try { // Call Web Service Operation
                    WServices.WSCarreraService service = new WServices.WSCarreraService();
                    WServices.WSCarrera port = service.getWSCarreraPort();
                    // TODO initialize WS operation arguments here
                    java.lang.String carNombre = campos[0].trim();
                    java.lang.String carDescripcion = campos[1].trim();
                    int carEstado = Integer.parseInt(campos[2].trim());
                    // TODO process result here
                    int result = port.insertarCarrera(campos[0].trim(), campos[1].trim(),Integer.parseInt(campos[2].trim()));
                   //int result = port.insertarCarrera("car1","hhh",1);
                    id=result;
                    System.out.println("Result = "+result);
                } catch (Exception ex) {
                    id=-1;
                    // TODO handle custom exceptions here
                }

            } catch (Exception ex) {
                return "Ocurrio un error al insertar el registro";
            }
        }
//        if (tabla.equals("MATERIACARRERA")) {
//            GMateriaCarrera gm = new GMateriaCarrera();
//            if (campos.length != 2) {
//                return "Parametros incorrectos";
//            }
//            try {
//                id = gm.insertar(Integer.parseInt(campos[0].trim()), Integer.parseInt(campos[1].trim()));
//
//            } catch (Exception ex) {
//                return "Ocurrio un error al insertar el registro";
//            }
//        }
//        if (tabla.equals("GESTION")) {
//            GGestion g = new GGestion();
//            if (campos.length != 3) {
//                return "Parametros incorrectos";
//            }
//            try {
//                id = g.insertar(Integer.parseInt(campos[0].trim()), Integer.parseInt(campos[1].trim()), Integer.parseInt(campos[2].trim()));
//
//            } catch (Exception ex) {
//                return "Ocurrio un error al insertar el registro";
//            }
//        }
//        if (tabla.equals("PREREQUISITO")) {
//            GPreRequisito grq = new GPreRequisito();
//            if (campos.length != 2) {
//                return "Parametros incorrectos";
//            }
//            try {
//                id = grq.insertar(Integer.parseInt(campos[0].trim()), Integer.parseInt(campos[1].trim()));
//
//            } catch (Exception ex) {
//                return "Ocurrio un error al insertar el registro";
//            }
//        }
//        if (tabla.equals("MATERIA")) {
//            GMateria gmt = new GMateria();
//            if (campos.length != 8) {
//                return "Parametros incorrectos";
//            }
//            try {
//                id = gmt.insertar(campos[0].trim(), campos[1].trim(), Integer.parseInt(campos[2].trim()), Float.parseFloat(campos[3].trim()), Float.parseFloat(campos[4].trim()), Float.parseFloat(campos[5].trim()), Float.parseFloat(campos[6].trim()), Integer.parseInt(campos[7].trim()));
//
//            } catch (Exception ex) {
//                return "Ocurrio un error al insertar el registro";
//            }
//        }
        return ": Se inserto el registro correctamente [id=" + id + "]";
    }

    private String modificar(String tabla, String[] campos) {
//        if (tabla.equals("PERSONA")) {
//            GPersona gp = new GPersona();
//            if (campos.length != 9) {
//                return "Parametros incorrectos";
//            }
//            try {
//                gp.modificar(Integer.parseInt(campos[0].trim()), campos[1].trim(), campos[2].trim(), campos[3].trim(), campos[4].trim(), campos[5].trim(), campos[6].trim(), campos[7].trim(), campos[8].trim());
//            } catch (Exception ex) {
//                return "Ocurrio un error al modificar el registro";
//            }
//        }
//
//        if (tabla.equals("DOCENTE")) {
//            GDocente gd = new GDocente();
//            if (campos.length != 4) {
//                return "Parametros incorrectos";
//            }
//            try {
//                gd.modificar(Integer.parseInt(campos[0].trim()), Integer.parseInt(campos[1].trim()), campos[2].trim(), Integer.parseInt(campos[3].trim()));
//            } catch (Exception ex) {
//                return "Ocurrio un error al modificar el registro";
//            }
//
//        }
//        if (tabla.equals("CARRERA")) {
//            GCarrera gc = new GCarrera();
//            if (campos.length != 4) {
//                return "Parametros incorrectos";
//            }
//            try {
//                gc.modificar(Integer.parseInt(campos[0].trim()), campos[1].trim(), campos[2].trim(), Integer.parseInt(campos[3].trim()));
//            } catch (Exception ex) {
//                return "Ocurrio un error al modificar el registro";
//            }
//
//        }
//        if (tabla.equals("MATERIACARRERA")) {
//            GMateriaCarrera gm = new GMateriaCarrera();
//            if (campos.length != 3) {
//                return "Parametros incorrectos";
//            }
//            try {
//                gm.modificar(Integer.parseInt(campos[0].trim()), Integer.parseInt(campos[1].trim()), Integer.parseInt(campos[2].trim()));
//            } catch (Exception ex) {
//                return "Ocurrio un error al modificar el registro";
//            }
//
//        }
//        if (tabla.equals("GESTION")) {
//            GGestion g = new GGestion();
//            if (campos.length != 4) {
//                return "Parametros incorrectos";
//            }
//            try {
//                g.modificar(Integer.parseInt(campos[0].trim()), Integer.parseInt(campos[1].trim()), Integer.parseInt(campos[2].trim()), Integer.parseInt(campos[3].trim()));
//            } catch (Exception ex) {
//                return "Ocurrio un error al modificar el registro";
//            }
//
//        }
//        if (tabla.equals("PREREQUISITO")) {
//            GPreRequisito grq = new GPreRequisito();
//            if (campos.length != 3) {
//                return "Parametros incorrectos";
//            }
//            try {
//                grq.modificar(Integer.parseInt(campos[0].trim()), Integer.parseInt(campos[1].trim()), Integer.parseInt(campos[2].trim()));
//            } catch (Exception ex) {
//                return "Ocurrio un error al modificar el registro";
//            }
//
//        }
//        if (tabla.equals("MATERIA")) {
//            GMateria gmt = new GMateria();
//            if (campos.length != 9) {
//                return "Parametros incorrectos";
//            }
//            try {
//                gmt.modificar(Integer.parseInt(campos[0].trim()), campos[1].trim(), campos[2].trim(), Integer.parseInt(campos[3].trim()), Float.parseFloat(campos[4].trim()), Float.parseFloat(campos[5].trim()), Float.parseFloat(campos[6].trim()), Float.parseFloat(campos[7].trim()), Integer.parseInt(campos[8].trim()));
//            } catch (Exception ex) {
//                return "Ocurrio un error al modificar el registro";
//            }
//        }
        return "Se modifico el registro correctamente [id=" + campos[0] + "]";
    }
}
