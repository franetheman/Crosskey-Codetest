package me.sontag.codetest.logic;

import me.sontag.codetest.model.Mortgage;
import me.sontag.codetest.utils.FileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  A class that parses input files
 */
public class FileParser {

    private List<Mortgage> mortageList;

    /**
     *  Default constructor.
     *  Initializes list to be empty.
     */
    public FileParser() {
        mortageList = new ArrayList<>();
    }

    /**
     *  Class constructor. contains parsing logic so it is done on init
     *  @param fileName name of file to parse
     */
    public FileParser(String fileName) {
        File f = getFileToParse(fileName);
        if(f == null) {
            mortageList = new ArrayList<>();
            return;
        }

        List<String> lines = readLines(f);
        if(lines.size() <= 1) { // if empty or only contains template we ignore
            mortageList = new ArrayList<>();
            return;
        }

        mortageList = parseLines(lines);
    }

    /**
     *  Gets the file to parse from the jar directory
     *  @param fileName the name of the file to parse
     *  @return null if not found or else the desired file
     */
    public File getFileToParse(String fileName) {
        File dataFolder = new File(FileUtil.getJarPath());
        File[] files = dataFolder.listFiles();

        if(files.length == 0)
            return null;

        for(File f : files)
            if(f.getName().equalsIgnoreCase(fileName))
                return f;

        return null;
    }

    /**
     *  A method that reads all lines from the input file.
     *  @param file file to read lines from
     *  @return A list of strings containing the file content
     */
    public List<String> readLines(File file) {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line;
            while((line = br.readLine()) != null)
                lines.add(line);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     *  A method that parses a list of strings to a list of mortgages
     *  @param lines the list of strings with file content
     *  @return the list of mortgages. Empty if there was nothing to parse
     */
    public List<Mortgage> parseLines(List<String> lines) {
        List<Mortgage> temp = new ArrayList<>();
        for(int i = 1; i < lines.size(); i++) // ignore first line since it is template
            temp.addAll(parseLine(lines.get(i)));

        return temp;
    }

    /**
     *  A method that parses a single line
     *  @param line the string to parse
     *  @return all the mortgages contained on a line. Multiple if name contained in quotations.
     *  Empty list returned if line doesn't follow template.
     */
    public List<Mortgage> parseLine(String line) {
        // Customer,Total loan,Interest,Years
        // if customer inside quotations, assume it is multiple customers with same loan plan. Create separate listings
        List<Mortgage> mortages = new ArrayList<>();

        line = line.replace("\"", "");
        String[] tokens = line.split(",");

        if(tokens.length < 4) // return if there is not sufficiently many tokens
            return mortages;

        int people = tokens.length-3;
        for(int i = 0; i < people; i++) {
            Mortgage mortage = new Mortgage();
            mortage.setName(tokens[i]);
            mortage.setTotalLoan(Double.parseDouble(tokens[tokens.length-3]));
            mortage.setMonthlyInterest(Double.parseDouble(tokens[tokens.length-2]));
            mortage.setPayments(Integer.parseInt(tokens[tokens.length-1]));
            mortage.setMonthlyPayment();
            mortages.add(mortage);
        }

        return mortages;
    }

    /**
     *  Getter for the list of mortgages that were parsed
     *  @return the list of mortgages.
     */
    public List<Mortgage> getMortageList() {
        return mortageList;
    }
}
