package demo;

public class message {

    
    private int userId;
    private String title;
    private String body;

    public void setMessage(int userId,String title,String body)
    {
        this.userId=userId;
        this.title=title;
        this.body=body;
    }
    

    public String getBody()
    {
        return body;
    }

    public String getTitle()
    {
        return title;
    }

    public int getUserId()
    {
        return userId;
    }
}
