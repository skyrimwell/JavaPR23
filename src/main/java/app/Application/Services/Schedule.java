package app.Application.Services;

import app.Application.Classes.Manufacture;
import app.Application.Classes.Phone;
import app.Application.Controllers.PhoneController;
import app.Application.Controllers.ManufactureController;
import app.Application.ScheduleMXBean;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class Schedule implements ScheduleMXBean {
    private Boolean isEmpty(final File file) {
        return (file.isDirectory() && (file.list().length > 0));
    }
    @ManagedOperation
    @Scheduled(cron = "0 0/30 * * * *")
    public void doScheduledTask() throws IOException {
        if(isEmpty(new File("C:/Users/skyri/ideaProjects/PR22/outFile"))){
            for (File myFile : new File("C:/Users/skyri/ideaProjects/PR22/outFile")
                    .listFiles()) {
                if (myFile.isFile()) myFile.delete();
            }
        }
        PhoneController phoneController = new PhoneController();
        ManufactureController manufactureController = new ManufactureController();
        List <Manufacture> manufactures= manufactureController.getAll();
        List <Phone> phones= phoneController.getAll();
        for (int i=0; i< phones.size();i++) {
            File game = new File("C:/Users/skyri/ideaProjects/PR22/outFile");
            FileWriter writer = new FileWriter(game, false);
            writer.write(phones.get(i).toString());
        }

        for (int i=0; i< manufactures.size();i++) {
            File level = new File("C:/Users/skyri/ideaProjects/PR22/outFile");
            FileWriter writer = new FileWriter(level, false);
            writer.write(manufactures.get(i).toString());
        }
    }
}
