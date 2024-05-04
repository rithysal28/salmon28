package com.example.tempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restoreState(savedInstanceState);
        Button convertButton = (Button)findViewById(R.id.ConvertButton);
        convertButton.setOnClickListener(convertBtnListener);
    }
    private View.OnClickListener convertBtnListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            convertButtonClicked();
        }
    };
    private void convertButtonClicked(){
        EditText inputTempText = (EditText) findViewById(R.id.inputTempEditText);
        TextView convertedText = (TextView) findViewById(R.id.convertedTempTextView);
        String frStr = convertToFh(inputTempText.getText().toString());
        convertedText.setText(frStr + "F");
    };
    private String convertToFh(String pCelcius){
        try{
            double c = Double.parseDouble(pCelcius);
            double f = c * ( 9.0/5.0) + 32.0;
            return String.format("%3.2f",f);
        }catch(NumberFormatException nfe){
            return "Error";
        }
    };
    protected void onSaveInstanceState(Bundle state){
        EditText inputTempText = (EditText) findViewById(R.id.inputTempEditText);
        String inputTemp = inputTempText.getText().toString();
        state.putString("inputTemperature",inputTemp);
        super.onSaveInstanceState(state);
    };
    private void restoreState(Bundle state){
        if(state == null) return;
        EditText inputTempText = (EditText) findViewById(R.id.inputTempEditText);
        String inputTemp = state.getString("inputTemperature");
        inputTempText.setText(inputTemp);
    };

}