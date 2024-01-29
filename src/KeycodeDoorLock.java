import java.util.Scanner;

public class KeycodeDoorLock {
    private static final int TRIES = 3;
    private String answer;
    private int incorrect;
    private boolean locked;

    public KeycodeDoorLock(String initialCode) {
        this.answer = initialCode;
        this.locked = true;
        this.incorrect = 0;
    }
    public void enterCode(String inputCode) {
        if (locked) {
            if (inputCode.equals(answer)) {
                System.out.println("Status: Unlocked");
                locked = false;
                incorrect = 0;
            } else {
                System.out.println("Status: Locked");
                incorrect++;
                if (incorrect >= TRIES) {
                    System.out.println("Status: Hard Locked");
                    locked = true;
                }
            }
        } else {
            System.out.println("Status: Locked");
        }
    }

    public void lock() {
        if (locked) {
            System.out.println("Status: Locked");
        } else {
            System.out.println("Status: Locked");
            locked = true;
        }
    }

    public void reset() {
        if(locked) {
            System.out.println("Cannot reset while the door is locked.");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("New Answer Code: ");
            String newCode = scanner.nextLine();
            this.answer = newCode;
            System.out.println("Answer Code set successfully.");
            locked = true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Answer Code? ");
        String initialCode = scanner.nextLine();
        KeycodeDoorLock doorLock = new KeycodeDoorLock(initialCode);

        while (true) {
            System.out.print("(reset, lock, quit) Or enter the Code\n> ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("quit")) {
                break;
            } else if (userInput.equalsIgnoreCase("reset")) {
                doorLock.reset();
            } else if (userInput.equalsIgnoreCase("lock")) {
                doorLock.lock();
            } else {
                doorLock.enterCode(userInput);
            }
        }
    }
}
// this is a comment