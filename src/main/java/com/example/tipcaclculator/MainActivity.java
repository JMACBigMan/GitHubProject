package com.example.tipcaclculator;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText enteredAmount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView TotalResultTextView;
    private TextView textViewSeekbar;
    private int seekbarPercentage;
    private float enterBillFloat;
    private TextView totalBillTv;

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredAmount = (EditText)findViewById(R.id.billamountID);
        seekBar = (SeekBar) findViewById(R.id.percentageSeekbar);
        calculateButton = (Button) findViewById(R.id.calculateButton);
        TotalResultTextView = (TextView) findViewById(R.id.resultID);
        textViewSeekbar = (TextView) findViewById(R.id.textViewSeekbar);
        totalBillTv = (TextView) findViewById(R.id.totalBillTextView);
        calculateButton.setOnClickListener(this);

        Toast.makeText(getApplication(), "Hello", Toast.LENGTH_LONG).show();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewSeekbar.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                seekbarPercentage = seekBar.getProgress();

            }
        });



    }

    @Override
    public void onClick(View v) {
        calculate();
    }


    public void calculate() {
        float result = 0.0f;

        if (!enteredAmount.getText().toString().equals("")) {
            enterBillFloat = Float.parseFloat(enteredAmount.getText().toString());
            result = enterBillFloat * seekbarPercentage / 100;
            TotalResultTextView.setText("Your tip will be " + "$" + String.valueOf(result));
            totalBillTv.setText("Total bill: " + "$" + String.valueOf(enterBillFloat + result));

            Log.v(TAG, String.valueOf((result)));

        } else {
            Toast.makeText(MainActivity.this, "Please enter a bill amount.", Toast.LENGTH_LONG).show();
        }


      }

}

