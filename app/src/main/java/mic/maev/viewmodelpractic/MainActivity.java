package mic.maev.viewmodelpractic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private ImageView img;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        img = findViewById(R.id.img);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Override
    protected void onStart() {
        super.onStart();

        viewModel.startTimer().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        viewModel.link.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String link) {
                Picasso.get().load(link).into(img);
            }
        });
    }
}