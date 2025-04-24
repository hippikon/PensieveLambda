package digital.pensieve.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="record")
public class RecordData {

    @Id
    public int id;

    public String device;


    public String deviceName;

    public String username;

    public String notes;

    public Date created = new Date();

}
