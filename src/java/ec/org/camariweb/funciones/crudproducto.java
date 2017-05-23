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
import www.camariweb.org.entidades.clscliente;
import www.camariweb.org.entidades.clsproducto;

/**
 *
 * @author VINICIO-DIAZ
 */
public class crudproducto {
    
//GUARDAR
     public boolean save(clsproducto pro){
        boolean resultado = false;
        String sql = "INSERT INTO public.producto(nombre,stock,precio_venta) VALUES(?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pro.getNombre()));
        lstPar.add(new Parametro(2, pro.getStock()));
        lstPar.add(new Parametro(3, pro.getPrecio_venta()));
              
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
           
        }
        return resultado;
    }
     
     ///ELIMINAR
        public boolean delete(clsproducto pro) {
        boolean res=false;
        String sql = "DELETE FROM public.producto WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,pro.getIdproducto()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {

                System.out.println(e.getMessage());
            }
        return res;
    }

//          //ACTUALIZAR
         public boolean update(clsproducto pro) {
        boolean res = false;
        String sql = "UPDATE public.producto" +
                "SET nombre=?,stock=?,precio_venta=?" + 
                "WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1,pro.getNombre()));
        lstPar.add(new Parametro(2,pro.getStock()));
        lstPar.add(new Parametro(3,pro.getPrecio_venta()));
        lstPar.add(new Parametro(4,pro.getIdproducto()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }
         ///BUSQUEDA POR TODOS//
          public ArrayList<clsproducto> findbyAll() {
        ArrayList<clsproducto> listado = new ArrayList<>();
        String sql = "SELECT id, nombre, stock, precio_venta "+
                "FROM public.producto";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsproducto cliente = null;
            while (cres.next())
            {
                cliente = new clsproducto();
                cliente.setIdproducto(cres.getInt("id"));
                cliente.setNombre(cres.getString("nombre"));
                cliente.setStock(cres.getInt("stock"));
                cliente.setPrecio_venta(cres.getDouble("precio_venta"));
                //dfactura.setGenero(cres.getString("genero"));
               // dfactura.setIdpropietario(crudPropietario.findbyId(cres.getInt("idpropietario")));
                listado.add((cliente));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
}

