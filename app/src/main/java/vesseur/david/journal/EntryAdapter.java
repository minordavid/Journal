package vesseur.david.journal;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

/**
 * Created by Gebruiker on 4-5-2018.
 */

public class EntryAdapter extends ResourceCursorAdapter {
    public EntryAdapter(Context context, Cursor cursor) {
        super(context, R.layout.entry_row, cursor);
    }

    public void bindView(View view, Context context, Cursor cursor) {

        int mood = cursor.getInt(cursor.getColumnIndex("mood"));
        String content = cursor.getString(cursor.getColumnIndex("content"));
        String title = cursor.getString(cursor.getColumnIndex("title"));
        String time = cursor.getString(cursor.getColumnIndex("timestamp"));
        TextView contentView = view.findViewById(R.id.Entry);
        TextView titleView = view.findViewById(R.id.title);
        TextView timeView = view.findViewById(R.id.timeView);
//        ImageView moodView = (ImageView) view.findViewById(R.id.mood);

        // set content to view
        contentView.setText(content);
        titleView.setText(title);
        timeView.setText(time);
    }
}
