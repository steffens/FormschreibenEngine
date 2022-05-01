package de.dfg.example.formschreiben;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;


public class FormschreibenGenerator {

    public void erzeugeFromschreiben(String formschreibenTemplateName, String outFileName, String personName, String personAnrede) {
        
        try {
         
            // Template mit Platzhaltern laden
            InputStream in = new FileInputStream(
                        new File(formschreibenTemplateName));
            // Velocity Template Engine für Ersetzen von Platzhaltern initialisieren
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);
            //context laden und Attribute setzen
            IContext context = report.createContext();
            context.put("anrede", personAnrede);
            context.put("name", personName);

            // Ergebnisdokument erzeugen
            java.io.OutputStream out = new java.io.FileOutputStream(new File(outFileName));
            report.process(context, out);
     
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XDocReportException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}
