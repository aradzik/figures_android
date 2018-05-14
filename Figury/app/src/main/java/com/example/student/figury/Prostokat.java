package com.example.student.figury;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;

class Rectangle{

    private double a,b;
    Rectangle(double _a, double _b){a=_a;b=_b;}

    double area(){
        double p=a*b;
        return p;

    }
}
public class Prostokat extends AppCompatActivity {

    public final static String RECTANGLE_RESULT = "Area of rectangle";
    public static int CODE_MENU = 10;
    int puste = 0;

    public void obliczClick(View v){

        double a,b;

        a = Double.parseDouble(((EditText)findViewById(R.id.bokA)).getText().toString());
        b = Double.parseDouble(((EditText)findViewById(R.id.bokB)).getText().toString());

        if(a > 0 && b>0){

            Rectangle Rec = new Rectangle(a,b);
            double area = Rec.area();
            puste = 0;

            ((TextView)findViewById(R.id.wynik)).setText(Double.toString(area));

        }
   else  {
            puste = 1;
            ((TextView)findViewById(R.id.wynik_pole)).setText("Nie da sie");
        }



    }

    public void dodajClick(View v){

        Menu.CODE = 2;
        if (puste == 0){
            String area_string = ((TextView)findViewById(R.id.wynik)).getText().toString();

            Intent backIntent = new Intent();
            backIntent.putExtra(RECTANGLE_RESULT, area_string);
            setResult(RESULT_OK, backIntent);
            finish();
        }
        else ((TextView)findViewById(R.id.wynik_pole)).setText("Puste pole");

    }

    public void anuluj(View v){

        Menu.CODE = 4;
        String area_string = ((TextView)findViewById(R.id.wynik)).getText().toString();

        Intent backIntent = new Intent();
        backIntent.putExtra(RECTANGLE_RESULT, area_string);
        setResult(RESULT_OK, backIntent);
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prostokat);
    }
}
