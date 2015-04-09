/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import controle.ControleCliente;
import controle.ControleProduto;
import controle.ControlePedido;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author pande_000
 */
public class ThServidor extends Thread {

    /**
     * @param args the command line arguments
     */
    private ServerSocket s0;// = new ServerSocket[ControleCliente.getNUMPORTAS()];
    private ServerSocket s1;
    private ServerSocket s2;
    private Socket sA;// = new Socket[ControleCliente.getNUMPORTAS()];
    private Socket sB;
    private Socket sC;

    private DefaultListModel<String> clienteON;
    private DefaultListModel<String> clienteOFF;

    // Controle de textos na janela
    private JTextField status;
    private JTextField txtNumClientes;

    private int numCliente;
    private String ipCliente;

    public ThServidor(DefaultListModel clienteON, DefaultListModel clienteOFF, JTextField status, JTextField txtNumClientes) {
        this.status = status;
        this.clienteON = clienteON;
        this.clienteOFF = clienteOFF;
        this.txtNumClientes = txtNumClientes;
        try {
            s0 = new ServerSocket();
            s1 = new ServerSocket();
            s2 = new ServerSocket();
        } catch (IOException ex) {
            Logger.getLogger(ThServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        sA = new Socket();
        sB = new Socket();
        sC = new Socket();

        preActions();
    }

    public void pararServ() {
        //      this.thcliente.interrupt();
        try {
            clienteOFF.insertElementAt(numCliente + " - IP: " + sA.getInetAddress(), 0);

        } catch (Exception ex) {

        }
        try {
            s0.close();
            s1.close();
            s2.close();
        } catch (IOException ex) {
            Logger.getLogger(ThServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preActions() {

        numCliente = 0;
        ipCliente = "255.255.255.1";

        try {
            s0 = new ServerSocket(ControleCliente.getPorta(0));
            s1 = new ServerSocket(ControleCliente.getPorta(1));
            s2 = new ServerSocket(ControleCliente.getPorta(2));
        } catch (IOException ex) {
            Logger.getLogger(ThServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        // TODO code application logic here
        System.out.println("Classe Servidor Play - run()");
        status.setText("ONLINE");
        txtNumClientes.setText("" + numCliente);

        try {
            ControleCliente.carregar();
            status.setText("ONLINE");
            txtNumClientes.setText("" + numCliente);

        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível Ler o Arquivo Cliente !!!",
                    "Servidor", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(ThServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ControleProduto.carregar();
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível Ler o Arquivo Produto !!!",
                    "Servidor", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(ThServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ControlePedido.carregar();
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível Ler o Arquivo Pedido !!!",
                    "Servidor", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(ThServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {

            try {
//                for (int i = 0; i < ControleCliente.getNUMPORTAS(); i++) {
                    sA = s0.accept();
//                }
                sB = s1.accept();
                sC = s2.accept();
//                for (int i = 0; i < ControleCliente.getNUMPORTAS(); i++) {
                    new ThCliente(sA).start();
                    new ThProduto(sB).start();
                    new ThPedido(sC).start();
                    System.out.println("Cliente Conectado - Porta <" + ControleCliente.getTodasPortas() + "> " + sA.isConnected());
//                }
//                System.out.println("Cliente Conectado Porta 6060> " + sB.isConnected());

            } catch (IOException ex) {
                Logger.getLogger(ThServidor.class.getName()).log(Level.SEVERE, null, ex);
            }

            numCliente++;
            txtNumClientes.setText("" + numCliente);
            clienteON.insertElementAt(numCliente + " - IP: " + sA.getInetAddress(), 0);

            System.out.println("ip>" + sA.getInetAddress());
        }
    }
}
