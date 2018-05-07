package vesseur.david.journal;

import java.io.Serializable;

/**
 * Created by Gebruiker on 2-5-2018.
 */

public class JournalEntry implements Serializable {
    private String title, content, timestamp;
    private int id, mood;

    public JournalEntry(String title, String content, int mood) {
        this.title = title;
        this.content = content;
        this.mood = mood;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getMood() {
        return mood;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
