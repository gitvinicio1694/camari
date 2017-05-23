/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.org.camariweb.funciones;

import ec.org.camariweb.accesodatos.AccesoDatos;
import ec.org.camariweb.accesodatos.ConjuntoResultado;
import ec.org.camariweb.accesodatos.Parametro;
import java.util.ArrayList;
import www.camariweb.org.entidades.clsDestalleFacturaProducto;
import www.camariweb.org.entidades.clsfactura;

/**
 *
 * @author USU-PC
 */
public class clsreportes {
    //listado de todos los clienes con comoras mayores a mil
    //mostrar el numero,fecha,total,y el cliente factura y el nombre del ciente
    
   
     public static ArrayList<clsfactura> clienteFacturaMayorMil() {
        ArrayList<clsfactura> listado = new ArrayList<>();
        String sql = "SELECT\n" +
"\"public\".cliente.nombre,\n" +
"\"public\".cliente.direccion,\n" +
"\"public\".factura.fecha,\n" +
"\"public\".factura.total,\n" +
"\"public\".factura.numerofac\n" +
"FROM\n" +
"\"public\".cliente\n" +
"INNER JOIN \"public\".factura ON \"public\".factura.id_cliente = \"public\".cliente.\"id\"\n" +
"WHERE\n" +
"\"public\".factura.total > '1000'";
                         
            
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsfactura factura = null;
            while (cres.next())
            {
                factura = new clsfactura();
                factura.setNumerofac(cres.getInt("id"));
                factura.setFecha(cres.getDate("fecha"));
                factura.setTotal(cres.getDouble("total"));
                //dfactura.setGenero(cres.getString("genero"));
               // dfactura.setIdpropietario(crudPropietario.findbyId(cres.getInt("idpropietario")));
                listado.add((factura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    
}
