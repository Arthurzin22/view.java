package funcionario;

import clienteCorrente.ClienteCorrenteView;
import clientePoupanca.ClientePoupancaView;
import java.awt.*;
import javax.swing.*;

public class MenuFuncionarioView extends JFrame {

    public MenuFuncionarioView() {
        setTitle("Menu do Funcionário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel para título
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("MENU FUNCIONÁRIO", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnAberturaConta = new JButton("1 – ABERTURA DE CONTA");
        JButton btnEncerramentoConta = new JButton("2 – ENCERRAMENTO DE CONTA");
        JButton btnConsultarDados = new JButton("3 – CONSULTAR DADOS");
        JButton btnAlterarDados = new JButton("4 – ALTERAR DADOS");
        JButton btnCadastroFuncionario = new JButton("5 – CADASTRO DE FUNCIONÁRIOS");
        JButton btnGerarRelatorios = new JButton("6 – GERAR RELATÓRIOS");
        JButton btnSair = new JButton("7 – SAIR");

        // Adicionar botões ao painel
        buttonPanel.add(btnAberturaConta);
        buttonPanel.add(btnEncerramentoConta);
        buttonPanel.add(btnConsultarDados);
        buttonPanel.add(btnAlterarDados);
        buttonPanel.add(btnCadastroFuncionario);
        buttonPanel.add(btnGerarRelatorios);
        buttonPanel.add(btnSair);

        add(buttonPanel, BorderLayout.CENTER);

        // Adicionar ações aos botões
        btnAberturaConta.addActionListener(e -> mostrarMenuAberturaConta());
        btnEncerramentoConta.addActionListener(e -> JOptionPane.showMessageDialog(this, "Encerramento de Conta - Em Desenvolvimento"));
        btnConsultarDados.addActionListener(e -> JOptionPane.showMessageDialog(this, "Consultar Dados - Em Desenvolvimento"));
        btnAlterarDados.addActionListener(e -> JOptionPane.showMessageDialog(this, "Alterar Dados - Em Desenvolvimento"));
        btnCadastroFuncionario.addActionListener(e -> JOptionPane.showMessageDialog(this, "Cadastro de Funcionários - Em Desenvolvimento"));
        btnGerarRelatorios.addActionListener(e -> JOptionPane.showMessageDialog(this, "Gerar Relatórios - Em Desenvolvimento"));
        btnSair.addActionListener(e -> System.exit(0));

        // Tornar a janela visível
        setVisible(true);
    }

    // Submenu para "Abertura de Conta"
    private void mostrarMenuAberturaConta() {
        JFrame subMenuFrame = new JFrame("Abertura de Conta");
        subMenuFrame.setSize(400, 300);
        subMenuFrame.setLocationRelativeTo(this);
        subMenuFrame.setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnContaPoupanca = new JButton("1 – CONTA POUPANÇA - CP");
        JButton btnContaCorrente = new JButton("2 – CONTA CORRENTE - CC");
        JButton btnVoltar = new JButton("3 – VOLTAR");

        subMenuFrame.add(btnContaPoupanca);
        subMenuFrame.add(btnContaCorrente);
        subMenuFrame.add(btnVoltar);

        // Ações do submenu
        btnContaPoupanca.addActionListener(e -> {
            subMenuFrame.dispose(); // Fecha o submenu atual
            new ClientePoupancaView(); // Abre a tela ClientePoupancaView
        });

        btnContaCorrente.addActionListener(e -> {
            subMenuFrame.dispose(); // Fecha o submenu atual
            new ClienteCorrenteView(); // Abre a tela ClienteCorrenteView
        });

        btnVoltar.addActionListener(e -> subMenuFrame.dispose());

        subMenuFrame.setVisible(true);
    }
}
