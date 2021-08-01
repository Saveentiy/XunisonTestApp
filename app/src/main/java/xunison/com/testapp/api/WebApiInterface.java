package xunison.com.testapp.api;

import xunison.com.testapp.api.models.States;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WebApiInterface {
    @GET("states/all")
    Call<States> getStates();
}
