package com.example.romannumeralconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Convert Number To Roman Numerals
        Button RomanConvertBtn = (Button)findViewById(R.id.RomanConvertBtn);
        RomanConvertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText RomanToNumberInputText = (EditText) findViewById(R.id.RomanToNumberInputText);
                TextView RomanToNumConvertResult = findViewById(R.id.RomanToNumConvertResult);


                int num = Integer.parseInt(RomanToNumberInputText.getText().toString());

                String RomanResult = "";

                while(num > 0){

                    if(num >= 1000){
                        RomanResult += "M";
                        num -= 1000;
;                   }
                    else if(num >= 900){
                        RomanResult += "CM";
                        num -= 900;
                    }
                    else if(num >= 500){
                        RomanResult += "D";
                        num -= 500;
                    }
                    else if(num >= 400){
                        RomanResult += "CD";
                        num -= 400;
                    }
                    else if(num >= 100){
                        RomanResult += "C";
                        num -= 100;
                    }
                    else if(num >= 90){
                        RomanResult += "XC";
                        num -= 90;
                    }
                    else if(num >= 50){
                        RomanResult += "L";
                        num -= 50;
                    }
                    else if(num >= 40){
                        RomanResult += "XL";
                        num -= 40;
                    }
                    else if(num >= 10){
                        RomanResult += "X";
                        num -= 10;
                    }
                    else if(num >= 9){
                        RomanResult += "IX";
                        num -= 9;
                    }
                    else if(num >= 5){
                        RomanResult += "V";
                        num -= 5;
                    }
                    else if(num >= 4){
                        RomanResult += "IV";
                        num -= 4;
                    }
                    else if(num >= 1){
                        RomanResult += "I";
                        num -= 1;
                    }
                }

                RomanToNumConvertResult.setText(RomanResult);
            }
        });

        //Convert Roman Numerals to Number
        Button NumToRomBtn = (Button)findViewById(R.id.NumToRomBtn);
        NumToRomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText NumberToRomanInputText = (EditText)findViewById(R.id.NumberToRomanInputText);
                TextView NumberConvertResult = (TextView)findViewById(R.id.NumberConvertResult);

                int numResult = 0;

                String input = NumberToRomanInputText.getText().toString();


                for(int i = 0; i < input.length(); i++){
                    //get value of current index
                    int current = charVal(input.charAt(i));

                    //checks if there is a next character in string
                    if((i + 1) < input.length()){


                        // Get value of next char in string
                        int next = charVal(input.charAt(i + 1));

                        // Comparing both values
                        if (current >= next)
                        {

                            // Value of current symbol is greater
                            // or equal to the next symbol
                            numResult += current;
                        }
                        else if(next > current)
                        {
                            numResult += next - current;
                            i++;
                        }
                    }
                    else {
                        numResult += current;
                    }

                }



                NumberConvertResult.setText(numResult + "");
            }
        });


    }

    /**
     * intakes a char Value and returns the Roman Numeral
     * @param r
     * @return
     */
    public int charVal(char r){
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }
}
