package com.example.mentoringv1ex2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String description;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Long maximumConsumption;

    @Column(nullable = false)
    private Long averageConsumption;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(nullable = false)
    private User user;

}
