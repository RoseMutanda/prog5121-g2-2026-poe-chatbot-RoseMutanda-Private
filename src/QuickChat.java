import java.util.Scanner;

public class QuickChat {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=== Register User ===");

        System.out.print("First Name: ");
        String firstName = input.nextLine();

        System.out.print("Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Username: ");
        String username = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        System.out.print("Cell Number (+27): ");
        String phoneNumber = input.nextLine();

        Login login = new Login(username, password, phoneNumber, firstName, lastName);

        System.out.println(login.registerUser());

        if (!login.checkUserName()
                || !login.checkPasswordComplexity()
                || !login.checkCellPhoneNumber()) {
            input.close();
            return;
        }

        System.out.println("\n=== Login ===");

        System.out.print("Username: ");
        String enteredUsername = input.nextLine();

        System.out.print("Password: ");
        String enteredPassword = input.nextLine();

        System.out.println(login.returnLoginStatus(enteredUsername, enteredPassword));

        if (!login.loginUser(enteredUsername, enteredPassword)) {
            input.close();
            return;
        }

        System.out.println("\nWelcome to QuickChat.");

        MessageManager manager = new MessageManager();

        System.out.print("How many messages would you like to enter? ");
        int numberOfMessages = input.nextInt();
        input.nextLine();

        boolean running = true;

        while (running) {

            System.out.println("\n====== MENU ======");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");

            System.out.print("Choose an option: ");
            int menuOption = input.nextInt();
            input.nextLine();

            switch (menuOption) {

                case 1:
                    for (int i = 1; i <= numberOfMessages; i++) {

                        System.out.println("\nMessage " + i);

                        System.out.print("Recipient number: ");
                        String recipient = input.nextLine();

                        System.out.print("Enter message: ");
                        String messageText = input.nextLine();

                        Message message = new Message(i, recipient, messageText);

                        System.out.println(message.validateRecipient());

                        if (message.checkRecipientCell() == 0) {
                            i--;
                            continue;
                        }

                        System.out.println(message.validateMessageLength());

                        if (messageText.length() > 250) {
                            i--;
                            continue;
                        }

                        System.out.println("\nSelect an option:");
                        System.out.println("1) Send Message");
                        System.out.println("2) Disregard Message");
                        System.out.println("3) Store Message To Send Later");

                        System.out.print("Choose an option: ");
                        int sendOption = input.nextInt();
                        input.nextLine();

                        switch (sendOption) {

                            case 1:
                                manager.addSentMessage(message);
                                System.out.println("Message successfully sent.");
                                System.out.println(message.printMessages());
                                break;

                            case 2:
                                manager.addDisregardedMessage(message);
                                System.out.println("Press 0 to delete the message.");
                                break;

                            case 3:
                                manager.addStoredMessage(message);
                                manager.saveStoredMessagesToJSON();
                                System.out.println("Message successfully stored.");
                                break;

                            default:
                                System.out.println("Invalid option selected.");
                                i--;
                                break;
                        }
                    }

                    System.out.println("\nTotal messages sent: "
                            + manager.getTotalSentMessages());
                    break;

                case 2:
                    boolean reportMenu = true;

                    while (reportMenu) {
                        System.out.println("\n===== PART 3 REPORT MENU =====");
                        System.out.println("1) Display sender and recipient of all sent messages");
                        System.out.println("2) Display the longest sent message");
                        System.out.println("3) Search by Message ID");
                        System.out.println("4) Search by Recipient");
                        System.out.println("5) Delete message by Message Hash");
                        System.out.println("6) Display full sent message report");
                        System.out.println("7) Back to main menu");

                        System.out.print("Choose an option: ");
                        int reportOption = input.nextInt();
                        input.nextLine();

                        switch (reportOption) {
                            case 1:
                                System.out.println(manager.displaySenderAndRecipient());
                                break;

                            case 2:
                                System.out.println(manager.displayLongestMessage());
                                break;

                            case 3:
                                System.out.print("Enter Message ID: ");
                                String searchID = input.nextLine();
                                System.out.println(manager.searchByMessageID(searchID));
                                break;

                            case 4:
                                System.out.print("Enter recipient number: ");
                                String searchRecipient = input.nextLine();
                                System.out.println(manager.searchByRecipient(searchRecipient));
                                break;

                            case 5:
                                System.out.print("Enter Message Hash: ");
                                String hash = input.nextLine();
                                System.out.println(manager.deleteByHash(hash));
                                break;

                            case 6:
                                System.out.println(manager.displayFullReport());
                                break;

                            case 7:
                                reportMenu = false;
                                break;

                            default:
                                System.out.println("Invalid option.");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting QuickChat...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        input.close();
    }
}