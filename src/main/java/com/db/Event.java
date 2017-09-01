package com.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Evegeny on 01/09/2017.
 */
@Data
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue
    private int id;
    private String what;

    public Event(String what) {
        this.what = what;
    }
}
