package de.dfg.example.formschreiben;



import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;





public class FormschreibenGeneratorTest {

    private static String outfilename;
    private FormschreibenGenerator fsgen = new FormschreibenGenerator();

    @BeforeAll
    static void initAll() {
        outfilename = "out.docx";
    }

    @BeforeEach
    void init() {
    }

    @Test
    void succeedingTest() {
        fsgen.erzeugeFromschreiben(outfilename, "Anja");
        assertTrue(new File(outfilename).exists());
    }

    @Test
    void testTest() {
    assertTrue(true);
    }
    
    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
        new File(outfilename).delete();
    }

}
