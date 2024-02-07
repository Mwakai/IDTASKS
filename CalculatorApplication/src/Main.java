public class Main {
    public static void main(String[] args) {

        try {
            Ui uiCal = new Ui();
            uiCal.init();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}