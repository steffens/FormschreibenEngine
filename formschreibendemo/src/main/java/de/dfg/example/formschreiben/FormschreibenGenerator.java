package de.dfg.example.formschreiben;

import java.io.IOException;
import java.io.InputStream;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

import java.io.FileInputStream;
import java.io.File;

public class FormschreibenGenerator {

    public void erzeugeFromschreiben(String outFileName, String name) {
        try (

                InputStream in = new FileInputStream(new File("ressources/Textbausteine_Korrespondenz_mit_Gutachtenden.docx"))) {
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

            IContext context = report.createContext();

            /*
             * System.out.println("Name: ");
             * String n = System.console().readLine();
             * if (n.endsWith("a")) {
             */
            context.put("anrede", "geehrte");
            /*
             * } else {
             * context.put("anrede", "geehrter");
             * }
             */
            context.put("name", name);

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
