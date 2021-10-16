package commands;

public class commandExecutor {
    public String executeCommand(IShellState shellState string commandLine)
            throws Exeption{
        /*
         * throws an exception when the command given is invalid
         */
        shellState.addHistory(commandLine);
        if (commandLine.equals("")){
            return "";
        }
        /*
         * returns a string that is given after command is executed
         */
    }


}
