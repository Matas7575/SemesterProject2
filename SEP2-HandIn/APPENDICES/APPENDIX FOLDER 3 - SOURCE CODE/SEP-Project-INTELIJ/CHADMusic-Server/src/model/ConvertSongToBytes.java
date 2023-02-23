package model;

import java.io.*;
/*** a class that converts songs in the database to bytes that it can send to the client
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class ConvertSongToBytes {
    private File file;
    private InputStream fileStream;
    private  long length;

    /**
     * a method that converts songs to bytes
     * @param song variable as Song type
     * @return bytes as byte[] type
     * @throws IOException in case of not finding the song
     */
    public  byte[] convert(Song song) throws IOException {
        System.out.println("Running convert!!!!");
        file = new File(song.getPath());
        fileStream = new FileInputStream(file);
        length = file.length();
        if (length > Integer.MAX_VALUE) {
            System.out.println("TOO LARGE - ERROR");
        }
        byte[] bytes = new byte[(int)length];
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length && (numRead=fileStream.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+ file.getName());
        }
        fileStream.close();
        return bytes;
    }
}
