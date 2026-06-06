import org.junit.Test;
import static org.junit.Assert.*;

public class MessageManagerTest {

    @Test
    public void testAddSentMessage() {
        MessageManager manager = new MessageManager();

        Message message = new Message(1, "+27838884567", "Hello Mike");

        manager.addSentMessage(message);

        assertEquals(1, manager.getTotalSentMessages());
    }

    @Test
    public void testDisplayLongestMessage() {
        MessageManager manager = new MessageManager();

        Message message1 = new Message(1, "+27838884567", "Short message");
        Message message2 = new Message(2, "+27838884567", "This is the longest message in the test");

        manager.addSentMessage(message1);
        manager.addSentMessage(message2);

        assertTrue(manager.displayLongestMessage().contains("This is the longest message in the test"));
    }

    @Test
    public void testSearchByMessageID() {
        MessageManager manager = new MessageManager();

        Message message = new Message(1, "+27838884567", "Hello Mike");
        manager.addSentMessage(message);

        String result = manager.searchByMessageID(message.getMessageID());

        assertTrue(result.contains("Hello Mike"));
    }

    @Test
    public void testSearchByRecipient() {
        MessageManager manager = new MessageManager();

        Message message = new Message(1, "+27838884567", "Hello Mike");
        manager.addSentMessage(message);

        String result = manager.searchByRecipient("+27838884567");

        assertTrue(result.contains("Hello Mike"));
    }

    @Test
    public void testDeleteByHash() {
        MessageManager manager = new MessageManager();

        Message message = new Message(1, "+27838884567", "Hello Mike");
        manager.addSentMessage(message);

        String result = manager.deleteByHash(message.getMessageHash());

        assertEquals("Message successfully deleted.", result);
        assertEquals(0, manager.getTotalSentMessages());
    }
}