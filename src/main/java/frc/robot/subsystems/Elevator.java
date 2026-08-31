package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {

    public enum ElevatorState {
        IDLE,
        MOVING_UP,
        MOVING_DOWN
    }

    private double height;
    private ElevatorState currentState;
    private ElevatorState wantedState;

    public Elevator() {
        height = 0.0; // in milimeters
        currentState = ElevatorState.IDLE;
        wantedState = ElevatorState.IDLE;
    }

    public void periodic() {
        currentState = handleStateTransition();
        switch (currentState) {
            case IDLE:
                System.out.println("Elevator is idle");
                break;
            case MOVING_UP:
                System.out.println("Elevator is moving up");
                break;
            case MOVING_DOWN:
                System.out.println("Elevator is moving down");
                break;
        }
    }

    private ElevatorState handleStateTransition() {
        if (currentState != wantedState) {
            return wantedState;
        }
        return currentState;
    }

    public void setHeight(double newHeight) {
        if (newHeight < 0) {
            throw new IllegalArgumentException("Height cannot be negative");
        }
        height = newHeight;
    }

    public double getHeight() {
        return height;
    }
}
