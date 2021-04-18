package app.Application;

import app.Application.Interfaces.PhoneRepository;
import app.Application.Interfaces.ManufactureRepository;

import java.io.IOException;

public interface ScheduleMXBean {
    void doScheduledTask() throws IOException;
}
