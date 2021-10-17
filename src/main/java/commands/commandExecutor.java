package commands;

public class commandExecutor {
    /**
     *Executes the provided commandLine
     * @param shellState the state of the program
     * @param commandLine is the given command line
     * @return string that is given back when command is executed
     * @throws Exeption if any of the provided commands/arguments is invalid
     */

    public String executeCommand(IShellState Shuffler string commandLine)
            throws Exeption{
        Shuffler.addHistory(commandLine);
        commandLine.equals("");
        return "";
    }

}
