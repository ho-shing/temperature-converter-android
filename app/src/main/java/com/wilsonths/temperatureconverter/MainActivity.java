package com.wilsonths.temperatureconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private EditText inputEditText;
    private TextView convertedValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEditText = (EditText)findViewById(R.id.input_edit_text);
        convertedValueTextView = (TextView)findViewById(R.id.converted_value_text_view);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    public void onCelsiusToFahrenheitButtonTapped(View view) {
        String text = inputEditText.getText().toString();
        try {
            double convertedValue = Integer.valueOf(text) * 9.0 / 5.0 + 32;
            convertedValueTextView.setText(String.format("%.2f", convertedValue)+ " degrees Fahrenheit");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
    }

    public void onFahrenheitToCelsiusButtonTapped(View view) {
        String text = inputEditText.getText().toString();
        try {
            double convertedValue = (Integer.valueOf(text) - 32.0) * 5.0 / 9.0;
            convertedValueTextView.setText(String.format("%.2f", convertedValue)+ " degrees Celsius");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
    }
}
