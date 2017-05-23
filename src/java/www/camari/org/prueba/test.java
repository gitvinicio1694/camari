/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.camari.org.prueba;

import ec.org.camariweb.funciones.clsreporte2;
import ec.org.camariweb.funciones.clsreporte3;
import ec.org.camariweb.funciones.clsreporte6;
import ec.org.camariweb.funciones.clsreportes;
import java.util.ArrayList;
import www.camariweb.org.entidades.clscliente;
import www.camariweb.org.entidades.clsfactura;



public class test {
    //psvm tab tab
public static void main(String[] args) {
    
//    ArrayList<clsfactura> factura = new ArrayList<>();
//    factura = clsreportes.clienteFacturaMayorMil();
//    System.out.print(factura.toString());
//
//            
//    }

//    consulta2
//    ArrayList<clsfactura> factura = new ArrayList<>();
//    factura = clsreporte2.numeroComprasCliente();
//    System.out.print(factura.toString());

            
    
 //    consulta3
//    ArrayList<clsfactura> factura = new ArrayList<>();
//    factura = clsreporte3.NumeroComprasTotalCliente();
//    System.out.print(factura.toString());

ArrayList<clsfactura> factura = new ArrayList<>();
    factura = clsreporte6.promedioCompraCliente();
    System.out.print(factura.toString());
}
}