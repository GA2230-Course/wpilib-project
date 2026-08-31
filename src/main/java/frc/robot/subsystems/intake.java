package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    public enum SystemState {
        OPEN,
        CLOSED
    }

    private SystemState currentState;
    private SystemState wantedState;

    public Intake() {
        currentState = SystemState.CLOSED;
        wantedState = SystemState.CLOSED;
    }

    @Override
    public void periodic() {
        currentState = handleStateTransition();

        switch (currentState) {
            case OPEN:
                System.out.println("Intake is open");
                break;
        
            case CLOSED:
                System.out.println("Intake is closed");
                break;
        }
    }

    private SystemState handleStateTransition() {
        if (currentState != wantedState) {
            return wantedState;
        }
        return currentState;
    }

    public void setSystemState(SystemState state) {
        wantedState = state;
    }

    public void open() {
        wantedState = SystemState.OPEN;
    }

    public void close() {
        wantedState = SystemState.CLOSED;
    }
}
