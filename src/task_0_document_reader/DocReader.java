package task_0_document_reader;

import java.io.*;
import java.util.*;
import java.util.regex.*;


public class DocReader {

    static Scanner input;
    static String p = "docnum";
    static List<String> arrayDoc = new ArrayList<>();
    static Set<String> setDoc = new HashSet<>();
    static Map<String, String> fileReport = new HashMap<>();
    static String docNum;
    static Pattern pattern = Pattern.compile(p);

    public static void documentRead() {

        System.out.println("Enter the path to file:");
        Scanner scanner2 = new Scanner(System.in);
        String file = scanner2.nextLine();
        System.out.println(" ");
        arrayDoc.add(file);
        //System.out.println(arrayDoc);

// Add doc numbers for Set collections
        try (BufferedReader fr = new BufferedReader(new FileReader(file))) {

            System.out.println("---------");

            while ((docNum = fr.readLine()) != null) {

                setDoc.add(docNum);
                System.out.println(docNum);

            }
            System.out.println(setDoc);

            System.out.println("---------");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

// Output document numbers
        try (BufferedWriter outReportFile = new BufferedWriter(new FileWriter("docValid.txt", true))) {

            for (String item : setDoc) {
                Matcher matcher = pattern.matcher(item);
                if (item.length() == 15 && matcher.find()) {

                    outReportFile.write(" Document name is  - " + item);
                    outReportFile.write("\n");
                    fileReport.put(item, " - document is valid.");
                } else { // TODO: Better add sort doc numbers valid/notValid, but idk how i can do it.

                    outReportFile.write(item + "- the document is not valid (Reason: Length < 15 symbols and (or) does not start with (docnum)");
                    outReportFile.write("\n");
                    fileReport.put(item, " - the document is not valid (Reason: Length < 15 symbols and (or) does not start with (docnum)");
                }

            }
            System.out.println("Output completed");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        input = new Scanner(System.in);

        while (true) {
            System.out.println("---------");
            System.out.println("Chose: ");
            System.out.println("1 - File");
            System.out.println("0 - Exit");
            System.out.println("---------");

            int i = input.nextInt();
            if (i == 1) {
                documentRead();
            } else if (i == 0) {
                break;
            }


        }
    }
}


