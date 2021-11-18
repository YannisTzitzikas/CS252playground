package frontistirio03;

import java.io.*;
import java.util.Random;
import java.util.regex.Pattern;

/* 
author: kadilier
modified: ngounakis
See Slides of F03_FilesStreams_2019-2020.pdf
*/
public class GeneralExamples {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        /*
        Examine each method(test0(), test1()..) and run the code(important).
        
        test0() --> Files
        test1() --> Input and Output Stream
        test2() --> Reader and Writer(dealing with characters)
        test3() --> Built in Streams(SystemIn, SystemOut, SystemErr)
        test4() --> Data Input/Output Streams
        test5() --> Buffered Reader/Writer Streams
        test6() --> Random Access File
        test7() --> Formatting, using PrintWriter
        test8() --> Assignment hints, regex
        */
        
        test0();
        
    }

    //***********************Files***********************
    // Slides 47-50
    public static void test0() throws IOException {
    
        File testFile = new File("F03TestFiles/file1.txt");
        File testDir = new File("F03TestFiles");
    
            System.out.println(testFile.getCanonicalPath());
    
        // Tests whether there a file with the given path exists.
        if (testFile.exists()) {
    
            System.out.println("test0(): TestFile(Absolute Path): " + testFile.getAbsolutePath());
            System.out.println("test0(): TestFile(RelativePath): " + testFile.getPath());
    
        } else {
            System.err.println("test0(): " + testFile.getName() + " file does not exist.");
        }
    
        System.out.println();
    
        // Tests whether there a directory with the given path exists.
        if (testDir.isDirectory()) {
    
            // store all files included in the dircectory to an array of Files
            File[] files = testDir.listFiles();
    
            System.out.println("test0(): Directory '" + testDir.getName() + "' contains " + files.length + " files: ");
            for (File currentFile : files) {
    
                System.out.println("---" + currentFile.getName());
    
            }
    
        } else {
            System.err.println("test0(): " + testDir.getName() + " directory does not exist.");
            return;
        }
    
    }

    //***********************Input/Output Streams***********************
    // Slides 7-11
    public static void test1() throws FileNotFoundException, IOException {

        //Opening a FileInputStream and FileOutputStream for the file with given path.
        File inputFile = new File("F03TestFiles/file1.txt");
        File outputFile = new File("F03TestFiles/output.txt");

        //File with name: "F03TestFiles/input.txt" must exist.
        if (!inputFile.exists()) {
            System.err.println(inputFile.getName() + " does not exist");

            return;
        }

        InputStream in = new FileInputStream(inputFile);
        OutputStream out = new FileOutputStream(outputFile);

        int c;
        while ((c = in.read()) != -1) {
            System.out.print(c);
            out.write(c);
        }

        in.close();
        out.close();

    }



    //***********************Reader/Writer***********************
    public static void test2() throws FileNotFoundException, IOException {

        File inputFile = new File("F03TestFiles/file1.txt");

        //File with name: "F03TestFiles\\input.txt" must exist.
        if (!inputFile.exists()) {
            System.err.println(inputFile.getName() + " does not exist");
            return;
        }

        // Opens a InputStreamReader for the given file. 
        Reader in2 = new InputStreamReader(new FileInputStream(inputFile));
        Writer out2 = new OutputStreamWriter(new FileOutputStream("F03TestFiles/output.txt"));

        int c;
        while ((c = in2.read()) != -1) {
            System.out.print((char) c);
            out2.write(c);
        }

        char[] array = "\n This is a test 2".toCharArray();
        String str = "\n This is test 3";

        out2.write(array);
        out2.write(str);

        in2.close();
        out2.close();

    }

    
    //***********************Data Input/Output Streams***********************
    public static void test3() throws FileNotFoundException, IOException {
        
        DataOutputStream out4 = new DataOutputStream(new FileOutputStream("F03TestFiles/output4.txt"));
        
        // Writing a float(double). Important : You must read it as a float(double). Otherwise an Exception is thrown.
        out4.writeFloat(12f);
        out4.close();
        
        // Opening a DataInputStream for reading the file that was written.
        DataInputStream in4 = new DataInputStream(new FileInputStream("F03TestFiles/output4.txt"));
        
        // While there is content on file, read it.
        while (in4.available() > 0) {
            System.out.println(in4.readFloat());
            //System.out.println(in4.readDouble());
            //System.out.println(in4.readUTF());
        }
        
        in4.close();
        
    }

    //***********************Built in Streams(SystemIn, SystemOut, SystemErr)***********************
    public static void test4() throws IOException, IOException {
        Reader in3 = new InputStreamReader(System.in);

        char c;

        System.out.println("Insert a character(q : exit): ");
        while ((c = (char) in3.read()) != 'q') {
            System.out.println("You typed: " + c);
        }

        System.err.println("Exiting");

    }
    
    //***********************Buffered Reader/Writer Streams***********************
    public static void test5() throws FileNotFoundException, FileNotFoundException, IOException {

        File inputFile = new File("F03TestFiles/input.txt");
        File outputFile = new File("F03TestFiles/output5.txt");

        if (!inputFile.exists()) {

            System.err.println(inputFile.getName() + " does not exist");
            return;
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFile));

        // Read and write bytes with the same write/read methods of FileStream.
        bos.write(127);
        bis.read();
        //

        // Buffered Reader/Writer for dealing with characters/strings but using BufferedStream.
        BufferedReader br = new BufferedReader(new FileReader(outputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        String line;

        bw.write("Testing buffered writer. Dont forget to flush at the end of writing.");
        bw.write("More writing");

        bw.flush();
        bw.close();

        while ((line = br.readLine()) != null) {

            System.out.println(line);

        }

    }

    //***********************Random Access Files***********************
    public static void test6() throws FileNotFoundException, IOException {

        RandomAccessFile ra = new RandomAccessFile("F03TestFiles/output6.txt", "rw");

        System.out.println("File pointer initial position at: " + ra.getFilePointer());

        ra.writeUTF("Hello1 \n\n Hello2");

        System.out.println("File Pointer is now(after writeUTF()): " + ra.getFilePointer());

        ra.seek(12);
        System.out.println("File Pointer is now(after seek()): " + ra.getFilePointer());

        System.out.println(ra.readLine());

    }

    //***********************Formatting with PrintWriter***********************
    public static void test7() throws FileNotFoundException, IOException {

        String line = "";
        int randomL = 1 + (new Random()).nextInt((7 - 1) + 1);

        PrintWriter pwriter = new PrintWriter("F03TestFiles/output7.txt", "UTF-8");
        PrintWriter pwriterZ = new PrintWriter("F03TestFiles/Z.html");

        pwriter.write("Κείμενο στα Ελληνικά\n ");
        pwriter.printf("%d %s %d = %d", 5, "+", 3, 8);

        pwriterZ.write("<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\" />\n"
                + "</head\n"
                + "<body>\n"
                + "\n"
                + "<font size=\"" + randomL + "\">Z</font>\n"
                + "\n"
                + "</body>\n"
                + "</html>");

        pwriter.close();
        pwriterZ.close();

        BufferedReader br2 = new BufferedReader(new FileReader("F03TestFiles/output8.txt"));
        while ((line = br2.readLine()) != null) {
            System.out.println(line);
        }

    }

    //***********************Regular Expressions***********************
    public static void test8(){

        String thePattern = "[^A-Za-z0-9\\s]+";
        String theInput = "A string !@#$%^&*()_+-={}|[]\\:\";'<>?/.,~`^";

        String noSpecialChars =  Pattern.compile(thePattern).matcher(theInput).replaceAll("1");

        System.out.println("Input: " + theInput);
        System.out.println("Input(only numbers-letters): " + noSpecialChars);

    }

}
