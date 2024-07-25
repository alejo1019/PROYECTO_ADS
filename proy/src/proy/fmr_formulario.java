package proy;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class fmr_formulario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public fmr_menu fm;

	
	public fmr_formulario() {
		//openFormWindow();
		 JFrame formFrame = new JFrame("Formulario");
	        formFrame.setSize(400, 300);
	        formFrame.setLayout(new GridLayout(4, 2));

	        JLabel lblCedula = new JLabel("Cédula:");
	        JTextField txtCedula = new JTextField();

	        JLabel lblDatosPersonales = new JLabel("Datos Personales:");
	        JTextField txtDatosPersonales = new JTextField();

	        JLabel lblExperiencia = new JLabel("Experiencia:");
	        JTextField txtExperiencia = new JTextField();

	        JButton btnSubmit = new JButton("Enviar");

	        formFrame.add(lblCedula);
	        formFrame.add(txtCedula);
	        formFrame.add(lblDatosPersonales);
	        formFrame.add(txtDatosPersonales);
	        formFrame.add(lblExperiencia);
	        formFrame.add(txtExperiencia);
	        formFrame.add(new JLabel()); // Empty label for spacing
	        formFrame.add(btnSubmit);

	        btnSubmit.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String cedula = txtCedula.getText();
	                String datosPersonales = txtDatosPersonales.getText();
	                String experiencia = txtExperiencia.getText();

	                if (fm.saveFormDataToDatabase(cedula, datosPersonales, experiencia)) {
	                    JOptionPane.showMessageDialog(formFrame, "Datos guardados con éxito.");
	                    formFrame.dispose();
	                } else {
	                    JOptionPane.showMessageDialog(formFrame, "Error al guardar los datos.");
	                }
	            }
	        });

	        formFrame.setVisible(true);
	    }

	}

