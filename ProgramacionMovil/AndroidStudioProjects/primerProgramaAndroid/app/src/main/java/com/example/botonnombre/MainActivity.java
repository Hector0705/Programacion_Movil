package com.example.botonnombre;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    LinearLayout layout;
    Button btnSaludar;
    TextView txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(40, 40, 40, 40);

        btnSaludar = new Button(this);
        btnSaludar.setText("Saludo");

        txtNombre = new TextView(this);
        txtNombre.setTextSize(24);
        txtNombre.setGravity(Gravity.CENTER);
        txtNombre.setPadding(0, 30, 0, 0);

        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNombre.setText("Hector Rogelio Gonzalez Amezquita");
            }
        });

        layout.addView(btnSaludar);
        layout.addView(txtNombre);
        setContentView(layout);
    }
}