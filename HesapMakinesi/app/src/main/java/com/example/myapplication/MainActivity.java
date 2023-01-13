package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTxtBirinciSayi, editTxtIkinciSayi;
    private TextView txtSonuc;
    private String birinciSayi, ikinciSayi;
    private int s1, s2, sonuc;
    private Hesapla hesapla; //class çağırıldı

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTxtBirinciSayi = (EditText) findViewById(R.id.editTxtBirinciSayi);
        editTxtIkinciSayi = (EditText) findViewById(R.id.editTxtIkinciSayi);
        txtSonuc = (TextView) findViewById(R.id.txtViewSonuc);

    }
    public void btnHesapla(View v){

        birinciSayi = editTxtBirinciSayi.getText().toString(); //kullanıcının girdiği sayıyı alma
        ikinciSayi = editTxtIkinciSayi.getText().toString();

        //boş olup olmadığını kontrol etme
        if(!TextUtils.isEmpty(birinciSayi) && !TextUtils.isEmpty(ikinciSayi)){

            //sayıların alınıp int'e dönüştürülmesi
            s1 = Integer.valueOf(birinciSayi);
            s2 = Integer.valueOf(ikinciSayi);

            hesapla = new Hesapla(s1, s2);

            switch (v.getId()){
                case R.id.btnTopla:
                    sonuc = hesapla.toplam();
                    break;
                case R.id.btnCikarma:
                    sonuc = hesapla.fark();
                    break;
                case R.id.btnCarpma:
                    sonuc = hesapla.carpma();
                    break;
                case R.id.btnBolme:
                    sonuc = hesapla.bolme();
            }

            //sonucun textview içerisine yazdırılması
            txtSonuc.setText("Sonuç:" + sonuc);
        } else
            txtSonuc.setText("Boş Olamaz!!");
    }
}