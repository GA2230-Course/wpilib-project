package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    private double height;

    public Elevator() {
        height = 0.0; // in milimeters
    }

    public void periodic() {
        System.out.println("Elevator height: " + height);
    }

    public void setHeight(double newHeight) {
        if(newHeight < 0) {
            throw new IllegalArgumentException("Height cannot be negative");
        }
        height = newHeight;
    }

    public double getHeight() {
        return height;
    }
}
