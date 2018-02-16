package utils;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;

public class TakeCapture {

	public static void main(String[] args) { 
		ArrayList<String> data = new ArrayList<String>();
		int j = 2;
		for (int i = 1; i < j; i++) {
			String fila = utils.Read_Excel.dataLogin(0, i, 0);
			j++;
			if (!fila.equals("")) {
				data.add("" + i);
			} else {
				j = 0;
			}
		}
		System.out.println(data.get(1));
		
		Object[][] data2 = new Object[data.size()][1];

		for (int i = 0; i < data.size(); i++){
			data2[i][0] = data.get(i);
		}
		System.out.println(data2[0][0]);
		
	}
	
	public void vector (int n, int n1){
	}

	static int cont = 1;
	public static int contTest = 1;
	public static int ciclos = 1;
	static int contCiclos = 1;
	static String module = "nada";
	static String tipo = "nada";
	static String process;
	public static int numTest = 0;

	public void capturarPantalla(String proceso, String nomModulo) {
		try {
			String direcCarpeta = "utilidades\\capturas";
			direcCarpeta = direcCarpeta + "\\" + proceso;
			File carpeta = new File(direcCarpeta);
			if (!carpeta.exists()) {
				carpeta.mkdir();
			}

			Thread.sleep(1000 * Integer.parseInt(Read_Excel.dataConfiguration(0, 1, 1)));

			if (numTest != contTest || !process.equals(proceso)) {
				process = proceso;
				contTest = numTest;
				cont = 1;
			}

			/*
			 * if (!module.equals(nomModulo)) { module = nomModulo; cont = 1; }
			 */

			Date hoy = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String fechaAct = sdf.format(hoy);

			int a = 1;
			if (ciclos == 1) {
				while (a > 0) {
					carpeta = new File(direcCarpeta + "\\" + fechaAct + " Ciclo_" + ciclos);
					if (!carpeta.exists()) {
						direcCarpeta = direcCarpeta + "\\" + fechaAct + " Ciclo_" + ciclos;
						carpeta.mkdir();
						contCiclos = ciclos;
						a = 0;
					}
					ciclos++;
				}
			} else {
				direcCarpeta = direcCarpeta + "\\" + fechaAct + " Ciclo_" + contCiclos;
			}

			direcCarpeta = direcCarpeta + "\\" + "Test " + numTest;
			carpeta = new File(direcCarpeta);
			if (!carpeta.exists()) {
				carpeta.mkdir();
			}

			/*
			 * direcCarpeta = direcCarpeta + "\\" + nomModulo; carpeta = new
			 * File(direcCarpeta); if (!carpeta.exists()) { carpeta.mkdir(); }
			 */

			String nombreCap = "Captura_" + cont;
			BufferedImage captura = null;
			int number = Integer.parseInt(Read_Excel.dataConfiguration(0, 1, 2));

			if (number == 1) {
				captura = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
				
			} else if (number > 1) {
				int width = Integer.parseInt(Read_Excel.dataConfiguration(0, 2, 3));
				int heigth = Integer.parseInt(Read_Excel.dataConfiguration(0, 2, 4));
				Dimension screenSize = new Dimension(width, heigth);
				
				Point point = new Point(Toolkit.getDefaultToolkit().getScreenSize().width * (number -1), 0);
				captura = new Robot().createScreenCapture(new Rectangle(point, screenSize));
			}
			
			File file = new File(direcCarpeta + "\\" + nombreCap + ".jpg");
			ImageIO.write(captura, "jpg", file);

			cont++;
		} catch (Exception e) {
		}
	}
}
