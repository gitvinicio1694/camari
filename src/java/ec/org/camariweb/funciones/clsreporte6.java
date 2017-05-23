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
import www.camariweb.org.entidades.clsfactura;

/**
 *
 * @author VINICIO-DIAZ
 */
public class clsreporte6 {
    public static ArrayList<clsfactura> promedioCompraCliente() {
 ArrayList<clsfactura> listado = new ArrayList<>();
 String sql = "SELECT "
 + "AVG(\"public\".factura.total) as Promedio "
 + "FROM "
 + "\"public\".factura";

 ArrayList<Parametro> lstPar = new ArrayList<>();
 try {
 ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
 clsfactura factura = null;
 while (cres.next()) {
 factura = new clsfactura();
 factura.setTotal(cres.getInt("total"));

 listado.add((factura));
 }
 } catch (Exception e) {
 System.out.println(e.getMessage());
 }
 return listado;
 }
    
}
