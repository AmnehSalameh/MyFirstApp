package com.example.amoon.randomnumbergame;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
int RandomNumber;
    TextView view ,res;
    EditText inp  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RandomNumber=SelectRand();
        inp=(EditText) findViewById(R.id.inp);
        res=(TextView) findViewById(R.id.res);

        Button check=(Button) findViewById(R.id.check);
        final Button restart=(Button) findViewById(R.id.restart);
        restart.setTextColor(Color.GRAY);
        restart.setEnabled(false);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int userNum = Integer.parseInt(inp.getText().toString());

                System.out.println(RandomNumber);
                if (RandomNumber == userNum) {
                    res.setText("Equal");
                    restart.setEnabled(true);
                    restart.setTextColor(Color.rgb(13,27,74));
                } else {
                    if (RandomNumber > userNum)
                        res.setText("smaller");
                    else if (RandomNumber < userNum)
                        res.setText("greater");
                    if (Math.abs(RandomNumber - userNum) < 5) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Very Close", Toast.LENGTH_LONG);

                        toast.show();
                    }
                }
            }
        });
       restart.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          RandomNumber=SelectRand();
                                          res.setText("");
                                          inp.setText("");
                                          restart.setEnabled(false);
                                      }
                                  }
       );
    }

public  int SelectRand(){
    int num=(int)(Math.random()*1000+1);
    return num;

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
