public class TransactionDemo {

    public static void main(String[] args) {

        AccountDAO dao = new AccountDAO();

        dao.transferMoney(
                1,
                2,
                200
        );
    }
}