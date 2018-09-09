package gridentertainment.net.showjoke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class JokeActivity extends AppCompatActivity {

    public static final String JK = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView jkTv = findViewById(R.id.textViewjk);
        jkTv.setText(getIntent().getStringExtra(JK));
    }
}
