package sg.edu.np.mad.madpractical3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.app.AlertDialog;
import android.widget.ImageView;
import android.content.Intent;
import java.util.Random;


public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get a reference to the ImageView
        ImageView imageView = findViewById(R.id.imageView4);

        // Set an OnClickListener for the ImageView
        imageView.setOnClickListener(v -> {
            // Create and show an AlertDialog
            AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
            builder.setTitle("Profile");
            builder.setMessage("MADness");
            builder.setPositiveButton("View", (dialog, which) -> {
                // Generate a random integer
                Random random = new Random();
                int randomNumber = random.nextInt(100); // Generate a random number between 0 and 99

                // Launch MainActivity and pass the random integer as an extra
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                intent.putExtra("randomNumber", randomNumber);
                startActivity(intent);
            });
            builder.setNegativeButton("Close", (dialog, which) -> {
                // Handle the "Close" button click
                dialog.dismiss();
            });
            builder.show();
        });
    }
}