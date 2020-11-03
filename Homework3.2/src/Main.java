import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frog frog = new Frog();
        char[] field = new char[11];
        List<FrogCommand> commands = new ArrayList<>();
        int curCommand = -1;
        while (true) {
            System.out.println("Список комманд:\n" +
                    "+N - прыгни на N шагов направо\n" +
                    "-N - прыгни на N шагов налево\n" +
                    "<< - Undo (отмени последнюю команду)\n" +
                    ">> - Redo (повтори последнюю команду)\n" +
                    "0 - выход");
            String input = scanner.nextLine();

            if (input.equals("0")) break;
            if (input.equals("<<")) {
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand).undoCom();
                    //Тут комманда только отменяется, не удаляется
                }
            } else if (input.equals(">>")) {
                if (curCommand < 0) {
                    System.out.println("Нечего повторять!");
                } else {
                    commands.get(curCommand).doCom();
                    commands.add(commands.get(curCommand));
                    curCommand++;
                }
            } else {
                try {
                    int steps = Integer.parseInt(input);
                    FrogCommand cmd = FrogCommands.jumpRightCommand(frog, steps);
                    curCommand++;
                    commands.add(cmd);
                    cmd.doCom();
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка!");
                }
            }
            Arrays.fill(field, 'o');
            field[frog.position] = 'x';
            System.out.println(Arrays.toString(field));
        }
    }
}
