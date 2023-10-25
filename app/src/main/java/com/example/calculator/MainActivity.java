package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2, edtNum3;
    TextView tvOperator;
    RadioGroup rGroup;
    RadioButton rAdd, rSub, rMul, rDiv;
    Button btnCal;
    String num1, num2;
    float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("계산기");

        edtNum1 = (EditText) findViewById(R.id.edtNum1);
        edtNum2 = (EditText) findViewById(R.id.edtNum2);
        edtNum3 = (EditText) findViewById(R.id.edtNum3);

        tvOperator = (TextView) findViewById(R.id.tvOperator);

        rGroup = (RadioGroup) findViewById(R.id.rGroup);
        rAdd = (RadioButton) findViewById(R.id.rAdd);
        rSub = (RadioButton) findViewById(R.id.rSub);
        rMul = (RadioButton) findViewById(R.id.rMul);
        rDiv = (RadioButton) findViewById(R.id.rDiv);

        btnCal = (Button) findViewById(R.id.btnCal);

        rAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOperator.setText("+");
            }
        });
        rSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOperator.setText("-");
            }
        });
        rMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOperator.setText("*");
            }
        });
        rDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOperator.setText("/");
            }
        });


        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edtNum1.getText().toString();
                num2 = edtNum2.getText().toString();

                if(num1.trim().equals("") | num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                } else if(tvOperator.getText().toString().equals("op")) {
                    Toast.makeText(getApplicationContext(), "연산자를 선택하세요", Toast.LENGTH_SHORT).show();
                } else {
                    switch (tvOperator.getText().toString()) {
                        case "+":
                            result = Float.parseFloat(num1) + Float.parseFloat(num2);
                            break;
                        case "-":
                            result = Float.parseFloat(num1) - Float.parseFloat(num2);
                            break;
                        case "*":
                            result = Float.parseFloat(num1) * Float.parseFloat(num2);
                            break;
                        case "/":
                            if(Float.parseFloat(num2) == 0) {
                                Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                                edtNum2.setText("");
                                break;
                            } else {
                                result = Float.parseFloat(num1) / Float.parseFloat(num2);
                                break;
                            }
                    }
                    edtNum3.setText(String.valueOf(result));
                }
            }
        });
    }
}