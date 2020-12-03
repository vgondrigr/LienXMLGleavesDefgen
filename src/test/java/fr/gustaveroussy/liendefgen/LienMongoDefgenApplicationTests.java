package fr.gustaveroussy.liendefgen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;

import fr.gustaveroussy.liendefgen.model.PatientDefgen;
import fr.gustaveroussy.liendefgen.model.ResultatNGS;
import fr.gustaveroussy.liendefgen.model.VariantDefgen;
import fr.gustaveroussy.liendefgen.service.impl.Secteur;
import fr.gustaveroussy.liendefgen.service.service.LiendMongoDefgen;

@SpringBootTest
class LienMongoDefgenApplicationTests {

	@Autowired
	LiendMongoDefgen liendMongoDefgen;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void requetemongoDB() throws JAXBException, IOException {
		
		String login = "MlmgCancer";
		int pid = 75;
		String collection = "basket";
		  
		ResultatNGS patient = liendMongoDefgen.getPatientDefgen(login, pid, collection, Secteur.tumeursolide);
		  
		JAXBContext contextbis = JAXBContext.newInstance(ResultatNGS.class);
		Marshaller mbis = contextbis.createMarshaller();
		mbis.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		// écriture dans le fichier
		File xml = new File("xml/resultat.xml");
		mbis.marshal(patient, xml);
		
		var fileName = "xml/resultat.xml";
        var filePath = Paths.get(fileName);

        var content = Files.readString(filePath);
        content = content.replace("<ns5:resultatNGS xmlns:ns2=\"namespace\" xmlns:ns3=\"patient\" xmlns:ns4=\"crr\" xmlns:ns5=\"resultat_NGS\">", "<resultat_NGS>");
        content = content.replace("</ns5:resultatNGS>", "</resultatNGS>");
        System.out.println(content);
        File xmlfinal = new File("xml/resultat.xml");
        
        PrintWriter writer = new PrintWriter("xml/resultat.xml", "UTF-8");
        writer.println(content);
        writer.close();
		
	}

	//@Test
	void testdot() {
		
		//liendMongoDefgen.getDocumentInterneByDocumentAndListeKey(null, "patate", "poire");
		
	}
}
