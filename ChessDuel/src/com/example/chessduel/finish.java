package com.example.chessduel;

import android.app.Activity;
import android.content.Intent;							//import Libaries
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class finish extends Activity{    //finish class declaration

	@Override
	protected void onCreate(Bundle savedInstanceState) {   //Overrided Activity's onCreate metod
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.finish_page);       //Display finish layout
		
		//GameName Font style
		Typeface font;
        font = Typeface.createFromAsset(getResources().getAssets(), "towerruinscondital.ttf");
        
        //Variables declaration according to the finish layout  
		Bundle gelenler = getIntent().getExtras();
		winFlag = gelenler.getBoolean("winFlag");
		final TextView gameText = (TextView)findViewById(R.id.finishText);
		gameText.setTypeface(font);
		final TextView situationText = (TextView)findViewById(R.id.situationText);
		
		
		//if the player wins,winFlag is came from the board activity
		if(winFlag){
			situationText.setText("You Win!! \nThank You for playing :)");
		}
		//if the computer wins
		else
		{
			situationText.setText("Unfortunately You Lost... \nThank You for playing :)");
		}
		
		//new game button, and its onClickListener Metod
		final Button newGameBut = (Button)findViewById(R.id.newGameButton);
		
		newGameBut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();  //finish that activity and 
				           //callback the board activity to return the MainActivity
			}
		});
		
	}
	
	private boolean winFlag=true;    //Finish class variable declaration
}
