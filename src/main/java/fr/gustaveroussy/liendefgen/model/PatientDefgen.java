package fr.gustaveroussy.liendefgen.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "patient")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { 	"idft", "ideechantillon", "numeroechantilloncomplet", "liostevariant", "listegene", "facture", "crr"})
public class PatientDefgen {

	@XmlElement(name = "IDFT")
	int idft;
	
	@XmlElement(name = "IDECHANTILLON")
	int ideechantillon;
	
	@XmlElement(name = "NUMEROECHANTILLONCOMPLET")
	String numeroechantilloncomplet;
	
	@XmlElementWrapper(name = "GENES_CR_VARIANT")
	@XmlElement(name = "variant")
	List<VariantDefgen> liostevariant;
	
	@XmlElementWrapper(name = "GENES_CR")
	@XmlElement(name = "gene")
	List<GeneAnalyse> listegene;
	
	@XmlElementWrapper(name = "FACT_ACTES_CR")
	@XmlElement(name = "CODE")
	List<Integer> facture;
	
	@XmlElement(name = "CRR")
	CRR crr;
	
	public CRR getCrr() {
		return crr;
	}
	public void setCrr(CRR crr) {
		this.crr = crr;
	}
	public List<Integer> getFacture() {
		return facture;
	}
	public void setFacture(List<Integer> facture) {
		this.facture = facture;
	}
	public List<GeneAnalyse> getListegene() {
		return listegene;
	}
	public void setListegene(List<GeneAnalyse> listegene) {
		this.listegene = listegene;
	}
	public int getIdft() {
		return idft;
	}
	public void setIdft(int idft) {
		this.idft = idft;
	}
	public int getIdeechantillon() {
		return ideechantillon;
	}
	public void setIdeechantillon(int ideechantillon) {
		this.ideechantillon = ideechantillon;
	}
	public String getNumeroechantilloncomplet() {
		return numeroechantilloncomplet;
	}
	public void setNumeroechantilloncomplet(String numeroechantilloncomplet) {
		this.numeroechantilloncomplet = numeroechantilloncomplet;
	}
	public List<VariantDefgen> getLiostevariant() {
		return liostevariant;
	}
	public void setLiostevariant(List<VariantDefgen> liostevariant) {
		this.liostevariant = liostevariant;
	}
	@Override
	public String toString() {
		return "PatientDefgen [idft=" + idft + ", ideechantillon=" + ideechantillon + ", numeroechantilloncomplet="
				+ numeroechantilloncomplet + ", liostevariant=" + liostevariant + ", listegene=" + listegene + "]";
	}
	
}
