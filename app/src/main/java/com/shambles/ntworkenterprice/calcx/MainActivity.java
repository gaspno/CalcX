package com.shambles.ntworkenterprice.calcx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,
                   btnAC,btnDel,btnMinus,btnPlus,btnEquals,btnDivide,btnMult,btnDot;
    private TextView TextViewResult,TextViewHistory;

    private String number=null;
    private double firstNumber,lastNumber=0;

    private String status=null;
    private boolean opertor=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);

        btnAC=findViewById(R.id.btnAC);
        btnDot=findViewById(R.id.btnDot);
        btnDel=findViewById(R.id.btnDel);
        btnEquals=findViewById(R.id.btnEquals);

        btnPlus=findViewById(R.id.btnSum);
        btnMult=findViewById(R.id.btnMult);
        btnDivide=findViewById(R.id.btnDiv);
        btnMinus=findViewById(R.id.btnMin);

        TextViewHistory=findViewById(R.id.textViewHistory);
        TextViewResult=findViewById(R.id.textViewResult);

        btn0.setOnClickListener(view -> numberClick((TextView) view));
        btn1.setOnClickListener(view -> numberClick((TextView) view));
        btn2.setOnClickListener(view -> numberClick((TextView) view));
        btn3.setOnClickListener(view -> numberClick((TextView) view));
        btn4.setOnClickListener(view -> numberClick((TextView) view));
        btn5.setOnClickListener(view -> numberClick((TextView) view));
        btn6.setOnClickListener(view -> numberClick((TextView) view));
        btn7.setOnClickListener(view -> numberClick((TextView) view));
        btn8.setOnClickListener(view -> numberClick((TextView) view));
        btn9.setOnClickListener(view -> numberClick((TextView) view));

      //  btnAC.setOnClickListener(view ->);
     //   btnDel.setOnClickListener(view ->);
        btnPlus.setOnClickListener(view -> {
            if(opertor) {
                if (status == "multiply") {
                    multiply();
                } else if (status == "divide") {
                    divide();
                } else if (status == "substraction") {
                    minus();
                } else {
                    plus();
                }
            }
            status="sum";
            opertor=false;
            number=null;
        });


        btnMinus.setOnClickListener(view ->{
            if(opertor) {
                if (status == "multiply") {
                    multiply();
                } else if (status == "divide") {
                    divide();
                } else if (status == "sum") {
                    plus();
                } else {
                    minus();
                }
            }
            status="substraction";
            opertor=false;
            number=null;
        });

        btnMult.setOnClickListener(view ->{
            if(opertor) {
                if (status == "sum") {
                    plus();
                } else if (status == "divide") {
                    divide();
                } else if (status == "substraction") {
                    minus();
                } else {
                    multiply();
                }
            }
            status="multiply";
            opertor=false;
            number=null;
        });
        btnDivide.setOnClickListener(view ->{
            if(opertor) {
                if (status == "sum") {
                    plus();
                } else if (status == "divide") {
                    divide();
                } else if (status == "substraction") {
                    minus();
                } else {
                   divide();
                }
            }
            status="divide";
            opertor=false;
            number=null;
        });
     //   btnDot.setOnClickListener(view ->);
      //  btnEquals.setOnClickListener(view ->);

    }
    public void numberClick(TextView view){

        if(number==null){

            number=view.getText().toString();
        }
        else{
            number=number+view.getText().toString();
        }
        TextViewResult.setText(number);
        opertor=true;

    }
    public void plus(){
        lastNumber=Double.parseDouble(TextViewResult.getText().toString());
        firstNumber=firstNumber+lastNumber;
        TextViewResult.setText(""+firstNumber);
    }
    public void minus(){
        if(firstNumber==0){
            firstNumber=Double.parseDouble(TextViewResult.getText().toString());
        }
        else {
            lastNumber = Double.parseDouble(TextViewResult.getText().toString());
            firstNumber = firstNumber - lastNumber;

        }
        TextViewResult.setText("" + firstNumber);
    }
    public void multiply(){
        if(firstNumber==0){
            firstNumber=1;
            lastNumber = Double.parseDouble(TextViewResult.getText().toString());
            firstNumber=firstNumber*lastNumber;
        }
        else {
            lastNumber = Double.parseDouble(TextViewResult.getText().toString());
            firstNumber=firstNumber*lastNumber;
        }
        TextViewResult.setText("" + firstNumber);
    }
    public void divide(){
        if(firstNumber==0){

            lastNumber = Double.parseDouble(TextViewResult.getText().toString());
            firstNumber=lastNumber/1;
        }
        else {
            lastNumber = Double.parseDouble(TextViewResult.getText().toString());
            firstNumber=firstNumber/lastNumber;
        }
        TextViewResult.setText("" + firstNumber);
    }
}