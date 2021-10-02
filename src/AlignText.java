import java.util.ArrayList;

/**
 * Align Text class - for aligning text.
 */
public class AlignText {
    /**
     * main method.
     * @param args [filepath] [line_length] [mode].
     */
    public static void main(String[] args) {
        try {
            String[] paragraphs = FileUtil.readFile(args[0]);
            int lineLength = Integer.parseInt(args[1]);
            String mode = (args.length > 2 ? args[2] : "L");

            if (lineLength < 0) {
                throw new Exception("usage: java AlignText file_name line_length [align_mode]");
            } else {
                if (mode.equals("B")) {
                    lineLength = lineLength - 4;
                }

                ArrayList<String> parsedParagraph = TextProcessor.parse(paragraphs, lineLength, mode);
                TextProcessor.printFormated(parsedParagraph, lineLength, mode);
            }
        } catch (Exception e) {
            System.out.println("usage: java AlignText file_name line_length [align_mode]");
        }
    }


}
