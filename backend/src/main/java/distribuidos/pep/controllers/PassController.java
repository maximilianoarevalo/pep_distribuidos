package distribuidos.pep.controllers;

import java.sql.Date;
import java.util.ArrayList;

import distribuidos.pep.models.Pass;
import distribuidos.pep.repositories.PassRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "*")
public class PassController {
    @Autowired
    PassRepository passRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/pass")
    public ArrayList<Pass> getAllPass() {
        return passRepository.findAll();
    }

    @PostMapping("/newPass")
    public Pass createPass(@RequestBody Pass pass) {
        System.out.print(passRepository.save(pass));
        pass.setInitialDate(new Date(System.currentTimeMillis()));
        pass.setFinalDate(pass.sumarRestarHorasFecha(pass.getInitialDate(), 2));

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(pass.getEmail());
        msg.setSubject("Información pase");
        msg.setText("Nombre: "+pass.getNames()+" "+pass.getLastName()+"\n"+
        "R.U.T: " + pass.getRut()+"\n" +
        "Género: "+pass.getGender()+"\n"+
        "Razón: "+pass.getType()+"\n"+
        "Inicio: "+pass.getInitialDate()+"\n"+
        "Fin: "+pass.getFinalDate()+"\n");

        javaMailSender.send(msg);

        return passRepository.save(pass);
    }

  

}