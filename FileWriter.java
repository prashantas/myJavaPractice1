import java.io.*;

/*
//  https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
Writing Text Files in Java
To write a text file in Java, use FileWriter instead of FileReader, and BufferedOutputWriter instead of BufferedOutputReader.
Simple eh? 
Here's an example program that creates a file called 'temp.txt' and writes some lines of text to it. 
/*

public class FileWriter {
    public static void main(String [] args) {

        // The name of the file to open.
        String fileName = "temp.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write("Hello there,");
            bufferedWriter.write(" here is some text.");
            bufferedWriter.newLine();
            bufferedWriter.write("We are writing");
            bufferedWriter.write(" the text to the file.");

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}



/*
The output file now looks like this (after running the program): 


Hello there, here is some text.
We are writing the text to the file.

*/
