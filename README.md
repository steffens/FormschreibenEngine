# FormschreibenEngine

basiert auf dem Tutorial von Spring: https://spring.io/guides/gs/crud-with-vaadin/

verwendet die folgenden Frameworks:
* Apache POI, um Word-Dokumente zu erzeugen
* https://github.com/opensagres/xdocreport von opensagres, um Word-Dokumente in XML-Format mit einem Java Model zu mergen und bei Bedarf PDF-Dokumente zu erzeugen
** siehe auch https://github.com/opensagres/xdocreport/wiki/DocxReportingJavaMain
* Velocity: Template Engine

siehe auch:
https://git.zssi.ivbb.bund.de/registerfactory/rf-schreiben/-/blob/master/isy-schreiben/src/main/java/de/bund/bva/isyfact/schreiben/core/schreiben/impl/SchreibenVerwalterImpl.java


Beispiel:

    @Test
    public void testeErzeugeSchreiben() throws IOException {

        final List<String> beispielauflistung = new ArrayList<>();
        beispielauflistung.add("Ein Text. Soll: Position 1 | Ist: Position");
        beispielauflistung.add("Ein Text. Soll: Position 2 | Ist: Position");
        final String andere = "Herr";
        final String vorname = "Rudolf";

        final TestSchreibenDaten testSchreibenDaten = new TestSchreibenDaten(andere, vorname,
            SchreibenListenelementUtil.konvertiereElementeZuListenelementen(beispielauflistung));
        final WordSchreiben ausgabe = schreibenVerwalter.erzeugeSchreiben(testSchreibenDaten);
        assertThat(ausgabe).isNotNull();
        assertThat(ausgabe.getDocument()).isNotNull();
        assertThat(ausgabe.getMimeType()).isNotNull();

        // output the Schreiben
        SchreibenTestfallUtil.schreibeSchreibenAufFestplatte(ausgabe, "testImportUndErzeugung.out", ".docx");

        // Check the actual text against the expected text of the created Word-Schreiben
        final String text = WordParser.extrahiereTextAusDocx(new ByteArrayInputStream(ausgabe.getDocument()));
        final String unterschiede =
            TextVergleich.vergleicheText(text, SollSchreibenInhalte.SCHREIBEN_TEST_INHALT, true);

        assertThat(unterschiede).isNullOrEmpty();
    }

    @Test
    public void testeErzeugePDFSchreiben() throws IOException {
        final List<String> beispielauflistung = new ArrayList<>();
        beispielauflistung.add("Ein Text. Soll: Position 1 | Ist: Position");
        beispielauflistung.add("Ein Text. Soll: Position 2 | Ist: Position");
        final String andere = "Herr";
        final String vorname = "Rudolf";

        final TestSchreibenDaten testSchreibenDaten = new TestSchreibenDaten(andere, vorname,
            SchreibenListenelementUtil.konvertiereElementeZuListenelementen(beispielauflistung));
        final WordSchreiben ausgabe = schreibenVerwalter.erzeugeSchreiben(testSchreibenDaten, OutputFormat.PDF);
        assertThat(ausgabe).isNotNull();
        assertThat(ausgabe.getDocument()).isNotNull();
        assertThat(ausgabe.getMimeType()).isNotNull();

        // output the Schreiben
        SchreibenTestfallUtil.schreibeSchreibenAufFestplatte(ausgabe, "testImportUndErzeugung.out", ".pdf");
    }

