package com.zugatti.recargoconsumo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zugatti.recargoconsumo.database.ConnectionJDBC;
import com.zugatti.recargoconsumo.model.AreaEmpresa;
import com.zugatti.recargoconsumo.model.PresupuestoArea;

public class RecargoConsumoDAO {
	
	ConnectionJDBC jdbc = new ConnectionJDBC();
	
	public ArrayList<PresupuestoArea> getDistribucionRCporArea(int anio, int mes){
		
		
		ArrayList<PresupuestoArea> listaPresupuesto =  new ArrayList<PresupuestoArea>();
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select ARE_ID,ARE_NOMBRE as area,month(APR_MES) as mes , APR_PORCENTAJE as porcentaje ,APR_PRESUPUESTO as presupuesto " +
		"from `t_area_empresa` ARE " +
		"LEFT  JOIN t_area_presupuesto APR " +
		"ON ARE.ARE_ID=APR.APR_AREA " +
		"AND YEAR(APR.APR_MES) = " + anio + " " +
		"AND MONTH(APR.APR_MES) = " + mes + " " +
		"ORDER BY ARE.ARE_ID";
	
		
		try {
			ps = jdbc.getConnection().prepareStatement(sql);			
			System.out.println("QUERY DistRCporArea: " + sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				PresupuestoArea presupuesto = new PresupuestoArea();
				 
				AreaEmpresa area = new AreaEmpresa();
				 area.setId(rs.getInt("ARE_ID"));
				 area.setNombre(rs.getString("area"));
				 presupuesto.setAreaEmpresa(area);
				 
				 presupuesto.setPorcentaje(rs.getDouble("porcentaje"));
				 presupuesto.setPresupuesto(rs.getDouble("presupuesto"));
				 
				 listaPresupuesto.add(presupuesto);
				 
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jdbc.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaPresupuesto;

	}

	

}
