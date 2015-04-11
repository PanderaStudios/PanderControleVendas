package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Pedido implements Serializable {

    private String codPed;
    private String codCli;
    private String nomeCli;
    //   private ItemPedido[] codProd;
    private ItemPedido[] itemPedido;
    private ArrayList<ItemPedido> item;
//    String codProdB;
    private String totalPed;

    public Pedido(String codPed, String codCli, String codProd, String nomeCli, String totalPed) {
//        super(codPed, codProd, 0, 0);
        this.codPed = codPed;
        this.codCli = codCli;
        this.nomeCli = nomeCli;
        this.totalPed = totalPed;

        try {
            item.add(new ItemPedido(codPed, codProd, 0, 0));
        } catch (NullPointerException ex) {

        }
//    codProdB=codProd;
    }

    public String getCodPed() {
        return codPed;
    }

    public void setCodPed(String codPed) {
        this.codPed = codPed;
    }

    public String getCodCli() {
        return codCli;
    }

    public void setCodCli(String codCli) {
        this.codCli = codCli;
    }

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }

    //  public String getCodProdB() {
    //      return codProdB;
    //  }
//    public void setCodProdB(String codProdB) {
//        this.codProdB = codProdB;
//    }
    /**
     * @return the codProd
     */
//    public ItemPedido getCodProd() {
//        return codProd;
//    }
    /**
     * @param codProd the codProd to set
     */
    public void setCodProd(String codProd) {
        ItemPedido itemPedido = new ItemPedido(codPed, codProd, 0, 0);
    }

    public ItemPedido[] getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido[] itemPedido) {
        this.itemPedido = itemPedido;
    }

    public ArrayList<ItemPedido> getItem() {
        return item;
    }

    public void setItem(ArrayList<ItemPedido> item) {
        this.item = item;
    }

    public String getTotalPed() {
        return totalPed;
    }

    public void setTotalPed(String totalPed) {
        this.totalPed = totalPed;
    }

}
