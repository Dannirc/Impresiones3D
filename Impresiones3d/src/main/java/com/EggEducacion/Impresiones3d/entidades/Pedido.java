package com.EggEducacion.Impresiones3d.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	@OneToOne
	private Producto producto;
	@OneToOne
	private Usuario usuario;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	
	
	public Pedido() {
		super();
	}


	public Pedido(String id, Producto producto, Usuario usuario, Date fecha) {
		super();
		this.id = id;
		this.producto = producto;
		this.usuario = usuario;
		this.fecha = fecha;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuario getCliente() {
		return usuario;
	}

	public void setCliente(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Pedido [cliente=" + usuario + ", fecha=" + fecha + "]";
	}
	
	
	
	

}
