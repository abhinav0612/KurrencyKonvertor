package com.example.kurrencykonvertor;

public class Rates {
    private Double THB,
            PHP,
            CZK,
            BRL,
            CHF,
            INR,
            ISK,
            HRK,
            PLN,
            NOK,
            USD,
            CNY,
            RUB,
            SEK,
            MYR,
            SGD,
            ILS,
            TRY,
            BGN,
            NZD,
            HKD,
            RON,
            EUR,
            MXN,
            CAD,
            AUD,
            GBP,
            KRW,
            IDR,
            JPY,
            DKK,
            ZAR,
            HUF;

    public Double getcurrcency(String string)
    {
        switch (string)
        {
            case "HUF" :
                return HUF;
            case "DKK" :
                return DKK;
            case "JPY" :
                return JPY;
            case "THB" :
                return THB;
            case "PHP" :
                return PHP;
            case "CZK" :
                return CZK;
            case "BRL" :
                return BRL;
            case "CHF" :
                return CHF;
            case "INR" :
                return INR;
            case "ISK" :
                return ISK;
            case "HRK" :
                return HRK;
            case "BGN" :
                return BGN;
            case "NOK" :
                return NOK;
            case "USD" :
                return USD;
            case "CNY" :
                return CNY;
            case "RUB" :
                return RUB;
            case "SEK" :
                return SEK;
            case "MYR" :
                return MYR;
            case "SGD" :
                return SGD;
            case "ILS" :
                return ILS;
            case "TRY" :
                return TRY;
            case "PLN" :
                return PLN;
            case "NZD" :
                return NZD;
            case "HKD" :
                return HKD;
            case "RON" :
                return RON;
            case "MXN" :
                return MXN;
            case "CAD" :
                return CAD;
            case "AUD" :
                return AUD;
            case "GBP" :
                return GBP;
            case "KRW" :
                return KRW;
            case "IDR" :
                return IDR;

            default:
                return null;
        }

    }
}
