package com.example.toastdemo5;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity
{
    
    Random rnd = new Random();
    int num1 = 0;
    int score = 0;
    int num2 = 0;
    String ans1AsStr = "";
    int ans1Int = 0;
    String ans2AsStr = "";
    int ans2Int = 0;
    String ans3AsStr = "";
    int ans3Int = 0;
    //----------------------------------------------------------------
    Button btn1,btn2,btn3;
    ImageButton newGame;
    ImageView iv1,iv2,iv3;
    TextView firstNumQ1,firstNumQ2,firstNumQ3,secNumQ2,secNumQ1,secNumQ3;
    EditText ed1,ed2,ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        newGame = findViewById(R.id.imageButton2);
        //----------------------------------------------------------------
        iv1 = findViewById(R.id.imageView);
        iv2 = findViewById(R.id.imageView2);
        iv3 = findViewById(R.id.imageView3);
        //------------------------------------
        iv1.setImageResource(R.drawable.ic_launcher_background);
        iv2.setImageResource(R.drawable.ic_launcher_background);
        iv3.setImageResource(R.drawable.ic_launcher_background);
        //----------------------------------------------------------------
        firstNumQ1 = findViewById(R.id.textView2);
        firstNumQ2 = findViewById(R.id.textView3);
        firstNumQ3 = findViewById(R.id.textView4);
        secNumQ2 = findViewById(R.id.textView5);
        secNumQ1 = findViewById(R.id.textView6);
        secNumQ3 = findViewById(R.id.textView7);
        //----------------------------------------------------------------
        ed1 = findViewById(R.id.editTextNumber);
        ed2 = findViewById(R.id.editTextNumber2);
        ed3 = findViewById(R.id.editTextNumber3);
        //----------------------------------------------------------------

        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        newGame.setVisibility(View.INVISIBLE);
        firstNumQ2.setVisibility(View.INVISIBLE);
        firstNumQ3.setVisibility(View.INVISIBLE);
        secNumQ2.setVisibility(View.INVISIBLE);
        secNumQ3.setVisibility(View.INVISIBLE);
        iv1.setVisibility(View.INVISIBLE);
        iv2.setVisibility(View.INVISIBLE);
        iv3.setVisibility(View.INVISIBLE);
        ed2.setVisibility(View.INVISIBLE);
        ed3.setVisibility(View.INVISIBLE);
        //----------------------------------------------------------------
        num1 = rnd.nextInt(81)+10;
        num2 = rnd.nextInt(81)+10;
        firstNumQ1.setText( " " + num1);
        secNumQ1.setText(" " + num2);

    }
    //----------------------------------------------------------------
    public void ans1(View view)
    {
    }
    public void nextQuestion(View view)
    {
        ans1AsStr = ed1.getText().toString();
        if (!ans1AsStr.isEmpty())
        {
            ans1Int = Integer.parseInt(ans1AsStr);
            if (ans1Int == num1 + num2)
            {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                iv1.setVisibility(View.VISIBLE);
                iv1.setImageResource(R.drawable.v);
                score +=1;
            }
            else
            {
                Toast.makeText(this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
                iv1.setVisibility(View.VISIBLE);
                iv1.setImageResource(R.drawable.x);
            }
            num1 = num1 + num2;
            num2 = rnd.nextInt(89)+10;
            firstNumQ2.setText( "" + num1);
            secNumQ2.setText("" + num2);
            firstNumQ2.setVisibility(View.VISIBLE);
            secNumQ2.setVisibility(View.VISIBLE);
            ed2.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
        }
    }
//----------------------------------------------------------------
    public void ans2(View view)
    {
    }
    public void lastQuetion(View view)
    {
        ans2AsStr = ed2.getText().toString();
        if (!ans2AsStr.isEmpty())
        {
            ans2Int = Integer.parseInt(ans2AsStr);
            if (ans2Int == num1 + num2)
            {
                iv2.setVisibility(View.VISIBLE);
                iv2.setImageResource(R.drawable.v);
                score +=1;
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
            }
            else
            {
                iv2.setVisibility(View.VISIBLE);
                iv2.setImageResource(R.drawable.x);
                Toast.makeText(this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
            }
            num1 = num1+num2;
            num2 = rnd.nextInt(81)+10;
            firstNumQ3.setText( " " + num1);
            secNumQ3.setText(" " + num2);
            firstNumQ3.setVisibility(View.VISIBLE);
            secNumQ3.setVisibility(View.VISIBLE);
            ed3.setVisibility(View.VISIBLE);
            btn3.setVisibility(View.VISIBLE);
        }
    }

//----------------------------------------------------------------
    public void ans3(View view)
    {
    }
    public void button3(View view)
    {
        ans3AsStr = ed3.getText().toString();
        if (!ans3AsStr.isEmpty())
        {
            ans3Int = Integer.parseInt(ans3AsStr);
            if (ans3Int == num1 + num2)
            {
                iv3.setVisibility(View.VISIBLE);
                iv3.setImageResource(R.drawable.v);
                score +=1;
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
            }
            else
            {
                iv3.setVisibility(View.VISIBLE);
                iv3.setImageResource(R.drawable.x);
                Toast.makeText(this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
            }

            switch (score)
            {
                case 0:
                    newGame.setImageResource(R.drawable.score0);
                    Toast.makeText(this, "score: 0%", Toast.LENGTH_SHORT).show();

                    break;
                case 1:
                    newGame.setImageResource(R.drawable.score1);
                    Toast.makeText(this, "score: 33%", Toast.LENGTH_SHORT).show();

                    break;
                case 2:
                    newGame.setImageResource(R.drawable.score2);
                    Toast.makeText(this, "score: 66%", Toast.LENGTH_SHORT).show();

                    break;
                case 3:
                    newGame.setImageResource(R.drawable.score3);
                    Toast.makeText(this, "score: 100%", Toast.LENGTH_SHORT).show();

                    break;
            }
            newGame.setVisibility(View.VISIBLE);
        }

    }
//----------------------------------------------------------------`
    public void NewGame(View view)
    {
        num1 = rnd.nextInt(81) + 10;
        num2 = rnd.nextInt(81) + 10;
        score = 0;
        firstNumQ1.setText(" " + num1);
        secNumQ1.setText(" " + num2);
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        newGame.setVisibility(View.INVISIBLE);
        firstNumQ2.setVisibility(View.INVISIBLE);
        firstNumQ3.setVisibility(View.INVISIBLE);
        secNumQ2.setVisibility(View.INVISIBLE);
        secNumQ3.setVisibility(View.INVISIBLE);
        iv1.setVisibility(View.INVISIBLE);
        iv2.setVisibility(View.INVISIBLE);
        iv3.setVisibility(View.INVISIBLE);
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ed2.setVisibility(View.INVISIBLE);
        ed3.setVisibility(View.INVISIBLE);
    }

}
