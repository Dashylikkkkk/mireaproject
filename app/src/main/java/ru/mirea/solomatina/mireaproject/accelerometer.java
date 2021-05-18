package ru.mirea.solomatina.mireaproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class accelerometer extends Fragment implements SensorEventListener {

    private TextView azimuthTextView;
    private TextView pitchTextView;
    private TextView rollTextView;
    private TextView gyroAzimuthTextView;
    private TextView gyroPitchTextView;
    private TextView gyroRollTextView;
    private TextView staticTextView;

    public accelerometer() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_accelerometer, container, false);
        super.onCreate(savedInstanceState);
        SensorManager sensorManager =
                (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);
        Sensor accelerometerSensor = sensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        Sensor temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        azimuthTextView = v.findViewById(R.id.textViewAzimuth);
        pitchTextView = v.findViewById(R.id.textViewPitch);
        rollTextView = v.findViewById(R.id.textViewRoll);
        gyroAzimuthTextView = v.findViewById(R.id.gyroTextViewAzimuth);
        gyroPitchTextView = v.findViewById(R.id.gyroTextViewPitch);
        gyroRollTextView = v.findViewById(R.id.gyroTextViewRoll);
        staticTextView = v.findViewById(R.id.isStaticView);
        sensorManager.registerListener(this, accelerometerSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, gyroscopeSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, temperatureSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        return v;
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float valueAzimuth = event.values[0];
            float valuePitch = event.values[1];
            float valueRoll = event.values[2];
            azimuthTextView.setText("Azimuth: " + valueAzimuth);
            pitchTextView.setText("Pitch: " + valuePitch);
            rollTextView.setText("Roll: " + valueRoll);
        }
        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE){
            float valueAzimuth = event.values[0];
            float valuePitch = event.values[1];
            float valueRoll = event.values[2];
            gyroAzimuthTextView.setText("Gyro X: " + valueAzimuth);
            gyroPitchTextView.setText("Gyro Y: " + valuePitch);
            gyroRollTextView.setText("Gyro Z: " + valueRoll);
        }
        if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE){
            float temperature = event.values[0];
            staticTextView.setText("Температура равняется " + temperature + " градусам цельсия");
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}