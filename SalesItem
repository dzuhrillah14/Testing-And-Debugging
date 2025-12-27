import java.util.ArrayList;

public class SalesItem {
    private String description;
    private double price;
    private ArrayList<Comment> comments;

    public SalesItem(String description, double price) {
        this.description = description;
        this.price = price;
        this.comments = new ArrayList<>();
    }

    public boolean addComment(String author, String text, int rating) {
        if (rating < 1 || rating > 5) return false;

        for (Comment c : comments) {
            if (c.getAuthor().equals(author)) return false;
        }

        comments.add(new Comment(author, text, rating));
        return true;
    }

    public boolean removeComment(String author) {
        for (Comment c : comments) {
            if (c.getAuthor().equals(author)) {
                comments.remove(c);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Comment> getComments() { return comments; }
}
