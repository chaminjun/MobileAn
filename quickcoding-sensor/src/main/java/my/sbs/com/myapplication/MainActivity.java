package my.sbs.com.myapplication;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

    private SensorManager sm;
    private Sensor sensor_gravity, sensor_accelerometer,
            sensor_linear_acceleration, sensor_gyroscope;
    TextView gtv01, gtv02, gtv03;
    TextView atv01, atv02, atv03;
    TextView latv01, latv02, latv03;
    TextView gytv01, gytv02, gytv03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor_gravity = sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensor_accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor_linear_acceleration = sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensor_gyroscope = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        gtv01 = (TextView)findViewById(R.id.gtv01);
        gtv02 = (TextView)findViewById(R.id.gtv02);
        gtv03 = (TextView)findViewById(R.id.gtv03);
        atv01 = (TextView)findViewById(R.id.atv01);
        atv02 = (TextView)findViewById(R.id.atv02);
        atv03 = (TextView)findViewById(R.id.atv03);
        latv01 = (TextView)findViewById(R.id.latv01);
        latv02 = (TextView)findViewById(R.id.latv02);
        latv03 = (TextView)findViewById(R.id.latv03);
        gytv01 = (TextView)findViewById(R.id.gytv01);
        gytv02 = (TextView)findViewById(R.id.gytv02);
        gytv03 = (TextView)findViewById(R.id.gytv03);

    }

    @Override
    protected void onResume(){
        super.onResume();
        sm.registerListener(this, sensor_gravity, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, sensor_accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, sensor_linear_acceleration, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, sensor_gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();

        //센서 리스너 해제
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()) {
            case Sensor.TYPE_GRAVITY:
                gtv01.setText("X : " + event.values[0]);
                gtv02.setText("Y : " + event.values[1]);
                gtv03.setText("Z : " + event.values[2]);
                break;
            case Sensor.TYPE_ACCELEROMETER:
                atv01.setText("X : " + event.values[0]);
                atv02.setText("Y : " + event.values[1]);
                atv03.setText("Z : " + event.values[2]);
                break;
            case Sensor.TYPE_LINEAR_ACCELERATION:
                latv01.setText("X : " + event.values[0]);
                latv02.setText("Y : " + event.values[1]);
                latv03.setText("Z : " + event.values[2]);
                break;
            case Sensor.TYPE_GYROSCOPE:
                gytv01.setText("X : " + event.values[0]);
                gytv02.setText("Y : " + event.values[1]);
                gytv03.setText("Z : " + event.values[2]);
                break;

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
