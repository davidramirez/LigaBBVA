package liga.packVistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class I_Usuario extends JFrame {

	private JPanel contentPane;
	private JButton btnSalir;
	private JButton btnPichichi;
	private JButton btnClasificacin;
	private JButton btnEstadsticas;
	private JButton btnFairplay;
	private JButton btnQuiniela;
	private JButton btnDatos;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					I_Usuario frame = new I_Usuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public I_Usuario() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.add(getBtnSalir());
		contentPane.add(getBtnPichichi());
		contentPane.add(getBtnClasificacin());
		contentPane.add(getBtnEstadsticas());
		contentPane.add(getBtnFairplay());
		contentPane.add(getBtnQuiniela());
		contentPane.add(getBtnDatos());
		contentPane.add(getScrollPane());
		contentPane.add(getTextArea());
		setResizable(false);
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.setBounds(12, 419, 117, 25);
		}
		return btnSalir;
	}
	private JButton getBtnPichichi() {
		if (btnPichichi == null) {
			btnPichichi = new JButton("Pichichi");
			btnPichichi.setEnabled(false);
			btnPichichi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnPichichi.setBounds(216, 305, 139, 25);
		}
		return btnPichichi;
	}
	private JButton getBtnClasificacin() {
		if (btnClasificacin == null) {
			btnClasificacin = new JButton("Clasificación");
			btnClasificacin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnClasificacin.setBounds(216, 342, 139, 25);
		}
		return btnClasificacin;
	}
	private JButton getBtnEstadsticas() {
		if (btnEstadsticas == null) {
			btnEstadsticas = new JButton("Estadísticas");
			btnEstadsticas.setBounds(216, 379, 139, 25);
		}
		return btnEstadsticas;
	}
	private JButton getBtnFairplay() {
		if (btnFairplay == null) {
			btnFairplay = new JButton("FairPlay");
			btnFairplay.setBounds(408, 305, 139, 25);
		}
		return btnFairplay;
	}
	private JButton getBtnQuiniela() {
		if (btnQuiniela == null) {
			btnQuiniela = new JButton("Quiniela");
			btnQuiniela.setBounds(408, 342, 139, 25);
		}
		return btnQuiniela;
	}
	private JButton getBtnDatos() {
		if (btnDatos == null) {
			btnDatos = new JButton("Datos");
			btnDatos.setBounds(408, 379, 139, 25);
		}
		return btnDatos;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 127, 117, 280);
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBounds(216, 48, 190, 78);
		}
		return textArea;
	}
}
