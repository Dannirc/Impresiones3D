package com.EggEducacion.Impresiones3d.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Presupuesto {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	@OneToOne
	private Pedido pedido;
	private Float precio;
	private Integer PlazoEntrega;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Presupuesto(String id, Pedido pedido, Float precio, Integer plazoEntrega) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.precio = precio;
		PlazoEntrega = plazoEntrega;
	}

	public Presupuesto() {
		super();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Integer getPlazoEntrega() {
		return PlazoEntrega;
	}

	public void setPlazoEntrega(Integer plazoEntrega) {
		PlazoEntrega = plazoEntrega;
	}

	@Override
	public String toString() {
		return "Presupuesto [pedido=" + pedido + ", precio=" + precio + ", PlazoEntrega=" + PlazoEntrega + "]";
	}

}
