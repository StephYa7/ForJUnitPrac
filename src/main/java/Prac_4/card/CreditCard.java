package Prac_4.card;

public class CreditCard {
    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    private String cvv;

    public CreditCard(String cardNumber, String cardHolder, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void charge(double amount) {
        System.out.println("Charged amount " + amount + " from the card: " + cardNumber);
    }
}