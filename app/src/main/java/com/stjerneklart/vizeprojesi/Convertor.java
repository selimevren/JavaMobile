package com.stjerneklart.vizeprojesi;

import androidx.appcompat.app.AppCompatActivity;




import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Convertor extends AppCompatActivity {
    private EditText girilenDeger1,girilenDeger2,girilenDeger3;
    private TextView sonuc1,sonuc2,sonuc3;
    private Spinner spinner1,spinner2;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor);

        girilenDeger1 = findViewById(R.id.textInput1);
        sonuc1 = findViewById(R.id.result1);
        spinner1 = findViewById(R.id.spinner1);

        List<String> kategori = new ArrayList<>();
        kategori.add("Seçim yapınız:");
        kategori.add("binary");
        kategori.add("Octal");
        kategori.add("Hexadecimal");

        ArrayAdapter<String> verilistesi1= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,kategori);
        verilistesi1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(verilistesi1);

        spinner1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedCategory = kategori.get(position);
                String girilenDegerValue1 = girilenDeger1.getText().toString();
                convertAndDisplayResult(girilenDegerValue1,selectedCategory);
            }
        });

        girilenDeger2 = findViewById(R.id.textInput2);
        sonuc2 = findViewById(R.id.result2);
        spinner2 = findViewById(R.id.spinner2);

        List<String> kategori2 = new ArrayList<>();
        kategori.add("Seçim yapınız:");
        kategori.add("Kilo Byte");
        kategori.add("Byte");
        kategori.add("Bit");

        ArrayAdapter<String> verilistesi2= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,kategori2);
        verilistesi1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(verilistesi2);

        spinner2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedCategory2 = kategori.get(position);
                String girilenDegerValue2 = girilenDeger2.getText().toString();
                convertAndDisplayResult2(girilenDegerValue2,selectedCategory2);

            }
        });

        girilenDeger3 = findViewById(R.id.textInput3);
        sonuc3 = findViewById(R.id.result3);
        radioGroup = findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton selectedButton = findViewById(radioGroup);
                String conversionType = selectedButton.getText().toString();

                String girilenDegerValue2 = girilenDeger2.getText().toString();
                convertAndDisplayResult3(girilenDegerValue2, String.valueOf(selectedButton));
            }

            private RadioButton findViewById(RadioGroup radioGroup) {
                return null;
            }
        });
    }
    private void convertAndDisplayResult (String girilenDegerValue1, String selectedCategory){
        if (girilenDegerValue1.isEmpty()){
            Toast.makeText(getApplicationContext(),"Bir sayı giriniz:", Toast.LENGTH_SHORT);
            return;
        }
        try {
            int decimalNumber = Integer.parseInt(girilenDegerValue1);
            String result1 ="";
            switch (selectedCategory){
                case "Binary":
                    result1 = Integer.toBinaryString(decimalNumber);
                    break;
                case "Octal":
                    result1 = Integer.toOctalString(decimalNumber);
                    break;
                case "Hexadecimal":
                    result1 = Integer.toHexString(decimalNumber);
                    break;
            }
            sonuc1.setText(result1);
        }catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Geçerli bir sayı girin:",Toast.LENGTH_SHORT).show();
        }
    }
    private void convertAndDisplayResult2 (String girilenDegerValue2, String selectedCategory2){
        if (girilenDegerValue2.isEmpty()){
            Toast.makeText(getApplicationContext(),"Bir sayı giriniz:", Toast.LENGTH_SHORT);
            return;
        }
        try {
            int decimalNumber2 = Integer.parseInt(girilenDegerValue2);
            String result2 ="";
            switch (selectedCategory2){
                case "KiloByte":
                    double kilobyte = decimalNumber2*1000;
                    result2 = String.valueOf(kilobyte);
                    break;

                case "Byte":
                    double byteValue= decimalNumber2*1024*1024;
                    result2 = String.valueOf(byteValue);
                    break;

                case "Bit":
                    double bitValue = decimalNumber2*1024;
                    result2 = String.valueOf(bitValue);
                    break;
            }
            sonuc1.setText(result2);
        }catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Geçerli bir sayı girin:",Toast.LENGTH_SHORT).show();
        }
    }
    private void convertAndDisplayResult3 (String girilenDegerValue3, String conversionType){

        if (girilenDegerValue3.isEmpty()){
            Toast.makeText(getApplicationContext(),"Lütfen bir sıcaklık değeri girin:",Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            double girilenDeger3 = Double.parseDouble(girilenDegerValue3);
            String result3="";
            if (conversionType.equals("Celcius to Fahrenayt")){

                double fahrenayt = (girilenDeger3*9/5)*32;
                result3 = String.valueOf(fahrenayt);
            } else if (conversionType.equals("Celcius to Kelvin")) {
                double kelvin = (girilenDeger3*273.15);
                result3= String.valueOf(kelvin);
            }
            sonuc3.setText(result3);
        }catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Lütfen geçerli bir değer girin:",Toast.LENGTH_SHORT).show();
        }
    }
}