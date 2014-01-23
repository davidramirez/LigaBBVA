package liga.packVistas;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class IU_DatosPartido extends JFrame {
	private JComboBox cmbTemp;
	private JComboBox cmbJor;
	private JComboBox cmbPart;
	private JLabel lblEquipoLocal;
	private JTextArea txtLocal;
	private JLabel lblAlineacin;
	private JTextArea titLocal;
	private JScrollPane scrollPane;
	private JLabel lblGoles;
	private JTextArea txtGolesLocal;
	private JTextArea goleadoresLocal;
	private JLabel lblTarjetas;
	private JTextArea txtTarjLocal;
	private JTextArea sancionadosLocal;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JLabel lblCambios;
	private JTextArea txtCambiosLoc;
	private JTextArea cambiosLocal;
	private JScrollPane scrollPane_3;
	private JLabel lblEquipoVisitante;
	private JTextArea txtVisitante;
	private JTextArea titVisitante;
	private JLabel label_1;
	private JTextArea txtGolesVisit;
	private JTextArea goleadoresVisit;
	private JLabel label_2;
	private JTextArea txtTarjVisit;
	private JLabel label_3;
	private JTextArea sancionadosVisit;
	private JLabel label_4;
	private JTextArea cambiosVisit;
	private JTextArea txtCambiosVisit;
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_5;
	private JScrollPane scrollPane_6;
	private JScrollPane scrollPane_7;
	public IU_DatosPartido() {
		getContentPane().setLayout(null);
		getContentPane().add(getCmbTemp());
		getContentPane().add(getCmbJor());
		getContentPane().add(getCmbPart());
		getContentPane().add(getLblEquipoLocal());
		getContentPane().add(getTxtLocal());
		getContentPane().add(getLblAlineacin());
		getContentPane().add(getScrollPane());
		getContentPane().add(getLblGoles());
		getContentPane().add(getTxtGolesLocal());
		getContentPane().add(getScrollPane_2());
		getContentPane().add(getLblTarjetas());
		getContentPane().add(getTxtTarjLocal());
		getContentPane().add(getScrollPane_1());
		getContentPane().add(getLblCambios());
		getContentPane().add(getTxtCambiosLoc());
		getContentPane().add(getScrollPane_3());
		getContentPane().add(getLblEquipoVisitante());
		getContentPane().add(getTxtVisitante());
		getContentPane().add(getScrollPane_7());
		getContentPane().add(getLabel_1());
		getContentPane().add(getTxtGolesVisit());
		getContentPane().add(getScrollPane_6());
		getContentPane().add(getLabel_2());
		getContentPane().add(getTxtTarjVisit());
		getContentPane().add(getLabel_3());
		getContentPane().add(getScrollPane_5());
		getContentPane().add(getLabel_4());
		getContentPane().add(getScrollPane_4());
		getContentPane().add(getTxtCambiosVisit());
	}

	private JComboBox getCmbTemp() {
		if (cmbTemp == null) {
			cmbTemp = new JComboBox();
			cmbTemp.setBounds(12, 12, 120, 24);
		}
		return cmbTemp;
	}
	private JComboBox getCmbJor() {
		if (cmbJor == null) {
			cmbJor = new JComboBox();
			cmbJor.setBounds(145, 12, 120, 24);
		}
		return cmbJor;
	}
	private JComboBox getCmbPart() {
		if (cmbPart == null) {
			cmbPart = new JComboBox();
			cmbPart.setBounds(277, 12, 155, 24);
		}
		return cmbPart;
	}
	private JLabel getLblEquipoLocal() {
		if (lblEquipoLocal == null) {
			lblEquipoLocal = new JLabel("Equipo local:");
			lblEquipoLocal.setBounds(12, 82, 130, 15);
		}
		return lblEquipoLocal;
	}
	private JTextArea getTxtLocal() {
		if (txtLocal == null) {
			txtLocal = new JTextArea();
			txtLocal.setEditable(false);
			txtLocal.setBounds(12, 109, 120, 15);
		}
		return txtLocal;
	}
	private JLabel getLblAlineacin() {
		if (lblAlineacin == null) {
			lblAlineacin = new JLabel("Alineación:");
			lblAlineacin.setBounds(12, 136, 120, 15);
		}
		return lblAlineacin;
	}
	private JTextArea getTitLocal() {
		if (titLocal == null) {
			titLocal = new JTextArea();
		}
		return titLocal;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 163, 192, 80);
			scrollPane.setViewportView(getTitLocal());
		}
		return scrollPane;
	}
	private JLabel getLblGoles() {
		if (lblGoles == null) {
			lblGoles = new JLabel("Goles:");
			lblGoles.setBounds(12, 251, 70, 15);
		}
		return lblGoles;
	}
	private JTextArea getTxtGolesLocal() {
		if (txtGolesLocal == null) {
			txtGolesLocal = new JTextArea();
			txtGolesLocal.setEditable(false);
			txtGolesLocal.setBounds(157, 251, 45, 15);
		}
		return txtGolesLocal;
	}
	private JTextArea getGoleadoresLocal() {
		if (goleadoresLocal == null) {
			goleadoresLocal = new JTextArea();
		}
		return goleadoresLocal;
	}
	private JLabel getLblTarjetas() {
		if (lblTarjetas == null) {
			lblTarjetas = new JLabel("Tarjetas:");
			lblTarjetas.setBounds(12, 367, 70, 15);
		}
		return lblTarjetas;
	}
	private JTextArea getTxtTarjLocal() {
		if (txtTarjLocal == null) {
			txtTarjLocal = new JTextArea();
			txtTarjLocal.setEditable(false);
			txtTarjLocal.setBounds(157, 367, 45, 15);
		}
		return txtTarjLocal;
	}
	private JTextArea getSancionadosLocal() {
		if (sancionadosLocal == null) {
			sancionadosLocal = new JTextArea();
		}
		return sancionadosLocal;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(13, 394, 189, 77);
			scrollPane_1.setViewportView(getSancionadosLocal());
		}
		return scrollPane_1;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(12, 278, 189, 77);
			scrollPane_2.setViewportView(getGoleadoresLocal());
		}
		return scrollPane_2;
	}
	private JLabel getLblCambios() {
		if (lblCambios == null) {
			lblCambios = new JLabel("Cambios:");
			lblCambios.setBounds(12, 490, 70, 15);
		}
		return lblCambios;
	}
	private JTextArea getTxtCambiosLoc() {
		if (txtCambiosLoc == null) {
			txtCambiosLoc = new JTextArea();
			txtCambiosLoc.setEditable(false);
			txtCambiosLoc.setBounds(157, 490, 45, 15);
		}
		return txtCambiosLoc;
	}
	private JTextArea getCambiosLocal() {
		if (cambiosLocal == null) {
			cambiosLocal = new JTextArea();
		}
		return cambiosLocal;
	}
	private JScrollPane getScrollPane_3() {
		if (scrollPane_3 == null) {
			scrollPane_3 = new JScrollPane();
			scrollPane_3.setBounds(16, 517, 186, 74);
			scrollPane_3.setViewportView(getCambiosLocal());
		}
		return scrollPane_3;
	}
	private JLabel getLblEquipoVisitante() {
		if (lblEquipoVisitante == null) {
			lblEquipoVisitante = new JLabel("Equipo visitante:");
			lblEquipoVisitante.setBounds(242, 82, 130, 15);
		}
		return lblEquipoVisitante;
	}
	private JTextArea getTxtVisitante() {
		if (txtVisitante == null) {
			txtVisitante = new JTextArea();
			txtVisitante.setEditable(false);
			txtVisitante.setBounds(242, 109, 120, 15);
		}
		return txtVisitante;
	}
	private JTextArea getTitVisitante() {
		if (titVisitante == null) {
			titVisitante = new JTextArea();
		}
		return titVisitante;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Alineación:");
			label_1.setBounds(242, 136, 120, 15);
		}
		return label_1;
	}
	private JTextArea getTxtGolesVisit() {
		if (txtGolesVisit == null) {
			txtGolesVisit = new JTextArea();
			txtGolesVisit.setEditable(false);
			txtGolesVisit.setBounds(387, 251, 45, 15);
		}
		return txtGolesVisit;
	}
	private JTextArea getGoleadoresVisit() {
		if (goleadoresVisit == null) {
			goleadoresVisit = new JTextArea();
		}
		return goleadoresVisit;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Goles:");
			label_2.setBounds(242, 251, 70, 15);
		}
		return label_2;
	}
	private JTextArea getTxtTarjVisit() {
		if (txtTarjVisit == null) {
			txtTarjVisit = new JTextArea();
			txtTarjVisit.setEditable(false);
			txtTarjVisit.setBounds(387, 367, 45, 15);
		}
		return txtTarjVisit;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("Tarjetas:");
			label_3.setBounds(242, 367, 70, 15);
		}
		return label_3;
	}
	private JTextArea getSancionadosVisit() {
		if (sancionadosVisit == null) {
			sancionadosVisit = new JTextArea();
		}
		return sancionadosVisit;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("Cambios:");
			label_4.setBounds(242, 490, 70, 15);
		}
		return label_4;
	}
	private JTextArea getCambiosVisit() {
		if (cambiosVisit == null) {
			cambiosVisit = new JTextArea();
		}
		return cambiosVisit;
	}
	private JTextArea getTxtCambiosVisit() {
		if (txtCambiosVisit == null) {
			txtCambiosVisit = new JTextArea();
			txtCambiosVisit.setEditable(false);
			txtCambiosVisit.setBounds(387, 490, 45, 15);
		}
		return txtCambiosVisit;
	}
	private JScrollPane getScrollPane_4() {
		if (scrollPane_4 == null) {
			scrollPane_4 = new JScrollPane();
			scrollPane_4.setBounds(247, 518, 183, 71);
			scrollPane_4.setViewportView(getCambiosVisit());
		}
		return scrollPane_4;
	}
	private JScrollPane getScrollPane_5() {
		if (scrollPane_5 == null) {
			scrollPane_5 = new JScrollPane();
			scrollPane_5.setBounds(244, 395, 186, 74);
			scrollPane_5.setViewportView(getSancionadosVisit());
		}
		return scrollPane_5;
	}
	private JScrollPane getScrollPane_6() {
		if (scrollPane_6 == null) {
			scrollPane_6 = new JScrollPane();
			scrollPane_6.setBounds(243, 279, 186, 74);
			scrollPane_6.setViewportView(getGoleadoresVisit());
		}
		return scrollPane_6;
	}
	private JScrollPane getScrollPane_7() {
		if (scrollPane_7 == null) {
			scrollPane_7 = new JScrollPane();
			scrollPane_7.setBounds(243, 164, 189, 77);
			scrollPane_7.setViewportView(getTitVisitante());
		}
		return scrollPane_7;
	}
}
