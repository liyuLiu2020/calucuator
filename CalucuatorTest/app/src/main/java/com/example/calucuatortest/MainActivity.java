package com.example.calucuatortest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextView tv;
    private ArrayList<String> nList;
    private ArrayList<String> pList;
    private String last;
    private String symbol;
    private double Result;
    private double pResult;
    private Boolean isdiv = true;
    private Boolean isEnd = false;
    private Boolean isFrist =true;
    private Boolean isChange = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Monitor();
        number_List();
    }

    @Override
    public void onClick(View view)
    {
        String number = tv.getText().toString();

        switch (view.getId()) {
            case R.id.btn_zero:
                if (!number.equals("0") && isEnd == false) {
                    tv.append("0");
                } else {
                    tv.setText("0");
                    isEnd = false;
                }
                break;

            case R.id.btn_one:
                if (!number.equals("0") && isEnd == false) {
                    tv.append("1");
                }
                else {
                    tv.setText("1");
                    isEnd = false;
                }
                break;

            case R.id.btn_two:
                if (!number.equals("0") && isEnd == false) {
                    tv.append("2");
                }
                else {
                    tv.setText("2");
                    isEnd = false;
                }
                break;

            case R.id.btn_three:
                if (!number.equals("0") && isEnd == false) {
                    tv.append("3");
                }
                else {
                    tv.setText("3");
                    isEnd = false;
                }
                break;

            case R.id.btn_four:
                if (!number.equals("0") && isEnd == false) {
                    tv.append("4");
                }
                else {
                    tv.setText("4");
                    isEnd = false;
                }
                break;

            case R.id.btn_five:
                if (!number.equals("0") && isEnd == false) {
                    tv.append("5");
                } else {
                    tv.setText("5");
                    isEnd = false;
                }
                break;
            case R.id.btn_six:
                if (!number.equals("0") && isEnd == false) {
                    tv.append("6");
                } else {
                    tv.setText("6");
                    isEnd = false;
                }
                break;
            case R.id.btn_seven:
                if (!number.equals("0") && isEnd == false) {
                    tv.append("7");
                } else {
                    tv.setText("7");
                    isEnd = false;
                }
                break;
            case R.id.btn_eight:
                if (!number.equals("0") && isEnd == false) {
                    tv.append("8");
                } else {
                    tv.setText("8");
                    isEnd = false;
                }
                break;
            case R.id.btn_nine:
                if (!number.equals("0") && isEnd == false) {
                    tv.append("9");
                } else {
                    tv.setText("9");
                    isEnd = false;
                }
                break;
            case R.id.btn_plus:
                if(isFrist == true) {
                    nList.add(number);
                    nList.add("+");
                    this.calculate();
                    tv.setText("0");
                    isFrist = false;
                }
                symbol = "+";
                judge_Symbol();
                if(isChange == true) {
                nList.add("+");
                tv.setText("0");
                isChange = false;
                }
                break;

            case R.id.btn_minus:
                if(isFrist == true) {
                    nList.add(number);
                    nList.add("-");
                    this.calculate();
                    tv.setText("0");
                    isFrist = false;
                }
                symbol = "-";
                judge_Symbol();
                if(isChange == true) {
                    nList.add("-");
                    tv.setText("0");
                    isChange = false;
                }
                break;

            case R.id.btn_mulitply:
                if(isFrist == true) {
                    nList.add(number);
                    nList.add("*");
                    this.calculate();
                    tv.setText("0");
                    isFrist = false;
                }
                symbol ="*";
                judge_Symbol();
                if(isChange == true) {
                    nList.add("*");
                    tv.setText("0");
                    isChange = false;
                }
                break;

            case R.id.btn_divide:
                if(isFrist == true) {
                    nList.add(number);
                    nList.add("/");
                    this.calculate();
                    tv.setText("0");
                    isFrist = false;
                }
                symbol = "/";
                judge_Symbol();
                if(isChange == true) {
                    nList.add("/");
                    tv.setText("0");
                    isChange = false;
                }
                break;

            case R.id.btn_point:
                if (!number.contains("."))
                {
                    tv.append(".");
                }
                break;
            case R.id.btn_equal:
                nList.add(number);
                this.calculate();
                if(isdiv==false)
                {
                    tv.setText("ERROR！");
                    isdiv = true;
                }
                else
                {
                    change_Number();
                    tv.setText(String.valueOf(last));
                    isEnd=true;
                }
                nList.clear();
                break;

            case R.id.btn_plus_minus:
                if (!number.contains("-"))
                {
                    tv.setText("-"+number);
                }
                else
                {
                    number.replace("-","");
                    tv.setText(number);
                }
                break;
            case R.id.btn_percentage:
                this.per_List();
                tv.setText(String.valueOf(pResult));
                break;

            case R.id.btn_clear:
                tv.setText("0");
                Result = 0;
                nList.clear();
                isFrist = true;
                isChange =false;
                isEnd = false;
                break;
        }
    }

    private void calculate()
    {
        double number1 = Double.parseDouble(nList.get(0));

        if (nList.size() == 3)
        {
            double number2 = Double.parseDouble(nList.get(2));

            switch (nList.get(1))
            {
                case "+":
                    Result = number1 + number2;
                    break;
                case "-":
                    Result = number1 - number2;
                    break;
                case "*":
                    Result = number1 * number2;
                    break;
                case "/":
                    if (number2 == 0)
                    {
                        isdiv= false;
                        break;
                    }
                    else
                    {
                        Result = number1 / number2;
                    }
                    break;
            }
            nList.clear();
            nList.add(String.valueOf(Result));
        }
        else
        {
            Result = number1;
        }
    }

    private void change_Number ()
    {
        last =String.valueOf(Result);
        if(last.endsWith(".0"))
        {
            last = last.substring(0,last.length()-2);
        }
    }

    private void number_List()
    {
        nList = new ArrayList<>();
    }

    private void per_List()
    {
        double pNumber ;
        pList = new ArrayList<>();

        String percent = tv.getText().toString();
        pList.add(percent);
        pResult = Double.parseDouble(pList.get(0))*0.01;
    }

    private void judge_Symbol()
    {
        String lastItem = nList.get(nList.size() - 1);
        switch (symbol)
        {
            case "+":
                if(lastItem !="+"){
                    nList.remove( nList.size()-1);
                    isChange = true;
                }
                break;
            case "-":if(lastItem !="-") {
                nList.remove(nList.size() - 1);
                isChange = true;
                }
                break;
            case "*":
                if(lastItem !="*"){
                    nList.remove( nList.size()-1);
                    isChange = true;
                }
                break;
            case "/":
                if(lastItem !="/"){
                    nList.remove( nList.size()-1);
                    isChange = true;
                }
                break;
        }
    }

    private void Monitor()
    {
        tv = (TextView) findViewById(R.id.text_result);
        findViewById(R.id.btn_zero).setOnClickListener(this);
        findViewById(R.id.btn_one).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_three).setOnClickListener(this);
        findViewById(R.id.btn_four).setOnClickListener(this);
        findViewById(R.id.btn_five).setOnClickListener(this);
        findViewById(R.id.btn_six).setOnClickListener(this);
        findViewById(R.id.btn_seven).setOnClickListener(this);
        findViewById(R.id.btn_eight).setOnClickListener(this);
        findViewById(R.id.btn_nine).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_mulitply).setOnClickListener(this);
        findViewById(R.id.btn_divide).setOnClickListener(this);
        findViewById(R.id.btn_point).setOnClickListener(this);
        findViewById(R.id.btn_equal).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        findViewById(R.id.btn_plus_minus).setOnClickListener(this);
        findViewById(R.id.btn_percentage).setOnClickListener(this);
    }
}