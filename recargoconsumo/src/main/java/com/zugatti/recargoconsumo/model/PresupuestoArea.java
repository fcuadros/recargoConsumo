package com.zugatti.recargoconsumo.model;

public class PresupuestoArea {
	
	
		private AreaEmpresa areaEmpresa;
		private java.util.Date mes;
		private double porcentaje;
		private double presupuesto;
		
		
		
		public AreaEmpresa getAreaEmpresa() {
			return areaEmpresa;
		}
		public void setAreaEmpresa(AreaEmpresa areaEmpresa) {
			this.areaEmpresa = areaEmpresa;
		}
		public java.util.Date getMes() {
			return mes;
		}
		public void setMes(java.util.Date mes) {
			this.mes = mes;
		}
		public double getPorcentaje() {
			return porcentaje;
		}
		public void setPorcentaje(double porcentaje) {
			this.porcentaje = porcentaje;
		}
		public double getPresupuesto() {
			return presupuesto;
		}
		public void setPresupuesto(double presupuesto) {
			this.presupuesto = presupuesto;
		}
		@Override
		public String toString() {
			return "PresupuestoArea [areaEmpresa=" + areaEmpresa + ", mes=" + mes + ", porcentaje=" + porcentaje
					+ ", presupuesto=" + presupuesto + "]";
		}
		
		
		
		
		
		

		
}
