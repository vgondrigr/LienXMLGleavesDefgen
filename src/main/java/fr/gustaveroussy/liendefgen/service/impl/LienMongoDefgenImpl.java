package fr.gustaveroussy.liendefgen.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;

import fr.gustaveroussy.liendefgen.model.CRR;
import fr.gustaveroussy.liendefgen.model.GeneAnalyse;
import fr.gustaveroussy.liendefgen.model.PatientDefgen;
import fr.gustaveroussy.liendefgen.model.ResultatNGS;
import fr.gustaveroussy.liendefgen.model.VariantDefgen;
import fr.gustaveroussy.liendefgen.service.service.LiendMongoDefgen;

@Service
public class LienMongoDefgenImpl implements LiendMongoDefgen{

	@Value("${spring.data.mongodb.host}")
    String host;
	
	@Value("${spring.data.mongodb.port}")
    int port;
	
	@Value("${spring.data.mongodb.database}")
    String database;
	
	@Value("${spring.data.mongodb.password}")
    String password;
	
	@Value("${spring.data.mongodb.username}")
    String username;
	
	@Value("${spring.data.mongodb.databasebis}")
    String databasebis;
	
	@Override
	public String getDocumentInterneByDocumentAndListeKey(Document document, String ... clefs) {
		
		String 	valeurcherche 	= null;
		List 	listeinterne 	= null;
		
		//Cette fonction permet de retourner un élément enfoui très profondement dans un document si le chemin des clefs est connu
		for( int i = 0; i < clefs.length; i++){
			
			try {
			
				if (listeinterne == null) {
				
					document = (Document) document.get(clefs[i]);
					//System.out.println("document");
					//System.out.println(document);
				} else {
					document 		= (Document) listeinterne.get(0);
					listeinterne 	= null;
					//System.out.println("listeinterne");
					document 		= (Document) document.get(clefs[i]);
					//System.out.println(document);
				}
				
			} catch(ClassCastException e) {
				//System.out.println(e);
				if (e.toString().contains("java.lang.String")) {
				
					valeurcherche = document.get(clefs[i]).toString();
				
				} else if (e.toString().contains("java.util.ArrayList")) {
				
					listeinterne = (List) document.get(clefs[i]);
					
				} else if (e.toString().contains("java.lang.Integer")) {
					
					valeurcherche = document.get(clefs[i]).toString();
					
				} else if (e.toString().contains("java.lang.Double")) {
					
					valeurcherche = document.get(clefs[i]).toString();
					
				}
				
			}
	    }
		
		if(listeinterne != null) {
			valeurcherche = listeinterne.get(0).toString();
		}
		
		return valeurcherche;
	}

	@Override
	public List<VariantDefgen> getVariantsDefgen(String login, int pid, String collection, Secteur secteur) {
		
		String statut = null;
		String etat = null;
		
		List<ServerAddress> seeds = new ArrayList<ServerAddress>();
		seeds.add( new ServerAddress(host, port));
		List<MongoCredential> credentials = new ArrayList<MongoCredential>();
		credentials.add(
		    MongoCredential.createScramSha1Credential(
		    	username,
		    	database,
		    	password.toCharArray()
		    )
		);
		
		MongoClient mongo = new MongoClient( seeds, credentials );
		mongo.getDatabaseNames().forEach(System.out::println);
		
		FindIterable<Document> 	documenttrouve 	= mongo.getDatabase(databasebis).getCollection(collection).find(new Document("login", login).append("pid",pid)).projection(new Document("selected_variants",1).append("_id", 0));
		Iterator<Document> 		it 				= documenttrouve.iterator();
		
		Document 	document;
		Document 	documentinterne;
		Document 	documentvariant;
		String 		valeurcherche;
		
		Set<String> clefvariants;
		Iterator<String> itvariant;
		String clefvariant;
		
		VariantDefgen variantdefgen 			= new VariantDefgen();
		List<VariantDefgen> listevariantdefgen 	= new ArrayList<VariantDefgen>();
		
		//Ici, on boucle sur les différents éléments renvoyé par mongo
		while(it.hasNext()) {
			
			document 		= it.next();
			documentinterne = (Document) document.get("selected_variants");
			clefvariants 	= documentinterne.keySet();
			
			itvariant = clefvariants.iterator();
			
			//Ici, on boucle sur les clefs à la racine de selected_variants
			while(itvariant.hasNext()) {
				variantdefgen 			= new VariantDefgen();
				clefvariant 	= itvariant.next();
				documentvariant	= (Document) documentinterne.get(clefvariant);
				System.out.println(documentvariant);
				//A ce stade, toutes les clefs ont des noms connus
				
				valeurcherche = this.getDocumentInterneByDocumentAndListeKey(documentvariant, "variant", "ANN", "selectedMulti", "values", "Gene_Name");
				variantdefgen.setGene(valeurcherche);
				
				valeurcherche = this.getDocumentInterneByDocumentAndListeKey(documentvariant, "variant", "ANN", "selectedMulti", "values", "HGVS_p");
				variantdefgen.setVariantproteique(valeurcherche);
				variantdefgen.setVariantproteiquebis(valeurcherche);
				variantdefgen.setAenregistrer(0);
				
				if (secteur.equals(secteur.tumeursolide)) {
					
					statut	= "Non confirmé";
					etat 	= "Tumoral";
					
				}
				
				variantdefgen.setStatut(statut);
				variantdefgen.setEtat(etat);
				variantdefgen.setResultat(1);
				
				valeurcherche = this.getDocumentInterneByDocumentAndListeKey(documentvariant, "variant", "ANN", "selectedMulti", "values", "HGVS_c");
				variantdefgen.setVariantnucleique(valeurcherche);
				variantdefgen.setEnst("");
				variantdefgen.setNm(""); //<-- Normallement on en a besoin
				
				valeurcherche = this.getDocumentInterneByDocumentAndListeKey(documentvariant, "variant", "pos");
				variantdefgen.setPositiongenomiquestart(new Integer(valeurcherche));
				variantdefgen.setPositiongenomiquestartbis(new Integer(valeurcherche));
				
				variantdefgen.setClassesur5("");//<-- Normallement on en a besoin
				variantdefgen.setClassesur3("");//<-- Normallement on en a besoin
				
				variantdefgen.setCosmic("");//<-- Normallement on en a besoin
				
				valeurcherche = this.getDocumentInterneByDocumentAndListeKey(documentvariant, "annotations", "dbsnp_RS");
				variantdefgen.setRs(valeurcherche);
				variantdefgen.setReferences("");
				variantdefgen.setConsequences("");
				variantdefgen.setCommentaires("");
				
				valeurcherche = this.getDocumentInterneByDocumentAndListeKey(documentvariant, "variant", "contig");
				variantdefgen.setChromosome(valeurcherche);
				
				variantdefgen.setGenomereference("");//<-- Normallement on en a extremement besoin
				variantdefgen.setNomenclaturehgvs("");
				
				variantdefgen.setLocalisation("");//<-- Normallement on en a extremement besoin
				
				valeurcherche = this.getDocumentInterneByDocumentAndListeKey(documentvariant, "variant", "ref");
				variantdefgen.setSequenceref(valeurcherche);
				variantdefgen.setLocus("");
				variantdefgen.setAllele1("");
				variantdefgen.setAlllele2("");
				variantdefgen.setProteine("");
				variantdefgen.setNotes("");
				
				valeurcherche = this.getDocumentInterneByDocumentAndListeKey(documentvariant, "variant", "alt");
				variantdefgen.setSequenceAlt(valeurcherche);
				
				variantdefgen.setZr1("");
				variantdefgen.setZr2("");
				variantdefgen.setZr3("");
				variantdefgen.setZr4("");
				variantdefgen.setZr5("");
				variantdefgen.setZr6("");
				variantdefgen.setZr7("");
				variantdefgen.setZr8("");
				
				valeurcherche = this.getDocumentInterneByDocumentAndListeKey(documentvariant, "annotations", "DP");
				variantdefgen.setProfondeurvariant(new Integer(valeurcherche));
				
				valeurcherche = this.getDocumentInterneByDocumentAndListeKey(documentvariant, "annotations", "AF");
				
				double afpasmodifie = new Double(valeurcherche);
				
				double af = new Double(valeurcherche) * 100;
				
				Integer afpourcentage = (int) af;
				
				variantdefgen.setFrequencealleliquepourcentage(afpourcentage);
				
				Integer profondeurtotal = (int) (variantdefgen.getProfondeurvariant() / afpasmodifie);
				
				variantdefgen.setProfondeurposition(profondeurtotal);
				
				//variantdefgen.setStatusgenetique(statusgenetique); //depent du classement
				
				variantdefgen.setIndicequalite("");
				variantdefgen.setStranddetectration("");
				
				String typemutation 	= null;
				Integer positionstop 	= 0;
				Integer taillemutation 	= variantdefgen.getSequenceAlt().length() - variantdefgen.getSequenceref().length(); //Il vaut mieux l'obtenir de la base
				
				if (variantdefgen.getSequenceref().length() == variantdefgen.getSequenceAlt().length()) {
				
					typemutation = "SNV";
					positionstop = variantdefgen.getPositiongenomiquestart();
					
				} else if (variantdefgen.getSequenceref().length() < variantdefgen.getSequenceAlt().length()) {
					
					typemutation = "INDEL";
					positionstop = variantdefgen.getPositiongenomiquestart() + 1;
					
				} else if (variantdefgen.getSequenceref().length() > variantdefgen.getSequenceAlt().length()) {
					
					typemutation = "INDEL";
					positionstop = variantdefgen.getPositiongenomiquestart() + taillemutation;
					
				}
				
				variantdefgen.setPositiongenomiquestopbis(positionstop);//<-- A calculer
				variantdefgen.setTypemutation(typemutation);
				variantdefgen.setInterpretation("");
				variantdefgen.setDomaineFCTL("");
				
				listevariantdefgen.add(variantdefgen);
				
				System.out.println(variantdefgen);
				System.out.println(documentvariant);
				
			}
			
		}
		return listevariantdefgen;
	}

	@Override
	public ResultatNGS getPatientDefgen(String login, int pid, String collection, Secteur secteur) {
		
		ResultatNGS resultat = new ResultatNGS();
		
		List<PatientDefgen> patients = new ArrayList<PatientDefgen>();
		
		PatientDefgen patient = new PatientDefgen();
		
		patient.setIdft(0);
		patient.setIdeechantillon(0);
		patient.setNumeroechantilloncomplet("");
		
		List<VariantDefgen> listevariants = this.getVariantsDefgen(login, pid, collection, Secteur.tumeursolide);
		patient.setLiostevariant(listevariants);
		List<GeneAnalyse> geneAnalyses = new ArrayList<GeneAnalyse>();
		GeneAnalyse geneAnalyse = new GeneAnalyse();
		geneAnalyse.setGene("");
		geneAnalyse.setGenotype("");
		geneAnalyse.setInterpretation("");
		geneAnalyse.setProteinepredie("");
		geneAnalyses.add(geneAnalyse);
		patient.setListegene(geneAnalyses);
		
		List<Integer> factur = new ArrayList<Integer>();
		factur.add(0);
		patient.setFacture(factur);
		
		CRR crr = new CRR();
		
		crr.setCommentaire("");
		crr.setFormule("");
		crr.setResNormal("");
		patient.setCrr(crr);
		
		patients.add(patient);
		resultat.setListepatientdefgen(patients);
		
		return resultat;
	}

}
