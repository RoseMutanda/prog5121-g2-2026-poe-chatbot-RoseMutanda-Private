import java.util.Random;

public class Message {

    private String messageID;
    private String recipient;
    private String message;
    private String messageHash;
    private int numMessagesSent;

    public Message(int numMessagesSent, String recipient, String message) {
        this.numMessagesSent = numMessagesSent;
        this.recipient = recipient;
        this.message = message;
        this.messageID = createMessageID();
        this.messageHash = createMessageHash();
    }

    /**
 * Creates a random 10-digit message ID.
 *
 * @return message ID
 */

    public String createMessageID() {
        Random random = new Random();
        String id = "";

        for (int i = 0; i < 10; i++) {
            id += random.nextInt(10);
        }

        return id;
    }

    public boolean checkMessageID() {
        return messageID.length() == 10;
    }

    public int checkRecipientCell() {
        if (recipient.matches("^\\+27\\d{9}$")) {
            return 1;
        }

        return 0;
    }

    public String validateRecipient() {
        if (checkRecipientCell() == 1) {
            return "Cell phone number successfully captured.";
        }

        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    public String validateMessageLength() {
        if (message.length() <= 250) {
            return "Message ready to send.";
        }

        int extraCharacters = message.length() - 250;
        return "Message exceeds 250 characters by " + extraCharacters + ", please reduce size.";
    }

    public String createMessageHash() {
        String cleanMessage = message.trim();

        if (cleanMessage.isEmpty()) {
            return messageID.substring(0, 2) + ":" + numMessagesSent + ":EMPTY";
        }

        String[] words = cleanMessage.split("\\s+");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return (messageID.substring(0, 2) + ":" + numMessagesSent + ":" + firstWord + lastWord).toUpperCase();
    }

    public String sentMessage(int option) {
        if (option == 1) {
            return "Message successfully sent.";
        } else if (option == 2) {
            return "Press 0 to delete the message.";
        } else if (option == 3) {
            return "Message successfully stored.";
        } else {
            return "Invalid option selected.";
        }
    }

    public String printMessages() {
        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + message;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public int getNumMessagesSent() {
        return numMessagesSent;
    }
}