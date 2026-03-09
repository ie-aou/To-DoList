package model;
public class Task{
    private String title;
    private String priority;
    private String detail;

    public Task(String title, String priority, String detail){
        this.title = title;
        this.priority = priority;
        this.detail = detail;
    }
    public String getTitle(){
        return title;
    }
    public String getPriority(){
        return priority;
    }
    public String getDetail(){
        return detail;
    }
}