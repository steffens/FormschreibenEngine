package de.dfg.example.formschreiben;

/**
 * App
 *
 */
public class App{
 
    public static void main(String[] args){

      new FormschreibenGenerator().erzeugeFromschreiben("ressources/Textbausteine_Korrespondenz_mit_Gutachtenden.docx", "Korrespondenz_mit_Gutachtenden.docx", "Frau Professor Müller", "geehrte");

    }
}