package com.example.unitconversion1;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.AdapterView.OnItemSelectedListener;

public class UnitConversion extends Activity implements OnItemSelectedListener
{
	double v1, v2;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
	        R.array.tempUnits, android.R.layout.simple_spinner_item);

        Spinner spinner01 = (Spinner) findViewById(R.id.unit01);
        Spinner spinner02 = (Spinner) findViewById(R.id.unit02);

		spinner01.setAdapter(adapter);
		spinner01.setOnItemSelectedListener(this);
		spinner02.setAdapter(adapter);
		spinner02.setOnItemSelectedListener(this);

    }
/*
 	@Override
	public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
		int from = position, to;
		EditText v;

		switch(parentView.getId()) {
			case R.id.unit01:
				v = (EditText)findViewById(R.id.value01);
				if(v.getText().length()==0) break;
				v1 = Double.parseDouble(v.getText().toString());
				to = ((Spinner)findViewById(R.id.unit02)).getSelectedItemPosition();
				v2 = (TempConverter.convert(v1, from, to));
				((EditText)findViewById(R.id.value02)).setText(Double.toString(v2));
				break;
			case R.id.unit02:
				v = (EditText)findViewById(R.id.value02);
				if(v.getText().length()==0) break;
				v2 = Double.parseDouble(v.getText().toString());
				to = ((Spinner)findViewById(R.id.unit01)).getSelectedItemPosition();
				v1 = (TempConverter.convert(v2, from, to));
				((EditText)findViewById(R.id.value01)).setText(Double.toString(v1));
				break;
		}

	}
 */
    
 	public void convertTemperature(View view) {
 		/*
 		 * First we setup the views and then check to make sure we
 		 * don't have a null value.
 		 */
 		int from = ((Spinner)findViewById(R.id.unit01)).getSelectedItemPosition(), 
 				to = ((Spinner)findViewById(R.id.unit02)).getSelectedItemPosition();
		EditText fromValue = (EditText)findViewById(R.id.value01);
		if(fromValue.getText().length()==0) return;
		
		/*
		 * Now we populate the class level variables with the values to convert.
		 */
		v1 = Double.parseDouble(fromValue.getText().toString());
		v2 = (TempConverter.convert(v1, from, to));
		
		/*
		 * Now we display the converted value in the second EditText view.00
		 */
		((EditText)findViewById(R.id.value02)).setText(Double.toString(v2));
		
 	}


	@Override
	public void onNothingSelected(AdapterView<?> parentView) {
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}
}
