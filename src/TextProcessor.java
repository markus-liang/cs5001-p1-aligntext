import java.util.ArrayList;

/**
 * Text Processor Class.
 */
public class TextProcessor {
    /**
     * parse : Parseing line text to fit the maximum line length.
     * @param paragraphs : text input from file.
     * @param lineLength : expected maximum length per line.
     * @param mode : alignment mode [ L | R | C | B ].
     * @return Array List of String, contains ready to print paragraph.
     */
    public static ArrayList<String> parse(String[] paragraphs, int lineLength, String mode) {
        ArrayList<String> resultList = new ArrayList<String>();
        String result;
        String[] words;

        for (String line : paragraphs) {
            result = "";

            words = line.split(" ");
            for (String word : words) {
                if (result.length() == 0) {
                    if (result.length() + word.length() <= lineLength) {
                        result +=  word;
                    } else {
                        resultList.add(word);
                        result = "";
                    }
                } else {
                    if (result.length() + word.length() + 1 <= lineLength) {
                        result += " " + word;
                    } else {
                        resultList.add(result);
                        result = word;
                    }
                }
            }

            resultList.add(result);
        }

        return resultList;
    }

    /**
     * printFormated : Print text to monitor.
     * @param textList : text input from file.
     * @param lineLength : expected maximum length per line.
     * @param mode : alignment mode [ L | R | C | B ].
     */
    public static void printFormated(ArrayList<String> textList, int lineLength, String mode) {
        switch (mode) {
            case "R" :
                for (String text: textList) {
                    System.out.println(String.format("%" + lineLength + "s", text));
                }
                break;
            case "C" :
                for (String text: textList) {
                    int padLeft = ((lineLength - text.length()) / 2) + ((lineLength - text.length()) % 2);
                    int padRight = lineLength - text.length() - padLeft;
                    if (lineLength < text.length()) {
                        padLeft = 0;
                        padRight = 0;
                    }

                    System.out.println(" ".repeat(padLeft) + text + " ".repeat(padRight));
                }
                break;
            case "B" :
                int barWidth = 0;
                for (String text: textList) {
                    barWidth = (text.length() > barWidth ? text.length() : barWidth);
                }
                System.out.println(" " + "_".repeat(barWidth + 2) + " ");
                for (String text: textList) {
                    System.out.println(String.format("| %-" + barWidth + "s |", text));
                }
                System.out.println(" " + "-".repeat(barWidth + 2) + " ");
                System.out.println(" ".repeat(8) + "\\");
                System.out.println(" ".repeat(9) + "\\");
                break;
            default :
                for (String text: textList) {
                    System.out.println(text);
                }
                break;
        }
    }
}
