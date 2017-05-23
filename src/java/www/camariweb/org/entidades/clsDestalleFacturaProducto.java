/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.camariweb.org.entidades;

/**
 *
 * @author USU-PC
 */
public class clsDestalleFacturaProducto {
    
     private int _id;
     private clsproducto _idproducto;
     private clsfactura _numerofac;
     private int _cantidad;
     private double _subtotal;

    public clsDestalleFacturaProducto() {
    }

    public clsDestalleFacturaProducto(int _id, clsproducto _idproducto, clsfactura _numerofac, int _cantidad, double _subtotal) {
        this._id = _id;
        this._idproducto = _idproducto;
        this._numerofac = _numerofac;
        this._cantidad = _cantidad;
        this._subtotal = _subtotal;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public clsproducto getIdproducto() {
        return _idproducto;
    }

    public void setIdproducto(clsproducto _idproducto) {
        this._idproducto = _idproducto;
    }

    public clsfactura getNumerofac() {
        return _numerofac;
    }

    public void setNumerofac(clsfactura _numerofac) {
        this._numerofac = _numerofac;
    }

    public int getCantidad() {
        return _cantidad;
    }

    public void setCantidad(int _cantidad) {
        this._cantidad = _cantidad;
    }

    public double getSubtotal() {
        return _subtotal;
    }

    public void setSubtotal(double _subtotal) {
        this._subtotal = _subtotal;
    }

    @Override
    public String toString() {
        return "clsDestalleFacturaProducto{" + "_id=" + _id + ", _idproducto=" + _idproducto + ", _numerofac=" + _numerofac + ", _cantidad=" + _cantidad + ", _subtotal=" + _subtotal + '}';
    }

   
}
