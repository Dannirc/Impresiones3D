/* probando metodo para subir archivos */

package com.EggEducacion.Impresiones3d.controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file/")
public class FileController {
	@RequestMapping("upload")
	@ResponseBody
	public String upload (@RequestParam("file") MultipartFile file) {
		 // Obtén el nombre original
		String fileName = file.getOriginalFilename();
		 // Obtener el nombre del sufijo
		// String suffixName = fileName.substring(fileName.lastIndexOf("."));
		 // Ruta para guardar el archivo
		String filePath = "e:/upload/";
		 // Cambiar el nombre del archivo para evitar la duplicación
		fileName = filePath + UUID.randomUUID() + fileName;
		 // objeto de archivo
		File dest = new File(fileName);
		 // Determinar si la ruta existe y crearla si no existe
		if(!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			 // Guardar en el servidor
			file.transferTo(dest);
			 // devuelve "Subido con éxito";
		} catch (Exception e) {
			e.printStackTrace();
		}
		 // devuelve "Error al cargar";
		return ("subirArchivo");
	}
	
	@GetMapping
	public String index() {		
		return ("subirArchivo");
	}
	
	@RequestMapping("download")
	public void download(HttpServletResponse response) throws Exception {
		// Dirección del archivo, el entorno real se almacena en la base de datos
		File file = new File("E:\\upload\\a.txt");
		 // Llevando objeto de entrada
		FileInputStream fis = new FileInputStream(file);
		 // Establecer el formato relevante
		response.setContentType("application/force-download");
		 // Establecer el nombre y el encabezado del archivo descargado
		response.addHeader("Content-disposition", "attachment;fileName=" + "a.txt");
		 // Crear objeto de salida
		OutputStream os = response.getOutputStream();
		 // operación normal
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = fis.read(buf)) != -1) {
			os.write(buf, 0, len);
		}
		fis.close();
	}
}