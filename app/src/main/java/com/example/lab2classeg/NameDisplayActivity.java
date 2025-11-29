package com.example.lab2classeg;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NameDisplayActivity extends AppCompatActivity {
    TextView txtNameDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_name_display);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            txtNameDisplay = findViewById(R.id.txtNameDisplay);

            // Nhận dữ liệu từ Intent
            String name = getIntent().getStringExtra("NAME");

            // Hiển thị tên ra màn hình
            txtNameDisplay.setText("Hello, " + name + "!");
            return insets;
        });
    }
}