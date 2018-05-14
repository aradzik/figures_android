package com.example.student.figury;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.TextView;


public class Menu extends AppCompatActivity {

    public static int CODE_TROJKAT = 11;
    public static int CODE_PROSTOKAT = 12;
    public static int CODE_KOLO = 13;

    public static int CODE;
    double area;


    public void trojkatClick(View v){

        Intent trojkatIntent = new Intent(this,Trojkat.class);
        startActivityForResult(trojkatIntent, CODE_TROJKAT);
    }
    public void prostokatClick(View v){

        Intent prostokatIntent = new Intent(this,Prostokat.class);
        startActivityForResult(prostokatIntent, CODE_PROSTOKAT);
    }
    public void koloClick(View v){

        Intent koloIntent = new Intent(this,Kolo.class);
        startActivityForResult(koloIntent, CODE_KOLO);
    }

    public void resetClick(View v){
        area = 0;
        Intent menuIntent = new Intent(this,Menu.class);
        startActivityForResult(menuIntent, 13);
    }

    //@override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode,resultCode,data);
        java.text.DecimalFormat pole = new java.text.DecimalFormat();
        pole.setMaximumFractionDigits(2);
        pole.setMinimumFractionDigits(4);


        if(CODE == 1){
            String new_area = data.getStringExtra(Trojkat.TRIANGLE_RESULT);  //odwolanie do trojakt.java
            area += Double.parseDouble(new_area);
        }
        if(CODE ==2){
            String new_area = data.getStringExtra(Prostokat.RECTANGLE_RESULT);
            area += Double.parseDouble(new_area);
        }
        if(CODE==3){
            String new_area = data.getStringExtra(Kolo.WHEEL_RESULT);
            area += Double.parseDouble(new_area);
        }
        if(CODE==4){
            String new_area = "0";
            area += Double.parseDouble(new_area);
        }

        ((TextView)findViewById(R.id.suma_pol_txt)).setText(pole.format(area));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
}


