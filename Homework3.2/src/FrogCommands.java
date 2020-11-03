public class FrogCommands {

    public static FrogCommand jumpRightCommand(Frog frog, int steps) {
        return new FrogCommand() {
            @Override
            public boolean doCom() {
                return frog.jump(steps);
            }

            @Override
            public boolean undoCom() {
                return frog.jump(-steps);
            }
        };
    }
}
