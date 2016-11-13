package my.sbs.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import static my.sbs.com.myapplication.Getre.arr;



abstract class Getre
{
    static int arr[] = {2,3,9,8,5,7};
    public abstract String getResult();
}

class GetMin extends Getre
{
    @Override
    public String getResult() {
        Arrays.sort(arr);
        int min = arr[0];
        return ""+min;
    }
}

class GetAve extends Getre
{
    @Override
    public String getResult() {
        double average = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
            sum += arr[i];
        average = sum / arr.length;

        return ""+average;
    }
}

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {    // 애플리케이션이 처음 생성될때 실행
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // resource아이디가 파라미터로 들어가게 된다.

        TextView t01 = (TextView) findViewById(R.id.tx1);
        String str1 = "Current Value.....";

        TextView t02 = (TextView) findViewById(R.id.tx2);
        String str2 = Arrays.toString(arr);

        t01.setText(str1);
        t02.setText(str2);

        Button MyButton1 = (Button) findViewById(R.id.bt1);
        Button MyButton2 = (Button) findViewById(R.id.bt2);

        MyButton1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Getre gm1 = new GetMin();
                //내부 클래스이므로 외부에서 선언된 String값의 Scope에서 벗어난다
                Toast.makeText(getApplicationContext(), "최솟값 버튼이 눌렸어용~\n결과는!! "+gm1.getResult(),
                        Toast.LENGTH_SHORT).show();
            }
        });


        MyButton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Getre gv1 = new GetAve();
                Toast.makeText(getApplicationContext(), "평균 버튼이 눌렸어용~\n결과는!! "+gv1.getResult(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
