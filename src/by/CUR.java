package by;

public enum CUR {
    USD(2.4),EUR(3),RUB(0.034),BYN(1);
    double cursVal;

    CUR(double cursVal) {
        this.cursVal = cursVal;
    }
}
