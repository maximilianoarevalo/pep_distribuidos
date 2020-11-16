package distribuidos.pep.models;

import java.util.Calendar;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor
public class Pass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String names;
    private String lastName;
    private String email;
    private String gender;
    private String type;
    private String rut;
    private Date initialDate;
    private Date finalDate;




    public Date sumarRestarHorasFecha(Date fecha, int horas){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); 
        calendar.add(Calendar.HOUR, horas);  
        return calendar.getTime(); 
   }
}