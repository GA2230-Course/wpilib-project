package frc.robot.subsystems;

public class SuperstructureSubsystem extends StateMachineSubsystem<SuperstructureSubsystem.SuperState> {

    public enum SuperState {
        IDLE,
        INTAKE,
        ELEVATOR_UP
    }

    private Intake intake;
    private Elevator elevator;

    public SuperstructureSubsystem() {
        super(SuperState.IDLE);
        this.intake = new Intake();
        this.elevator = new Elevator();
    }

    @Override
    protected SuperState handleStateTransition() {
        return getWantedState();
    }

    @Override
    protected void applyCurrentState() {
        switch (getCurrentState()) {
            case INTAKE:
                this.elevator.setHeight(0);
                this.intake.open();
                break;
            case ELEVATOR_UP:
                this.intake.close();
                this.elevator.setHeight(500);;
                break;
            case IDLE:
                this.intake.close();
                this.elevator.setHeight(0);
                break;
        }
    }
}