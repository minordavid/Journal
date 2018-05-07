package vesseur.david.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EntryDatabase db;
    EntryAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = EntryDatabase.getInstance(getApplicationContext());
        adapter = new EntryAdapter(this, db.selectAll());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        listView.setOnItemClickListener(new ListItemClickListener());
        listView.setOnItemLongClickListener(new LongListItemClickListener());






    }
    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Cursor cursorToJournal = (Cursor) adapterView.getItemAtPosition(i);
            int mood = cursorToJournal.getInt(cursorToJournal.getColumnIndex("mood"));
            String title = cursorToJournal.getString(cursorToJournal.getColumnIndex("title"));
            String content = cursorToJournal.getString(cursorToJournal.getColumnIndex("content"));
            String timestamp = cursorToJournal.getString(cursorToJournal.getColumnIndex("timestamp"));

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("mood", mood);
            intent.putExtra("title", title);
            intent.putExtra("content", content);
            intent.putExtra("timestamp", timestamp);
            startActivity(intent);

        }
    }

    private class LongListItemClickListener implements AdapterView.OnItemLongClickListener {

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            Cursor cursorToJournal = (Cursor) adapterView.getItemAtPosition(i);
            long _id = cursorToJournal.getInt(cursorToJournal.getColumnIndex("_id"));
            db.deleteEntry(_id);
            updateData();
            return true;

        }
    }
    private void updateData(){
        Cursor newCursor =  db.selectAll();
        adapter.swapCursor(newCursor);
    }

    public void actionButton(View view){
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume(){
        super.onResume();
        updateData();
    }


}
