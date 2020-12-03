package fr.gustaveroussy.liendefgen.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "patient")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { 	"gene", "genotype", "proteinepredie", "interpretation"})
public class GeneAnalyse {

	@XmlElement(name = "GENE")
	String gene;
	
	@XmlElement(name = "GENOTYPE")
	String genotype;
	
	@XmlElement(name = "PROTEINE_PREDITE")
	String proteinepredie;
	
	@XmlElement(name = "INTERPRETATION")
	String interpretation;
	public String getGene() {
		return gene;
	}
	public void setGene(String gene) {
		this.gene = gene;
	}
	public String getGenotype() {
		return genotype;
	}
	public void setGenotype(String genotype) {
		this.genotype = genotype;
	}
	public String getProteinepredie() {
		return proteinepredie;
	}
	public void setProteinepredie(String proteinepredie) {
		this.proteinepredie = proteinepredie;
	}
	public String getInterpretation() {
		return interpretation;
	}
	public void setInterpretation(String interpretation) {
		this.interpretation = interpretation;
	}
	@Override
	public String toString() {
		return "GeneAnalyse [gene=" + gene + ", genotype=" + genotype + ", proteinepredie=" + proteinepredie
				+ ", interpretation=" + interpretation + "]";
	}
	
}
