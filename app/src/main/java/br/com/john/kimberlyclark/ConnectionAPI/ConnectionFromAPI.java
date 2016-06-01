package br.com.john.kimberlyclark.ConnectionAPI;

import android.os.SystemClock;
import android.text.Html;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.john.kimberlyclark.Classes.Process;
import br.com.john.kimberlyclark.ConnectionAPI.Deserializer.ProcessDeserializer;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Jonathan on 01/06/16.
 */
public class ConnectionFromAPI {
    public static final String TAG = "LOG";
    public static final String API = "";

    Gson gson = new GsonBuilder().registerTypeAdapter(Process.class, new ProcessDeserializer()).create();

    Retrofit retrofit = new Retrofit
            .Builder()
            .baseUrl(API)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    ConnectionAPI connAPI = retrofit.create(ConnectionAPI.class);


    // GET LUXURY CAR - REQUEST
    public void getProcess(){
        final Call<Process> callProcess = connAPI.getProcess("CtrlLuxuryCar.php");
        callProcess.enqueue(new Callback<Process>() {
            @Override
            public void onResponse(Response<Process> response, Retrofit retrofit) {
                Process c = response.body();
                if( c != null ){

                }
                else{
                    Log.i(TAG, "R: Error GET LUXURY CAR: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i(TAG, "Error GET LUXURY CAR: "+t.getMessage());
            }
        });

        new Thread(){
            @Override
            public void run() {
                super.run();

                SystemClock.sleep(2000);
                callProcess.cancel();
            }
        }.start();
    }




    // ONE CAR - REQUEST
   /* Call<Car> call = carAPI.getOneCar("one-car");
    call.enqueue(new Callback<Car>() {
        @Override
        public void onResponse(Response<Car> response, Retrofit retrofit) {
            Car c = response.body();
            if( c != null ){
                Log.i(TAG, "Car: " + c.getName());
                //tvData.setText(Html.fromHtml( "Model: "+c.getName()+"<br>Brand: "+c.getBrand().getName()+"<br>Engine: "+c.getEngine().getStrength() ) );
            }
        }

        @Override
        public void onFailure(Throwable t) {
            Log.i(TAG, "Error ONE CAR: "+t.getMessage());
        }
    });


    // MANY CAR - REQUEST
    final Call<List<Car>> callManyCars = carAPI.getManyCars("many-cars");

    new Thread(){
        @Override
        public void run() {
            super.run();

            try {
                List<Car> listCars = callManyCars.execute().body();

                if( listCars != null ){
                    for( Car c : listCars ){
                        Log.i(TAG, "Car: "+c.getName());
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.i(TAG, "MANY CAR request Ok");
                }
            });
        }
    }.start();


    // SAVE CAR - REQUEST
    Engine e = new Engine(325, 2015, "5.9");
    Brand b = new Brand("Ferrari", null);
    Car c = new Car("Spider", null, b, e);

    WrapRequest wrapRequest = new WrapRequest( "save-car", c );

    call = carAPI.saveCar(wrapRequest);
    call.enqueue(new Callback<Car>() {
        @Override
        public void onResponse(Response<Car> response, Retrofit retrofit) {
        }

        @Override
        public void onFailure(Throwable t) {
            Log.i(TAG, "Error SAVE CAR: " + t.getMessage());
        }
    });


    // SEND IMG - REQUEST
    String imageName = BinaryBytes.getResourceName(this, R.drawable.beach);
    byte[] imageBinary = BinaryBytes.getResourceInBytes(this, R.drawable.beach);
    RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), imageBinary);

    call = carAPI.sendImg("send-img", imageName, requestBody);
    call.enqueue(new Callback<Car>() {
        @Override
        public void onResponse(Response<Car> response, Retrofit retrofit) {}
        @Override
        public void onFailure(Throwable t) {
            Log.i(TAG, "Error SEND IMG: " + t.getMessage());
        }
    });


    // SEND HEADER - REQUEST
    Interceptor interceptor = new Interceptor() {
        @Override
        public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
            Request request = chain.request().newBuilder()
                    .addHeader("username", "thiengo")
                    .addHeader("password", "calopsita")
                    .build();

            return chain.proceed( request );
        }
    };
    OkHttpClient okHttpClient = new OkHttpClient();
    okHttpClient.interceptors().add(interceptor);

    retrofit = new Retrofit
            .Builder()
            .baseUrl(API)
    .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
    .build();
    carAPI = retrofit.create(CarAPI.class);

    call = carAPI.sendHeader("mega-test-header", "send-header");
    call.enqueue(new Callback<Car>() {
        @Override
        public void onResponse(Response<Car> response, Retrofit retrofit) {}
        @Override
        public void onFailure(Throwable t) {
            Log.i(TAG, "Error SEND HEADER: " + t.getMessage());
        }
    });


    // SAVE CAR - REQUEST
    ArrayList<Car> listCars = new ArrayList<>();

    e = new Engine(325, 2015, "5.9");
    b = new Brand("Ferrari", null);
    c = new Car("Spider", null, b, e);
    listCars.add(c);

    e = new Engine(325, 2015, "5.9");
    b = new Brand("Ferrari", null);
    c = new Car("F-150", null, b, e);
    listCars.add(c);

    call = carAPI.saveCars("save-cars", new Gson().toJson( listCars ));
    call.enqueue(new Callback<Car>() {
        @Override
        public void onResponse(Response<Car> response, Retrofit retrofit) {}
        @Override
        public void onFailure(Throwable t) {
            Log.i(TAG, "Error SAVE CARS: " + t.getMessage());
        }
    });*/

}
