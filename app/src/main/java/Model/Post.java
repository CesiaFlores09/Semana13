package Model;

public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

    @GET("posts")
    Call<List<Post>> getPost();

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
