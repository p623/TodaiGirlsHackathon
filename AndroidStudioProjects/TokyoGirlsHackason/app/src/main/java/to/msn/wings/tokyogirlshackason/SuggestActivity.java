package to.msn.wings.tokyogirlshackason;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SuggestActivity extends AppCompatActivity {

    Clothes cort = new Clothes("アウター","コート",true,true,true,true,true,false,false,false,false,false,false);
    Clothes jacket = new Clothes("アウター","ジャケット",true,true,true,true,true,true,false,false,false,false,false);
    Clothes cardiganUsude = new Clothes("羽織物","カーディガン(薄手)",false,false,false,false,true,true,true,true,false,false,false);
    Clothes cardiganAtsude = new Clothes("羽織物","カーディガン(厚手)",true,true,true,true,true,false,false,false,false,false,false);
    Clothes sweaterUsude = new Clothes("羽織物","セーター(薄手)",false,false,false,false,true,true,true,true,false,false,false);
    Clothes sweaterAtsude = new Clothes("羽織物","セーター(厚手)",true,true,true,true,true,false,false,false,false,false,false);
    Clothes nagasodeT = new Clothes("トップス","長袖Tシャツ",false,false,false,false,false,true,true,true,false,false,false);
    Clothes hansodeT = new Clothes("トップス","半袖Tシャツ",false,false,false,false,false,false,false,true,true,true,true);
    Clothes tanktop = new Clothes("トップス","タンクトップ",false,false,false,false,false,false,false,false,true,true,true);
    Clothes zubonAtsude =new Clothes("ボトムス","長ズボン(厚手)",true,true,true,true,true,false,false,false,false,false,false);
    Clothes zubonUsude =new Clothes("ボトムス","長ズボン(薄手)",false,false,false,false,true,true,true,true,false,false,false);
    Clothes shortPants =new Clothes("ボトムス","ショートパンツ",false,false,false,false,false,false,false,true,true,true,true);
    Clothes miniSkirt =new Clothes("ボトムス","ミニスカート",false,false,false,false,false,false,false,true,true,true,true);
    Clothes longSkirt = new Clothes("ボトムス","ロングスカート",true,true,true,true,true,true,true,true,false,false,false);
    Clothes onepieceNagasode =new Clothes("ワンピース","ワンピース(長袖)",true,true,true,true,true,true,true,false,false,false,false);
    Clothes onepieceHansode = new Clothes("ワンピース","ワンピース(半袖)",false,false,false,false,false,false,false,true,true,true,true);
    List<Clothes> clothesList = new ArrayList<Clothes>();

    void prepareClothesList() {
        clothesList.add(cort);
        clothesList.add(jacket);
        clothesList.add(cardiganUsude);
        clothesList.add(cardiganAtsude);
        clothesList.add(sweaterUsude);
        clothesList.add(sweaterAtsude);
        clothesList.add(nagasodeT);
        clothesList.add(hansodeT);
        clothesList.add(tanktop);
        clothesList.add(zubonAtsude);
        clothesList.add(zubonUsude);
        clothesList.add(shortPants);
        clothesList.add(miniSkirt);
        clothesList.add(longSkirt);
        clothesList.add(onepieceNagasode);
        clothesList.add(onepieceHansode);
    }

    List<MyClothes> createMyClothesList() {
        List<MyClothes> myClothesList= new ArrayList<MyClothes>();
        SharedPreferences sharedPref = getSharedPreferences("temp",MODE_PRIVATE);
        Map<String, ?> sharedPrefMap = sharedPref.getAll();
        for(String key : sharedPrefMap.keySet()) {
            if(key != null && key.startsWith("服") && key.endsWith("カテゴリ")) {
                MyClothes clothes = new MyClothes();
                clothes.id = key.replace("カテゴリ", "").replace("服", "");
                clothes.category = (String)sharedPrefMap.get(key);
                clothes.uri = (String)sharedPrefMap.get(key.replace("カテゴリ", "ファイルパス"));
                myClothesList.add(clothes);
            }
        }
        return myClothesList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        prepareClothesList();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);
        Intent intent =getIntent();
        String taikanTemp=intent.getStringExtra("Temp");
//        TextView textView3 = (TextView) findViewById(R.id.editText2);
//        textView3.setText("体感温度は" + taikanTemp + "す");

    }

    public void MenuModoru(View view){
        android.content.Intent intent = new Intent(SuggestActivity.this, SettingActivity.class);

        startActivity(intent);
    }

    protected void suggest(View view) {
        Intent intent =getIntent();
        String taikanTemp=intent.getStringExtra("Temp");
//        TextView textView3 = (TextView) findViewById(R.id.editText2);
//        textView3.setText("体感温度は" + taikanTemp + "℃です");

        // 体感温度を決定
        int taikanTempInt = Integer.parseInt(taikanTemp);
        // 対象となる服の種類リストを取得
//        List<Clothes> targetClothesTypeList = this.createCurrentTargetClothesTypeList(taikanTempInt);
//        // 自分の服のリストを作成
//        List<MyClothes> myClothesList = this.createMyClothesList();
//        // マッチングして服を推薦
//        List<MyClothes> recommendClothesList = this.createRecommend(targetClothesTypeList, myClothesList);
//
//        try {
//            MyClothes c0 = (recommendClothesList.size() > 0 ? recommendClothesList.get(0) : null);
//            if (c0 != null) {
//                TextView textReccomend1 = (TextView) findViewById(R.id.viewRecommendText1);
//                textReccomend1.setText(c0.toString());
//                ImageView viewRecommend1 = (ImageView) findViewById(R.id.viewRecommend1);
//                Bitmap bmp = getBitmapFromUri(Uri.parse(c0.uri));
//                viewRecommend1.setImageBitmap(bmp);
//            }
//            MyClothes c1 = (recommendClothesList.size() > 1 ? recommendClothesList.get(1) : null);
//            if (c1 != null) {
//                TextView textReccomend2 = (TextView) findViewById(R.id.viewRecommendText2);
//                textReccomend2.setText(c1.toString());
//                ImageView viewRecommend2 = (ImageView) findViewById(R.id.viewRecommend2);
//                Bitmap bmp = getBitmapFromUri(Uri.parse(c1.uri));
//                viewRecommend2.setImageBitmap(bmp);
//            }
//            MyClothes c2 = (recommendClothesList.size() > 2 ? recommendClothesList.get(2) : null);
//            if (c2 != null) {
//                TextView textReccomend3 = (TextView) findViewById(R.id.viewRecommendText3);
//                textReccomend3.setText(c1.toString());
//                ImageView viewRecommend3 = (ImageView) findViewById(R.id.viewRecommend3);
//                Bitmap bmp = getBitmapFromUri(Uri.parse(c2.uri));
//                viewRecommend3.setImageBitmap(bmp);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }

    private List<MyClothes> createRecommend(List<Clothes> aTargetClothesTypeList, List<MyClothes> aMyClothesList) {

        List<MyClothes> recommendClothesList = new ArrayList<MyClothes>();

        // "アウター"
        for(Clothes targetClothesType : aTargetClothesTypeList) {
            if("アウター".equals(targetClothesType.category)) {
                // アウターで持っている服を取得
                List<MyClothes> targetMyClothesList = new ArrayList<MyClothes>();
                for(MyClothes myClothesTemp : aMyClothesList) {
                    if(targetClothesType.name.equals(myClothesTemp.category)) {
                        targetMyClothesList.add(myClothesTemp);
                    }
                }
                // 乱数取得
                if(targetMyClothesList.size() > 0) {
                    int rand = new Random().nextInt(targetMyClothesList.size());
                    recommendClothesList.add(targetMyClothesList.get(rand));
                }
            }
        }

        // "羽織物"
        for(Clothes targetClothesType : aTargetClothesTypeList) {
            if("羽織物".equals(targetClothesType.category)) {
                // 羽織物で持っている服を取得
                List<MyClothes> targetMyClothesList = new ArrayList<MyClothes>();
                for(MyClothes myClothesTemp : aMyClothesList) {
                    if(targetClothesType.name.equals(myClothesTemp.category)) {
                        targetMyClothesList.add(myClothesTemp);
                    }
                }
                // 乱数取得
                if(targetMyClothesList.size() > 0) {
                    int rand = new Random().nextInt(targetMyClothesList.size());
                    recommendClothesList.add(targetMyClothesList.get(rand));
                }
            }
        }

        // "トップス" + "ボトムス" or "ワンピース"
        MyClothes onepieceClothes = null;
        MyClothes topsClothes = null;
        MyClothes bottomsClothes = null;
        int numOfOnepiece = 0;
        int numOfTops = 0;
        int numOfBottomes = 0;

        for(Clothes targetClothesType : aTargetClothesTypeList) {
            if("ワンピース".equals(targetClothesType.category)) {
                // ワンピースで持っている服を取得
                List<MyClothes> targetMyClothesList = new ArrayList<MyClothes>();
                for(MyClothes myClothesTemp : aMyClothesList) {
                    if(targetClothesType.name.equals(myClothesTemp.category)) {
                        targetMyClothesList.add(myClothesTemp);
                        numOfOnepiece++;
                    }
                }
                // 乱数取得
                if(targetMyClothesList.size() > 0) {
                    int rand = new Random().nextInt(targetMyClothesList.size());
                    onepieceClothes = targetMyClothesList.get(rand);
                }
            }
        }

        for(Clothes targetClothesType : aTargetClothesTypeList) {
            if("トップス".equals(targetClothesType.category)) {
                // トップスの服を取得
                List<MyClothes> targetMyClothesList = new ArrayList<MyClothes>();
                for(MyClothes myClothesTemp : aMyClothesList) {
                    if(targetClothesType.name.equals(myClothesTemp.category)) {
                        targetMyClothesList.add(myClothesTemp);
                        numOfTops++;
                    }
                }
                // 乱数取得
                if(targetMyClothesList.size() > 0) {
                    int rand = new Random().nextInt(targetMyClothesList.size());
                    topsClothes = targetMyClothesList.get(rand);
                }
            }
        }
        for(Clothes targetClothesType : aTargetClothesTypeList) {
            if("ボトムス".equals(targetClothesType.category)) {
                // トップスの服を取得
                List<MyClothes> targetMyClothesList = new ArrayList<MyClothes>();
                for(MyClothes myClothesTemp : aMyClothesList) {
                    if(targetClothesType.name.equals(myClothesTemp.category)) {
                        targetMyClothesList.add(myClothesTemp);
                        numOfBottomes++;
                    }
                }
                // 乱数取得
                if(targetMyClothesList.size() > 0) {
                    int rand = new Random().nextInt(targetMyClothesList.size());
                    bottomsClothes = targetMyClothesList.get(rand);
                }
            }
        }

        if(onepieceClothes == null && topsClothes == null && bottomsClothes == null) {
            // 服が無い為、サジェストしない
        } else if (onepieceClothes == null) {
            // ワンピースが無い場合は、トップス・ボトムスを推薦
            recommendClothesList.add(topsClothes);
            recommendClothesList.add(bottomsClothes);
        } else if (topsClothes == null || bottomsClothes == null) {
            // トップス・ボトムスが両方無い場合、ワンピースを推薦
            recommendClothesList.add(onepieceClothes);
        } else {
            // 種類の数に応じて乱数で決定
            int numOfTopsAndBottomsSet = (numOfTops > numOfBottomes ? numOfBottomes : numOfTops);
            double rateOfTopsAndBottoms = numOfTopsAndBottomsSet / (numOfTopsAndBottomsSet + numOfOnepiece);
            double rand = new Random().nextDouble();
            if(rateOfTopsAndBottoms > rand) {
                // トップス・ボトムスを推薦
                recommendClothesList.add(topsClothes);
                recommendClothesList.add(bottomsClothes);
            } else {
                // ワンピースを推薦
                recommendClothesList.add(onepieceClothes);
            }
        }

        return recommendClothesList;
    }

    private List<Clothes> createCurrentTargetClothesTypeList(int taikanTempInt) {
        List<Clothes> targetClothesList = new ArrayList<Clothes>();
        if(taikanTempInt > 35) {
            for(Clothes clothes : clothesList) {
                if(clothes.temp40 == true) {
                    targetClothesList.add(clothes);
                }
            }
        } else if(taikanTempInt > 30) {
            for(Clothes clothes : clothesList) {
                if(clothes.temp35 == true) {
                    targetClothesList.add(clothes);
                }
            }
        }else if(taikanTempInt > 25) {
            for(Clothes clothes : clothesList) {
                if(clothes.temp30 == true) {
                    targetClothesList.add(clothes);
                }
            }
        }else if(taikanTempInt > 20) {
            for(Clothes clothes : clothesList) {
                if(clothes.temp25 == true) {
                    targetClothesList.add(clothes);
                }
            }
        }else if(taikanTempInt > 15) {
            for(Clothes clothes : clothesList) {
                if(clothes.temp20 == true) {
                    targetClothesList.add(clothes);
                }
            }
        }else if(taikanTempInt > 10) {
            for(Clothes clothes : clothesList) {
                if(clothes.temp15 == true) {
                    targetClothesList.add(clothes);
                }
            }
        }else if(taikanTempInt > 5) {
            for(Clothes clothes : clothesList) {
                if(clothes.temp10 == true) {
                    targetClothesList.add(clothes);
                }
            }
        }else if(taikanTempInt > 0) {
            for(Clothes clothes : clothesList) {
                if(clothes.temp5 == true) {
                    targetClothesList.add(clothes);
                }
            }
        }else if(taikanTempInt > -5) {
            for(Clothes clothes : clothesList) {
                if(clothes.temp0 == true) {
                    targetClothesList.add(clothes);
                }
            }
        }else if(taikanTempInt > -10) {
            for(Clothes clothes : clothesList) {
                if(clothes.tempMinus5 == true) {
                    targetClothesList.add(clothes);
                }
            }
        }else if(taikanTempInt <= -10) {
            for(Clothes clothes : clothesList) {
                if(clothes.tempMinus10 == true) {
                    targetClothesList.add(clothes);
                }
            }
        }
        return targetClothesList;
    }

}

