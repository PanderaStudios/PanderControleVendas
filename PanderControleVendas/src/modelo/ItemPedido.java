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

    private String codProd;
    private String nomeProd;
    private int qtdComprada;
    private double valorCompra;

    public ItemPedido(String codProd, String nomeProd, int qtdComprada, double valorCompra) {
        this.codProd = codProd;
        this.nomeProd = nomeProd;
        this.qtdComprada = qtdComprada;
        this.valorCompra = valorCompra;
    }

    public String getCodPed() {
        return codProd;
    }

    public void setCodPed(String codPed) {
        this.codProd = codPed;
    }

    public String getCodProd() {
        return nomeProd;
    }

    public void setCodProd(String codProd) {
        this.nomeProd = codProd;
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
