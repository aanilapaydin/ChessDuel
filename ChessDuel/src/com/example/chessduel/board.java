package com.example.chessduel;

import android.app.Activity;				////import libraries
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class board extends Activity {    //board activity class declaration 

	@Override
	//Overrided Activity's onCreate metod
	protected void onCreate(Bundle savedInstanceState) {   
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setCurrentViewById(R.layout.board);   //Display the view
		
		//Variables declaration according to the board layout
		Bundle gelenler = getIntent().getExtras();     
		numOfCol = gelenler.getInt("numCol");
		numOfRow = gelenler.getInt("numRow");
		isWhite = gelenler.getBoolean("isWhite");
		comX=0;
		comY=0;
		
		initilizeBoardImages();   //Determine board's color and deployment the horses 
		selectedBut = (ImageView)findViewById(boardArray[plaX][plaY]);  //player's horse
		
		move();  //game is starting and player's turn
			
				
	}
		
	//The game and player's turn function
	public void move() {
		// TODO Auto-generated method stub
		
		//Looking player's could go area's 
		if(plaX-2<numOfCol && plaX-2>=0 && plaY-1<numOfRow && plaY-1>=0){
			ImageButton onWayBut1 = (ImageButton)findViewById(boardArray[plaX-2][plaY-1]);
			ImageView onWayView1 = (ImageView)findViewById(boardArray[plaX-2][plaY-1]);
			if(isSameDrawable(onWayView1,R.drawable.white)||
			   isSameDrawable(onWayView1,R.drawable.black)||
			   (isWhite && (isMate(onWayView1,R.drawable.black_on_white)||
				        isMate(onWayView1,R.drawable.black_on_black)))||
			   (!isWhite && (isMate(onWayView1,R.drawable.white_on_white)||
						isMate(onWayView1,R.drawable.white_on_black)))){
				//if the area is valid create onCliskListener metod
				onWayBut1.setOnClickListener(new View.OnClickListener() {
			
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//move the player's knight
					setPlayerKnight(plaX,plaY,plaX-2,plaY-1);
					plaX=plaX-2;    //Reposition the player
					plaY=plaY-1;
					selectedBut = (ImageButton)findViewById(boardArray[plaX][plaY]);
					ImageView temp = (ImageView)findViewById(boardArray[plaX][plaY]);
					//Control the player's next move
					if(availableMoves(temp,plaX,plaY)==0)
						comWin();
					else{
						if(gameIsOn){
							computerMove();
							if(onProcess)
								move();
							else{
								comWin();
							}
						}
						else
							playerWin();
					}
						
				}			
			});	
		}
		}
		
		//Do same things for the other area that player can go
		if(plaX-1<numOfCol && plaX-1>=0 && plaY-2<numOfRow && plaY-2>=0){
			ImageButton onWayBut2 = (ImageButton)findViewById(boardArray[plaX-1][plaY-2]);
			ImageView onWayView2 = (ImageView)findViewById(boardArray[plaX-1][plaY-2]);
			if(isSameDrawable(onWayView2,R.drawable.white)||
			   isSameDrawable(onWayView2,R.drawable.black)||
			   (isWhite && (isMate(onWayView2,R.drawable.black_on_white)||
				        isMate(onWayView2,R.drawable.black_on_black)))||
			   (!isWhite && (isMate(onWayView2,R.drawable.white_on_white)||
						isMate(onWayView2,R.drawable.white_on_black)))){
			onWayBut2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					setPlayerKnight(plaX,plaY,plaX-1,plaY-2);
					plaX=plaX-1;
					plaY=plaY-2;
					selectedBut = (ImageButton)findViewById(boardArray[plaX][plaY]);
					ImageView temp = (ImageView)findViewById(boardArray[plaX][plaY]);
					if(availableMoves(temp,plaX,plaY)==0)
						comWin();
					else{
						if(gameIsOn){
							computerMove();
							if(onProcess)
								move();
							else{
								comWin();
							}
						}
						else
							playerWin();
					}
				}			
			});
		}
		}
		//Do same things for the other area that player can go
		if(plaX+1<numOfCol && plaX+1>=0 && plaY-2<numOfRow && plaY-2>=0){
			ImageButton onWayBut3 = (ImageButton)findViewById(boardArray[plaX+1][plaY-2]);
			ImageView onWayView3 = (ImageView)findViewById(boardArray[plaX+1][plaY-2]);
			if(isSameDrawable(onWayView3,R.drawable.white)||
			   isSameDrawable(onWayView3,R.drawable.black)||
			   (isWhite && (isMate(onWayView3,R.drawable.black_on_white)||
				        isMate(onWayView3,R.drawable.black_on_black)))||
			   (!isWhite && (isMate(onWayView3,R.drawable.white_on_white)||
						isMate(onWayView3,R.drawable.white_on_black)))){
			onWayBut3.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					setPlayerKnight(plaX,plaY,plaX+1,plaY-2);
					plaX=plaX+1;
					plaY=plaY-2;
					selectedBut = (ImageButton)findViewById(boardArray[plaX][plaY]);
					ImageView temp = (ImageView)findViewById(boardArray[plaX][plaY]);
					if(availableMoves(temp,plaX,plaY)==0)
						comWin();
					else{
						if(gameIsOn){
							computerMove();
							if(onProcess)
								move();
							else{
								comWin();
							}
						}
						else
							playerWin();
					}
				}			
			});
		}
		}
		//Do same things for the other area that player can go
		if(plaX+2<numOfCol && plaX+2>=0 && plaY-1<numOfRow && plaY-1>=0){
			ImageButton onWayBut4 = (ImageButton)findViewById(boardArray[plaX+2][plaY-1]);
			ImageView onWayView4 = (ImageView)findViewById(boardArray[plaX+2][plaY-1]);
			if(isSameDrawable(onWayView4,R.drawable.white)||
			   isSameDrawable(onWayView4,R.drawable.black)||
			   (isWhite && (isMate(onWayView4,R.drawable.black_on_white)||
				        isMate(onWayView4,R.drawable.black_on_black)))||
			   (!isWhite && (isMate(onWayView4,R.drawable.white_on_white)||
						isMate(onWayView4,R.drawable.white_on_black)))){
			onWayBut4.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					setPlayerKnight(plaX,plaY,plaX+2,plaY-1);
					plaX=plaX+2;
					plaY=plaY-1;
					selectedBut = (ImageButton)findViewById(boardArray[plaX][plaY]);
					ImageView temp = (ImageView)findViewById(boardArray[plaX][plaY]);
					if(availableMoves(temp,plaX,plaY)==0)
						comWin();
					else{
						if(gameIsOn){
							computerMove();
							if(onProcess)
								move();
							else{
								comWin();
							}
						}
						else
							playerWin();
					}
				}			
			});
		}
		}
		//Do same things for the other area that player can go
		if(plaX-2<numOfCol && plaX-2>=0 && plaY+1<numOfRow && plaY+1>=0){
			ImageButton onWayBut5 = (ImageButton)findViewById(boardArray[plaX-2][plaY+1]);
			ImageView onWayView5 = (ImageView)findViewById(boardArray[plaX-2][plaY+1]);
			if(isSameDrawable(onWayView5,R.drawable.white)||
			   isSameDrawable(onWayView5,R.drawable.black)||
			   (isWhite && (isMate(onWayView5,R.drawable.black_on_white)||
				        isMate(onWayView5,R.drawable.black_on_black)))||
			   (!isWhite && (isMate(onWayView5,R.drawable.white_on_white)||
						isMate(onWayView5,R.drawable.white_on_black)))){
			onWayBut5.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					setPlayerKnight(plaX,plaY,plaX-2,plaY+1);
					plaX=plaX-2;
					plaY=plaY+1;
					selectedBut = (ImageButton)findViewById(boardArray[plaX][plaY]);
					ImageView temp = (ImageView)findViewById(boardArray[plaX][plaY]);
					if(availableMoves(temp,plaX,plaY)==0)
						comWin();
					else{
						if(gameIsOn){
							computerMove();
							if(onProcess)
								move();
							else{
								comWin();
							}
						}
						else
							playerWin();
					}
				}			
			});
		}
		}
		//Do same things for the other area that player can go
		if(plaX-1<numOfCol && plaX-1>=0 && plaY+2<numOfRow && plaY+2>=0){
			ImageButton onWayBut6 = (ImageButton)findViewById(boardArray[plaX-1][plaY+2]);
			ImageView onWayView6 = (ImageView)findViewById(boardArray[plaX-1][plaY+2]);
			if(isSameDrawable(onWayView6,R.drawable.white)||
			   isSameDrawable(onWayView6,R.drawable.black)||
			   (isWhite && (isMate(onWayView6,R.drawable.black_on_white)||
				        isMate(onWayView6,R.drawable.black_on_black)))||
			   (!isWhite && (isMate(onWayView6,R.drawable.white_on_white)||
						isMate(onWayView6,R.drawable.white_on_black)))){
			onWayBut6.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					setPlayerKnight(plaX,plaY,plaX-1,plaY+2);
					plaX=plaX-1;
					plaY=plaY+2;
					selectedBut = (ImageButton)findViewById(boardArray[plaX][plaY]);
					ImageView temp = (ImageView)findViewById(boardArray[plaX][plaY]);
					if(availableMoves(temp,plaX,plaY)==0)
						comWin();
					else{
						if(gameIsOn){
							computerMove();
							if(onProcess)
								move();
							else{
								comWin();
							}
						}
						else
							playerWin();
					}
				}			
			});
		}
		}
		//Do same things for the other area that player can go
		if(plaX+1<numOfCol && plaX+1>=0 && plaY+2<numOfRow && plaY+2>=0){
			ImageButton onWayBut7 = (ImageButton)findViewById(boardArray[plaX+1][plaY+2]);
			ImageView onWayView7 = (ImageView)findViewById(boardArray[plaX+1][plaY+2]);
			if(isSameDrawable(onWayView7,R.drawable.white)||
			   isSameDrawable(onWayView7,R.drawable.black)||
			   (isWhite && (isMate(onWayView7,R.drawable.black_on_white)||
				        isMate(onWayView7,R.drawable.black_on_black)))||
			   (!isWhite && (isMate(onWayView7,R.drawable.white_on_white)||
						isMate(onWayView7,R.drawable.white_on_black)))){
			onWayBut7.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					setPlayerKnight(plaX,plaY,plaX+1,plaY+2);
					plaX=plaX+1;
					plaY=plaY+2;
					selectedBut = (ImageButton)findViewById(boardArray[plaX][plaY]);
					ImageView temp = (ImageView)findViewById(boardArray[plaX][plaY]);
					if(availableMoves(temp,plaX,plaY)==0)
						comWin();
					else{
						if(gameIsOn){
							computerMove();
							if(onProcess)
								move();
							else{
								comWin();
							}
						}
						else
							playerWin();
					}
				}			
			});
		}
		}
		//Do same things for the other area that player can go
		if(plaX+2<numOfCol && plaX+2>=0 && plaY+1<numOfRow && plaY+1>=0){
			ImageButton onWayBut8 = (ImageButton)findViewById(boardArray[plaX+2][plaY+1]);
			ImageView onWayView8 = (ImageView)findViewById(boardArray[plaX+2][plaY+1]);
			if(isSameDrawable(onWayView8,R.drawable.white)||
			   isSameDrawable(onWayView8,R.drawable.black)||
			   (isWhite && (isMate(onWayView8,R.drawable.black_on_white)||
				        isMate(onWayView8,R.drawable.black_on_black)))||
			   (!isWhite && (isMate(onWayView8,R.drawable.white_on_white)||
						isMate(onWayView8,R.drawable.white_on_black)))){
			onWayBut8.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					setPlayerKnight(plaX,plaY,plaX+2,plaY+1);
					plaX=plaX+2;
					plaY=plaY+1;
					selectedBut = (ImageButton)findViewById(boardArray[plaX][plaY]);
					ImageView temp = (ImageView)findViewById(boardArray[plaX][plaY]);
					if(availableMoves(temp,plaX,plaY)==0)
						comWin();
					else{
						if(gameIsOn){
							computerMove();
							if(onProcess)
								move();
							else{
								comWin();
							}
						}
						else
							playerWin();
					}
				}			
			});
		}
		}
			
	}

	//Ýnitialize board images,determine board's color and deployment the horses
	public void initilizeBoardImages(){
		
		//Assing image the board's button's ID to the board array
		for(int i=0;i<8;++i)
		{ 
				 if(i==0){
					boardArray[i][0]=R.id.imageButton1;
					boardArray[i][1]=R.id.imageButton2;
					boardArray[i][2]=R.id.imageButton3;
					boardArray[i][3]=R.id.imageButton4;
					boardArray[i][4]=R.id.imageButton5;
					boardArray[i][5]=R.id.imageButton6;
					boardArray[i][6]=R.id.imageButton7;
					boardArray[i][7]=R.id.imageButton8;
				 }
				 if(i==1){
					boardArray[i][0]=R.id.imageButton9;
					boardArray[i][1]=R.id.imageButton10;
					boardArray[i][2]=R.id.imageButton11;
					boardArray[i][3]=R.id.imageButton12;
					boardArray[i][4]=R.id.imageButton13;
					boardArray[i][5]=R.id.imageButton14;
					boardArray[i][6]=R.id.imageButton15;
					boardArray[i][7]=R.id.imageButton16;
				}
				if(i==2){
					boardArray[i][0]=R.id.imageButton17;
					boardArray[i][1]=R.id.imageButton18;
					boardArray[i][2]=R.id.imageButton19;
					boardArray[i][3]=R.id.imageButton20;
					boardArray[i][4]=R.id.imageButton21;
					boardArray[i][5]=R.id.imageButton22;
					boardArray[i][6]=R.id.imageButton23;
					boardArray[i][7]=R.id.imageButton24;
				 }
				 if(i==3){
					boardArray[i][0]=R.id.imageButton25;
					boardArray[i][1]=R.id.imageButton26;
					boardArray[i][2]=R.id.imageButton27;
					boardArray[i][3]=R.id.imageButton28;
					boardArray[i][4]=R.id.imageButton29;
					boardArray[i][5]=R.id.imageButton30;
					boardArray[i][6]=R.id.imageButton31;
					boardArray[i][7]=R.id.imageButton32;
			  	 }
				 if(i==4){
					boardArray[i][0]=R.id.imageButton33;
					boardArray[i][1]=R.id.imageButton34;
					boardArray[i][2]=R.id.imageButton35;
					boardArray[i][3]=R.id.imageButton36;
					boardArray[i][4]=R.id.imageButton37;
					boardArray[i][5]=R.id.imageButton38;
					boardArray[i][6]=R.id.imageButton39;
					boardArray[i][7]=R.id.imageButton40;
				 }
				 if(i==5){
					boardArray[i][0]=R.id.imageButton41;
					boardArray[i][1]=R.id.imageButton42;
					boardArray[i][2]=R.id.imageButton43;
					boardArray[i][3]=R.id.imageButton44;
					boardArray[i][4]=R.id.imageButton45;
					boardArray[i][5]=R.id.imageButton46;
					boardArray[i][6]=R.id.imageButton47;
					boardArray[i][7]=R.id.imageButton48;
				}
				if(i==6){
					boardArray[i][0]=R.id.imageButton49;
					boardArray[i][1]=R.id.imageButton50;
					boardArray[i][2]=R.id.imageButton51;
					boardArray[i][3]=R.id.imageButton52;
					boardArray[i][4]=R.id.imageButton53;
					boardArray[i][5]=R.id.imageButton54;
					boardArray[i][6]=R.id.imageButton55;
					boardArray[i][7]=R.id.imageButton56;
				 }
				 if(i==7){
					boardArray[i][0]=R.id.imageButton57;
					boardArray[i][1]=R.id.imageButton58;
					boardArray[i][2]=R.id.imageButton59;
					boardArray[i][3]=R.id.imageButton60;
					boardArray[i][4]=R.id.imageButton61;
					boardArray[i][5]=R.id.imageButton62;
					boardArray[i][6]=R.id.imageButton63;
					boardArray[i][7]=R.id.imageButton64;
			  	 }
		}
		
		for(int i=0;i<8;++i){
			for(int j=0;j<8;++j){
				
				//Assign all board color to the transparent first
				ImageView gen_temp = (ImageView)findViewById(boardArray[i][j]);
				gen_temp.setBackgroundResource(R.drawable.transparent);
				gen_temp.setTag(R.drawable.transparent);
				//Determine the board's button's color white or black
				if(i<numOfCol && j<numOfRow){
					if(i%2==0){
						if(j%2==0){
							ImageView temp = (ImageView)findViewById(boardArray[i][j]);
							temp.setImageResource(R.drawable.white);	
							temp.setTag(R.drawable.white);
						}
						else{
							ImageView temp = (ImageView)findViewById(boardArray[i][j]);
							temp.setImageResource(R.drawable.black);
							temp.setTag(R.drawable.black);
						}
					}
					else{
						if(j%2==0){
							ImageView temp = (ImageView)findViewById(boardArray[i][j]);
							temp.setImageResource(R.drawable.black);
							temp.setTag(R.drawable.black);
						}
						else{
							ImageView temp = (ImageView)findViewById(boardArray[i][j]);
							temp.setImageResource(R.drawable.white);
							temp.setTag(R.drawable.white);
						}
					}
				}
				else
				{
					ImageView temp = (ImageView)findViewById(boardArray[i][j]);
					temp.setImageResource(R.drawable.transparent);
					temp.setTag(R.drawable.transparent);
				}	
				if(i==0 && j==0){
					ImageView temp = (ImageView)findViewById(boardArray[i][j]);
					if(isWhite){
						temp.setImageResource(R.drawable.black_on_white);
						temp.setTag(R.drawable.black_on_white);
					}
					else{
						temp.setImageResource(R.drawable.white_on_white);
						temp.setTag(R.drawable.white_on_white);
					}
				}
				//Deployment the horse's and determine their colors
				if(i==numOfCol-1 && j==numOfRow-1){
				ImageView temp = (ImageView)findViewById(boardArray[i][j]);
				plaX=i;
				plaY=j;
					if(isWhite){
						if(Math.abs(numOfCol-numOfRow)%2==0){
							temp.setImageResource(R.drawable.white_on_white);
							temp.setTag(R.drawable.white_on_white);
						}
						else{
							temp.setImageResource(R.drawable.white_on_black);
							temp.setTag(R.drawable.white_on_black);
						}
					}
					else{
						if(Math.abs(numOfCol-numOfRow)%2==0){
							temp.setImageResource(R.drawable.black_on_white);
							temp.setTag(R.drawable.black_on_white);
						}
						else{
							temp.setImageResource(R.drawable.black_on_black);						
							temp.setTag(R.drawable.black_on_black);
						}
					}
				
				}
			}
		}
			
		
	}
	//Computer wins
	public void comWin(){
		Intent temp = new Intent("com.example.chessduel.FINISH");
		Bundle veriler = new Bundle();
		veriler.putBoolean("winFlag",false);  //if computer wins,winFlag is false
		temp.putExtras(veriler);
		startActivity(temp);			//start the finish activity
		finish();     //callback the main activity,if the user wants to play a new game
	}
	//Player wins
	public void playerWin(){
		Intent temp = new Intent("com.example.chessduel.FINISH");
		Bundle veriler = new Bundle();
		veriler.putBoolean("winFlag",true);		//if player wins,winFlag is false
		temp.putExtras(veriler);		//start the finish activity
		startActivity(temp);	
		finish();					//callback the main activity,if the user wants to play a new game
	}
	
	
	//Computer move 
	private void computerMove() {
		// TODO Auto-generated method stub
		Integer[] compX = new Integer[8];		//computer's position to go and points array
		Integer[] compY = new Integer[8];
		Integer[] points = new Integer[8];
		for(int i=0;i<8;++i)   //initialize points array
			points[i]=null;
		
		
		//check the area that computer can go is in the board
		if(comX-2<numOfCol && comY-1<numOfRow && comX-2>=0 && comY-1>=0){
			ImageView temp = (ImageView)findViewById(boardArray[comX-2][comY-1]);
			//check if it is previously gone
			if(!isSameDrawable(temp,R.drawable.white_invalid) && 
			   !isSameDrawable(temp,R.drawable.black_invalid)){
				points[0]=0;
				compX[0]=comX-2;
				compY[0]=comY-1;
				//check the area, if the computer moves there player can mate it
				if(ifComWillMated(temp,compX[0],compY[0]))   
					points[0]-=999;    //if player can mate
				else
					points[0]+=1;      //else
				
				
				//check the areas available move areas,and the points array
				points[0]+=availableMoves(temp,compX[0],compY[0]);  
				
				//Check the are, if computer moves there,it can mates the payer
				if((isWhite && (isComMate(temp,R.drawable.white_on_white)||
								isComMate(temp,R.drawable.white_on_black)))||
				   !isWhite && (isComMate(temp,R.drawable.black_on_white)||
				    			isComMate(temp,R.drawable.black_on_black))){
					points[0]+=999;   //if computer mates the player
				}
			}
		}
		//Do the same things for the other areas that computer can go
		if(comX-1<numOfCol && comY-2<numOfRow && comX-1>=0 && comY-2>=0){
			ImageView temp = (ImageView)findViewById(boardArray[comX-1][comY-2]);
			if(!isSameDrawable(temp,R.drawable.white_invalid) && 
			   !isSameDrawable(temp,R.drawable.black_invalid)){
				points[1]=0;
				compX[1]=comX-1;
				compY[1]=comY-2;
				if(ifComWillMated(temp,compX[1],compY[1]))
					points[1]-=999;
				else
					points[1]+=1;
				
				points[1]+=availableMoves(temp,compX[1],compY[1]);
				
				if((isWhite && (isComMate(temp,R.drawable.white_on_white)||
								isComMate(temp,R.drawable.white_on_black)))||
				   !isWhite && (isComMate(temp,R.drawable.black_on_white)||
				    			isComMate(temp,R.drawable.black_on_black))){
					points[1]+=999;
				}
			}
			
		}
		//Do the same things for the other areas that computer can go
		if(comX+1<numOfCol && comY-2<numOfRow && comX+1>=0 && comY-2>=0){
			ImageView temp = (ImageView)findViewById(boardArray[comX+1][comY-2]);
			if(!isSameDrawable(temp,R.drawable.white_invalid) && 
			   !isSameDrawable(temp,R.drawable.black_invalid)){
				points[2]=0;
				compX[2]=comX+1;
				compY[2]=comY-2;
				if(ifComWillMated(temp,compX[2],compY[2]))
					points[2]-=999;
				else
					points[2]+=1;
				
				points[2]+=availableMoves(temp,compX[2],compY[2]);
				
				if((isWhite && (isComMate(temp,R.drawable.white_on_white)||
								isComMate(temp,R.drawable.white_on_black)))||
				   !isWhite && (isComMate(temp,R.drawable.black_on_white)||
				    			isComMate(temp,R.drawable.black_on_black))){
					points[2]+=999;
				}
			}
			
		}
		//Do the same things for the other areas that computer can go
		if(comX+2<numOfCol && comY-1<numOfRow && comX+2>=0 && comY-1>=0){
			ImageView temp = (ImageView)findViewById(boardArray[comX+2][comY-1]);
			if(!isSameDrawable(temp,R.drawable.white_invalid) && 
			   !isSameDrawable(temp,R.drawable.black_invalid)){
				points[3]=0;
				compX[3]=comX+2;
				compY[3]=comY-1;
				if(ifComWillMated(temp,compX[3],compY[3]))
					points[3]-=999;
				else
					points[3]+=1;
				
				points[3]+=availableMoves(temp,compX[3],compY[3]);
				
				if((isWhite && (isComMate(temp,R.drawable.white_on_white)||
								isComMate(temp,R.drawable.white_on_black)))||
				   !isWhite && (isComMate(temp,R.drawable.black_on_white)||
				    			isComMate(temp,R.drawable.black_on_black))){
					points[3]+=999;
				}
			}
			
		}
		//Do the same things for the other areas that computer can go
		if(comX-2<numOfCol && comY+1<numOfRow && comX-2>=0 && comY+1>=0){
			ImageView temp = (ImageView)findViewById(boardArray[comX-2][comY+1]);
			if(!isSameDrawable(temp,R.drawable.white_invalid) && 
			   !isSameDrawable(temp,R.drawable.black_invalid)){
				points[4]=0;
				compX[4]=comX-2;
				compY[4]=comY+1;
				if(ifComWillMated(temp,compX[4],compY[4]))
					points[4]-=999;
				else
					points[4]+=1;
				
				points[4]+=availableMoves(temp,compX[4],compY[4]);
				
				if((isWhite && (isComMate(temp,R.drawable.white_on_white)||
								isComMate(temp,R.drawable.white_on_black)))||
				   !isWhite && (isComMate(temp,R.drawable.black_on_white)||
				    			isComMate(temp,R.drawable.black_on_black))){
					points[4]+=999;
				}
			}
			
		}
		//Do the same things for the other areas that computer can go
		if(comX-1<numOfCol && comY+2<numOfRow && comX-1>=0 && comY+2>=0){
			ImageView temp = (ImageView)findViewById(boardArray[comX-1][comY+2]);
			if(!isSameDrawable(temp,R.drawable.white_invalid) && 
			   !isSameDrawable(temp,R.drawable.black_invalid)){
				points[5]=0;
				compX[5]=comX-1;
				compY[5]=comY+2;
				if(ifComWillMated(temp,compX[5],compY[5]))
					points[5]-=999;
				else
					points[5]+=1;
				
				points[5]+=availableMoves(temp,compX[5],compY[5]);
				
				if((isWhite && (isComMate(temp,R.drawable.white_on_white)||
								isComMate(temp,R.drawable.white_on_black)))||
				   !isWhite && (isComMate(temp,R.drawable.black_on_white)||
				    			isComMate(temp,R.drawable.black_on_black))){
					points[5]+=999;
				}
			}
			
		}
		//Do the same things for the other areas that computer can go
		if(comX+1<numOfCol && comY+2<numOfRow && comX+1>=0 && comY+2>=0){
			ImageView temp = (ImageView)findViewById(boardArray[comX+1][comY+2]);
			if(!isSameDrawable(temp,R.drawable.white_invalid) && 
			   !isSameDrawable(temp,R.drawable.black_invalid)){
				points[6]=0;
				compX[6]=comX+1;
				compY[6]=comY+2;
				if(ifComWillMated(temp,compX[6],compY[6]))
					points[6]-=999;
				else
					points[6]+=1;
				
				points[6]+=availableMoves(temp,compX[6],compY[6]);
				
				if((isWhite && (isComMate(temp,R.drawable.white_on_white)||
								isComMate(temp,R.drawable.white_on_black)))||
				   !isWhite && (isComMate(temp,R.drawable.black_on_white)||
				    			isComMate(temp,R.drawable.black_on_black))){
					points[6]+=999;
				}
			}
			
		}
		//Do the same things for the other areas that computer can go
		if(comX+2<numOfCol && comY+1<numOfRow && comX+2>=0 && comY+1>=0){
			ImageView temp = (ImageView)findViewById(boardArray[comX+2][comY+1]);
			if(!isSameDrawable(temp,R.drawable.white_invalid) && 
			   !isSameDrawable(temp,R.drawable.black_invalid)){
				points[7]=0;
				compX[7]=comX+2;
				compY[7]=comY+1;
				if(ifComWillMated(temp,compX[7],compY[7]))
					points[7]-=999;
				else
					points[7]+=1;
				
				points[7]+=availableMoves(temp,compX[7],compY[7]);
				
				if((isWhite && (isComMate(temp,R.drawable.white_on_white)||
								isComMate(temp,R.drawable.white_on_black)))||
				   !isWhite && (isComMate(temp,R.drawable.black_on_white)||
				    			isComMate(temp,R.drawable.black_on_black))){
					points[7]+=999;
				}
			}
		}
		//initialize maxPoint and maxPoint's index in points array
		int maxPoint=-1000;
		int max_i=0;
		//check the points array for determine max point that areas earned
		for(int i=0;i<8;++i){
			
			if(points[i]!=null){
				if(i==0){
					maxPoint=points[i];
					max_i=i;
				}
				else if(points[i]>maxPoint){
						maxPoint=points[i];
						max_i=i;
					
				}	
			}
		}
		
		//if the computer moves the area that it can be mated by player
		if(maxPoint>=-999 && maxPoint<=-991){
			setPlayerKnight(comX,comY,compX[max_i],compY[max_i]);
			comX=compX[max_i];
			comY=compY[max_i];
		}
		//if the computer moves empty and standard area
		else if(maxPoint>=2 && maxPoint<=9){
			setPlayerKnight(comX,comY,compX[max_i],compY[max_i]);
			comX=compX[max_i];
			comY=compY[max_i];
		}
		//if the computer moves the area that it  can mate the player
		else if(maxPoint>=999 && maxPoint<=1008){
			setPlayerKnight(comX,comY,compX[max_i],compY[max_i]);
			comX=compX[max_i];
			comY=compY[max_i];
		}
		//if there is no area that computer can go 
		else if(maxPoint==-1000)
			playerWin();
		//if there is one area that computer can go and 
		//that area has not any available area around it.
		else if(maxPoint==1){
			setPlayerKnight(comX,comY,compX[max_i],compY[max_i]);
			comX=compX[max_i];
			comY=compY[max_i];
			playerWin();
		}
	}			
	//Computer or player's available areas around him
	public int availableMoves(ImageView temp,int i,int j){
		
		int count = 0;  //count for the avaiblable areas
			
		//check computer's or player's knight's around
		if(i-2<numOfCol && j-1<numOfRow && i-2>=0 && j-1>=0){
			ImageView genTemp = (ImageView) findViewById(boardArray[i-2][j-1]);
			if(isSameDrawable(genTemp,R.drawable.black)||
			   isSameDrawable(genTemp,R.drawable.white)){
				count++;
			}
		}
		if(i-1<numOfCol && j-2<numOfRow && i-1>=0 && j-2>=0){
			ImageView genTemp = (ImageView) findViewById(boardArray[i-1][j-2]);
			if(isSameDrawable(genTemp,R.drawable.black)||
			   isSameDrawable(genTemp,R.drawable.white)){
				count++;
			}
		}
		if(i+1<numOfCol && j-2<numOfRow && i+1>=0 && j-2>=0){
			ImageView genTemp = (ImageView) findViewById(boardArray[i+1][j-2]);
			if(isSameDrawable(genTemp,R.drawable.black)||
			   isSameDrawable(genTemp,R.drawable.white)){
				count++;
			}
		}
		if(i+2<numOfCol && j-1<numOfRow && i+2>=0 && j-1>=0){
			ImageView genTemp = (ImageView) findViewById(boardArray[i+2][j-1]);
			if(isSameDrawable(genTemp,R.drawable.black)||
			   isSameDrawable(genTemp,R.drawable.white)){
				count++;
			}
		}
		if(i-2<numOfCol && j+1<numOfRow && i-2>=0 && j+1>=0){
			ImageView genTemp = (ImageView) findViewById(boardArray[i-2][j+1]);
			if(isSameDrawable(genTemp,R.drawable.black)||
			   isSameDrawable(genTemp,R.drawable.white)){
				count++;
			}
		}
		if(i-1<numOfCol && j+2<numOfRow && i-1>=0 && j+2>=0){
			ImageView genTemp = (ImageView) findViewById(boardArray[i-1][j+2]);
			if(isSameDrawable(genTemp,R.drawable.black)||
			   isSameDrawable(genTemp,R.drawable.white)){
				count++;
			}
		}
		if(i+1<numOfCol && j+2<numOfRow && i+1>=0 && j+2>=0){
			ImageView genTemp = (ImageView) findViewById(boardArray[i+1][j+2]);
			if(isSameDrawable(genTemp,R.drawable.black)||
			   isSameDrawable(genTemp,R.drawable.white)){
				count++;
			}
		}
		if(i+2<numOfCol && j+1<numOfRow && i+2>=0 && j+1>=0){
			ImageView genTemp = (ImageView) findViewById(boardArray[i+2][j+1]);
			if(isSameDrawable(genTemp,R.drawable.black)||
			   isSameDrawable(genTemp,R.drawable.white)){
				count++;
			}
		}
			
		return count;   //return available areas that are counted
	}	
	
	//if computer will be mated after that move by the player
	public boolean ifComWillMated(ImageView temp,int i,int j){
		
		//checks computer's around if player is here
		if(isWhite){
			if(i-2<numOfCol && j-1<numOfRow && i-2>=0 && j-1>=0){
				ImageView genTemp = (ImageView) findViewById(boardArray[i-2][j-1]);
				if(isSameDrawable(genTemp,R.drawable.white_on_black)||
				   isSameDrawable(genTemp,R.drawable.white_on_white)){
					return true;
				}
			}
			if(i-1<numOfCol && j-2<numOfRow && i-1>=0 && j-2>=0){
				ImageView genTemp = (ImageView) findViewById(boardArray[i-1][j-2]);
				if(isSameDrawable(genTemp,R.drawable.white_on_black)||
				   isSameDrawable(genTemp,R.drawable.white_on_white)){
					return true;
				}
			}
			if(i+1<numOfCol && j-2<numOfRow && i+1>=0 && j-2>=0){
				ImageView genTemp = (ImageView) findViewById(boardArray[i+1][j-2]);
				if(isSameDrawable(genTemp,R.drawable.white_on_black)||
				   isSameDrawable(genTemp,R.drawable.white_on_white)){
					return true;
				}
			}
			if(i+2<numOfCol && j-1<numOfRow && i+2>=0 && j-1>=0){
				ImageView genTemp = (ImageView) findViewById(boardArray[i+2][j-1]);
				if(isSameDrawable(genTemp,R.drawable.white_on_black)||
				   isSameDrawable(genTemp,R.drawable.white_on_white)){
					return true;
				}
			}
			if(i-2<numOfCol && j+1<numOfRow && i-2>=0 && j+1>=0){
				ImageView genTemp = (ImageView) findViewById(boardArray[i-2][j+1]);
				if(isSameDrawable(genTemp,R.drawable.white_on_black)||
				   isSameDrawable(genTemp,R.drawable.white_on_white)){
					return true;
				}
			}
			if(i-1<numOfCol && j+2<numOfRow && i-1>=0 && j+2>=0){
				ImageView genTemp = (ImageView) findViewById(boardArray[i-1][j+2]);
				if(isSameDrawable(genTemp,R.drawable.white_on_black)||
				   isSameDrawable(genTemp,R.drawable.white_on_white)){
					return true;
				}
			}
			if(i+1<numOfCol && j+2<numOfRow && i+1>=0 && j+2>=0){
				ImageView genTemp = (ImageView) findViewById(boardArray[i+1][j+2]);
				if(isSameDrawable(genTemp,R.drawable.white_on_black)||
				   isSameDrawable(genTemp,R.drawable.white_on_white)){
					return true;
				}
			}
			if(i+2<numOfCol && j+1<numOfRow && i+2>=0 && j+1>=0){
				ImageView genTemp = (ImageView) findViewById(boardArray[i+2][j+1]);
				if(isSameDrawable(genTemp,R.drawable.white_on_black)||
				   isSameDrawable(genTemp,R.drawable.white_on_white)){
					return true;
				}
			}
		}
		else{
			if(i-2<numOfCol && j-1<numOfRow && i-2>=0 && j-1>=0){
				ImageView genTemp = (ImageView) findViewById(boardArray[i-2][j-1]);
				if(isSameDrawable(genTemp,R.drawable.black_on_black)||
				   isSameDrawable(genTemp,R.drawable.black_on_white)){
					return true;
				}
			}
			if(i-1<numOfCol && j-2<numOfRow && i-1>=0 && j-2>=0){
				ImageView genTemp = (ImageView) findViewById(boardArray[i-1][j-2]);
				if(isSameDrawable(genTemp,R.drawable.black_on_black)||
				   isSameDrawable(genTemp,R.drawable.black_on_white)){
					return true;
				}
			}
			if(i+1<numOfCol && j-2<numOfRow && i+1>=0 && j-2>=0){
				ImageView genTemp = (ImageView) findViewById(boardArray[i+1][j-2]);
				if(isSameDrawable(genTemp,R.drawable.black_on_black)||
				   isSameDrawable(genTemp,R.drawable.black_on_white)){
					return true;
				}
			}
			if(i+2<numOfCol && j-1<numOfRow && i+2>=0 && j-1>=0){
				ImageView genTemp = (ImageView) findViewById(boardArray[i+2][j-1]);
				if(isSameDrawable(genTemp,R.drawable.black_on_black)||
				   isSameDrawable(genTemp,R.drawable.black_on_white)){
					return true;
				}
			}
			if(i-2<numOfCol && j+1<numOfRow && i-2>=0 && j+1>=0){
				ImageView genTemp = (ImageView) findViewById(boardArray[i-2][j+1]);
				if(isSameDrawable(genTemp,R.drawable.black_on_black)||
				   isSameDrawable(genTemp,R.drawable.black_on_white)){
					return true;
				}
			}
			if(i-1<numOfCol && j+2<numOfRow && i-1>=0 && j+2>=0){
				ImageView genTemp = (ImageView) findViewById(boardArray[i-1][j+2]);
				if(isSameDrawable(genTemp,R.drawable.black_on_black)||
				   isSameDrawable(genTemp,R.drawable.black_on_white)){
					return true;
				}
			}
			if(i+1<numOfCol && j+2<numOfRow && i+1>=0 && j+2>=0){
				ImageView genTemp = (ImageView) findViewById(boardArray[i+1][j+2]);
				if(isSameDrawable(genTemp,R.drawable.black_on_black)||
				   isSameDrawable(genTemp,R.drawable.black_on_white)){
					return true;
				}
			}
			if(i+2<numOfCol && j+1<numOfRow && i+2>=0 && j+1>=0){
				ImageView genTemp = (ImageView) findViewById(boardArray[i+2][j+1]);
				if(isSameDrawable(genTemp,R.drawable.black_on_black)||
				   isSameDrawable(genTemp,R.drawable.black_on_white)){
					return true;
				}
			}
			
		}
		
		return false; //if player is not around the computer function return false 
	}
	//SetContentView function's another version
	//there is View's id in it 
    public void setCurrentViewById(int id)
    {
        setContentView(id);
        currentViewId = id;
    }
    //Current View's ID getter function
    public int getCurrentViewById()
    {
        return currentViewId;
    }
    //Move the knight to the area that is determined
	public void setPlayerKnight(int i,int j,int new_i,int new_j){
		
		ImageView temp = (ImageView)findViewById(boardArray[new_i][new_j]);
		//move the knight for the computer
		if(i==comX && j==comY){
			if(isWhite){
				if(Math.abs(new_i-new_j)%2==0){
					temp.setImageResource(R.drawable.black_on_white);
					temp.setTag(R.drawable.black_on_white);
				}
				else{
					temp.setImageResource(R.drawable.black_on_black);
					temp.setTag(R.drawable.black_on_black);
				}
			}
			else{
				if(Math.abs(new_i-new_j)%2==0){
					temp.setImageResource(R.drawable.white_on_white);
					temp.setTag(R.drawable.white_on_white);
				}
				else{
					temp.setImageResource(R.drawable.white_on_black);						
					temp.setTag(R.drawable.white_on_black);
				}
			}
			//old area must be invalid area
			temp=(ImageView)findViewById(boardArray[i][j]);
			if(Math.abs(i-j)%2==0){
				temp.setImageResource(R.drawable.white_invalid);
				temp.setTag(R.drawable.white_invalid);
			}
			else{
				temp.setImageResource(R.drawable.black_invalid);
				temp.setTag(R.drawable.black_invalid);
			}
				
		}
		//move the knight for the player
		else{
			if(isWhite){
				if(Math.abs(new_i-new_j)%2==0){
					temp.setImageResource(R.drawable.white_on_white);
					temp.setTag(R.drawable.white_on_white);
				}
				else{
					temp.setImageResource(R.drawable.white_on_black);
					temp.setTag(R.drawable.white_on_black);
				}
			}
			else{
				if(Math.abs(new_i-new_j)%2==0){
					temp.setImageResource(R.drawable.black_on_white);
					temp.setTag(R.drawable.black_on_white);
				}
				else{
					temp.setImageResource(R.drawable.black_on_black);						
					temp.setTag(R.drawable.black_on_black);
				}
			}
			//old area must be invalid area
			temp=(ImageView)findViewById(boardArray[i][j]);
			if(Math.abs(i-j)%2==0){
				temp.setImageResource(R.drawable.white_invalid);
				temp.setTag(R.drawable.white_invalid);
			}
			else{
				temp.setImageResource(R.drawable.black_invalid);
				temp.setTag(R.drawable.black_invalid);
			}
		}
		
	
	}
	//check the area button's background to the drawable that is given with id
	public boolean isSameDrawable(ImageView but,int id)
	{
		Object tag = but.getTag();               
		int imageId = tag == null ? -1 : Integer.parseInt(but.getTag().toString());
		if(id==imageId)
			return true;
		else
			return false;
		
	}
	//check the computer mates the player
	public boolean isComMate(ImageView but,int id){
		Object tag = but.getTag();               
		int imageId = tag == null ? -1 : Integer.parseInt(but.getTag().toString());
		if(id==imageId){
			onProcess=false;
			return true;
		}
		else
			return false;
	}
	//check the player mates the computer
	public boolean isMate(ImageView but,int id){
		Object tag = but.getTag();               
		int imageId = tag == null ? -1 : Integer.parseInt(but.getTag().toString());
		if(id==imageId){
			gameIsOn = false;
			return true;
		}
		else
			return false;
	}
	
	private Integer[][] boardArray = new Integer[8][8];     //boardArray,it keeps board's button's id in it
	private boolean isWhite;							 	//if the player selects the white horse
	private int numOfCol;									//number of columns,it came from MainActivity
	private int numOfRow;									//number of rows,it came from MainActivity
	private boolean onProcess = true;						//if computer is mated flag
	private boolean gameIsOn = true;						//if player is mated flag
	private int comX=0,comY=0;								//computer's current position
	private int plaX,plaY;									//player's current position
	private ImageView selectedBut;							//player's current button that selected
	private int currentViewId = -1;							//currentView's id num
}
