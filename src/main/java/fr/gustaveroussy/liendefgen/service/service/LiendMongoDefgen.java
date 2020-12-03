package fr.gustaveroussy.liendefgen.service.service;

import java.util.List;

import org.bson.Document;

import fr.gustaveroussy.liendefgen.model.PatientDefgen;
import fr.gustaveroussy.liendefgen.model.ResultatNGS;
import fr.gustaveroussy.liendefgen.model.VariantDefgen;
import fr.gustaveroussy.liendefgen.service.impl.Secteur;

public interface LiendMongoDefgen {

	String getDocumentInterneByDocumentAndListeKey(Document document, String ... clefs);
	List<VariantDefgen> getVariantsDefgen(String login, int pid, String collection, Secteur secteur);
	ResultatNGS getPatientDefgen(String login, int pid, String collection, Secteur secteur);
	
}
