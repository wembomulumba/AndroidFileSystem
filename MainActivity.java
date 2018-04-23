package com.example.personnel_msg;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static final String DEBUGTAG = "WEBJUST";
	public static final String TEXTFILE = "notepadText.txt";

	final Button   saveBtn =   (Button) findViewById(R.id.button1);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		CalculatebtnActionListener();
		loadTextFile();
	}
	
	private void loadTextFile(){
		
		try {
		FileInputStream data= 	openFileInput(TEXTFILE);
		
		// read the data line by line
		BufferedReader reader = new BufferedReader(new InputStreamReader(new 
				DataInputStream(data)));
		    
	    String line;	    
		while((line = reader.readLine()) != null){
			
			
			// append text lines here usingjava setText method
			saveBtn.setText(line);		
		}
		data.close();	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	// perfoming action listenners here 
	private void CalculatebtnActionListener(){
			
	// actual code to call action on button click			
	
	saveBtn.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			TextView result  =   (TextView) findViewById(R.id.resultfield);
			EditText number1  =   (EditText) findViewById(R.id.editText1);
			EditText number2  =   (EditText) findViewById(R.id.editText2);		
			
		  	String num1	 = number1.getText().toString();
			int currentNum1 = Integer.parseInt(num1);	
			String num2	 = number2.getText().toString();
			int currentNum2 = Integer.parseInt(num2);	
		
			int total = currentNum1 + currentNum2;
			
			result.setText("Goto..." + total);
			
			try {
			FileOutputStream fos =	openFileOutput(TEXTFILE, Context.MODE_PRIVATE);
			fos.write(num2.getBytes());
			fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
	});
	
	
	
	}
}
