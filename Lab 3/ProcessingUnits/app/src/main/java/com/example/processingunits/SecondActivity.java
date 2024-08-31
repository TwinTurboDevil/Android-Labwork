package com.example.processingunits;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Retrieve the passed ArrayList
        ArrayList<String> ComponentList = getIntent().getStringArrayListExtra("ComponentList");

        // Format the components into a string
        StringBuilder unitFormatted = new StringBuilder();
        for (String component : ComponentList) {
            unitFormatted.append(component).append('\n');
        }

        // Display the components in the TextView
        TextView ComponentTextView = findViewById(R.id.ComponentTextView);
        ComponentTextView.setText(unitFormatted.toString());
    }
}