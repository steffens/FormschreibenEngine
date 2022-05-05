# FormschreibenEngine

basiert auf dem Tutorial von Spring: https://spring.io/guides/gs/crud-with-vaadin/

verwendet die folgenden Frameworks:
* Apache POI, um Word-Dokumente zu erzeugen
* https://github.com/opensagres/xdocreport von opensagres, um Word-Dokumente in XML-Format mit einem Java Model zu mergen und bei Bedarf PDF-Dokumente zu erzeugen
** siehe auch https://github.com/opensagres/xdocreport/wiki/DocxReportingJavaMain
* Velocity: Template Engine

siehe auch:
https://git.zssi.ivbb.bund.de/registerfactory/rf-schreiben/-/blob/master/isy-schreiben/src/main/java/de/bund/bva/isyfact/schreiben/core/schreiben/impl/SchreibenVerwalterImpl.java

# Erstellung des Word Templates
1. Word Dokument erstellen
2. Platzhalter als Merge-Field einfügen

# Beispiel

            // Template mit Platzhaltern laden
            InputStream in = new FileInputStream(
                        new File(formschreibenTemplateName));
            
            // Velocity Template Engine für Ersetzen von Platzhaltern initialisieren
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);
            
            //context laden und Attribute setzen
            IContext context = report.createContext();
            context.put("anrede", personAnrede);
            context.put("name", personName);

            // Ergebnisdokument erzeugen und Platzhalter ersetzen
            java.io.OutputStream out = new java.io.FileOutputStream(new File(outFileName));
            report.process(context, out);
    }

