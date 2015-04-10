package servidor;

import comum.controle.ControleComunicacao;
import controle.ControleCliente;
import controle.ControlePedido;
import controle.ControleProduto;
import java.io.IOException;
import java.net.Socket;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

public class ThCliente extends Thread {

    private Socket s;
//    private Object ctrl;
//   private Object arq;
    private int tipo;

    public ThCliente(Socket s, int tipo) {
        this.s = s;
        this.tipo = tipo;
    }

    @Override
    public void run() {
        try {
            ControleComunicacao c1 = new ControleComunicacao(s);

            while (true) {
                String comando = c1.receberTexto();
                if ("P".equals(comando)) {
                    System.out.println("Servidor ThCliente - persistir");
                    c1.enviarTexto("Servidor ThCliente - persistir");
                    if (tipo == 0) {
                        System.out.println("Servidor ThCliente - persistir");
                        c1.enviarTexto("Servidor ThCliente - persistir");
                        new ControleCliente().persistir((Cliente) c1.receberObjeto());
                        ControleCliente.armazenar();
                    } else {
                        if (tipo == 1) {
                            System.out.println("Servidor ThProduto - persistir");
                            c1.enviarTexto("Servidor ThProduto - persistir");
                            new ControleProduto().persistir((Produto) c1.receberObjeto());
                            ControleProduto.armazenar();
                        } else {
                            if (tipo == 2) {
                                System.out.println("Servidor ThPedido - persistir");
                                c1.enviarTexto("Servidor ThPedido - persistir");
                                new ControlePedido().persistir((Pedido) c1.receberObjeto());
                                ControlePedido.armazenar();
                            } else {
                                System.out.println("Servidor NENHUM TIPO - persistir");
                                c1.enviarTexto("Servidor NENHUM TIPO - persistir");
                            }
                        }
                    }
                }

                if ("R".equals(comando)) {
                    System.out.println("Servidor ThCliente - remover");
                    c1.enviarTexto("Servidor ThCliente - remover");
//                    cControl.remover(c1.receberTexto());
                    ControleCliente.armazenar();
                }

                if ("O".equals(comando)) {
                    System.out.println("Servidor ThCliente - obter");
                    c1.enviarTexto("Servidor ThCliente - obter");
                    String cpf = c1.receberTexto();
//                    c1.enviarObjeto(cControl.obter(cpf));
                }

                if ("T".equals(comando)) {
                    System.out.println("Servidor ThCliente - obter todos");
                    c1.enviarTexto("Servidor ThCliente - obter todos");
                    if (tipo == 0) {
                        System.out.println("Servidor ThCliente - obter todos");
                        c1.enviarTexto("Servidor ThCliente - obter todos");
                        c1.enviarObjeto(new ControleCliente().obterTodos());
                    } else {
                        if (tipo == 1) {
                            System.out.println("Servidor ThProduto - obter todos");
                            c1.enviarTexto("Servidor ThProduto - obter todos");
                          c1.enviarObjeto(new ControleProduto().obterTodosProdutos());
                      } else {
                            if (tipo == 2) {
                                System.out.println("Servidor ThPedido - obter todos");
                                c1.enviarTexto("Servidor ThPedido - obter todos");
                          c1.enviarObjeto(new ControlePedido().obterTodosPedidos());
                            } else {
                                System.out.println("Servidor NENHUM TIPO - obter todos");
                                c1.enviarTexto("Servidor NENHUM TIPO - obter todos");
                            }
                        }
                    }
                }

                if ("G".equals(comando)) {
                    ControleCliente.armazenar();
                }

                if ("C".equals(comando)) {
                    ControleCliente.carregar();
                }

//                c1.enviarObjeto(cCliente.obterTodosProdutos());
            }
        } catch (IOException | ClassNotFoundException ex) {
        }
    }

}
