package com.melon.melontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.melon.melontest.adapter.GirlAdapter;
import com.melon.melontest.model.Response;
import com.melon.melontest.model.Result;
import com.melon.melontest.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "zd" ;

    private RecyclerView recyclerView;
    private Button btnPass;
    private List<Result> datas = new ArrayList<>();
    private GirlAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycleView);
        btnPass = findViewById(R.id.btn_pass);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GirlAdapter(this, datas);
        recyclerView.setAdapter(adapter);
        btnPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.scrollToPosition(0);
                initData();
            }
        });
    }


    private void initData() {
        Observable<Response> observable = ServiceFactory.getGirlService().getCall();
        observable.subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Observer<Response>() {
                      @Override
                      public void onSubscribe(Disposable d) {

                      }

                      @Override
                      public void onNext(Response response) {
                          datas.clear();
                          datas.addAll(response.getResults());
                          adapter.notifyDataSetChanged();
                      }

                      @Override
                      public void onError(Throwable e) {
                          Log.i(TAG, "onError: ");
                      }

                      @Override
                      public void onComplete() {

                      }
                  });
    }

}
