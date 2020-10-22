package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input in, Tracker track, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = in.askInt("Select: ");
            if(select < 0  || select >= actions.length){
                out.println("Wrong  input, you can select: 0 .. \" " +
                        "+ (actions.length - 1));");
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(in, track);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu");
        for (int i = 0; i < actions.length; i++) {
            out.println(i + "." + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input in = new ValidateInput(out,new ConsoleInput());
        Tracker track = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new FindItemByName(out),
                new FindByIdAction(out),
                new CreateItem(out),
                new ShowItem(out),
                new ReplaceItem(out),
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, track, actions);
    }
}

