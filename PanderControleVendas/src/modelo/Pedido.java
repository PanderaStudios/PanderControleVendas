package modelo;

import java.io.Serializable;

public class Pedido implements Serializable {

    private String codPed;
    private String codCli;
    private String nomeCli;
    private ItemPedido codProd;
    
//    String codProdB;

    public Pedido(String codPed, String codCli, String codProd, String nomeCli) {
//        super(codPed, codProd, 0, 0);
        this.codPed = codPed;
        this.codCli = codCli;
        this.nomeCli = nomeCli;
        this.codProd = new ItemPedido(codPed, codProd, 0, 0);
    
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
    public ItemPedido getCodProd() {
        return codProd;
    }

    /**
     * @param codProd the codProd to set
     */
    public void setCodProd(ItemPedido codProd) {
        this.codProd = codProd;
    }

}
