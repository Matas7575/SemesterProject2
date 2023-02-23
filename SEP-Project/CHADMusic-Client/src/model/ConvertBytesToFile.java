package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/*** a class that converts bytes received from the server to a music file that the program can read
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class ConvertBytesToFile {
    private static String FILEPATH = "song.mp3";
    private static File file = new File(FILEPATH);
    /**
     * method to write the bytes into a file
     * @param bytes variable as byte[] type
     */
    public static void writeByte(byte[] bytes) {
        System.out.println("Writing bytes!!!!");
        try {
            OutputStream os = new FileOutputStream(file);
            os.write(bytes, 0, bytes.length);
            System.out.println(bytes.length);
            System.out.println("Successfully"
                    + " byte inserted");
            os.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * a method to get absolute path of the file
     * @return path as a String
     */
    public static String sendPath() {
        return file.getAbsolutePath();
    }
}