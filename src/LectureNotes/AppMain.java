package LectureNotes;

public class AppMain {
    public static void main(String[] args) {
        App app = new App(1, 1);
        App newApp = new App(1, 1);
        
        if (app.equals(newApp)){
            System.out.println("same");
        } else {
            System.out.println("different");
        }
        
    }
}
