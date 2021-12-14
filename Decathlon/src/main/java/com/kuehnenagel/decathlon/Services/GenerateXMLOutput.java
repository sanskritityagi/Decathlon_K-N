package com.kuehnenagel.decathlon.Services;

import com.kuehnenagel.decathlon.Exception.XMLException;
import com.kuehnenagel.decathlon.Model.Athlete;
import com.kuehnenagel.decathlon.Utils.Utility;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class GenerateXMLOutput implements GenerateOutput{

    private final static String OUTPUT_PATH = "Decathlon/src/main/resources/results.xml";

    @Override
    public void generateOutputFile(List<Athlete> results) {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Athletes");
            doc.appendChild(rootElement);


            for (Athlete result: results) {

                Element athlete = doc.createElement("Athlete");
                rootElement.appendChild(athlete);

                athlete.setAttribute("Name", result.getName());

                athlete.appendChild(createElement(doc, "Rank", result.getRank() + ""));
                athlete.appendChild(createElement(doc, "Score", result.getScore() + ""));
            }

            saveFile(doc);

        } catch (Exception e) {
            Utility.showError("Error on flow - %s", e.getMessage());
            throw new XMLException(e.getMessage());
        }

    }

    private Element createElement(Document doc, String name, String value) {
        Element element = doc.createElement(name);
        element.appendChild(doc.createTextNode(value));
        return element;
    }

    private void saveFile(Document document) throws TransformerException, IOException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        DOMSource source = new DOMSource(document);
        File file = File.createTempFile("DecathlonResult.", ".xml");
        StreamResult result = new StreamResult(file);
        Utility.showInfo("Output file can be found at- %s", file.getAbsolutePath());
        transformer.transform(source, result);
    }





}
