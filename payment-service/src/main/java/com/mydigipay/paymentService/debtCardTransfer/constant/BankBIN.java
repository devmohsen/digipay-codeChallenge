package com.mydigipay.paymentService.debtCardTransfer.constant;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum BankBIN {
    BOOMIR(0, "بانک محیط تستی بوم", "null", "BOOMIR"),
    CIYBIR(1, "بانک شهر", "502806", "CIYBIR"),
    CIYBIR2(2, "بانک شهر", "504706", "CIYBIR"),
    SABCIR(3, "بانک سامان", "621986", "SABCIR"),
    BEGNIR(4, "بانک اقتصاد نوین", "627412", "BEGNIR"),
    HEKMIR(5, "بانک حکمت ایرانیان", "636949", "HEKMIR"),
    ANSBIR(6, "بانک انصار", "627381", "ANSBIR"),
    DAYBIR(7, "بانک دی", "502938", "DAYBIR"),
    SINAIR(8, "بانک سینا", "639364", "SINAIR"),
    SINAIR2(9, "بانک سینا", "639346", "SINAIR"),
    SRMBIR(10, "بانک سرمایه", "639607", "SRMBIR"),
    IVBBIR(11, "بانک ایران ونزوئلا", "581874", "IVBBIR"),
    IRZAIR(12, "بانک ایران زمین", "505785", "IRZAIR"),
    MEHRIR(13, "بانک قرض الحسنه مهر ایران", "606373", "MEHRIR"),
    MEDBIR(14, "بانک مهر اقتصاد", "639370", "MEDBIR"),
    PBIRIR(15, " پست بانک ایران", "627760", "PBIRIR"),
    BOIMIR(16, "بانک صنعت و معدن", "627961", "BOIMIR"),
    MELIIR(17, "بانک ملی ایران", "603799", "MELIIR"),
    BTOSIR(18, "بانک توسعه تعاون", "502908", "BTOSIR"),
    BKBPIR(19, "بانک پاسارگاد", "502229", "BKBPIR"),
    BKBPIR2(20, "بانک پاسارگاد", "639347", "BKBPIR"),
    SEPBIR(21, "بانک سپه", "589210", "SEPBIR"),
    AYBKIR(22, "بانک آینده", "636214", "AYBKIR"),
    BKMTIR(23, "بانک ملت", "610433", "BKMTIR"),
    BKMTIR2(24, "بانک ملت", "991975", "BKMTIR"),
    BTEJIR(25, "بانک تجارت", "627353", "BTEJIR"),
    BTEJIR2(26, "بانک تجارت", "585983", "BTEJIR"),
    BKMNIR(27, "بانک مسکن", "628023", "BKMNIR"),
    KESHIR(28, "بانک کشاورزی", "603770", "KESHIR"),
    KESHIR2(29, "بانک کشاورزی", "628023", "KESHIR"),
    BKPAIR(30, "بانک پارسیان", "622106", "BKPAIR"),
    BKPAIR2(31, "بانک پارسیان", "627884", "BKPAIR"),
    BSIRIR(32, "بانک صادرات", "603769", "BSIRIR"),
    BSIRIR2(33, "بانک صادرات", "903769", "BSIRIR"),
    MELIIR2(34, "بانک ملی ایران", "170019", "MELIIR"),
    KHMIIR(35, "بانک خاورمیانه", "585947", "KHMIIR"),
    BTOSIR2(36, "بانک توسعه تعاون", "628157", "BTOSIR"),
    REFAIR(37, "بانک رفاه", "589463", "REFAIR"),
    ;


    int id;
    String bankName;
    String BIN;
    String BANK_ID;

    BankBIN(int id, String bankName, String BIN, String BANK_ID) {
        this.id = id;
        this.bankName = bankName;
        this.BIN = BIN;
        this.BANK_ID = BANK_ID
        ;
    }

    public static String getBankId(String cardNumber) {
        String BIN = cardNumber.substring(0, 6);
        Optional<BankBIN> bankBIN = Arrays.stream(BankBIN.values())
                .filter(t -> t.BIN.equals(BIN))
                .findFirst()
                ;
        if (bankBIN.isEmpty()) {
            return "BOOMIR";
        }
        return bankBIN.get().getBANK_ID();
    }
}
