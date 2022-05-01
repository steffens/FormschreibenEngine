package de.dfg.example.formschreiben;

/**
 * Minimales Beispiel zum Erzeugen einer Word-Datei aus einem Template
 * basierend auf XDocReport, Microsoft Word (docx) Vorlagen und
 * Apache Velocity Template Engine
 *
 */
public class App{
 
    public static void main(String[] args){
      // Erzeugt das Schreiben und befüllt die Platzhalte für Name und Anrede im Schreiben
      new FormschreibenGenerator().erzeugeFromschreiben("ressources/Textbausteine_Korrespondenz_mit_Gutachtenden.docx", 
        "Korrespondenz_mit_Gutachtenden.docx", 
        "Frau Professor Müller", 
        "geehrte");

    }
}