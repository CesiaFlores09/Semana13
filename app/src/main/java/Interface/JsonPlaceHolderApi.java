package Interface;

import android.telecom.Call;

import java.util.List;

import Model.Post;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPost();


}