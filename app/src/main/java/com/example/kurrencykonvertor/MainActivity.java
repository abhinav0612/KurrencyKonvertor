package com.example.kurrencykonvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView et_from,et_to;
    ArrayList<CountryList> myList;
    TextView tv_results;
    Button btn_convert;
    ImageButton reverse;
    EditText et_amount;
    ForeignExchangeApi foreignExchangeApi;
    String from,to;
    Double amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_from = findViewById(R.id.autoEdit);
        et_to = findViewById(R.id.autoEdit_to);
        tv_results = findViewById(R.id.tv_result);
        btn_convert = findViewById(R.id.convert);
        et_amount = findViewById(R.id.et_amount);
        reverse = findViewById(R.id.reverse);

        fillList();

        AutoCompleteAdapter adapter = new AutoCompleteAdapter(this,myList);
        et_from.setAdapter(adapter);
        et_to.setAdapter(adapter);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.exchangeratesapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        foreignExchangeApi = retrofit.create(ForeignExchangeApi.class);
        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });
        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to_reverse = et_from.getText().toString();
                String from_reverse = et_to.getText().toString();
                et_from.setText(from_reverse);
                et_to.setText(to_reverse);
            }
        });

    }

    void  fillList()
    {
        myList = new ArrayList<>();
        myList.add(new CountryList("Thailand",R.drawable.thailand,"THB"));
        myList.add(new CountryList("Philippines",R.drawable.phillipines,"PHP"));
        myList.add(new CountryList("Czech Republic",R.drawable.czech_republic,"CZK"));
        myList.add(new CountryList("Brazil",R.drawable.brazil,"BRL"));
        myList.add(new CountryList("Switzerland",R.drawable.switzerland,"CHF"));
        myList.add(new CountryList("India",R.drawable.india,"INR"));
        myList.add(new CountryList("Iceland",R.drawable.iceland,"ISK"));
        myList.add(new CountryList("Croatia",R.drawable.croatia,"HRK"));
        myList.add(new CountryList("Bulgaria",R.drawable.bulgeria,"BGN"));
        myList.add(new CountryList("Norway",R.drawable.norway,"NOK"));
        myList.add(new CountryList("United States",R.drawable.usa,"USD"));
        myList.add(new CountryList("China",R.drawable.china,"CNY"));
        myList.add(new CountryList("Russian Federation",R.drawable.russian,"RUB"));
        myList.add(new CountryList("Sweden",R.drawable.sweden,"SEK"));
        myList.add(new CountryList("Malaysia",R.drawable.malasia,"MYR"));
        myList.add(new CountryList("Singapore",R.drawable.singapore,"SGD"));
        myList.add(new CountryList("Israel",R.drawable.israel,"ISR"));
        myList.add(new CountryList("Turkey",R.drawable.turkey,"TRY"));
        myList.add(new CountryList("Poland",R.drawable.poland,"PLN"));
        myList.add(new CountryList("New Zealand",R.drawable.new_zealand,"NZD"));
        myList.add(new CountryList("Hong Kong",R.drawable.hong_kong,"HKD"));
        myList.add(new CountryList("Romania",R.drawable.romania,"RON"));
        myList.add(new CountryList("Mexico",R.drawable.mexico,"MXN"));
        myList.add(new CountryList("Canada",R.drawable.canada,"CAD"));
        myList.add(new CountryList("Australia",R.drawable.autralia,"AUD"));
        myList.add(new CountryList("United Kingdom",R.drawable.uk,"GBP"));
        myList.add(new CountryList("South Africa",R.drawable.south_africa,"ZAR"));
        myList.add(new CountryList("South Korea",R.drawable.south_koria,"KRW"));
        myList.add(new CountryList("Japan",R.drawable.japan,"JPY"));
        myList.add(new CountryList("Denmark",R.drawable.denmark,"DKK"));
        myList.add(new CountryList("Indonesia",R.drawable.indonezia,"IDR"));
        myList.add(new CountryList("Hungry",R.drawable.hungry,"HUF"));
    }

    void convert()
    {
        from = et_from.getText().toString().trim().toUpperCase();
        to = et_to.getText().toString().toUpperCase().trim();

     amount = Double.parseDouble(et_amount.getText().toString().trim());
        Log.d("___________","from : " +from);
        Log.d("___________","to : " +to);
        Log.d("___________","amount : " +amount);

        Map map = new HashMap();
        map.put("base",from);
        map.put("symbols",to);

        Call<ForeignExchange> call = foreignExchangeApi.getConverted(map);
            call.enqueue(new Callback<ForeignExchange>() {
                @Override
                public void onResponse(Call<ForeignExchange> call, Response<ForeignExchange> response) {
                    if (!response.isSuccessful())
                    {
                        tv_results.setText("Response" + response.code());
                        return;
                    }
                    ForeignExchange foreignExchange = response.body();
                    Rates rates = foreignExchange.getRates();
                    Double i = rates.getcurrcency(to.toUpperCase().trim());
                    Log.d("+++++++++","i" + i+amount);
                    tv_results.setText("Value : " + result(i,amount));

                }

                @Override
                public void onFailure(Call<ForeignExchange> call, Throwable t) {
                    tv_results.setText(t.getMessage());
                }
            });
    }
    Double result(Double value,Double amount)

    {
        return value*amount;
    }

}
