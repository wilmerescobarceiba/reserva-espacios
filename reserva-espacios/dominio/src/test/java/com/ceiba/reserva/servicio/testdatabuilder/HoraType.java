package com.ceiba.reserva.servicio.testdatabuilder;

public enum HoraType {
    H07_08("07:00 AM - 08:00 AM"),
    H08_09("08:00 AM - 08:00 AM"),
    H09_10("09:00 AM - 10:00 AM"),
    H10_11("10:00 AM - 11:00 AM"),
    H11_12("11:00 AM - 12:00 M"),
    H01_02("01:00 PM - 02:00 PM"),
    H02_03("02:00 PM - 03:00 PM"),
    H03_04("03:00 PM - 04:00 PM"),
    H04_05("04:00 PM - 05:00 PM");
	
    public final String value;

    private HoraType(String value) {
        this.value = value;
    }
}
