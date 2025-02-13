package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean gameactive=true;
    int activeplayer =0;
    int []gamestate={2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2};
    //player represantaton
    //0-x
    //1-0
    //game state:
    //0-x
    //1-o
    //2-null
        int [][]winpos={{0,1,2},{3,4,5},{6,7,8},
                        {0,3,6},{1,4,7},{2,5,8},
                        {0,4,8},{2,4,6}};
    public  void PlayerTap(View view){
        ImageView img= (ImageView) view;
        int tappedimage=Integer.parseInt(img.getTag().toString());
        if(!gameactive){
            gameReset(view);
        }
        if(isfull(gamestate)){
            gameReset(view);
        }
        if(gamestate[tappedimage]==2 && gameactive){
            gamestate[tappedimage]=activeplayer;
            img.setTranslationY(-1000f);
            if(activeplayer==0){
                img.setImageResource(R.drawable.x);
                TextView status=findViewById(R.id.textView2);
                status.setText("O's turn -Tap to play");
                activeplayer=1;
            }

            else {
                img.setImageResource(R.drawable.o);
                TextView status=findViewById(R.id.textView2);
                status.setText("x's turn -Tap to play");
                activeplayer=0;
            }
        }
        img.animate().translationY(10f).setDuration(300);
        //check if any player win
        for(int [] winpos :winpos){
            if(gamestate[winpos[1]] == gamestate[winpos[0]] && gamestate[winpos[1]]==gamestate[winpos[2]] && gamestate[winpos[1]]!=2){
                //somebody win
                //who
                String winner;
                gameactive=false;
                if(gamestate[winpos[0]]==0){
                    winner="X has Won";
                }
                else {
                    winner="O has won";
                }
                TextView status=findViewById(R.id.textView2);
                status.setText(winner);
            }
        }
    }
    public  void  gameReset(View view){
        gameactive=true;
        activeplayer=0;
        for(int i=0;i<gamestate.length;i++){
            gamestate[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        TextView status=findViewById(R.id.textView2);
        status.setText("x's turn -Tap to play");

    }
    public boolean isfull(int arr[]){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==2){
                return false;
            }
        }
        return  true;
    }
    ImageView i1,i2,i3,i4,i5,i6,i7,i8,i9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i1=findViewById(R.id.imageView1);
        i2=findViewById(R.id.imageView2);
        i3=findViewById(R.id.imageView3);
        i4=findViewById(R.id.imageView4);
        i5=findViewById(R.id.imageView5);
        i6=findViewById(R.id.imageView6);
        i7=findViewById(R.id.imageView7);
        i8=findViewById(R.id.imageView8);
        i9=findViewById(R.id.imageView9);










    }
}