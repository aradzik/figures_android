package com.example.student.figury;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;

class Wheel{

    private double r;
    Wheel(double _r){r=_r;}

    double area(){
        double p=(Math.PI)*(Math.pow(r,r)); ///zrobic wzor
        return p;

    }
}
public class Kolo extends AppCompatActivity {

    public final static String WHEEL_RESULT = "Area of wheel";
    public static int CODE_MENU = 10;

    public void obliczClick(View v){

        double a;

        a = Double.parseDouble(((EditText)findViewById(R.id.promien)).getText().toString());
        if(a>0){
            Wheel W = new Wheel(a);
            double area = W.area();

            ((TextView)findViewById(R.id.wynik)).setText(Double.toString(area));
        }
        else ((TextView)findViewById(R.id.wynik)).setText("Nie da sie");


    }

    public void dodajClick(View v){

        Menu.CODE = 3;
        String area_string = ((TextView)findViewById(R.id.wynik)).getText().toString();
        Intent backIntent = new Intent();
        backIntent.putExtra(WHEEL_RESULT, area_string);
        setResult(RESULT_OK, backIntent);
        finish();

    }

    public void anuluj(View v){


        Menu.CODE = 4;
        String area_string = ((TextView)findViewById(R.id.wynik)).getText().toString();
        Intent backIntent = new Intent();
        backIntent.putExtra(WHEEL_RESULT, area_string);
        setResult(RESULT_OK, backIntent);
        finish();




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolo);
    }
}
