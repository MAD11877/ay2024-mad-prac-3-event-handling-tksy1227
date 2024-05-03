package sg.edu.np.mad.madpractical3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import java.util.Random;
import android.view.View;
import android.os.Bundle;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Get the TextView for displaying the name and random number and description
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);

        int randomNumber = 000000;
// Get the user's name and generate a random 6-digit number
        Intent intent = getIntent();
        if (intent != null) {
            // Generate a random 6-digit number
            int min = 100000; // Minimum value (inclusive)
            int max = 999999; // Maximum value (inclusive)
            Random random = new Random();
            randomNumber = random.nextInt(max - min + 1) + min;
        }

        // Create a new User object with the name and random number
        User user = new User("MAD " + randomNumber, "MAD Developer", 1, false);

        // Set the TextViews with the User's name, description, and random number
        tvName.setText(user.name);
        tvDescription.setText(user.description);

        // Get the Button from the layout (you can remove this part if it's not needed)
        Button btnFollow = findViewById(R.id.btnFollow);

        // Find the Message button
        Button btnMessage = findViewById(R.id.btnMessage);

        // Set the initial text for the follow button based on the followed status
        btnFollow.setText(user.followed ? "Unfollow" : "Follow");

        // Set a click listener for the button to toggle the followed status and update the button text
        btnFollow.setOnClickListener(v -> {
            user.followed = !user.followed;
            btnFollow.setText(user.followed ? "Unfollow" : "Follow");

            // Show a Toast message indicating whether the user followed or unfollowed (you can remove this part if it's not needed)
            String toastMessage = user.followed ? "Followed" : "Unfollowed";
            Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
        });

        // Set an OnClickListener for the Message button
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(intent);
            }
        });

    }
}
