package proy;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class fmr_anuncio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public List<String> anuncios = new ArrayList<>();
	public fmr_menu fm;
	public fmr_reporte fr;
	private JLabel lblDetails;
	private JTextField txtDetails;
	private JTextField txtDetails_1;
	private JLabel lblDetails_1;
	
	
	public fmr_anuncio() {
		//openAddAnnouncementWindow();
		 //JFrame announcementFrame = new JFrame("Agregar Anuncio");
		 JFrame announcementFrame = new JFrame("Agregar Anuncio");
	        announcementFrame.setBounds(100, 100, 600, 500);
	        announcementFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        announcementFrame.getContentPane().setLayout(null);

	        lblDetails_1 = new JLabel("Detalles de la Vacante:");
	        lblDetails_1.setBounds(20, 20, 200, 30);
	        announcementFrame.getContentPane().add(lblDetails_1);

	        txtDetails_1 = new JTextField();
	        txtDetails_1.setBounds(20, 60, 550, 30);
	        announcementFrame.getContentPane().add(txtDetails_1);

	        JLabel lblKnowledge = new JLabel("Conocimientos Requeridos:");
	        lblKnowledge.setBounds(20, 100, 200, 30);
	        announcementFrame.getContentPane().add(lblKnowledge);

	        JTextField txtKnowledge = new JTextField();
	        txtKnowledge.setBounds(20, 140, 550, 30);
	        announcementFrame.getContentPane().add(txtKnowledge);

	        JLabel lblExperience = new JLabel("Experiencia Mínima Requerida:");
	        lblExperience.setBounds(20, 180, 250, 30);
	        announcementFrame.getContentPane().add(lblExperience);

	        JTextField txtExperience = new JTextField();
	        txtExperience.setBounds(20, 220, 550, 30);
	        announcementFrame.getContentPane().add(txtExperience);

	        JLabel lblBenefits = new JLabel("Beneficios:");
	        lblBenefits.setBounds(20, 260, 200, 30);
	        announcementFrame.getContentPane().add(lblBenefits);

	        JTextField txtBenefits = new JTextField();
	        txtBenefits.setBounds(20, 300, 550, 30);
	        announcementFrame.getContentPane().add(txtBenefits);

	        JLabel lblSchedule = new JLabel("Horario:");
	        lblSchedule.setBounds(20, 340, 200, 30);
	        announcementFrame.getContentPane().add(lblSchedule);

	        JTextField txtSchedule = new JTextField();
	        txtSchedule.setBounds(20, 380, 550, 30);
	        announcementFrame.getContentPane().add(txtSchedule);

	        JButton btnPublish = new JButton("Publicar");
	        btnPublish.setBounds(150, 430, 100, 30);
	        announcementFrame.getContentPane().add(btnPublish);

	        JButton btnGenerateReport = new JButton("Generar Reporte");
	        btnGenerateReport.setBounds(270, 430, 150, 30);
	        announcementFrame.getContentPane().add(btnGenerateReport);
	        
	        btnPublish.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String detallesVacante = txtDetails_1.getText();
	                String conocimientosRequeridos = txtKnowledge.getText();
	                String experienciaMinima = txtExperience.getText();
	                String beneficios = txtBenefits.getText();
	                String horario = txtBenefits.getText();

	                // Agregar el anuncio a la lista
	                anuncios.add(String.format("Detalles: %s; Conocimientos: %s; Experiencia: %s; Beneficios: %s; Horario: %s",
	                        detallesVacante, conocimientosRequeridos, experienciaMinima, beneficios, horario));

	                // Mostrar en el menú principal
	                fm = new fmr_menu();
	                fm.actualizarAnunciosEnMenuPrincipal();
	               
	                

	                JOptionPane.showMessageDialog(announcementFrame, "Anuncio agregado.");
	               // announcementFrame.dispose(); // Cierra la ventana de agregar anuncio
	               
	            }
	        });
	       
	        btnGenerateReport.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	fr = new fmr_reporte();
	                fr.generateReport();
	            }
	        });
 
	        announcementFrame.setVisible(true);
	}

//	private void actualizarAnunciosEnMenuPrincipal() {
//        JPanel anunciosPanel = new JPanel();
//        anunciosPanel.setBounds(200, 30, 700, 440);
//        anunciosPanel.setLayout(null);
//        contentPane.add(anunciosPanel);
//
//        int yOffset = 10;
//        for (String anuncio : anuncios) {
//            JLabel lblAnuncio = new JLabel(anuncio);
//            lblAnuncio.setBounds(10, yOffset, 680, 30);
//            lblAnuncio.setFont(new Font("Arial", Font.PLAIN, 14));
//            anunciosPanel.add(lblAnuncio);
//            yOffset += 40;
//        }
//
//        anunciosPanel.revalidate();
//        anunciosPanel.repaint();
//    }
}
