package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class intake extends SubsystemBase {
    private int isOpen;

    public intake(){
        isOpen = 0;
    }

    @Override
    public void periodic() {
        System.out.println("Intake is " + (isOpen == 1 ? "open" : "closed"));
    }

    public void open() {
        isOpen = 1;
    }

    public void close() {
        isOpen = 0;
    }
}
