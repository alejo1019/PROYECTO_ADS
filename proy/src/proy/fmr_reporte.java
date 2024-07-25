package proy;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class fmr_reporte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public List<String> anuncios = new ArrayList<>();
	private static final String DB_URL = "jdbc:mysql://localhost:3306/proyecto";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
	
	public fmr_reporte() {
		generateReport();
		countPDFsInDatabase();
	}

	 void generateReport() {
	        // Crear directorio de reportes si no existe
	        File reportDir = new File("reportes");
	        if (!reportDir.exists()) {
	            reportDir.mkdir();
	        }

	        // Contar el número de archivos PDF en la base de datos
	        int pdfCount = countPDFsInDatabase();

	        // Crear archivo TXT con el reporte
	        File reportFile = new File(reportDir, "reporte_anuncios.txt");
	        try (PrintWriter writer = new PrintWriter(reportFile)) {
	        	writer.println("=======================================");
	            writer.println("|     \tReporte de Anuncios\t      |");
	            writer.println("=======================================");
	            writer.println();
	            
	            writer.println("Anuncios:");
	            for (String anuncio : anuncios) {
	                writer.println(anuncio);
	                writer.println("-----------------------------");
	            }

	            writer.println();
	            writer.printf("Número de archivos PDF registrados en la base de datos: %d%n", pdfCount);
	            
	            JOptionPane.showMessageDialog(this, "Reporte generado y guardado en 'reportes/reporte_anuncios.txt'.");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error al generar el reporte.");
	        }
	    }

	    private int countPDFsInDatabase() {
	        String query = "SELECT COUNT(*) FROM pdf_table";
	        int count = 0;

	        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	             PreparedStatement pstmt = conn.prepareStatement(query);
	             ResultSet rs = pstmt.executeQuery()) {

	            if (rs.next()) {
	                count = rs.getInt(1);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error al contar los archivos PDF en la base de datos.");
	        }

	        return count;
	    }
}
