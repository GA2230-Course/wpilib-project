package frc.robot.commands;

import frc.robot.subsystems.Intake;

import frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj.Timer;

public class TakeAndElevate extends Command {
    private final Intake intake;
    private final Elevator elevator;
    private final double intakeTimeout;
    private final double elevatorHeight;
    private final Timer timer = new Timer();

    public TakeAndElevate(Intake intake, Elevator elevator, double intakeTimeout, double elevatorHeight) {
        this.intake = intake;
        this.elevator = elevator;
        this.intakeTimeout = intakeTimeout;
        this.elevatorHeight = elevatorHeight;
        addRequirements(intake, elevator);
        System.out.println("TakeAndElevate command created with intake timeout: " + intakeTimeout + " seconds");
    }

    public void initialize() {
        intake.open();
        timer.start();
    }

    public void execute() {
    }

    public boolean isFinished() {
        return timer.get() >= intakeTimeout;
    }

    public void end(boolean interrupted) {
        elevator.setHeight(elevatorHeight);
        intake.close();
        timer.stop();
        System.out.println("TakeAndElevate command finished after " + timer.get() + " seconds");
        timer.reset();
    }
    
}
