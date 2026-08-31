package frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    public enum IntakeState {
        OPEN,
        CLOSED
    }

    private IntakeState currentState;
    private IntakeState wantedState;

    public Intake() {
        currentState = IntakeState.CLOSED;
        wantedState = IntakeState.CLOSED;
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

    private IntakeState handleStateTransition() {
        if (currentState != wantedState) {
            return wantedState;
        }
        return currentState;
    }

    public void setIntakeState(IntakeState state) {
        wantedState = state;
    }

    public void open() {
        wantedState = IntakeState.OPEN;
    }

    public void close() {
        wantedState = IntakeState.CLOSED;
    }
}
