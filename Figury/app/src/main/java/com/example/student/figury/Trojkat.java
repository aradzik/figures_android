package com.example.student.figury;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.content.Intent;

class Triangle{

    private double a,b,c;
    Triangle(double _a, double _b, double _c){ a=_a; b=_b; c=_c;}


    double area(){ //wzor Herona

        if(a+b>c && a+c>b && b+c>a){

            double p=(a+b+c)/2.0;
            double w=(p-a)*(p-b)*(p-c)*p;
            return Math.sqrt(w);
        }
        else return 0;
    }
}

public class Trojkat extends AppCompatActivity {

    public final static String TRIANGLE_RESULT = "Area of triangle";
    public static int CODE_MENU = 10;

    public void obliczClick(View v){

        double a,b,c;

        a = Double.parseDouble(((EditText)findViewById(R.id.bokA)).getText().toString());
        b = Double.parseDouble(((EditText)findViewById(R.id.bokB)).getText().toString());
        c = Double.parseDouble(((EditText)findViewById(R.id.bokC)).getText().toString());


        Triangle T = new Triangle(a,b,c);
        double area = T.area();

        if(T.area() == 0){
            ((TextView)findViewById(R.id.wynik_pole)).setText("Nie da sie");
        }
        else {
            ((TextView)findViewById(R.id.wynik_pole)).setText(Double.toString(area));
        }

    }

    public void dodajClick(View v){

        Menu.CODE = 1;

        String area_string = ((TextView)findViewById(R.id.wynik_pole)).getText().toString();

        Intent backIntent = new Intent();
        backIntent.putExtra(TRIANGLE_RESULT, area_string);
        setResult(RESULT_OK, backIntent);
        finish();

    }
    public void anuluj(View v){

        Menu.CODE = 4;

        String area_string = ((TextView)findViewById(R.id.wynik_pole)).getText().toString();

        Intent backIntent = new Intent();
        backIntent.putExtra(TRIANGLE_RESULT, area_string);
        setResult(RESULT_OK, backIntent);
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trojkat);

    }
}
