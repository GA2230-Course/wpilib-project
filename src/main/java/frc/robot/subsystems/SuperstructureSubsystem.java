package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;

import static frc.robot.subsystems.SuperstructureConstants.*;

public class SuperstructureSubsystem extends StateMachineSubsystem<SuperstructureSubsystem.SuperState> {

    public enum SuperState {
        IDLE,
        OPEN_INTAKE_TIMED,
        MOVE_ELEVATOR_TIMED,
        TAKE_AND_ELEVATE_INTAKE_STAGE,
        TAKE_AND_ELEVATE_LIFT_STAGE
    }

    private Intake intake;
    private Elevator elevator;
    private final Timer timer = new Timer();

    public SuperstructureSubsystem(Intake intake, Elevator elevator) {
        super(SuperState.IDLE);
        this.intake = intake;
        this.elevator = elevator;
    }

    @Override
    public void setWantedState(SuperState wantedState) {
        if (wantedState != getWantedState()) {
            timer.reset();
            timer.start();
        }
        super.setWantedState(wantedState);
    }

    @Override
    protected SuperState handleStateTransition() {
        SuperState wanted = getWantedState();

        switch (wanted) {
            case OPEN_INTAKE_TIMED:
                if (timer.hasElapsed(INTAKE_TIMEOUT_SEC)) {
                    timer.stop();
                    setWantedState(SuperState.IDLE);
                    return SuperState.IDLE;
                }
                return SuperState.OPEN_INTAKE_TIMED;

            case MOVE_ELEVATOR_TIMED:
                if (timer.hasElapsed(ELEVATOR_MOVE_TIMEOUT_SEC)) {
                    timer.stop();
                    setWantedState(SuperState.IDLE);
                    return SuperState.IDLE;
                }
                return SuperState.MOVE_ELEVATOR_TIMED;

            case TAKE_AND_ELEVATE_INTAKE_STAGE:
                if (timer.hasElapsed(INTAKE_TIMEOUT_SEC)) {
                    timer.stop();
                    setWantedState(SuperState.TAKE_AND_ELEVATE_LIFT_STAGE);
                    return SuperState.TAKE_AND_ELEVATE_LIFT_STAGE;
                }
                return SuperState.TAKE_AND_ELEVATE_INTAKE_STAGE;

            case TAKE_AND_ELEVATE_LIFT_STAGE:
            case IDLE:
            default:
                return wanted;
        }
    }

    @Override
    protected void applyCurrentState() {
        switch (getCurrentState()) {
            case OPEN_INTAKE_TIMED:
                elevator.setHeight(ELEVATOR_START_HEIGHT_MM);
                intake.open();
                break;

            case MOVE_ELEVATOR_TIMED:
                intake.close();
                elevator.setHeight(elevator.getHeight() + ELEVATOR_SPEED_STEP_UNITS);
                break;

            case TAKE_AND_ELEVATE_INTAKE_STAGE:
                elevator.setHeight(ELEVATOR_START_HEIGHT_MM);
                intake.open();
                break;

            case TAKE_AND_ELEVATE_LIFT_STAGE:
                intake.close();
                elevator.setHeight(TARGET_ELEVATOR_HEIGHT_MM);
                break;

            case IDLE:
            default:
                intake.close();
                break;
        }
    }
}