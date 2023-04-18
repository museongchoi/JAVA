package JavaLec_0411;

public class KakaoBank {
    // 예금주, 계좌번호, 잔액, 패스워드, 연락처
    String userName;    // 예금주
    String accountNum;  // 계좌번호
    int balance;    // 잔액
    String password;

    String accid;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public KakaoBank(String userName, String accountNum, int balance, String password) {
        this.setUserName(userName);
        this.setAccountNum(accountNum);
        this.setBalance(balance);
        this.setPassword(password);
    }

    public void deposit(int i) {
        //this.balance += i;
        this.setBalance(this.getBalance() + i);
    }

    public void withdraw(int i) {
        if((this.balance - i) >= 0)
        {
            this.setBalance(this.getBalance() - i);
        } else {
            System.out.println("----------Show Account-----------");
            System.out.println(this.userName + " 님의 계좌 잔액이 부족합니다. \n현재 계좌 잔액 : " + this.balance + "원");
            System.out.println("송금할 금액 : " + i + "원\n부족한 금액 : " + (i-this.balance) + "원");
            System.out.println("----------Show Account-----------");
            System.out.println();
        }
    }

    public void showAccount() {
        System.out.println("----------Show Account-----------");
        System.out.println("예 금 주 : " + this.getUserName());
        System.out.println("계 좌 번 호 : " + this.getAccountNum());
        System.out.println("잔 액 : " + this.getBalance());
        System.out.println("----------Show Account-----------");
        System.out.println();
    }

    public void transfer(KakaoBank holder, int i) {
        this.withdraw(i);
//        if((this.balance - i) >= 0)
//        {
//            this.setBalance(this.getBalance() - i);
//        } else {
//            System.out.println("잔액이 부족합니다.");
//        }
        holder.deposit(i);
    }
}
