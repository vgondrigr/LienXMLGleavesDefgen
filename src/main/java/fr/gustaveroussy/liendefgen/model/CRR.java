package fr.gustaveroussy.liendefgen.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "crr")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { 	"formule", "commentaire", "resNormal"})
public class CRR {
	
	@XmlElement(name = "FORMULE")
	String formule;
	
	@XmlElement(name = "COMMENTAIRE")
	String commentaire;
	
	@XmlElement(name = "RES_NORMAL")
	String resNormal;

	public String getFormule() {
		return formule;
	}

	public void setFormule(String formule) {
		this.formule = formule;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getResNormal() {
		return resNormal;
	}

	public void setResNormal(String resNormal) {
		this.resNormal = resNormal;
	}

	@Override
	public String toString() {
		return "CRR [formule=" + formule + ", commentaire=" + commentaire + ", resNormal=" + resNormal + "]";
	}
	
	
	
}
