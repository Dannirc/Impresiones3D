package com.EggEducacion.Impresiones3d.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Compra {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	@OneToOne
	private Presupuesto presupuesto;
	private Boolean pago;
	private Boolean terminado;
	public Compra() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Compra(String id, Presupuesto presupuesto, Boolean pago, Boolean terminado) {
		super();
		this.id = id;
		this.presupuesto = presupuesto;
		this.pago = pago;
		this.terminado = terminado;
	}

	public Presupuesto getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}
	public Boolean getPago() {
		return pago;
	}
	public void setPago(Boolean pago) {
		this.pago = pago;
	}
	public Boolean getTerminado() {
		return terminado;
	}
	public void setTerminado(Boolean terminado) {
		this.terminado = terminado;
	}
	@Override
	public String toString() {
		return "Compra [presupuesto=" + presupuesto + ", pago=" + pago + ", terminado=" + terminado + "]";
	}
	
	
}
