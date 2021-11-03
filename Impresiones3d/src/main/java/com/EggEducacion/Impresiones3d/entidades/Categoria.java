package com.EggEducacion.Impresiones3d.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Categoria {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String nombre; 
	private Integer PorcentajeDeRelleno;
	private Integer VelocidadDelImpresion;
	private Float DiametroDeBoquita;
	private String Material;
	private Float AlturaDeCapa;
	private Boolean soporte;
	public Categoria() {
		super();
	}

	public Categoria(String id, String nombre, Integer porcentajeDeRelleno, Integer velocidadDelImpresion,
			Float diametroDeBoquita, String material, Float alturaDeCapa, Boolean soporte) {
		super();
		this.id = id;
		this.nombre = nombre;
		PorcentajeDeRelleno = porcentajeDeRelleno;
		VelocidadDelImpresion = velocidadDelImpresion;
		DiametroDeBoquita = diametroDeBoquita;
		Material = material;
		AlturaDeCapa = alturaDeCapa;
		this.soporte = soporte;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getPorcentajeDeRelleno() {
		return PorcentajeDeRelleno;
	}
	public void setPorcentajeDeRelleno(Integer porcentajeDeRelleno) {
		PorcentajeDeRelleno = porcentajeDeRelleno;
	}
	public Integer getVelocidadDelImpresion() {
		return VelocidadDelImpresion;
	}
	public void setVelocidadDelImpresion(Integer velocidadDelImpresion) {
		VelocidadDelImpresion = velocidadDelImpresion;
	}
	public Float getDiametroDeBoquita() {
		return DiametroDeBoquita;
	}
	public void setDiametroDeBoquita(Float diametroDeBoquita) {
		DiametroDeBoquita = diametroDeBoquita;
	}
	public String getMaterial() {
		return Material;
	}
	public void setMaterial(String material) {
		Material = material;
	}
	public Float getAlturaDeCapa() {
		return AlturaDeCapa;
	}
	public void setAlturaDeCapa(Float alturaDeCapa) {
		AlturaDeCapa = alturaDeCapa;
	}
	public Boolean getSoporte() {
		return soporte;
	}
	public void setSoporte(Boolean soporte) {
		this.soporte = soporte;
	}
	@Override
	public String toString() {
		return "Categoria [nombre=" + nombre + ", PorcentajeDeRelleno=" + PorcentajeDeRelleno
				+ ", VelocidadDelImpresion=" + VelocidadDelImpresion + ", DiametroDeBoquita=" + DiametroDeBoquita
				+ ", Material=" + Material + ", AlturaDeCapa=" + AlturaDeCapa + ", soporte=" + soporte + "]";
	}
	
	
	
}
