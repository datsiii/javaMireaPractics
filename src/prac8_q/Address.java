package prac8_q;

public class Address {
    String country;
    String region;
    String city;
    String street;
    String house;
    String building;
    String apartment;

    public void separate(String strAddress) {
        String[] arr = strAddress.split("(, )|(: )|(; )|(/ )|(- )|(. )");

        country = arr[0];
        region = arr[1];
        city = arr[2];
        street = arr[3];
        house = arr[4];
        building = arr[5];
        apartment = arr[6];
    }

    @Override
    public String toString() {
        return new StringBuffer()
                .append(country)
                .append(" ")
                .append(region)
                .append(" ")
                .append(city)
                .append(" ")
                .append(street)
                .append(" ")
                .append(house)
                .append(" ")
                .append(building)
                .append(" ")
                .append(apartment)
                .toString();
    }
}
