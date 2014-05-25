package com.example.chessduel;

import android.os.Bundle;						//import libraries
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {         //MainActivity class declaration 

    @Override
    protected void onCreate(Bundle savedInstanceState) {     //Overrided  Activity's onCreate metod
        super.onCreate(savedInstanceState);	
        setContentView(R.layout.activity_main);				 //Display View
        
        
        Typeface font;                                       //Game Name Font
        font = Typeface.createFromAsset(getResources().getAssets(), "towerruinscondital.ttf");
        //Definiton some variables in MainActivity layout
        final Intent gecis = new Intent("com.example.chessduel.BOARD");    
        final Bundle veriler = new Bundle();
        final EditText numCol = (EditText)findViewById(R.id.numColText);
        final EditText numRow = (EditText)findViewById(R.id.numRowText);
        final TextView gameText = (TextView)findViewById(R.id.gameText);
        gameText.setTypeface(font);
        
        
        
        //White and Black horse button's ocClickListener metods
        ImageButton whiteButton = (ImageButton)findViewById(R.id.whiteButton);
        whiteButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Number of Column and Row that entered parsing 
				//if they are invalid throw exception and set them to default number,it is 8
				try {									
				    numOfCol = Integer.parseInt(numCol.getText().toString());
				} catch(NumberFormatException nfe) {
				   System.out.println("Could not parse " + nfe);
				   numOfCol=8;
				} 
				try {
				    numOfRow = Integer.parseInt(numRow.getText().toString());
				} catch(NumberFormatException nfe) {
				   System.out.println("Could not parse " + nfe);
				   numOfRow=8;
				} 
				//If they are valid,Control they are lesser than minimum number that expected
				if(numOfRow<5 && numOfCol<5)
					numOfRow = numOfCol = 8;
				
				//Put the variables into the bundle and start the board activity
				isWhite=true;
				veriler.putInt("numCol",numOfCol);
				veriler.putInt("numRow",numOfRow);
				veriler.putBoolean("isWhite", isWhite);
				gecis.putExtras(veriler);
				
				startActivity(gecis);
				
			}
		});
        //Black button's onClickListener metod
        ImageButton blackButton = (ImageButton)findViewById(R.id.blackButton);
        blackButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Number of Column and Row that entered parsing 
				//if they are invalid throw exception and set them to default number,it is 8
				try {
				    numOfCol = Integer.parseInt(numCol.getText().toString());
				} catch(NumberFormatException nfe) {
				   System.out.println("Could not parse " + nfe);
				   numOfCol=8;
				} 
				try {
				    numOfRow = Integer.parseInt(numRow.getText().toString());
				} catch(NumberFormatException nfe) {
				   System.out.println("Could not parse " + nfe);
				   numOfRow=8;
				} 
				//If they are valid,Control they are lesser than minimum number that expected
				if(numOfRow<5 && numOfCol<5)
					numOfRow = numOfCol = 8;
				
				//Put the variables into the bundle and start the board activity
				isWhite=false;
				veriler.putInt("numCol",numOfCol);
				veriler.putInt("numRow",numOfRow);
				veriler.putBoolean("isWhite", isWhite);
				gecis.putExtras(veriler);
				
				startActivity(gecis);
				
			}
		});
    }

    //MainActivity's variable's declaration
    private boolean isWhite;
    private int numOfCol = 8;
    private int numOfRow = 8;
    
}
