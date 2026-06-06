

import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {

    @Test
    public void testMessageLengthSuccess() {
        Message msg = new Message(1, "+27838884567", "Hi Mike, can you join us for dinner tonight");
        assertEquals("Message ready to send.", msg.validateMessageLength());
    }

    @Test
    public void testRecipientCorrectlyFormatted() {
        Message msg = new Message(1, "+27838884567", "Hi Mike");
        assertEquals("Cell phone number successfully captured.", msg.validateRecipient());
    }

    @Test
    public void testRecipientIncorrectlyFormatted() {
        Message msg = new Message(1, "0838884567", "Hi Mike");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", msg.validateRecipient());
    }

    @Test
    public void testMessageIDCreated() {
        Message msg = new Message(1, "+27838884567", "Hi Mike");
        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testSendMessageOption() {
        Message msg = new Message(1, "+27838884567", "Hi Mike");
        assertEquals("Message successfully sent.", msg.sentMessage(1));
    }

    @Test
    public void testDisregardMessageOption() {
        Message msg = new Message(1, "+27838884567", "Hi Mike");
        assertEquals("Press 0 to delete the message.", msg.sentMessage(2));
    }

    @Test
    public void testStoreMessageOption() {
        Message msg = new Message(1, "+27838884567", "Hi Mike");
        assertEquals("Message successfully stored.", msg.sentMessage(3));
    }
}