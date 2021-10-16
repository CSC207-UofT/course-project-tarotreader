package commands;

public class commandExecutor {
    /**
     *Executes the provided commandLine
     * @param shellState the state of the program
     * @param commandLine is the given command line
     * @return String that is given back when command is executed
     * @throws Exeption if any of the provided commands/arguments is invalid
     */
    public String executeCommand(IShellState shellState string commandLine)
            throws Exeption{
        shellState.addHistory(commandLine);
        if (commandLine.equals("")){
            return "";
        }

    }

}
