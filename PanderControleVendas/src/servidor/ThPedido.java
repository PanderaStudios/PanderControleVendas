package servidor;

import comum.controle.ControleComunicacao;
import controle.ControlePedido;
import java.io.IOException;
import java.net.Socket;
import modelo.Pedido;

public class ThPedido extends Thread {

    private Socket ped;

    public ThPedido(Socket ped) {
        this.ped = ped;
    }

    @Override
    public void run() {
        try {
            ControleComunicacao c1 = new ControleComunicacao(ped);

            ControlePedido cPedido = new ControlePedido();

            while (true) {
                String comando = c1.receberTexto();

                if ("P".equals(comando)) {
                    System.out.println("Servidor ThPedido - persistir");
                    c1.enviarTexto("Servidor ThPedido - persistir");
                    cPedido.persistir((Pedido) c1.receberObjeto());
                    ControlePedido.armazenar();
                }

                if ("R".equals(comando)) {
                    System.out.println("Servidor ThPedido - remover");
                    c1.enviarTexto("Servidor ThPedido - remover");
                    cPedido.remover(c1.receberTexto());
                    ControlePedido.armazenar();
                }

                if ("O".equals(comando)) {
                    System.out.println("Servidor ThPedido - obter");
                    c1.enviarTexto("Servidor ThPedido - obter");
                    String cpf = c1.receberTexto();
                    c1.enviarObjeto(cPedido.obter(cpf));
                }

                if ("G".equals(comando)) {
                    ControlePedido.armazenar();
                }

                if ("C".equals(comando)) {
                    ControlePedido.carregar();
                }

                if ("T".equals(comando)) {
                    System.out.println("Servidor ThPedido - obter todos");
                    c1.enviarTexto("Servidor ThPedido - obter todos");
                    c1.enviarObjeto(cPedido.obterTodosPedidos());
                }

//                c1.enviarObjeto(cPedido.obterTodosPedidos());

            }
        } catch (IOException | ClassNotFoundException ex) {
        }
    }

}
