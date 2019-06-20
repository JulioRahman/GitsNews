package com.julio.gitsnews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.julio.gitsnews.rests.APIClient;
import com.julio.gitsnews.rests.APIInterface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedbackActivity extends AppCompatActivity {

    private EditText tvName, tvDesc;
    private RatingBar rbRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        setTitle("Feedback");

        tvName = findViewById(R.id.tv_name_f);
        rbRate = findViewById(R.id.rating);
        tvDesc = findViewById(R.id.tv_desc_f);
        Button bSubmit = findViewById(R.id.b_submit_f);

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvName.getText().toString().trim().isEmpty() || tvDesc.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Semua kolom harus diisi", Toast.LENGTH_SHORT).show();
                } else {
                    postMessage();
                }
            }
        });
    }

    private void postMessage(){

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("nama", tvName.getText().toString());
        jsonObject.addProperty("rating", String.valueOf(rbRate.getRating()));
        jsonObject.addProperty("deskripsi", tvDesc.getText().toString());

        APIInterface apiService = APIClient.getClient().create(APIInterface.class);
        Call<ResponseBody> result = apiService.postFeedback(jsonObject);
        Log.d("iwi", "postMessage: "+result);
        result.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Feedback terkirim", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
