package Part2_2_1;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class BaseMessage {
    protected LocalDateTime date;
    protected String author;

    public BaseMessage(LocalDateTime date, String author) {
        this.date = date;
        this.author = author;
    }

    public abstract String output();
}

class TextMessage extends BaseMessage {
    protected String text;

    public TextMessage(LocalDateTime date, String author, String text) {
        super(date, author);
        this.text = text;
    }

    public String output() {
        return "[" + date + "] " + author + ": " + text;
    }
}

class ImageMessage extends TextMessage {
    protected String imageUrl;

    public ImageMessage(LocalDateTime date, String author, String text, String imageUrl) {
        super(date, author, text);
        this.imageUrl = imageUrl;
    }

    public String output() {
        return "[" + date + "] " + author + " sent an image: " + imageUrl;
    }
}

class VoiceMessage extends BaseMessage {
    protected int lengthInSeconds;

    public VoiceMessage(LocalDateTime date, String author, int lengthInSeconds) {
        super(date, author);
        this.lengthInSeconds = lengthInSeconds;
    }

    public String output() {
        return "[" + date + "] " + author + " sent a voice message (" + lengthInSeconds + " seconds)";
    }
}

class FileMessage extends TextMessage {
    protected String fileUrl;

    public FileMessage(LocalDateTime date, String author, String text, String fileUrl) {
        super(date, author, text);
        this.fileUrl = fileUrl;
    }

    public String output() {
        return "[" + date + "] " + author + " sent a file: " + fileUrl;
    }
}

class LocationMessage extends BaseMessage {
    protected double latitude;
    protected double longitude;

    public LocationMessage(LocalDateTime date, String author, double latitude, double longitude) {
        super(date, author);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String output() {
        return "[" + date + "] " + author + " sent a location: " + latitude + ", " + longitude;
    }
}

class MessageLibrary {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        TextMessage textMessage = new TextMessage(now, "Unknown", "Your account has been hacked. To fix this, sent 500$ on this card: NNNN NNNN NNNN NNNN");
        ImageMessage imageMessage = new ImageMessage(now, "Jane", "Here's what Kim hid in his safe for 10 years:", "https://mir-s3-cdn-cf.behance.net/project_modules/fs/a9448858711737.5a061fb97a538.png");
        VoiceMessage voiceMessage = new VoiceMessage(now, "Bob", 30);
        FileMessage fileMessage = new FileMessage(now, "Alice", "Here's the report for the meeting", "https://example.com/report.pdf");
        LocationMessage locationMessage = new LocationMessage(now, "Sam", 37.7749, -122.4194);

        System.out.println(textMessage.output());
        System.out.println(imageMessage.output());
        System.out.println(voiceMessage.output());
        System.out.println(fileMessage.output());
        System.out.println(locationMessage.output());

        }
    }

class Chat {
    private String chatName;
    private ArrayList<User> users;
    private ArrayList<BaseMessage> messages;

    public Chat(String chatName) {
        this.chatName = chatName;
        this.users = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addMessage(BaseMessage message) {
        messages.add(message);
    }

    public ArrayList<FileMessage> getAllFileMessages() {
        ArrayList<FileMessage> fileMessages = new ArrayList<>();
        for (BaseMessage message : messages) {
            if (message instanceof FileMessage) {
                fileMessages.add((FileMessage) message);
            }
        }
        return fileMessages;
    }

    public ArrayList<ImageMessage> getAllImageMessages() {
        ArrayList<ImageMessage> imageMessages = new ArrayList<>();
        for (BaseMessage message : messages) {
            if (message instanceof ImageMessage) {
                imageMessages.add((ImageMessage) message);
            }
        }
        return imageMessages;
    }

    public String output() {
        StringBuilder output = new StringBuilder();
        output.append("Chat Name: ").append(chatName).append("\n");
        output.append("Users: ").append("\n");
        for (User user : users) {
            output.append(user.output()).append("\n");
        }
        output.append("Messages: ").append("\n");
        for (BaseMessage message : messages) {
            output.append(message.output()).append("\n");
        }
        return output.toString();
    }
}

class User {
    private String nickname;
    private String phoneNumber;
    private String title;

    public User(String nickname, String phoneNumber, String title) {
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.title = title;
    }

    public String getNickname() {
        return nickname;
    }

    public String output() {
        return "Nickname: " + nickname + ", Phone Number: " + phoneNumber + ", Title: " + title;
    }
    public static void main(String[] args) {
        // Create two users
        User user1 = new User("John", "123-456-7890", "Admin");
        User user2 = new User("Sarah", "987-654-3210", "Member");

        // Create a chat and add the users to it
        Chat chat = new Chat("Group Chat");
        chat.addUser(user1);
        chat.addUser(user2);

        // Create some messages and add them to the chat
        TextMessage textMessage = new TextMessage(LocalDateTime.now(), "Anthony", "Hello there!");
        ImageMessage imageMessage = new ImageMessage(LocalDateTime.now(), "Maryna", "Check this out!", "https://mir-s3-cdn-cf.behance.net/project_modules/fs/a9448858711737.5a061fb97a538.png");
        FileMessage fileMessage = new FileMessage(LocalDateTime.now(), "Boss", "Here's the report.","https://mir-s3-cdn-cf.behance.net/project_modules/fs/a9448858711737.5a061fb97a538.png");
        chat.addMessage(textMessage);
        chat.addMessage(imageMessage);
        chat.addMessage(fileMessage);

        // Output all messages in the chat
        System.out.println(chat.output());

        // Output all file messages in the chat
        ArrayList<FileMessage> fileMessages = chat.getAllFileMessages();
        System.out.println("File Messages:");
        for (FileMessage message : fileMessages) {
            System.out.println(message.output());
        }
    }

}

