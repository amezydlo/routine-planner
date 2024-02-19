//package org.example.routineplanner.model;
//
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "activity_block")
//public class ActivityBlock {
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Id
//    private int id;
//
//    @Column(unique = true)
//    private String name;
//
//    // jak reprezentować dane mówiące, że w danym bloku mamy
//    // listę aktywności, gdzie każda trwa ileś minut i żeby
//    // były posortowane po offsecie? innymi słowy potrzebuję
//    // przechowywać sortedMap<(offset, activity)>
//
//}
