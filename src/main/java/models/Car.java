package models;

import lombok.*;

// Lombok - biblioteka kotoraya generiryet Java klassi v 3 strochki
@Getter //posle etogo getteri dostupni
@Setter //settery
@Builder
@ToString
@AllArgsConstructor

public class Car {
    String address;
    String manufacture;
    String model;
    String year;
    String fuel;
    String seats;
    String carClass;
    String registerNumber;
    String price;
    String about;


}
