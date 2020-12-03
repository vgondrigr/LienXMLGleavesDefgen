package fr.gustaveroussy.liendefgen.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(namespace = "namespace")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { 	"gene", 					"variantproteique", 				"aenregistrer",			"statut", 				"etat", 				
						"resultat", 				"variantproteiquebis", 				"variantnucleique", 	"enst", 				"nm", 					
						"positiongenomiquestart", 	"classesur5",						"classesur3", 			"cosmic", 				"rs",					
						"references", 				"consequences", 					"commentaires", 		"chromosome", 			"genomereference", 	
						"nomenclaturehgvs", 		"localisation",						"sequenceref", 			"locus", 				"allele1", 					
						"alllele2", 				"proteine", 						"notes", 				"sequenceAlt", 			"positiongenomiquestartbis", 		
						"positiongenomiquestopbis", "zr1", 								"zr2",	 				"zr3", 					"zr4", 					
						"zr5", 						"zr6", 								"zr7", 					"zr8", 					"profondeurposition", 
						"profondeurvariant", 		"statusgenetique", 					"indicequalite", 		"stranddetectration", 	"typemutation", 		
						"interpretation", 			"frequencealleliquepourcentage", 	"domaineFCTL"})
public class VariantDefgen {

	@XmlElement(name = "GENE")
	String gene;					//parser
	
	@XmlElement(name = "VARIANT")
	String variantproteique;		//parser
	
	@XmlElement(name = "A_ENREGISTRER")
	Integer aenregistrer;
	
	@XmlElement(name = "STATUT")
	String statut;
	
	@XmlElement(name = "ETAT")
	String etat;
	
	@XmlElement(name = "RESULTAT")
	Integer resultat;
	
	@XmlElement(name = "VARIANT_P")
	String variantproteiquebis;		//parser
	
	@XmlElement(name = "VARIANT_C")
	String variantnucleique;		//parser
	
	@XmlElement(name = "ENST")
	String enst;
	
	@XmlElement(name = "NM")
	String nm;
	
	@XmlElement(name = "POSITION_GENOMIQUE")
	Integer positiongenomiquestart;	//parser
	
	@XmlElement(name = "CLASSESUR5")
	String classesur5;
	
	@XmlElement(name = "CLASSESUR3")
	String classesur3;
	
	@XmlElement(name = "COSMIC")
	String cosmic;
	
	@XmlElement(name = "RS")
	String rs;
	
	@XmlElement(name = "REFERENCES")
	String references;				//parser
	
	@XmlElement(name = "CONSEQUENCES")
	String consequences;
	
	@XmlElement(name = "COMMENTAIRES")
	String commentaires;
	
	@XmlElement(name = "CHROMOSOME")
	String chromosome;				//parser
	
	@XmlElement(name = "GENOME_REFERENCE")
	String genomereference;
	
	@XmlElement(name = "NOMENCLATURE_HGVS")
	String nomenclaturehgvs;
	
	@XmlElement(name = "LOCALISATION")
	String localisation;			//parser
	
	@XmlElement(name = "SEQUENCE_REF")
	String sequenceref;				//parser
	
	@XmlElement(name = "LOCUS")
	String locus;
	
	@XmlElement(name = "ALLELE1")
	String allele1;
	
	@XmlElement(name = "ALLELE2")
	String alllele2;
	
	@XmlElement(name = "PROTEINE")
	String proteine;
	
	@XmlElement(name = "NOTES")
	String notes;
	
	@XmlElement(name = "SEQUENCE_ALT")
	String sequenceAlt;
	
	@XmlElement(name = "START_POS_G")
	Integer positiongenomiquestartbis;//parser
	
	@XmlElement(name = "END_POS_G")
	Integer positiongenomiquestopbis;
	
	@XmlElement(name = "ZR1")
	String zr1;
	
	@XmlElement(name = "ZR2")
	String zr2;
	
	@XmlElement(name = "ZR3")
	String zr3;
	
	@XmlElement(name = "ZR4")
	String zr4;
	
	@XmlElement(name = "ZR5")
	String zr5;
	
	@XmlElement(name = "ZR6")
	String zr6;
	
	@XmlElement(name = "ZR7")
	String zr7;
	
	@XmlElement(name = "ZR8")
	String zr8;
	
	@XmlElement(name = "COUVERTURE_ANALYSE")
	Integer profondeurposition;		
	
	@XmlElement(name = "COUVERTURE_VARIANT")
	Integer profondeurvariant;		//parser
	
	@XmlElement(name = "STATUT_GENETIQUE")
	String statusgenetique;
	
	@XmlElement(name = "INDICE_QUALITE")
	String indicequalite;
	
	@XmlElement(name = "STRAND_DETECT_RATIO")
	String stranddetectration;
	
	@XmlElement(name = "TYPE_VARIANT")
	String typemutation;
	
	@XmlElement(name = "INTERPRETATION")
	String interpretation;
	
	@XmlElement(name = "FREQUENCE_ALLELIQUE")
	Integer frequencealleliquepourcentage; //parser
	
	@XmlElement(name = "DOMAINE_FCTL")
	String domaineFCTL;
	
	public String getGene() {
		return gene;
	}
	public void setGene(String gene) {
		this.gene = gene;
	}
	public String getVariantproteique() {
		return variantproteique;
	}
	public void setVariantproteique(String variantproteique) {
		this.variantproteique = variantproteique;
	}
	public Integer getAenregistrer() {
		return aenregistrer;
	}
	public void setAenregistrer(Integer aenregistrer) {
		this.aenregistrer = aenregistrer;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Integer getResultat() {
		return resultat;
	}
	public void setResultat(Integer resultat) {
		this.resultat = resultat;
	}
	public String getVariantproteiquebis() {
		return variantproteiquebis;
	}
	public void setVariantproteiquebis(String variantproteiquebis) {
		this.variantproteiquebis = variantproteiquebis;
	}
	public String getVariantnucleique() {
		return variantnucleique;
	}
	public void setVariantnucleique(String variantnucleique) {
		this.variantnucleique = variantnucleique;
	}
	public String getEnst() {
		return enst;
	}
	public void setEnst(String enst) {
		this.enst = enst;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public Integer getPositiongenomiquestart() {
		return positiongenomiquestart;
	}
	public void setPositiongenomiquestart(Integer positiongenomiquestart) {
		this.positiongenomiquestart = positiongenomiquestart;
	}
	public String getClassesur5() {
		return classesur5;
	}
	public void setClassesur5(String classesur5) {
		this.classesur5 = classesur5;
	}
	public String getClassesur3() {
		return classesur3;
	}
	public void setClassesur3(String classesur3) {
		this.classesur3 = classesur3;
	}
	public String getCosmic() {
		return cosmic;
	}
	public void setCosmic(String cosmic) {
		this.cosmic = cosmic;
	}
	public String getRs() {
		return rs;
	}
	public void setRs(String rs) {
		this.rs = rs;
	}
	public String getReferences() {
		return references;
	}
	public void setReferences(String references) {
		this.references = references;
	}
	public String getConsequences() {
		return consequences;
	}
	public void setConsequences(String consequences) {
		this.consequences = consequences;
	}
	public String getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	public String getChromosome() {
		return chromosome;
	}
	public void setChromosome(String chromosome) {
		this.chromosome = chromosome;
	}
	public String getGenomereference() {
		return genomereference;
	}
	public void setGenomereference(String genomereference) {
		this.genomereference = genomereference;
	}
	public String getNomenclaturehgvs() {
		return nomenclaturehgvs;
	}
	public void setNomenclaturehgvs(String nomenclaturehgvs) {
		this.nomenclaturehgvs = nomenclaturehgvs;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public String getSequenceref() {
		return sequenceref;
	}
	public void setSequenceref(String sequenceref) {
		this.sequenceref = sequenceref;
	}
	public String getLocus() {
		return locus;
	}
	public void setLocus(String locus) {
		this.locus = locus;
	}
	public String getAllele1() {
		return allele1;
	}
	public void setAllele1(String allele1) {
		this.allele1 = allele1;
	}
	public String getAlllele2() {
		return alllele2;
	}
	public void setAlllele2(String alllele2) {
		this.alllele2 = alllele2;
	}
	public String getProteine() {
		return proteine;
	}
	public void setProteine(String proteine) {
		this.proteine = proteine;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getSequenceAlt() {
		return sequenceAlt;
	}
	public void setSequenceAlt(String sequenceAlt) {
		this.sequenceAlt = sequenceAlt;
	}
	public Integer getPositiongenomiquestartbis() {
		return positiongenomiquestartbis;
	}
	public void setPositiongenomiquestartbis(Integer positiongenomiquestartbis) {
		this.positiongenomiquestartbis = positiongenomiquestartbis;
	}
	public Integer getPositiongenomiquestopbis() {
		return positiongenomiquestopbis;
	}
	public void setPositiongenomiquestopbis(Integer positiongenomiquestopbis) {
		this.positiongenomiquestopbis = positiongenomiquestopbis;
	}
	public String getZr1() {
		return zr1;
	}
	public void setZr1(String zr1) {
		this.zr1 = zr1;
	}
	public String getZr2() {
		return zr2;
	}
	public void setZr2(String zr2) {
		this.zr2 = zr2;
	}
	public String getZr3() {
		return zr3;
	}
	public void setZr3(String zr3) {
		this.zr3 = zr3;
	}
	public String getZr4() {
		return zr4;
	}
	public void setZr4(String zr4) {
		this.zr4 = zr4;
	}
	public String getZr5() {
		return zr5;
	}
	public void setZr5(String zr5) {
		this.zr5 = zr5;
	}
	public String getZr6() {
		return zr6;
	}
	public void setZr6(String zr6) {
		this.zr6 = zr6;
	}
	public String getZr7() {
		return zr7;
	}
	public void setZr7(String zr7) {
		this.zr7 = zr7;
	}
	public String getZr8() {
		return zr8;
	}
	public void setZr8(String zr8) {
		this.zr8 = zr8;
	}
	public Integer getProfondeurposition() {
		return profondeurposition;
	}
	public void setProfondeurposition(Integer profondeurposition) {
		this.profondeurposition = profondeurposition;
	}
	public Integer getProfondeurvariant() {
		return profondeurvariant;
	}
	public void setProfondeurvariant(Integer profondeurvariant) {
		this.profondeurvariant = profondeurvariant;
	}
	public String getStatusgenetique() {
		return statusgenetique;
	}
	public void setStatusgenetique(String statusgenetique) {
		this.statusgenetique = statusgenetique;
	}
	public String getIndicequalite() {
		return indicequalite;
	}
	public void setIndicequalite(String indicequalite) {
		this.indicequalite = indicequalite;
	}
	public String getStranddetectration() {
		return stranddetectration;
	}
	public void setStranddetectration(String stranddetectration) {
		this.stranddetectration = stranddetectration;
	}
	public String getTypemutation() {
		return typemutation;
	}
	public void setTypemutation(String typemutation) {
		this.typemutation = typemutation;
	}
	public String getInterpretation() {
		return interpretation;
	}
	public void setInterpretation(String interpretation) {
		this.interpretation = interpretation;
	}
	public Integer getFrequencealleliquepourcentage() {
		return frequencealleliquepourcentage;
	}
	public void setFrequencealleliquepourcentage(Integer frequencealleliquepourcentage) {
		this.frequencealleliquepourcentage = frequencealleliquepourcentage;
	}
	public String getDomaineFCTL() {
		return domaineFCTL;
	}
	public void setDomaineFCTL(String domaineFCTL) {
		this.domaineFCTL = domaineFCTL;
	}
	@Override
	public String toString() {
		return "VariantDefgen [gene=" + gene + ", variantproteique=" + variantproteique + ", aenregistrer="
				+ aenregistrer + ", statut=" + statut + ", etat=" + etat + ", resultat=" + resultat
				+ ", variantproteiquebis=" + variantproteiquebis + ", variantnucleique=" + variantnucleique + ", enst="
				+ enst + ", nm=" + nm + ", positiongenomiquestart=" + positiongenomiquestart + ", classesur5="
				+ classesur5 + ", classesur3=" + classesur3 + ", cosmic=" + cosmic + ", rs=" + rs + ", references="
				+ references + ", consequences=" + consequences + ", commentaires=" + commentaires + ", chromosome="
				+ chromosome + ", genomereference=" + genomereference + ", nomenclaturehgvs=" + nomenclaturehgvs
				+ ", localisation=" + localisation + ", sequenceref=" + sequenceref + ", locus=" + locus + ", allele1="
				+ allele1 + ", alllele2=" + alllele2 + ", proteine=" + proteine + ", notes=" + notes + ", sequenceAlt="
				+ sequenceAlt + ", positiongenomiquestartbis=" + positiongenomiquestartbis
				+ ", positiongenomiquestopbis=" + positiongenomiquestopbis + ", zr1=" + zr1 + ", zr2=" + zr2 + ", zr3="
				+ zr3 + ", zr4=" + zr4 + ", zr5=" + zr5 + ", zr6=" + zr6 + ", zr7=" + zr7 + ", zr8=" + zr8
				+ ", profondeurposition=" + profondeurposition + ", profondeurvariant=" + profondeurvariant
				+ ", statusgenetique=" + statusgenetique + ", indicequalite=" + indicequalite + ", stranddetectration="
				+ stranddetectration + ", typemutation=" + typemutation + ", interpretation=" + interpretation
				+ ", frequencealleliquepourcentage=" + frequencealleliquepourcentage + ", domaineFCTL=" + domaineFCTL
				+ "]";
	}
}
