package clientePoupanca;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import menuPrincipal.MainMenu;

public class ClientePoupancaView extends JFrame {

    private ClientePoupancaController controller;

    public ClientePoupancaView() {
        // Configuração inicial da janela
        setTitle("Cadastro de Cliente Poupança");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Inicializar o controller
        controller = new ClientePoupancaController();

        // Painel para a logo
        JPanel logoPanel = new JPanel();
        logoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel logoLabel = new JLabel(new ImageIcon("src/images/dv.png"));
        logoPanel.add(logoLabel);

        // Painel para os campos de formulário
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Adicionar campos ao formulário
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField(20);
        formPanel.add(lblNome, gbc);
        gbc.gridx = 1;
        formPanel.add(txtNome, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblCpf = new JLabel("CPF:");
        JTextField txtCpf = new JTextField(20);
        formPanel.add(lblCpf, gbc);
        gbc.gridx = 1;
        formPanel.add(txtCpf, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
        JTextField txtDataNascimento = new JTextField(20);
        formPanel.add(lblDataNascimento, gbc);
        gbc.gridx = 1;
        formPanel.add(txtDataNascimento, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblAgencia = new JLabel("Agência:");
        JTextField txtAgencia = new JTextField(20);
        formPanel.add(lblAgencia, gbc);
        gbc.gridx = 1;
        formPanel.add(txtAgencia, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblConta = new JLabel("Conta:");
        JTextField txtConta = new JTextField(20);
        formPanel.add(lblConta, gbc);
        gbc.gridx = 1;
        formPanel.add(txtConta, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblDDD = new JLabel("DDD Telefone:");
        JTextField txtDddTelefone = new JTextField(20);
        formPanel.add(lblDDD, gbc);
        gbc.gridx = 1;
        formPanel.add(txtDddTelefone, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblTelefone = new JLabel("Telefone:");
        JTextField txtTelefone = new JTextField(20);
        formPanel.add(lblTelefone, gbc);
        gbc.gridx = 1;
        formPanel.add(txtTelefone, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblLogradouro = new JLabel("Logradouro:");
        JTextField txtLogradouro = new JTextField(20);
        formPanel.add(lblLogradouro, gbc);
        gbc.gridx = 1;
        formPanel.add(txtLogradouro, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblNumero = new JLabel("Número:");
        JTextField txtNumero = new JTextField(20);
        formPanel.add(lblNumero, gbc);
        gbc.gridx = 1;
        formPanel.add(txtNumero, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblComplemento = new JLabel("Complemento:");
        JTextField txtComplemento = new JTextField(20);
        formPanel.add(lblComplemento, gbc);
        gbc.gridx = 1;
        formPanel.add(txtComplemento, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblBairro = new JLabel("Bairro:");
        JTextField txtBairro = new JTextField(20);
        formPanel.add(lblBairro, gbc);
        gbc.gridx = 1;
        formPanel.add(txtBairro, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblCidade = new JLabel("Cidade:");
        JTextField txtCidade = new JTextField(20);
        formPanel.add(lblCidade, gbc);
        gbc.gridx = 1;
        formPanel.add(txtCidade, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblEstado = new JLabel("Estado:");
        JTextField txtEstado = new JTextField(20);
        formPanel.add(lblEstado, gbc);
        gbc.gridx = 1;
        formPanel.add(txtEstado, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblCep = new JLabel("CEP:");
        JTextField txtCep = new JTextField(20);
        formPanel.add(lblCep, gbc);
        gbc.gridx = 1;
        formPanel.add(txtCep, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField(20);
        formPanel.add(lblSenha, gbc);
        gbc.gridx = 1;
        formPanel.add(txtSenha, gbc);

        // Botão de salvar
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton btnSalvar = new JButton("Salvar");
        formPanel.add(btnSalvar, gbc);

        // Adicionar ação ao botão
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ClientePoupancaModel clientePoupanca = new ClientePoupancaModel(
                        txtNome.getText(),
                        txtCpf.getText(),
                        txtDataNascimento.getText(),
                        txtAgencia.getText(),
                        txtConta.getText(),
                        0.0,
                        txtDddTelefone.getText(),
                        txtTelefone.getText(),
                        txtLogradouro.getText(),
                        txtNumero.getText(),
                        txtComplemento.getText(),
                        txtBairro.getText(),
                        txtCidade.getText(),
                        txtEstado.getText(),
                        txtCep.getText(),
                        new String(txtSenha.getPassword())
                    );
                    
                    controller.salvarClientePoupanca(clientePoupanca);
                    JOptionPane.showMessageDialog(null, "Cliente Poupança salvo com sucesso!");
                    dispose();
                    new MainMenu().MenuPrincipal();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar cliente poupança: " + ex.getMessage());
                }
            }

            private Double Double(int i) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        // Adicionar componentes ao frame
        add(logoPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);

        // Tornar visível
        setVisible(true);
    }
}
