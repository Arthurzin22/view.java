package funcionario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import menuPrincipal.MainMenu;

public class FuncionarioView extends JFrame {

    private FuncionarioController controller;

    public FuncionarioView() {
        // Configuração inicial da janela
        setTitle("Cadastro de Funcionários");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Inicializar o controller
        controller = new FuncionarioController();

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
        JLabel lblCodigo = new JLabel("Código:");
        JTextField txtCodigo = new JTextField(20);
        formPanel.add(lblCodigo, gbc);
        gbc.gridx = 1;
        formPanel.add(txtCodigo, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblCargo = new JLabel("Cargo:");
        JTextField txtCargo = new JTextField(20);
        formPanel.add(lblCargo, gbc);
        gbc.gridx = 1;
        formPanel.add(txtCargo, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField(20);
        formPanel.add(lblNome, gbc);
        gbc.gridx = 1;
        formPanel.add(txtNome, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblCPF = new JLabel("CPF:");
        JTextField txtCPF = new JTextField(20);
        formPanel.add(lblCPF, gbc);
        gbc.gridx = 1;
        formPanel.add(txtCPF, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
        JTextField txtDataNascimento = new JTextField(20);
        formPanel.add(lblDataNascimento, gbc);
        gbc.gridx = 1;
        formPanel.add(txtDataNascimento, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblTelefone = new JLabel("Telefone:");
        JTextField txtTelefone = new JTextField(20);
        formPanel.add(lblTelefone, gbc);
        gbc.gridx = 1;
        formPanel.add(txtTelefone, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblEndereco = new JLabel("Endereço:");
        JTextField txtEndereco = new JTextField(20);
        formPanel.add(lblEndereco, gbc);
        gbc.gridx = 1;
        formPanel.add(txtEndereco, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblCEP = new JLabel("CEP:");
        JTextField txtCEP = new JTextField(20);
        formPanel.add(lblCEP, gbc);
        gbc.gridx = 1;
        formPanel.add(txtCEP, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblNumeroCasa = new JLabel("Número da Casa:");
        JTextField txtNumeroCasa = new JTextField(20);
        formPanel.add(lblNumeroCasa, gbc);
        gbc.gridx = 1;
        formPanel.add(txtNumeroCasa, gbc);

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
                    FuncionarioModel funcionario = new FuncionarioModel(
                            txtCodigo.getText(),
                            txtCargo.getText(),
                            txtNome.getText(),
                            txtCPF.getText(),
                            txtDataNascimento.getText(),
                            txtTelefone.getText(),
                            txtEndereco.getText(),
                            txtCEP.getText(),
                            "Local", // Pode adicionar campos adicionais se necessário
                            txtNumeroCasa.getText(),
                            txtBairro.getText(),
                            txtCidade.getText(),
                            txtEstado.getText(),
                            new String(txtSenha.getPassword())
                    );
                    controller.salvarFuncionario(funcionario);
                    JOptionPane.showMessageDialog(null, "Funcionário salvo com sucesso!");
                    dispose();
                    new MainMenu().MenuPrincipal();
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar funcionário: " + ex.getMessage());
                }
            }
        });

        // Adicionar componentes ao frame
        add(logoPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);

        // Tornar visível
        setVisible(true);
    }
}
