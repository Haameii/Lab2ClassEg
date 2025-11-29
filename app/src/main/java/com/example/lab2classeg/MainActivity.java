package com.example.lab2classeg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    Button btnPressMe;
    TextView textViewStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Xử lý insets (bo góc, status bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Tìm các view trong layout
        edtName = findViewById(R.id.edtName);
        btnPressMe = findViewById(R.id.btnPressMe);

        // Gắn sự kiện click
        btnPressMe.setOnClickListener(v -> {
            String name = edtName.getText().toString();
            Intent intent = new Intent(MainActivity.this, NameDisplayActivity.class);
            intent.putExtra("NAME", name);
            startActivity(intent);
        });
    }
}
