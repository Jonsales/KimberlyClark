package br.com.john.kimberlyclark.ConnectionAPI;

import com.squareup.okhttp.RequestBody;

import java.util.List;

import br.com.john.kimberlyclark.Classes.Process;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;

/**
 * Created by Jonathan on 01/06/16.
 */
public interface ConnectionAPI {
    @GET("package/ctrl/{ctrlCar}")
    Call<Process> getProcess(@Path("ctrlCar") String ctrl);


    @FormUrlEncoded
    @POST("package/ctrl/CtrlCar.php")
    Call<Process> getOneProcess( @Field("method") String method);


    @FormUrlEncoded
    @POST("package/ctrl/CtrlCar.php")
    Call<List<Process>> getListProcess(@Field("method") String method);


    /*@POST("package/ctrl/CtrlCar.php")
    Call<Process> sendProcess( @Body WrapRequest wrapRequest);*/


    @Multipart
    @POST("package/ctrl/CtrlCar.php")
    Call<Process> sendImg(@Part("method") String method, @Part("name_image") String imageName, @Part("binary_image") RequestBody requestBody);

    @FormUrlEncoded
    @POST("package/ctrl/CtrlCar.php")
    Call<Process> sendHeader(@Header("mega-test") String megaTest, @Field("method") String method);

    @FormUrlEncoded
    @POST("package/ctrl/CtrlCar.php")
    Call<Process> saveCars( @Field("method") String method, @Field("cars") String carsJson);

}
