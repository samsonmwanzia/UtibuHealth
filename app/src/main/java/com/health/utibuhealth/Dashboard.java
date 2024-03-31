package com.health.utibuhealth;

import android.os.Bundle;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        Button openFormButton = findViewById(R.id.button_send);
        openFormButton.setOnClickListener(v -> openOrderFormDialog());

    }

    private void openOrderFormDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_order_form);
        dialog.setTitle("Order Form");

        final EditText quantityEditText = dialog.findViewById(R.id.quantity);
        Button submitButton = dialog.findViewById(R.id.submitButton);

        submitButton.setOnClickListener(v -> {
            // Retrieve entered quantity
            String quantity = quantityEditText.getText().toString();

            Toast.makeText(Dashboard.this, "Quantity: " + quantity, Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        // Show the dialog
        dialog.show();
    }
}