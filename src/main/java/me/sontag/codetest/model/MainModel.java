package me.sontag.codetest.model;

import me.sontag.codetest.logic.FileParser;

import java.util.ArrayList;
import java.util.List;

/**
 *  A class representing the data model
 *  This is bad, but it will do for the purposes of this code test
 *  Normally would use some persistent data store as opposed to whatever we want to call this
 */
public class MainModel {

    // Lists for all mortgages and outputs
    private static List<Mortgage> mortageList;
    private static List<Output> outputList = new ArrayList<>();

    /**
     *  Getter for mortgage list
     *  If prospects.txt not present then list will be initialized as an empty list
     *  @return mortgage list
     *  @see FileParser
     */
    public static List<Mortgage> getMortageList() {
        if(mortageList == null) {
            FileParser parser = new FileParser("prospects.txt");
            mortageList = parser.getMortageList();

            for(Mortgage m : mortageList)
                outputList.add(new Output(m.toString()));
        }

        return mortageList;
    }

    /**
     *  Getter for output list
     *  @return output list
     */
    public static List<Output> getOutput() {
        return outputList;
    }
}
