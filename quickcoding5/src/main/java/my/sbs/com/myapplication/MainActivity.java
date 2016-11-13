package my.sbs.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText edit01;
    Button inputB, completeB, initB;
    TextView tv01, tv02;
    GenericStorNum<String, Integer> genstrornum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit01 = (EditText)findViewById(R.id.edit01);
        inputB = (Button)findViewById(R.id.inputB);
        completeB = (Button)findViewById(R.id.completeB);
        initB = (Button)findViewById(R.id.initB);
        tv01 = (TextView)findViewById(R.id.tv01);
        tv02 = (TextView)findViewById(R.id.tv02);

        genstrornum = new GenericStorNum<String, Integer>();

        inputB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = edit01.getText().toString();
                int temp_int;
                String temp_string;
                try{
                    temp_int = Integer.parseInt(temp);
                    genstrornum.addListNumber(temp_int);
                }catch(NumberFormatException e){
                    genstrornum.addListString(temp);
                }
            }
        });
        completeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv01.setText(genstrornum.ShowListString());
                tv02.setText(genstrornum.ShowListNumber());

            }
        });
        initB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genstrornum.deleteList();
            }
        });
    }
}


