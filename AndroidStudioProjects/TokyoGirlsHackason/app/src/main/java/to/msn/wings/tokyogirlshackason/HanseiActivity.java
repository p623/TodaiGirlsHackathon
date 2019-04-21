 package to.msn.wings.tokyogirlshackason;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

 public class HanseiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hansei);
    }


    public void selectAtsukatta(View view){

        // 今の相対体感温度を取得
        SharedPreferences sharedPreferences = getSharedPreferences("temp",MODE_PRIVATE);
        String characteristic = sharedPreferences.getString("性質", "普通");
        String currentTempStr = sharedPreferences.getString("体感温度", "0");
        int currentTemp = Integer.parseInt(currentTempStr);

        // 画面の入力に従って補正
        int nextTemp = currentTemp + 1;

        // 新しい相対体感温度を格納
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("体感温度", String.valueOf(nextTemp));
        editor.apply();

     TextView textview = (TextView)findViewById(R.id.editText5);
        textview.setText("アプリに情報を送信しました");

        }

     public void selectSamukatta(View view) {
         SharedPreferences sharedPreferences = getSharedPreferences("temp",MODE_PRIVATE);
         String characteristics = sharedPreferences.getString("性質", "普通");
         String currentTempStr = sharedPreferences.getString("体感温度", "0");
         int currentTemp = Integer.parseInt(currentTempStr);

         int nextTemp = currentTemp - 1;

         SharedPreferences.Editor editor = sharedPreferences.edit();
         editor.putString("体感温度", String.valueOf(nextTemp));
         editor.apply();
         TextView textview = (TextView)findViewById(R.id.editText5);
         textview.setText("アプリに情報を送信しました");

     }

     public void selectTyoudoyokatta(View view){
         SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
         String characteristics = sharedPreferences.getString("性質", "普通");
         String currentTempStr = sharedPreferences.getString("体感温度","0");
         int currentTemp = Integer.parseInt(currentTempStr);

         int nextTemp = currentTemp;

         SharedPreferences.Editor editor = sharedPreferences.edit();
         editor.putString("体感温度",String.valueOf(nextTemp));
         editor.apply();

         TextView textview = (TextView)findViewById(R.id.editText5);
         textview.setText("アプリに情報を送信しました");
     }
     public void selectModoru(View view){
         android.content.Intent intent = new Intent(HanseiActivity.this, SettingActivity.class);

         startActivity(intent);
     }




}
