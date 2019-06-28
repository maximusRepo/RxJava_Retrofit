package com.example.apicall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private RequestModel requestModel;
    private TextView textView,textView2;
    private EditText ed_email,ed_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_hit);
        textView = findViewById(R.id.text1);
        textView2 = findViewById(R.id.texxt2);
        ed_email = findViewById(R.id.ed_email);
        ed_text = findViewById(R.id.ed_name);
        requestModel = new RequestModel("Space Elevator, Mars Hyperloop, Space Model S (Model Space?)","Space Travel Ideas","note");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callService(requestModel);
            }
        });
    }

    private void callService(RequestModel requestModel){
        final Retrofitinterface retrofitinterface =  RetrofitService.getClient().create(Retrofitinterface.class);
        retrofitinterface.request(requestModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseModel responseModel) {
                        Log.d("response", String.valueOf(responseModel));
                        textView.setText(responseModel.active);
                        textView2.setText(responseModel.sender_email);
                        retrofitinterface.response()
                                .observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                                .subscribe(new Observer<GetResponse>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(GetResponse getResponse) {
                                        if(getResponse.name.equals("vaibhav gawde")){
                                            ed_email.setText(getResponse.email_normalized);
                                            ed_text.setText("Result is Perfect");
                                        }


                                    }

                                    @Override
                                    public void onError(Throwable e) {

                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                });
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
