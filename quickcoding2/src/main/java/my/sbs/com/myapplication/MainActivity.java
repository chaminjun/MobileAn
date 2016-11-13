package my.sbs.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {

    TextView tv01;
    EditText edit1;
    Button send, bigger, smaller, bingo;
    Random mRand = new Random();

    int min_num = 0;
    int max_num = 100;
    int key_num;
    int search_num;

    int ran_num = mRand.nextInt(100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv01 = (TextView)findViewById(R.id.tv01);
        edit1 = (EditText)findViewById(R.id.edit1);

        send = (Button)findViewById(R.id.send);
        bigger = (Button)findViewById(R.id.bigger);
        smaller = (Button)findViewById(R.id.smaller);
        bingo = (Button)findViewById(R.id.bingo);



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key_num = Integer.parseInt(String.valueOf(edit1.getText()));
                tv01.setText("Your Number is "+ran_num+"?");
                search_num = ran_num;
            }
        });
        bigger.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(key_num != search_num){
                    min_num = search_num + 1;
                    search_num = (min_num + max_num) / 2;
                    tv01.setText("설마..."+search_num+"...?!");
                }

            }
        });
        smaller.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(key_num != search_num){
                    max_num = search_num - 1;
                    search_num = (min_num + max_num) / 2;
                    tv01.setText("설마...."+search_num+"...?");
                }

            }
        });
        bingo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(key_num == search_num){
                    tv01.setText("이걸 맞추다니?");
                }

            }
        });
    }
}
