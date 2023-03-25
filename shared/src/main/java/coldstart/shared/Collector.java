package coldstart.shared;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * The collector.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class Collector {

    /**
     * Stores time 0 - Time before starting Java process.
     */
    public static long time0;

    /**
     * Stores time 1 - Entering user code timestamp.
     */
    public static long time1;

    /**
     * Stores time 2 - Server claiming it is ready for processing timestamp.
     */
    public static long time2;

    /**
     * Stores time 3 - 1st request server side completed timestamp.
     */
    public static long time3;

    /**
     * Stores the CSV filename.
     */
    public static String csvFilename;

    /**
     * Write the results to the CSV file.
     */
    public static void writeResults() {
        try {
            FileOutputStream fileOutput = new FileOutputStream(csvFilename, true);
            try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(fileOutput))) {
                writer.print(time0);
                writer.print(",");
                writer.print(time1);
                writer.print(",");
                writer.print(time2);
                writer.print(",");
                writer.print(time3);
                writer.print(",");
                writer.print((time1 - time0));
                writer.print(",");
                writer.print((time2 - time0));
                writer.print(",");
                writer.println((time3 - time0));
                writer.flush();
            }
        } catch (FileNotFoundException fne) {
            fne.printStackTrace();
        }
    }
}
