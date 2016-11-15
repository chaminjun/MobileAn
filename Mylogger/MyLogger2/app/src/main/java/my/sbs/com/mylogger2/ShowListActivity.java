package my.sbs.com.mylogger2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chaminjun on 2016. 11. 16..
 */

public class ShowListActivity extends ActionBarActivity {

    ArrayList<MyDataBaseIntent> mbi = new ArrayList<>();
    String category1[] = {"Study", "Meeting", "Health", "Eating", "etc"};
    final MyDB mydb = new MyDB(this);
    int num_study = 0;
    int num_meeting = 0;
    int num_health = 0;
    int num_eating = 0;
    int num_etc = 0;
    double sum = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        mydb.showMyMap(mbi);

        for (int i = 0; i < mbi.size(); i++) {
            int temp_num = mbi.get(i).category;
            switch (temp_num) {
                case 0:
                    num_study++;
                    break;
                case 1:
                    num_meeting++;
                    break;
                case 2:
                    num_health++;
                    break;
                case 3:
                    num_eating++;
                    break;
                case 4:
                    num_etc++;
                    break;
            }
        }
        int temp = 0;
        int biggestnum = num_study;

        if(biggestnum < num_meeting){
            biggestnum = num_meeting;
            temp = 1;
        }
        else if(biggestnum < num_health) {
            biggestnum = num_health;
            temp = 2;
        }
        else if(biggestnum < num_eating){
            biggestnum = num_eating;
            temp = 3;
        }
        else if(biggestnum < num_etc){
            biggestnum = num_etc;
            temp = 4;
        }

        sum = num_study + num_meeting + num_health + num_eating + num_etc;

        TextView ltv01 = (TextView) findViewById(R.id.ltv01);
        TextView ltv02 = (TextView) findViewById(R.id.ltv02);
        TextView ltv03 = (TextView) findViewById(R.id.ltv03);
        TextView ltv04 = (TextView) findViewById(R.id.ltv04);
        TextView ltv05 = (TextView) findViewById(R.id.ltv05);
        TextView whatbig = (TextView) findViewById(R.id.whatbig);

        ltv01.setText(num_study+"번 하셨군요! ("+Math.round((num_study/sum)*100)+"%)");
        ltv02.setText(num_meeting+"번 하셨군요! ("+Math.round((num_meeting/sum)*100)+"%)");
        ltv03.setText(num_health+"번 하셨군요! ("+Math.round((num_health/sum)*100)+"%)");
        ltv04.setText(num_eating+"번 하셨군요! ("+Math.round((num_eating/sum)*100)+"%)");
        ltv05.setText(num_etc+"번 하셨군요! ("+Math.round((num_etc/sum)*100)+"%)");

        whatbig.setText("'"+category1[temp]+"'를 "+biggestnum+"회로 가장 많이 하셨습니다~");
    }
}
