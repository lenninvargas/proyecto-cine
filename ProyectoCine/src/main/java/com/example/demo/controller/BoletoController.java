package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Boleto;
import com.example.demo.entity.Funcion;
import com.example.demo.repository.FuncionRepository;
import com.example.demo.service.BoletoService;
import com.example.demo.service.impl.PdfService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoletoController {
	
	@Autowired
	PdfService PdfService;
	
	@Autowired
	BoletoService boletoService;
	
	@Autowired
	FuncionRepository funcionRepository;

	@GetMapping("/asientos")
    public String showAsiento(HttpSession session, Model model, 
    		@RequestParam(value = "funId", defaultValue = "0") Integer funId, 
    		@RequestParam(value = "horId", defaultValue = "0") Integer horId, 
    		@RequestParam(value = "salId", defaultValue = "0") Integer salId) {
				
		if(session.getAttribute("empleado") == null) {
			return "redirect:/";
		}
		List<String> asientos = boletoService.obtenerAsientos(funId, salId, horId);
		List<Boleto> boletos = boletoService.obtenerTodosBoletos();
		
		List<String> filas = Arrays.asList("A", "B", "C", "D", "E", "F");

		String butaca[][]= new String[6][6];
		int k = 0;
		
		for(int i = 0; i < 6; i ++) {
			for(int j = 0; j < 6; j++) {
				if(k < boletos.size()) {
					if(asientos.contains(filas.get(i) + (j+1))) {
						butaca[i][j] = "BR";
						k++;
					}else {
						butaca[i][j] = filas.get(i) + (j+1);
					}
				}else {
					butaca[i][j] = filas.get(i) + (j+1);
				}
			}
		}
		model.addAttribute("funId", funId);
		model.addAttribute("horId", horId);
		model.addAttribute("salId", salId);
		model.addAttribute("butaca", butaca);
		        
        return "/boleto/asientos";
    }
	
	@GetMapping("/generar_pdf")
	public ResponseEntity<InputStreamResource>generarPdf(HttpSession session,
	        @RequestParam("asientos") String asientosString,
	        @RequestParam("fun") String fun,
	        @RequestParam("hor") String hor,
	        @RequestParam("sal") String sal) throws IOException{
		
		 // Convertir la cadena de asientos separados por coma en una lista  
		List<String> asientos = Arrays.asList(asientosString.split(",\\s*"));
		
	    Integer func = Integer.parseInt(fun);
	    Funcion funcion = funcionRepository.findById(func).get();
	    for (String asiento : asientos) {
	        Boleto boleto = new Boleto();
	        boleto.setAsiento(asiento);
	        boleto.setIdFuncion(funcion);
	        boletoService.guardarBoleto(boleto);
	    }
	    Integer total = asientos.size() * 16;	
		
		Map<String, Object>datosPdf = new HashMap<String, Object>();
		
		datosPdf.put("precio_total", total);
		datosPdf.put("sala", funcion.getIdSala().getNomSala());
		datosPdf.put("hora", funcion.getIdHorario().getHora());
		datosPdf.put("pelicula", funcion.getIdPelicula().getNomPelicula());
		datosPdf.put("funcion", funcion.getIdFuncion());
		datosPdf.put("asientos", asientos);
		
		ByteArrayInputStream pdfBytes = PdfService.generarPdfDeHtml("/boleto/template_pdf", datosPdf);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Disposition", "attachment; filename=boleto.pdf");
		
		return ResponseEntity.ok()
				.headers(httpHeaders)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(pdfBytes));
	}
}
