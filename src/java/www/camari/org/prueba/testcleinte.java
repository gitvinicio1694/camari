/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.camari.org.prueba;

import ec.org.camariweb.funciones.crudcliente;
import www.camariweb.org.entidades.clscliente;

/**
 *
 * @author VINICIO-DIAZ
 */
public class testcleinte {
      public static void main(String[] args) {
         
//        
        clscliente po = new clscliente(02, 1600089954, "ismael", "recreo");
 
        crudcliente cc = new crudcliente();
        
        System.out.println("Prueba de clases");
        System.out.println("=============================================");
        System.out.println("contenido de la clase propietario");
        System.out.println(po.toString());
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("INSERTANDO");
        if (cc.save(po)) {
            System.out.println("Guardado");
        }else{
            System.out.println("error!!!!");
        }
        System.out.println("Comprobando si hay datos");
        //System.out.println(cc.findbyId(po).toString());
        System.out.println("=============================================");
        System.out.println("=============================================");
//        System.out.println("Eliminando");    
//        if (cc.delete(po)) {
//            System.out.println("eliminado");
//        }else{
//            System.out.println("no se ha podido eliminar");
//        }
     }
    
}
