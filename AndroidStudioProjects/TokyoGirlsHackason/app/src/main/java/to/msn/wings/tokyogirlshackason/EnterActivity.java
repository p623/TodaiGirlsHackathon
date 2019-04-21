package to.msn.wings.tokyogirlshackason;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class EnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
    }
    public void taikanTemp(View view) {


        //気温の取得
        TextView textView = (TextView)findViewById(R.id.editText4);
        int temp = Integer.parseInt(textView.getText().toString());

        //天気の取得
        int selectedTemp =0;
        Spinner item = (Spinner) findViewById(R.id.spinner);
        String selected = (String) item.getSelectedItem();
        if(selected.equals("晴れ")) {
            selectedTemp =2;
        } else if(selected.equals("晴れのち曇り")){
            selectedTemp =1;
        }else if(selected.equals("曇り")){
            selectedTemp =0;
        }else if(selected.equals("雨")){
            selectedTemp =-1;
        }else if(selected.equals("雪")){
            selectedTemp =-2;
        }

        //性質の取得
        int characteristicTemp = 0;
        SharedPreferences sharedPref = getSharedPreferences("temp",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        String characteristic = sharedPref.getString("性質", "");
        if(characteristic.equals("暑がり")) {
            characteristicTemp = 4;
        } else if(characteristic.equals("やや暑がり")){
            characteristicTemp = 2;
        } else if(characteristic.equals("普通")){
            characteristicTemp = 0;
        } else if(characteristic.equals("やや寒がり")){
            characteristicTemp = -2;
        } else if(characteristic.equals("寒がり")){
            characteristicTemp = -4;
        }

        // 体感温度,反省の取得
        String hanseiTempStr = sharedPref.getString("体感温度", "0");
        int hanseiTemp = Integer.parseInt(hanseiTempStr);
        int taikanTemp = temp + characteristicTemp +selectedTemp+hanseiTemp;

        //体感温度出力

        TextView textView2 = (TextView) findViewById(R.id.editText5);
        textView2.setText("体感温度は" + taikanTemp + "℃です");

        //ページの移動
        android.content.Intent intent = new Intent(EnterActivity.this, SuggestActivity.class);
        intent.putExtra("Temp",String.valueOf(taikanTemp));
        startActivity(intent);
    }



}
