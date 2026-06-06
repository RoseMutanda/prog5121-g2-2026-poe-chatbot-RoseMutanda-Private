import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class MessageManager {

    private ArrayList<Message> sentMessages = new ArrayList<>();
    private ArrayList<Message> storedMessages = new ArrayList<>();
    private ArrayList<Message> disregardedMessages = new ArrayList<>();

    public void saveStoredMessagesToJSON() {
    try {
        FileWriter writer = new FileWriter("storedMessages.json");

        writer.write("[\n");

        for (int i = 0; i < storedMessages.size(); i++) {
            Message message = storedMessages.get(i);

            writer.write("  {\n");
            writer.write("    \"messageID\": \"" + message.getMessageID() + "\",\n");
            writer.write("    \"messageHash\": \"" + message.getMessageHash() + "\",\n");
            writer.write("    \"recipient\": \"" + message.getRecipient() + "\",\n");
            writer.write("    \"message\": \"" + message.getMessage() + "\"\n");
            writer.write("  }");

            if (i < storedMessages.size() - 1) {
                writer.write(",");
            }

            writer.write("\n");
        }

        writer.write("]");

        writer.close();

    } catch (IOException e) {
        System.out.println("An error occurred while saving stored messages.");
    }
}

    public void addSentMessage(Message message) {
        sentMessages.add(message);
    }

    public void addStoredMessage(Message message) {
        storedMessages.add(message);
    }

    public void addDisregardedMessage(Message message) {
        disregardedMessages.add(message);
    }

    public int getTotalSentMessages() {
        return sentMessages.size();
    }

    public String displaySenderAndRecipient() {
        if (sentMessages.isEmpty()) {
            return "No sent messages available.";
        }

        String output = "";

        for (Message message : sentMessages) {
            output += "Recipient: " + message.getRecipient() + "\n";
            output += "Message: " + message.getMessage() + "\n\n";
        }

        return output;
    }

    public String displayLongestMessage() {
        if (sentMessages.isEmpty()) {
            return "No sent messages available.";
        }

        Message longest = sentMessages.get(0);

        for (Message message : sentMessages) {
            if (message.getMessage().length() > longest.getMessage().length()) {
                longest = message;
            }
        }

        return "Longest Message:\n" + longest.getMessage();
    }
    /**
 * Searches for a message by ID.
 *
 * @param id Message ID to search for
 * @return Message details or not found message
 */

    public String searchByMessageID(String id) {
        for (Message message : sentMessages) {
            if (message.getMessageID().equals(id)) {
                return message.printMessages();
            }
        }

        return "Message ID not found.";
    }

    public String searchByRecipient(String recipient) {
        String output = "";

        for (Message message : sentMessages) {
            if (message.getRecipient().equals(recipient)) {
                output += message.printMessages() + "\n\n";
            }
        }

        if (output.equals("")) {
            return "No messages found for this recipient.";
        }

        return output;
    }

    public String deleteByHash(String hash) {
        for (int i = 0; i < sentMessages.size(); i++) {
            if (sentMessages.get(i).getMessageHash().equalsIgnoreCase(hash)) {
                sentMessages.remove(i);
                return "Message successfully deleted.";
            }
        }

        return "Message hash not found.";
    }

    public String displayFullReport() {
        if (sentMessages.isEmpty()) {
            return "No sent messages available.";
        }

        String output = "===== SENT MESSAGE REPORT =====\n\n";

        for (Message message : sentMessages) {
            output += message.printMessages() + "\n\n";
        }

        return output;
    }
}