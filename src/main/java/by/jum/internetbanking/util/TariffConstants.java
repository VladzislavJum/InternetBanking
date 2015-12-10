package by.jum.internetbanking.util;

public enum TariffConstants {
    ELECTRICITY_TARIFF(1000),
    WATER_TARIFF(1500),
    GAS_TARIFF(850);

    private int tariff;

    TariffConstants(int tariff) {
        this.tariff = tariff;
    }

    public int getTariff() {
        return tariff;
    }
}
