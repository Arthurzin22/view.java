package menuPrincipal;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class MainMenu extends JFrame {

    public class Caminhos {
        private String logoPrincipal = "src/images/dv.png";

        public String LogoPrincipal() {
            return this.logoPrincipal;
        }
    }

    public void MenuPrincipal() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Banco Malvader");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Agora no frame correto
            frame.setUndecorated(false); // Opcional, remova bordas se quiser
            Image icon = Toolkit.getDefaultToolkit().getImage("src/images/dv.png");
            frame.setIconImage(icon);

            // Painel principal com BoxLayout (Y_AXIS)
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza o painel

            // Fonts
            Font malvaderFont = null;
            Font padraoFont = null;

            // Carregando fonts
            try {
                padraoFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Nunito-VariableFont_wght.ttf"));
                malvaderFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/SHAXIZOR.TTF"));
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(malvaderFont);
                ge.registerFont(padraoFont);
            } catch (FontFormatException | IOException e) {
                e.printStackTrace();
            }

            // Logo e boas-vindas
            ImageIcon imageIcon = new ImageIcon(new Caminhos().LogoPrincipal());
            JLabel imageLabel = new JLabel(imageIcon);
            JLabel label = new JLabel("Bem-vindo ao Banco Malvader!");
            JLabel textMenu = new JLabel("Menu Principal");
            JLabel selecao = new JLabel("Selecione a opção desejada");

            // Flex dos componentes principais
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
            label.setAlignmentX(Component.CENTER_ALIGNMENT); 
            textMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
            selecao.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Margens
            selecao.setBorder(BorderFactory.createEmptyBorder(100, 10, 10, 10));

            mainPanel.add(imageLabel);
            mainPanel.add(label);
            mainPanel.add(textMenu);
            mainPanel.add(selecao);

            JPanel buttonPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            
            gbc.fill = GridBagConstraints.HORIZONTAL; 
            
            JButton buttonCliente = new JButton("CLIENTE");
            JButton buttonFuncionario = new JButton("FUNCIONARIO");
            JButton buttonSair = new JButton("SAIR DO PROGRAMA");

            // Definindo largura e altura dos botões
            Dimension buttonSize = new Dimension(400, 40); 
            
            buttonCliente.setPreferredSize(buttonSize);
            buttonFuncionario.setPreferredSize(buttonSize);
            buttonSair.setPreferredSize(buttonSize);

            // Definindo as fontes
            if (malvaderFont != null && padraoFont != null) {
                label.setFont(padraoFont.deriveFont(20f));
                textMenu.setFont(malvaderFont.deriveFont(44f));
                buttonCliente.setFont(padraoFont.deriveFont(15f));
                buttonFuncionario.setFont(padraoFont.deriveFont(15f));
                buttonSair.setFont(padraoFont.deriveFont(15f));
                selecao.setFont(padraoFont.deriveFont(15f));
              } else {
                label.setFont(new Font("Arial", Font.BOLD, 24));
                textMenu.setFont(new Font("Arial", Font.BOLD, 44));
                buttonCliente.setFont(new Font("Arial", Font.BOLD, 44));
                buttonFuncionario.setFont(new Font("Arial", Font.BOLD, 44));
                buttonSair.setFont(new Font("Arial", Font.BOLD, 44));
                selecao.setFont(new Font("Arial", Font.BOLD, 44));
              }

              estilizarBotao(
                buttonCliente, Color.BLACK,
                new Color(163, 162, 162),
                Color.BLACK,
                new Color(230, 227, 227),
                new Color(163, 162, 162)
                );

              estilizarBotao(
                buttonFuncionario,
                Color.BLACK,
                new Color(163, 162, 162),
                Color.BLACK,
                new Color(230, 227, 227),
                new Color(163, 162, 162)
                );

              estilizarBotao(
                buttonSair,
                Color.RED,
                Color.RED,
                Color.WHITE,
                new Color(184, 18, 21),
                Color.RED
                );

            
              gbc.gridx = 0;
              gbc.gridy = 0;
              gbc.insets = new Insets(0, 5, 5, 5); 
              buttonPanel.add(buttonCliente, gbc);

    
              gbc.gridy++;
              gbc.insets = new Insets(5, 5, 5, 5); 
              buttonPanel.add(buttonFuncionario, gbc);

    
              gbc.gridy++;
              buttonPanel.add(buttonSair, gbc);

              mainPanel.add(buttonPanel);
              frame.add(mainPanel);

              frame.pack(); 
              frame.setVisible(true);
        });
    }

    private void estilizarBotao(JButton botao, Color color,Color borda,Color colorHover,Color backgroundHover,Color bordaHover) {
        botao.setOpaque(false); 
        botao.setContentAreaFilled(false); 
        botao.setBorder(new LineBorder(borda, 1, true)); 
        botao.setForeground(color); 
        botao.setFocusPainted(false); 
        botao.setPreferredSize(new Dimension(400, 40)); 

        botao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botao.setOpaque(true); 
                botao.setBackground(backgroundHover);
                botao.setForeground(colorHover); 
                botao.setBorder(new LineBorder(bordaHover, 1, true)); 
                botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botao.setOpaque(false); 
                botao.setForeground(color); 
                botao.setBorder(new LineBorder(borda, 1, true)); 
            }
        });
    }
}