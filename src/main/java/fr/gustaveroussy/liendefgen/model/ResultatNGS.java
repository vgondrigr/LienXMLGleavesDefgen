package fr.gustaveroussy.liendefgen.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "resultat_NGS")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultatNGS {
	
	@XmlElement(name = "patient")
	List<PatientDefgen> listepatientdefgen;

	public List<PatientDefgen> getListepatientdefgen() {
		return listepatientdefgen;
	}

	public void setListepatientdefgen(List<PatientDefgen> listepatientdefgen) {
		this.listepatientdefgen = listepatientdefgen;
	}

	@Override
	public String toString() {
		return "ResultatNGS [listepatientdefgen=" + listepatientdefgen + "]";
	}

}
