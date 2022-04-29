package de.dfg.example.formschreiben;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.lowagie.text.pdf.codec.Base64.InputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    throws FileNotFoundException
    {
        System.out.println( "Hello World!" );
        InputStream in = new FileInputStream(new File(""));

    }
}
