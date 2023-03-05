package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputValue;
    private Spinner fromUnit;
    private Spinner toUnit;
    private TextView outputValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.input_value);
        fromUnit = findViewById(R.id.from_unit);
        toUnit = findViewById(R.id.to_unit);
        Button convertButton = findViewById(R.id.convert_button);
        outputValue = findViewById(R.id.output_value);

        convertButton.setOnClickListener(v -> convert());
    }

    @SuppressLint("DefaultLocale")
    private void convert() {
        String input = inputValue.getText().toString();
        double value = Double.parseDouble(input);

        String from = fromUnit.getSelectedItem().toString();
        String to = toUnit.getSelectedItem().toString();

        double result = 0;


        if (from.equals("Meters") && to.equals("Feet")) {
            result = value * 3.28084;
        } else if (from.equals("Feet") && to.equals("Meters")) {
            result = value / 3.28084;
        } else if (from.equals("Inches") && to.equals("Centimeters")) {
            result = value * 2.54;
        } else if (from.equals("Centimeters") && to.equals("Inches")) {
            result = value / 2.54;
        } else if (from.equals("Miles") && to.equals("Kilometers")) {
            result = value * 1.60934;
        } else if (from.equals("Kilometers") && to.equals("Miles")) {
            result = value / 1.60934;
        } else if (from.equals("Millimeters") && to.equals("Inches")) {
            result = value / 25.4;
        } else if (from.equals("Inches") && to.equals("Millimeters")) {
            result = value * 25.4;
        } else if (from.equals("Yards") && to.equals("Meters")) {
            result = value / 1.09361;
        } else if (from.equals("Meters") && to.equals("Yards")) {
            result = value * 1.09361;
        }

        outputValue.setText(String.format("%.2f",result));
    }
}
