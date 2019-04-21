package to.msn.wings.tokyogirlshackason;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AtsugariActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectAtsugari(View view) {
        SharedPreferences sharedPref = getSharedPreferences("temp",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("性質","暑がり");
        editor.apply();

        TextView textView = (TextView)findViewById(R.id.editText6);
        textView.setText("暑がりに設定しました");
    }
    public void selectYayaAtsugari(View view) {
        SharedPreferences sharedPref = getSharedPreferences("temp",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("性質","やや暑がり");
        editor.apply();

        TextView textView = (TextView)findViewById(R.id.editText6);
        textView.setText("やや暑がりに設定しました");
    }
    public void selectFutuu(View view) {
        SharedPreferences sharedPref = getSharedPreferences("temp",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("性質","普通");
        editor.apply();

        TextView textView = (TextView)findViewById(R.id.editText6);
        textView.setText("普通に設定しました");

    }
    public void selectYayaSamugari(View view) {
        SharedPreferences sharedPref = getSharedPreferences("temp",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("性質","やや寒がり");
        editor.apply();

        TextView textView = (TextView)findViewById(R.id.editText6);
        textView.setText("やや寒がりに設定しました");
    }
    public void selectSamugari(View view) {
        SharedPreferences sharedPref = getSharedPreferences("temp",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("性質","寒がり");
        editor.apply();

        TextView textView = (TextView)findViewById(R.id.editText6);
        textView.setText("寒がりに設定しました");
    }

    public void returnSettings(View view) {
        android.content.Intent intent = new Intent(AtsugariActivity.this, SettingActivity.class);

        startActivity(intent);
    }
}
