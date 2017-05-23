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
import www.camariweb.org.entidades.clscliente;
import www.camariweb.org.entidades.clsfactura;

/**
 *
 * @author VINICIO-DIAZ
 */
public class crudfactura {
    
//GUARDAR
     public boolean save(clsfactura factura){
        boolean resultado = false;
        String sql = "INSERT INTO public.factura(id_cliente,fecha,subtotal,iva,total) VALUES(?,?,?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, factura.getId().getId()));
        lstPar.add(new Parametro(2, factura.getFecha()));
        lstPar.add(new Parametro(3, factura.getSubtotal()));
         lstPar.add(new Parametro(4,factura.getIva()));
         lstPar.add(new Parametro(5,factura.getTotal()));
      
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }
        return resultado;
    }
    
     ///ELIMINAR
         public boolean delete(clsfactura factura) {
        boolean res=false;
        String sql = "DELETE FROM public.factura WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,factura.getId()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {

                System.out.println(e.getMessage());
            }
        return res;
    }

//          //ACTUALIZAR
         public boolean update(clsfactura factura) {
        boolean res = false;
        String sql = "UPDATE public.factura" +
                "SET =?,id_cliente=?,fecha=?, subtotal=?, iva=?, total=?" + 
                "WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1,factura.getId().getId()));
        lstPar.add(new Parametro(2,factura.getFecha()));
        lstPar.add(new Parametro(3,factura.getSubtotal()));
        lstPar.add(new Parametro(6,factura.getIva()));
        lstPar.add(new Parametro(4,factura.getTotal()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }
         ///BUSQUEDA POR TODOS//
          public ArrayList<clsfactura> findbyAll() {
        ArrayList<clsfactura> listado = new ArrayList<>();
        String sql = "SELECT numerofac, id_cliente, fecha, subtotal, iva, total"+
                "FROM public.factura";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsfactura factura = null;
            while (cres.next())
            {
                factura = new clsfactura();
                factura.setNumerofac(cres.getInt("numerofac"));
                factura.setFecha(cres.getDate("fecha"));
                factura.setSubtotal(cres.getDouble("subtotal"));
                factura.setIva(cres.getDouble("iva"));
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

   
    public static clsfactura findbyId(int id) {
        clsfactura fac = null;
        String sql = "SELECT numerofac, id_cliente, fecha, subtotal, iva, total  FROM public.factura WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                fac = new clsfactura();
                fac.setNumerofac(cres.getInt("nuemerofactura"));
                fac.setFecha(cres.getDate("fecha"));
                fac.setSubtotal(cres.getDouble("subtotal"));
                fac.setIva(cres.getDouble("iva"));
                fac.setTotal(cres.getDouble("total"));
                fac.setId(crudcliente.findbyId(cres.getInt("idcliente")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return fac;
    }

}