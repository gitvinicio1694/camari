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

/**
 *
 * @author USU-PC
 */
public class crudDetalleFacturaProducto {
    //GUARDAR
     public boolean save(clsDestalleFacturaProducto dfactura){
        boolean resultado = false;
        String sql = "INSERT INTO public.DFacturaProducto(numerfac,idproducto,cantidad,subtotal) VALUES(?,?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        //lstPar.add(new Parametro(1, dfactura.getNumerofac().getNumerofac()));
        lstPar.add(new Parametro(1, dfactura.getIdproducto().getIdproducto()));
        lstPar.add(new Parametro(2, dfactura.getCantidad()));
         lstPar.add(new Parametro(3, dfactura.getSubtotal()));
      
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
          
        }
        return resultado;
    }
    
     ///ELIMINAR
         public boolean delete(clsDestalleFacturaProducto dfactura) {
        boolean res=false;
        String sql = "DELETE FROM public.DFacturaProducto WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,dfactura.getId()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {

                System.out.println(e.getMessage());
            }
        return res;
    }

//          //ACTUALIZAR
         public boolean update(clsDestalleFacturaProducto dfactura) {
        boolean res = false;
        String sql = "UPDATE public.DFacturaProducto" +
                "SET raza=?,tamaño=?,genero=?, idpropietario=?" + 
                "WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1,dfactura.getNumerofac().getNumerofac()));
        lstPar.add(new Parametro(2,dfactura.getIdproducto().getIdproducto()));
        lstPar.add(new Parametro(3,dfactura.getCantidad()));
        lstPar.add(new Parametro(6,dfactura.getSubtotal()));
        lstPar.add(new Parametro(4,dfactura.getId()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }
         ///BUSQUEDA POR TODOS//
          public ArrayList<clsDestalleFacturaProducto> findbyAll() {
        ArrayList<clsDestalleFacturaProducto> listado = new ArrayList<>();
        String sql = "SELECT id, raza, tamaño, genero, idpropietario"+
                "FROM public.DFacturaProducto";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsDestalleFacturaProducto dfactura = null;
            while (cres.next())
            {
                dfactura = new clsDestalleFacturaProducto();
                dfactura.setId(cres.getInt("id"));
                dfactura.setCantidad(cres.getInt("cantidad"));
                dfactura.setSubtotal(cres.getDouble("subtotal"));
                //dfactura.setGenero(cres.getString("genero"));
               // dfactura.setIdpropietario(crudPropietario.findbyId(cres.getInt("idpropietario")));
                listado.add((dfactura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
          
///BUSQUEDA POR ID//
//    public clsMascota findbyId(clsMascota pro) {
//        clsMascota masc = null;
//        String sql = "SELECT id, raza, tamaño, genero, idpropietario FROM public.mascota WHERE id=?";
//        ArrayList<Parametro> lstPar = new ArrayList<>();
//        lstPar.add(new Parametro(1, pro.getId()));
//        try {
//            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
//            while (cres.next()) {
//                masc = new clsMascota();
//                masc.setId(cres.getInt("id"));
//                masc.setRaza(cres.getString("raza"));
//                masc.setTamaño(cres.getString("tamaño"));
//                masc.setGenero(cres.getString("genero"));
//                masc.setIdpropietario(crudPropietario.findbyId(cres.getInt("idpropietario")));
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return masc;
//    }
//    public static clsMascota findbyId(int id) {
//        clsMascota masc = null;
//        String sql = "SELECT id, raza, tamaño, genero,idpropietario  FROM public.mascota WHERE id=?";
//        ArrayList<Parametro> lstPar = new ArrayList<>();
//        lstPar.add(new Parametro(1, id));
//        try {
//            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
//            while (cres.next()) {
//                masc = new clsMascota();
//                masc.setId(cres.getInt("id"));
//                masc.setRaza(cres.getString("raza"));
//                masc.setTamaño(cres.getString("tamaño"));
//                masc.setGenero(cres.getString("genero"));
//                masc.setIdpropietario(crudPropietario.findbyId(cres.getInt("idpropietario")));
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return masc;
//    }
}

//    
    