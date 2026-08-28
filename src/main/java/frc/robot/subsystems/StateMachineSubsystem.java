package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public abstract class StateMachineSubsystem<T> extends SubsystemBase {

    private T wantedState;
    private T currentState;

    public StateMachineSubsystem(T initialState) {
        this.wantedState = initialState;
        this.currentState = initialState;
    }

    public T getCurrentState() {
        return currentState;
    }

    public T getWantedState() {
        return wantedState;
    }

    public void setWantedState(T wantedState) {
        this.wantedState = wantedState;
    }

    protected void setCurrentState(T currentState) {
        this.currentState = currentState;
    }

    protected abstract T handleStateTransition();

    protected abstract void applyCurrentState();

    @Override
    public void periodic() {
        this.currentState = handleStateTransition();
        applyCurrentState();
    }
}