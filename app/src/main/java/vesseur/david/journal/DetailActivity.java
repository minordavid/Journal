package vesseur.david.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int mood = (int) intent.getSerializableExtra("mood");
        String title = (String) intent.getSerializableExtra("title");
        String content = (String) intent.getSerializableExtra("content");
        String time = (String) intent.getSerializableExtra("timestamp");
        TextView contentView = findViewById(R.id.Entry);
        TextView titleView = findViewById(R.id.title);
        TextView timeView = findViewById(R.id.timeView);

        titleView.setText(title);
        contentView.setText(content);
        timeView.setText(time);
    }
}
