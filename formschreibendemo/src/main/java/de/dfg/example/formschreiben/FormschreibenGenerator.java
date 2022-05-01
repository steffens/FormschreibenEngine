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

/**
 * Der Formschreibengenerator verwendet XDocReport zum Erzeugen einer MS Word Datei aus einem MS Word Template mit Platzhaltern.
 * Der Formschreibengenerator verwendet den Apache Velocity Template Engine und ersetzt zwei Platzhalter im Word Template.
 */
public class FormschreibenGenerator {

    /**
     * erzeugt das Schreiben auf Basis des Templates
     * 
     * @param formschreibenTemplateName Verweis auf die Template-Datei (inkl. Pfad)
     * @param outFileName Name der Ergebnisdatei
     * @param personName erstes Attribut, welches den Platzhalter $name; im Word Tempalte ersetzt
     * @param personAnrede zweites Attribut, welches den Platzhalter $anrede; im Word Template ersetzt
 
     * @see XDdocReport
     */
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
