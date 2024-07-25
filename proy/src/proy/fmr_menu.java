package proy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class fmr_menu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txt_ubicacionArchivo;
    private JLabel lblFilePath;
    private File selectedFile;
    private int xMouse, yMouse;
    private List<String> anuncios = new ArrayList<>();
    private List<String> formularios = new ArrayList<>();

   
    public fmr_modista fm;
    public fmr_formulario ff;
    public fmr_anuncio fa;
    //conexion servidor BD
    private static final String DB_URL = "jdbc:mysql://localhost:3306/proyecto";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    fmr_menu frame = new fmr_menu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public fmr_menu() {
    	
    	this.fm = fm;
    	
    	
        setTitle("Creaciones KAS");
        setUndecorated(true); // Remove window border
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Main panel for the layout
        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 900, 600);
        mainPanel.setLayout(null);
        contentPane.add(mainPanel);
        //mainPanel.add(actualizarAnunciosEnMenuPrincipal());

        // Title bar
        JPanel titleBar = new JPanel();
        titleBar.setBounds(0, 0, 900, 30);
        titleBar.setBackground(new Color(0, 128, 128)); // Teal color
        titleBar.setLayout(null);
        mainPanel.add(titleBar);

        // Custom close button
        JButton btn_Close = new JButton("X");
        btn_Close.setBounds(845, 0, 55, 30);
        btn_Close.setFont(new Font("Arial", Font.BOLD, 16));
        btn_Close.setForeground(Color.WHITE);
        btn_Close.setBackground(new Color(255, 0, 0)); // Red color
        btn_Close.setBorderPainted(false);
        btn_Close.setFocusPainted(false);
        btn_Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        titleBar.add(btn_Close);

        // Custom minimize button
        JButton btn_Minimize = new JButton("-");
        btn_Minimize.setBounds(795, 0, 55, 30);
        btn_Minimize.setFont(new Font("Arial", Font.BOLD, 16));
        btn_Minimize.setForeground(Color.WHITE);
        btn_Minimize.setBackground(new Color(255, 165, 0)); // Orange color
        btn_Minimize.setBorderPainted(false);
        btn_Minimize.setFocusPainted(false);
        btn_Minimize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setState(JFrame.ICONIFIED);
            }
        });
        titleBar.add(btn_Minimize);

        // Title drag functionality
        titleBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xMouse = e.getX();
                yMouse = e.getY();
            }
        });

        titleBar.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - xMouse, y - yMouse);
            }
        });

        // Sidebar Panel
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setBounds(0, 30, 200, 570);
        sidebarPanel.setBackground(new Color(30, 30, 30)); // Dark color
        sidebarPanel.setLayout(null);
        mainPanel.add(sidebarPanel);

        // Logo and Title
        JLabel lblTitle = new JLabel("Creaciones KAS");
        lblTitle.setBounds(0, 10, 200, 30);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        sidebarPanel.add(lblTitle);

        // Buttons in Sidebar
        JButton btn_BuscarArchivo = new JButton("Buscar Archivo");
        btn_BuscarArchivo.setBounds(10, 60, 180, 40);
        btn_BuscarArchivo.setBackground(new Color(0, 128, 128)); // Teal color
        btn_BuscarArchivo.setForeground(Color.WHITE);
        btn_BuscarArchivo.setFont(new Font("Arial", Font.PLAIN, 14));
        sidebarPanel.add(btn_BuscarArchivo);

        JButton btn_ENVIAR = new JButton("Enviar");
        btn_ENVIAR.setBounds(10, 110, 180, 40);
        btn_ENVIAR.setBackground(new Color(0, 128, 128)); // Teal color
        btn_ENVIAR.setForeground(Color.WHITE);
        btn_ENVIAR.setFont(new Font("Arial", Font.PLAIN, 14));
        sidebarPanel.add(btn_ENVIAR);

        // New login button
        JButton btn_Login = new JButton("Iniciar Sesión");
        btn_Login.setBounds(10, 160, 180, 40);
        btn_Login.setBackground(new Color(0, 128, 128)); // Teal color
        btn_Login.setForeground(Color.WHITE);
        btn_Login.setFont(new Font("Arial", Font.PLAIN, 14));
        sidebarPanel.add(btn_Login);

        /*JButton btn_Formulario = new JButton("Llenar Formulario");
        btn_Formulario.setBounds(10, 210, 180, 40);
        btn_Formulario.setBackground(new Color(0, 128, 128)); // Teal color
        btn_Formulario.setForeground(Color.WHITE);
        btn_Formulario.setFont(new Font("Arial", Font.PLAIN, 14));
        sidebarPanel.add(btn_Formulario);*/
        
        JButton btn_FillForm = new JButton("Llenar Formulario");
        btn_FillForm.setBounds(10, 210, 180, 40);
        btn_FillForm.setBackground(new Color(0, 128, 128)); // Teal color
        btn_FillForm.setForeground(Color.WHITE);
        btn_FillForm.setFont(new Font("Arial", Font.PLAIN, 14));
        sidebarPanel.add(btn_FillForm);
        
        // Main Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(200, 30, 700, 570);
        contentPanel.setLayout(null);
        contentPane.add(contentPanel);
        

        // File path text field and label
        txt_ubicacionArchivo = new JTextField();
        txt_ubicacionArchivo.setBounds(20, 500, 600, 30);
        txt_ubicacionArchivo.setFont(new Font("Arial", Font.PLAIN, 14));
        contentPanel.add(txt_ubicacionArchivo);
        txt_ubicacionArchivo.setColumns(10);

        lblFilePath = new JLabel("Ruta del archivo:");
        lblFilePath.setBounds(20, 470, 600, 20);
        lblFilePath.setFont(new Font("Arial", Font.PLAIN, 14));
        contentPanel.add(lblFilePath);
       
       
        //fa = new fmr_anuncio(fmr_menu);
       
    
        // Action listeners
        btn_BuscarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFile();
            }
        });

        btn_ENVIAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedFile != null) {
                    try {
                        byte[] fileData = readFileToByteArray(selectedFile);
                        savePDFToDatabase(fileData, selectedFile.getName());
                        JOptionPane.showMessageDialog(fmr_menu.this, "Archivo guardado en la base de datos.");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(fmr_menu.this, "Error al leer el archivo.");
                    }
                } else {
                    JOptionPane.showMessageDialog(fmr_menu.this, "No se ha seleccionado ningún archivo.");
                }
            }
        });

        btn_Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	fm = new fmr_modista();
                //fm.setVisible(true);
            }
        });
        
        
        btn_FillForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ff = new fmr_formulario();
                //ff.setVisible(true);
            }
        }); 
    }
 
    
    
 
    private void selectFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            txt_ubicacionArchivo.setText(selectedFile.getAbsolutePath());
            lblFilePath.setText("Ruta del archivo: " + selectedFile.getAbsolutePath());
        } else {
            lblFilePath.setText("No se ha seleccionado ningún archivo.");
        }
    }

    private byte[] readFileToByteArray(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] fileBytes = new byte[(int) file.length()];
            fis.read(fileBytes);
            return fileBytes;
        }
    }

    private void savePDFToDatabase(byte[] pdfData, String fileName) {
        String query = "INSERT INTO pdf_table (file_name, file_data) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, fileName);
            pstmt.setBytes(2, pdfData);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar el archivo PDF en la base de datos.");
        }
    }



    private boolean authenticate(String username, String password) {
        // Implement authentication logic here
        return "admin".equals(username) && "password".equals(password);
    }

  
    boolean saveFormDataToDatabase(String cedula, String datosPersonales, String experiencia) {
        String insertSQL = "INSERT INTO encuesta (cedula, datos, experiencia) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setString(1, cedula);
            pstmt.setString(2, datosPersonales);
            pstmt.setString(3, experiencia);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    
public void actualizarAnunciosEnMenuPrincipal( ) {
	 
	    JPanel anunciosPanel = new JPanel();
	    anunciosPanel.setBounds(200, 30, 700, 440);
	    anunciosPanel.setLayout(null);
	    //mainPanel.add(anunciosPanel); 
	    contentPane.add(anunciosPanel);
        int yOffset = 10;
        for (String anuncio : anuncios) {
            JLabel lblAnuncio = new JLabel(anuncio);
            lblAnuncio.setBounds(10, yOffset, 680, 30);
            lblAnuncio.setFont(new Font("Arial", Font.PLAIN, 14));
            anunciosPanel.add(lblAnuncio);
            
            yOffset += 40;
        }
        
        anunciosPanel.revalidate();
        anunciosPanel.repaint();
    }

}
