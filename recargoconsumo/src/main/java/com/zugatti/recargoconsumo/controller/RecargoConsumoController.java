package com.zugatti.recargoconsumo.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.zugatti.recargoconsumo.model.PresupuestoArea;
import com.zugatti.recargoconsumo.service.RecargoConsumoService;


@RestController
public class RecargoConsumoController {
	
	RecargoConsumoService recargoConsumoService = new RecargoConsumoService();
	Gson gson = new Gson();
	
	@GetMapping("/obtenerDistribucionRCPorArea")
	//@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public String getDistribucionRCporArea(@RequestParam ("anio") int anio, @RequestParam ("mes") int mes)
	{
		ArrayList<PresupuestoArea> listaPresupuestos =   recargoConsumoService.getDistribucionRCporArea(anio, mes);		    
		String json = gson.toJson(listaPresupuestos);		    
		return json;
		
		
		}
		
		
	

}
