package com.zugatti.recargoconsumo.service;

import java.util.ArrayList;

import com.zugatti.recargoconsumo.dao.RecargoConsumoDAO;
import com.zugatti.recargoconsumo.model.PresupuestoArea;


public class RecargoConsumoService {
	
RecargoConsumoDAO rcDAO = new RecargoConsumoDAO();
	
	public ArrayList<PresupuestoArea> getDistribucionRCporArea(int anio, int mes) {
		
		ArrayList<PresupuestoArea> lista = rcDAO.getDistribucionRCporArea(anio, mes);		
		return lista;
	}

}
