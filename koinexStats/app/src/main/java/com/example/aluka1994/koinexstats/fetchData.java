package com.example.aluka1994.koinexstats;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by aluka1994 on 12/16/2017.
 */

public class fetchData extends AsyncTask<Void,Void,Void> {
    String data="";
    String dataParsed = "";
    String singleParsed = "";
    @Override
    protected Void doInBackground(Void... voids) {

        URL url;
        try {
            url = new URL("https://koinex.in/api/ticker");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line="";
            while (line!=null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            /*
            JSONObject jsonObject = (JSONObject) new JSONTokener(data).nextValue();
            JSONArray prices = jsonObject.getJSONArray("prices");
            JSONArray trading = jsonObject.getJSONArray("stats");
            JSONObject JO = (JSONObject) prices.get(0);
            Log.e("adda",(String) JO.get("BTC"));
            singleParsed = "BitCoin Price: " + (String) JO.get("BTC") + "\n"+
                            "BitCoinCash Price: " + (String) JO.get("BCH") + "\n"+
                             "EthereumCoin Price: " + (String) JO.get("ETH") + "\n"+
                              "XRPCoin Price: " + (String) JO.get("XRP") + "\n"+
                               "LiteCoin Price: " + (String) JO.get("LTC") + "\n"+
                               "OMGCOin Price: " + (String) JO.get("OMG") + "\n"+
                               "MIOTACoin Price: " + (String)JO.get("MIOTA") + "\n"+
                                "GNT Coin Price: " + (String)JO.get("GNT") + "\n";
            JSONArray JA = new JSONArray(data);
            for (int i=0;i<JA.length();i++){
                JSONObject JO1 = (JSONObject) JA.get(i);
            }
            */

            JSONObject mainObject;
            mainObject = new JSONObject(data);

            JSONObject JO = mainObject.getJSONObject("prices");
            JSONObject stats = mainObject.getJSONObject("stats");
            JSONObject eth = stats.getJSONObject("ETH");
            JSONObject btc = stats.getJSONObject("BTC");
            JSONObject rip = stats.getJSONObject("XRP");
            JSONObject ltc = stats.getJSONObject("LTC");
            JSONObject bch = stats.getJSONObject("BCH");

            Log.e("ads", String.valueOf(JO.get("BTC")));
            singleParsed = "BitCoin Price: " +   String.valueOf(JO.get("BTC")) + "\n"+
                    "BitCoinCash Price: " +   String.valueOf(JO.get("BCH")) + "\n" +
                    "EthereumCoin Price: " +  String.valueOf(JO.get("ETH")) + "\n"+
                    "XRPCoin Price: " +  String.valueOf(JO.get("XRP")) + "\n"+
                    "LiteCoin Price: " + String.valueOf(JO.get("LTC")) + "\n"+
                    "OMGCOin Price: " +  String.valueOf(JO.get("OMG")) + "\n"+
                    "MIOTACoin Price: " + String.valueOf(JO.get("MIOTA")) + "\n"+
                    "GNT Coin Price: " + String.valueOf(JO.get("GNT")) + "\n"+

                    "\n Coins Stats !!! \n" +
                    "\nCoinName : Ethereum\n"+
                    "last_traded_price: " + String.valueOf(eth.get("last_traded_price")) + "\n" +
                    "lowest_ask: " + String.valueOf(eth.get("lowest_ask")) + "\n" +
                    "highest_bid: " + String.valueOf(eth.get("highest_bid")) + "\n" +
                    "min_24hrs: " + String.valueOf(eth.get("min_24hrs")) + "\n" +
                    "max_24hrs: " + String.valueOf(eth.get("max_24hrs")) + "\n" +
                    "vol_24hrs: " + String.valueOf(eth.get("vol_24hrs")) + "\n" +
                    "\nCoinName : BitCoin\n"+
                    "last_traded_price: " + String.valueOf(btc.get("last_traded_price")) + "\n" +
                    "lowest_ask: " + String.valueOf(btc.get("lowest_ask")) + "\n" +
                    "highest_bid: " + String.valueOf(btc.get("highest_bid")) + "\n" +
                    "min_24hrs: " + String.valueOf(btc.get("min_24hrs")) + "\n" +
                    "max_24hrs: " + String.valueOf(btc.get("max_24hrs")) + "\n" +
                    "vol_24hrs: " + String.valueOf(btc.get("vol_24hrs")) + "\n" +
                    "\nCoinName : BitCoin Cash\n"+
                    "last_traded_price: " + String.valueOf(bch.get("last_traded_price")) + "\n" +
                    "lowest_ask: " + String.valueOf(bch.get("lowest_ask")) + "\n" +
                    "highest_bid: " + String.valueOf(bch.get("highest_bid")) + "\n" +
                    "min_24hrs: " + String.valueOf(bch.get("min_24hrs")) + "\n" +
                    "max_24hrs: " + String.valueOf(bch.get("max_24hrs")) + "\n" +
                    "vol_24hrs: " + String.valueOf(bch.get("vol_24hrs")) + "\n"+
                    "\nCoinName : Ripple \n"+
                    "last_traded_price: " + String.valueOf(rip.get("last_traded_price")) + "\n" +
                    "lowest_ask: " + String.valueOf(rip.get("lowest_ask")) + "\n" +
                    "highest_bid: " + String.valueOf(rip.get("highest_bid")) + "\n" +
                    "min_24hrs: " + String.valueOf(rip.get("min_24hrs")) + "\n" +
                    "max_24hrs: " + String.valueOf(rip.get("max_24hrs")) + "\n" +
                    "vol_24hrs: " + String.valueOf(rip.get("vol_24hrs")) + "\n"+
                    "\nCoinName : LiteCoin\n"+
                    "last_traded_price: " + String.valueOf(ltc.get("last_traded_price")) + "\n" +
                    "lowest_ask: " + String.valueOf(ltc.get("lowest_ask")) + "\n" +
                    "highest_bid: " + String.valueOf(ltc.get("highest_bid")) + "\n" +
                    "min_24hrs: " + String.valueOf(ltc.get("min_24hrs")) + "\n" +
                    "max_24hrs: " + String.valueOf(ltc.get("max_24hrs")) + "\n" +
                    "vol_24hrs: " + String.valueOf(ltc.get("vol_24hrs")) + "\n";


            Log.e("daad", singleParsed);
            dataParsed = dataParsed + singleParsed +"\n";
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.data.setText(this.dataParsed);
    }
}
