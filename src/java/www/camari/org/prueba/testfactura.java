/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.camari.org.prueba;

import ec.org.camariweb.funciones.crudfactura;
import ec.org.camariweb.funciones.crudproducto;
import www.camariweb.org.entidades.clscliente;
import www.camariweb.org.entidades.clsfactura;
import www.camariweb.org.entidades.clsproducto;

/**
 *
 * @author VINICIO-DIAZ
 */
public class testfactura {
    public static void main(String[] args) {
          
       
        clscliente cli = new clscliente(02, 1600089954, "ismael", "recreo");
       
       clsfactura factura = new clsfactura(01,null,0,0,0,cli);
        crudfactura res= new crudfactura();
        System.out.println("Prueba de clases");
        System.out.println("=============================================");
        System.out.println("contenido de la clase c");
        System.out.println(factura.toString());
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("INSERTANDO");
        if (res.save(factura)) {
            System.out.println("Guardado");
        } else {
            System.out.println("error!!!!");
        }
    
//    
//        System.out.println("Comprobando si hay datos");
//        //System.out.println(res.findbyId(factura).toString());
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//        System.out.println("Eliminando");
//        if (res.delete(factura)) {
//            System.out.println("eliminado");
//        } else {
//            System.out.println("no se ha podido eliminar");
//        }

//
        System.out.println("Comprobando si hay datos");
        //System.out.println(res.findbyId(fac).toString());
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("Actualizando");
        if (res.update(factura)) {
            System.out.println("Actualizado");
        } else {
            System.out.println("no se ha podido actualizar");
        }


//        System.out.println("Comprobando si hay datos");
//        System.out.println(pp.findbyId(p).toString());
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//        System.out.println("Listando");
//        if (pp.findbyAll(p)) {
//            System.out.println("Listado");
//        } else {
//            System.out.println("no se ha podido listar");
//        }





   } 
    

}
