package com.formation.velo.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OpenDataNantesPumpClient {

        @GET("explore/dataset/prix-carburants-fichier-instantane-test-ods-copie/api/?q=nantes&rows=182")
        Call<OpenData> getRecords();

}
