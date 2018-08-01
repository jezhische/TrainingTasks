package patterns.command;

public class CommandExample
{
    public interface Command
    {
        public void execute(Object data);
    }

    public class PrintCommand implements Command
    {
        public void execute(Object data)
        {
            System.out.println(data.toString());
        }
    }

    public static void callCommand(Command command, Object data)
    {
        command.execute(data);
    }

    public static void main(String... args)
    {
        callCommand(new CommandExample().new PrintCommand(), "hello world"); // new CommandExample.PrintCommand() или new PrintCommand(), если PrintCommand is static
//        по сути, PrintCommand не нужен - достаточно создать объект типа Command, и потом им пользоваться:
        Command command1 = new Command() {
            @Override
            public void execute(Object data) {System.out.println(data.toString());}
        };

        Command command2 = data -> System.out.println(data.toString());
    }
}