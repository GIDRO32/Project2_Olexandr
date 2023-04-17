package Part2_2;

import java.time.LocalDateTime;

abstract class BaseMessage {
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

class ContactMessage extends BaseMessage {
    protected String contactName;
    protected String phoneNumber;

    public ContactMessage(LocalDateTime date, String author, String contactName, String phoneNumber) {
        super(date, author);
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public String output() {
        return "[" + date + "] " + author + " sent a contact: " + contactName + " (" + phoneNumber + ")";
    }
}

class MessageLibrary {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        TextMessage textMessage = new TextMessage(now, "John", "Hey, how are you?");
        ImageMessage imageMessage = new ImageMessage(now, "Jane", "Check out this cute puppy!", "https://example.com/puppy.jpg");
        VoiceMessage voiceMessage = new VoiceMessage(now, "Bob", 30);
        FileMessage fileMessage = new FileMessage(now, "Alice", "Here's the report for the meeting", "https://example.com/report.pdf");
        LocationMessage locationMessage = new LocationMessage(now, "Sam", 37.7749, -122.4194);
        ContactMessage contactMessage = new ContactMessage(now, "Kim", "David Smith", "555-1234");

        System.out.println(textMessage.output());
        System.out.println(imageMessage.output());
        System.out.println(voiceMessage.output());
        System.out.println(fileMessage.output());
        System.out.println(locationMessage.output());
    }
}
