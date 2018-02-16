package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel {

	public static String dataLogin(int hoja, int fila, int celda) {
		return recolecta(hoja, fila, celda, "utilidades\\datos\\Inicio de sesión\\Datos inicio de sesión.xlsx");
	}

	public static String dataConfiguration(int hoja, int fila, int celda) {
		return recolecta(hoja, fila, celda, "utilidades\\datos\\Configuración.xlsx");
	}
	
	public static String dataActualizationInfo(int hoja, int fila, int celda) {
		return recolecta(hoja, fila, celda, "utilidades\\datos\\Actualizar información\\Actualizar información.xlsx");
	}
	
	public static String dataRecomposition(int hoja, int fila, int celda, String name) {
		return recolecta(hoja, fila, celda, "utilidades\\datos\\Recomposición\\" + name);
	}
	
	public static String dataAdministrationObjetives(int hoja, int fila, int celda, String name) {
		return recolecta(hoja, fila, celda, "utilidades\\datos\\Administración de objetivos\\" + name);
	}
	
	public static String dataDistributionContribution(int hoja, int fila, int celda, String name) {
		return recolecta(hoja, fila, celda, "utilidades\\datos\\Distribución de aportes\\" + name);
	}
	
	public static String dataMovementBetwenObjetives(int hoja, int fila, int celda, String name) {
		return recolecta(hoja, fila, celda, "utilidades\\datos\\Movimiento entre objetivos\\" + name);
	}
	
	public static String dataTransferBetweenProducts(int hoja, int fila, int celda, String name) {
		return recolecta(hoja, fila, celda, "utilidades\\datos\\Traslado entre productos\\" + name);
	}
	
	public static String dataRetirement(int hoja, int fila, int celda, String name) {
		return recolecta(hoja, fila, celda, "utilidades\\datos\\Retiros\\" + name);
	}

	public static String recolecta(int hoja, int fila, int celda, String position) {
		try {
			FileInputStream file;
			file = new FileInputStream(new File(position));
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheetAt(hoja);
			Row row = sheet.getRow(fila);
			String dato = "";

			switch (row.getCell(celda).getCellTypeEnum().toString()) {
			case "NUMERIC":
				dato = "" + (long) row.getCell(celda).getNumericCellValue();
				break;
			case "STRING":
				dato = row.getCell(celda).toString();
				break;
			default:
				dato = "";
			}
			wb.close();
			return dato;
		} catch (Exception e) {
			//System.out.println("ERROR EN EXCEL: " + e + " en Fila: " + fila + " Celda:" + celda + " En la carpeta: " + position);
			return "";
		}
	}
	
	public static List<String> searchFiles(String direcCarpeta){
		File carpeta = new File(direcCarpeta);
		List<String> data = new LinkedList<String>(Arrays.asList(carpeta.list()));
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).contains(".~lock.") || data.get(i).contains("xlsx#")) {
				data.remove(i);
				i = -1;
			}
		}
		return data;
	}

}
