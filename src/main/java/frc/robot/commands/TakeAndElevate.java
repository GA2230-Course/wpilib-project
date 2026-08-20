package frc.robot.commands;

import frc.robot.subsystems.Intake;

import frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.Command;

public class TakeAndElevate extends Command { // Command to take objects with the intake for a certain time and then elevate it to a certain height
    private final Intake intake;
    private final Elevator elevator;
    private final OpenIntakeWithTimeout intakeCommand;
    private final double elevatorHeight;
    private boolean elevatorFinished;

    public TakeAndElevate(Intake intake, Elevator elevator, double intakeTimeout, double elevatorHeight) {
        this.intake = intake;
        this.elevator = elevator;
        this.intakeCommand = new OpenIntakeWithTimeout(intake, intakeTimeout);
        this.elevatorHeight = elevatorHeight;
        this.elevatorFinished = false;
        addRequirements(intake, elevator);
    }

    public void initialize() {
        elevatorFinished = false;
        elevator.setHeight(0);
        intakeCommand.initialize();
    }

    public void execute() {
        if (!intakeCommand.isFinished()) {
            intakeCommand.execute();
        } else if (!elevatorFinished) {
            intakeCommand.end(false);
            elevator.setHeight(elevatorHeight);
            elevatorFinished = true;
        }
    }

    public boolean isFinished() {
        return intakeCommand.isFinished() && elevatorFinished;
    }

    public void end(boolean interrupted) {
    }
}
