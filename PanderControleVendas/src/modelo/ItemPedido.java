/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author pande_000
 */
public class ItemPedido implements Serializable {

    private String codPed;
    private String codProd;
    private int qtdComprada;
    private double valorCompra;

    public ItemPedido(String codPed, String codProd, int qtdComprada, double valorCompra) {
        this.codPed = codPed;
        this.codProd = codProd;
        this.qtdComprada = qtdComprada;
        this.valorCompra = valorCompra;
    }

    public String getCodPed() {
        return codPed;
    }

    public void setCodPed(String codPed) {
        this.codPed = codPed;
    }

    public String getCodProd() {
        return codProd;
    }

    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

    public int getQtdComprada() {
        return qtdComprada;
    }

    public void setQtdComprada(int qtdComprada) {
        this.qtdComprada = qtdComprada;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

}
