package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private boolean isOpen;

    public Intake() {
        isOpen = false;
    }

    @Override
    public void periodic() {
        System.out.println("Intake is " + (isOpen ? "open" : "closed"));
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }
}
