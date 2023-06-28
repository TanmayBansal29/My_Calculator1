package com.example.my_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private String currentSymbol;
    private double firstValue = Double.NaN;
    private double secondValue;
    private TextView inputDisplay, outputDisplay;
    private DecimalFormat decimalFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        decimalFormat = new DecimalFormat("#.##########");
        inputDisplay = findViewById(R.id.inputText);
        outputDisplay = findViewById(R.id.OutputText);
        Button button00 = (Button) findViewById(R.id.bu00);
        Button button0 = (Button) findViewById(R.id.bu0);
        Button button1 = (Button) findViewById(R.id.bu1);
        Button button2 = (Button) findViewById(R.id.bu2);
        Button button3 = (Button) findViewById(R.id.bu3);
        Button button4 = (Button) findViewById(R.id.bu4);
        Button button5 = (Button) findViewById(R.id.bu5);
        Button button6 = (Button) findViewById(R.id.bu6);
        Button button7 = (Button) findViewById(R.id.bu7);
        Button button8 = (Button) findViewById(R.id.bu8);
        Button button9 = (Button) findViewById(R.id.bu9);
        Button buttonAdd = (Button) findViewById(R.id.buAdd);
        Button buttonSub = (Button) findViewById(R.id.buSub);
        Button buttonDivide = (Button) findViewById(R.id.buDiv);
        Button buttonDot = (Button) findViewById(R.id.buDot);
        Button buttonMultiply = (Button) findViewById(R.id.buMul);
        Button buttonClear = (Button) findViewById(R.id.buAC);
//        buttonOFF = findViewById(R.id.bu);
        Button buttonEqual = (Button) findViewById(R.id.buEqual);
        Button buttonPercent = (Button) findViewById(R.id.buPer);

        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "00");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "9");
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + ".");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = "ADDITION";
                outputDisplay.setText(firstValue + "+");
                inputDisplay.setText(null);
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = "SUBTRACTION";
                outputDisplay.setText(firstValue+ "-");
                inputDisplay.setText(null);
            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = "MULTIPLICATION";
                outputDisplay.setText(firstValue + "x");
                inputDisplay.setText(null);
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = "DIVISION";
                outputDisplay.setText(firstValue + "/");
                inputDisplay.setText(null);
            }
        });
        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = "PERCENT";
                outputDisplay.setText(firstValue + "%");
                inputDisplay.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                outputDisplay.setText(decimalFormat.format(firstValue));
                firstValue = Double.NaN;
                currentSymbol = String.valueOf('0');
            }
        });
    }
    private void allCalculations(){
        if (!Double.isNaN(firstValue)) {
            secondValue = Double.parseDouble(inputDisplay.getText().toString());
            inputDisplay.setText("");
            if (currentSymbol == "ADDITION")
                firstValue = this.firstValue + secondValue;
            else if (currentSymbol == "SUBTRACTION")
                firstValue = this.firstValue - secondValue;
            else if (currentSymbol == "MULTIPLICATION")
                firstValue = this.firstValue * secondValue;
            else if (currentSymbol == "DIVISION")
                firstValue = this.firstValue / secondValue;
            else if (currentSymbol == "PERCENT")
                firstValue = this.firstValue % secondValue;
        } else {
            try {
                firstValue = Double.parseDouble(inputDisplay.getText().toString());
            } catch (Exception e) {
            }
        }
    }
}