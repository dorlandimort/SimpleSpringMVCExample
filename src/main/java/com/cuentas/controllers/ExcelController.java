package com.cuentas.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cuentas.dao.CuentaDAO;
import com.cuentas.pojos.Cuenta;

@Controller
public class ExcelController {
	
	private CuentaDAO dao;
	
	@RequestMapping("/generar")
	public void  generarArchivo(HttpServletRequest request, HttpServletResponse response) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("datos");
		List<Cuenta> cuentas = dao.obtenerCuentas();
		String[] encabezados = {"Usuario", "Nombre", "Perfil"};
		Row row = sheet.createRow(0);
		int colNum = 0;
		for (String e : encabezados) {
			Cell cell = row.createCell(colNum++);
			cell.setCellValue(e);
		}
		
		int rowNum = 1;
		
		for(Cuenta cuenta: cuentas) {
			row = sheet.createRow(rowNum++);
			Cell cell = row.createCell(0);
			cell.setCellValue(cuenta.getUsuario());
			
			cell = row.createCell(1);
			cell.setCellValue(cuenta.getPersona().getNombre());
			
			cell = row.createCell(2);
			cell.setCellValue(cuenta.getPerfil().getNombre());
		}
		
		try {
			File archivo = File.createTempFile("archivo", ".xlsx");
			FileOutputStream fos = new FileOutputStream(archivo);
			workbook.write(fos);
			workbook.close();
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.getOutputStream().write(IOUtils.toByteArray(new FileInputStream(archivo)));
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public CuentaDAO getDao() {
		return dao;
	}

	public void setDao(CuentaDAO dao) {
		this.dao = dao;
	}
	
	
	

}
