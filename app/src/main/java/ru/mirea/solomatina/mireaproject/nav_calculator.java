package ru.mirea.solomatina.mireaproject;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class nav_calculator extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private EditText num1;
    private EditText num2;
    private TextView result;


    private String mParam1;
    private String mParam2;

    public nav_calculator() {
    }

    public static nav_calculator newInstance(String param1, String param2) {
        nav_calculator fragment = new nav_calculator();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_nav_calculator, container, false);

        Button sum = (Button) v.findViewById(R.id.sum);
        sum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                num1 = (EditText) v.findViewById(R.id.num);
                float fnum1 = Float.parseFloat(String.valueOf(num1.getText()));
                num2 = (EditText) v.findViewById(R.id.num2);
                float fnum2 = Float.parseFloat(String.valueOf(num2.getText()));
                result = (TextView) v.findViewById(R.id.textResult);
                float r = fnum1 + fnum2;
                result.setText(String.valueOf(r));
            }
        });

        Button subtraction = (Button) v.findViewById(R.id.subtraction);
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = (EditText) v.findViewById(R.id.num);
                float fnum1 = Float.parseFloat(String.valueOf(num1.getText()));
                num2 = (EditText) v.findViewById(R.id.num2);
                float fnum2 = Float.parseFloat(String.valueOf(num2.getText()));
                result = (TextView) v.findViewById(R.id.textResult);
                float r = fnum1 - fnum2;
                result.setText(String.valueOf(r));
            }
        });

        Button multiply = (Button) v.findViewById(R.id.multiply);
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = (EditText) v.findViewById(R.id.num);
                float fnum1 = Float.parseFloat(String.valueOf(num1.getText()));
                num2 = (EditText) v.findViewById(R.id.num2);
                float fnum2 = Float.parseFloat(String.valueOf(num2.getText()));
                result = (TextView) v.findViewById(R.id.textResult);
                float r = fnum1 * fnum2;
                result.setText(String.valueOf(r));
            }
        });

        Button del = (Button) v.findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = (EditText) v.findViewById(R.id.num);
                float fnum1 = Float.parseFloat(String.valueOf(num1.getText()));
                num2 = (EditText) v.findViewById(R.id.num2);
                float fnum2 = Float.parseFloat(String.valueOf(num2.getText()));
                result = (TextView) v.findViewById(R.id.textResult);
                float r = fnum1 / fnum2;
                result.setText(String.valueOf(r));
            }
        });
        return v;
    }
}