package com.example.semana13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.os.Bundle;
import android.telecom.Call;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import Interface.JsonPlaceHolderApi;
import Model.Post;

public class MainActivity extends AppCompatActivity {

    private TextView mjstonTxtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mjstonTxtView= findViewById(R.id.jsontext);
        getPosts();
    }
    private void getPosts(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi=retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call=jsonPlaceHolderApi.getPost();
        call.enqueue(new Callback<List<Post>>() {

           @Override
           public void onResponse(Call<List<Post>> call, Response<List<Post>> response){
           if (!response.isSuccessfull()){
               mjstonTxtView.setText("Codigo: "+response.code());
               return;;

           }
           List<Post> postList=response.body();

           for (Post post: postList){
               String content ="";
               content += "userIde:"+ post.getUserId() + "\n";
               content += "ide:"+ post.getId() + "\n";
               content += "title:"+ post.getTitle() + "\n";
               content += "body:"+ post.getBody() + "\n";
               mjstonTxtView.append(content);
           }
           }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t){
               mjstonTxtView.setText(t.getMessage());
        }
        });

    }
}