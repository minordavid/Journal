package vesseur.david.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {
    int mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }
    public void addEntry (View view){
        EditText title = findViewById(R.id.editTitle);
        EditText description = findViewById(R.id.editEntry);

        JournalEntry entry = new JournalEntry( title.getText().toString(), description.getText().toString(), mood);
        EntryDatabase database = EntryDatabase.getInstance(this);
        database.insert(entry);

        Intent intent = new Intent(InputActivity.this, MainActivity.class);
        startActivity(intent);

    }
}
