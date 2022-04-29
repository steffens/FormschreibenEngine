package de.dfg.example.formschreiben;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.File;


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
        // klären InputStream in = new FileInputStream(new File(""));
        InputStream in = new FileInputStream(new File(""));

    }
}
