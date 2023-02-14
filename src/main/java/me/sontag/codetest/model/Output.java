package me.sontag.codetest.model;

/**
 *  A class containing an output instance
 *  This is essentially just a string wrapper that exists to get it into a vaadin grid
 *  The only upside to this is the potential to expand it in the future
 */
public class Output {
    // output string
    private String output;

    /**
     *  Default constructor
     */
    public Output() {

    }

    /**
     *  Constructor that initializes the output string
     *  @param output string to set as the output
     */
    public Output(String output) {
        this.output = output;
    }

    /**
     *  Getter for output
     *  @return output string
     */
    public String getOutput() {
        return output;
    }

    /**
     *  Setter for output string
     *  @param output the new output string
     */
    public void setOutput(String output) {
        this.output = output;
    }
}
