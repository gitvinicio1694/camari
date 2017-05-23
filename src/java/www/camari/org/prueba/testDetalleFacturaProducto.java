/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.camari.org.prueba;

import ec.org.camariweb.funciones.crudDetalleFacturaProducto;
import ec.org.camariweb.funciones.crudfactura;
import www.camariweb.org.entidades.clscliente;
import www.camariweb.org.entidades.clsfactura;
import www.camariweb.org.entidades. clsDestalleFacturaProducto;
import www.camariweb.org.entidades.clsproducto;
/*
 *
 * @author VINICIO-DIAZ
 */
public class testDetalleFacturaProducto {
    public static void main(String[] args) {
          
       //clsfactura fac = new clsfactura (01,null,0,0,0,cli);
       clsproducto pro = new clsproducto(01, "libro", 20, 30);
       clsDestalleFacturaProducto dell = new    clsDestalleFacturaProducto (01,pro,null, 20, 21);
       
   
        crudDetalleFacturaProducto res= new crudDetalleFacturaProducto();
        System.out.println("Prueba de clases");
        System.out.println("=============================================");
        System.out.println("contenido de la clase c");
        System.out.println(dell.toString());
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("INSERTANDO");
        if (res.save(dell)) {
            System.out.println("Guardado");
        } else {
            System.out.println("error!!!!");
        }
    }
}

