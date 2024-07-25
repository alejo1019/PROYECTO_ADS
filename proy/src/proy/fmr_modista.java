package proy;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class fmr_modista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//calse anuncio 
	public fmr_anuncio an;
	
	 //conexion servidor BD
    private static final String DB_URL = "jdbc:mysql://localhost:3306/proyecto";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

	
	public fmr_modista() {
		JFrame loginFrame = new JFrame("Iniciar Sesión");
        loginFrame.setBounds(100, 100, 400, 200);
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //loginFrame.setLayout(loginFrame);
        loginFrame.setLayout(null);

        JLabel lblUsername = new JLabel("Usuario:");
        lblUsername.setBounds(30, 30, 100, 30);
        loginFrame.add(lblUsername);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(130, 30, 200, 30);
        loginFrame.add(txtUsername);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(30, 80, 100, 30);
        loginFrame.add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(130, 80, 200, 30);
        loginFrame.add(txtPassword);

        JButton btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setBounds(130, 130, 150, 30);
        loginFrame.add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                String query = String.format("SELECT * FROM trabajadores WHERE usuarios='%s' AND contrasenia='%s';", username, password);
                try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                     PreparedStatement pstmt = conn.prepareStatement(query)) {

                    ResultSet res = pstmt.executeQuery();
                    if (res.next()) {
                        // Abrir la ventana de agregar anuncios si las credenciales son correctas
                    	an = new fmr_anuncio();
                    	//an.setVisible(true);
                        loginFrame.dispose(); // Cierra la ventana de inicio de sesión
                    } else {
                        JOptionPane.showMessageDialog(loginFrame, "Credenciales Incorrectas");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(loginFrame, "Error en la consulta");
                }
            }
        });

        loginFrame.setVisible(true);
    }
	}