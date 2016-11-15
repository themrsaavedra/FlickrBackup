package taulak_UI;

import java.io.IOException;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import flickrJava.Bildumak;

public class BildumenTaula extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object[][] data;
	private String[] columnNames = { "Titulua", "Deskripzioa", "Argazki kopurua" };
	private JTable taula;
	private JScrollPane scrollPanela;
	
	public BildumenTaula(){
		this.elementuakGehitu();
		taula = new JTable(data,columnNames);
		scrollPanela = new JScrollPane(taula);
		this.add(scrollPanela);
	}
	
	public void elementuakGehitu() {
		Bildumak bildumak;
		try {
			bildumak = new Bildumak();
			List<String[]> emaitzak = bildumak.showPhotosets();
			data = new Object[emaitzak.size()][3];
			for (int errenkada = 0; errenkada < data.length; errenkada++) {
					data[errenkada][0] = emaitzak.get(errenkada)[0];
					data[errenkada][1] = emaitzak.get(errenkada)[1];
					data[errenkada][2] = emaitzak.get(errenkada)[2];
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}