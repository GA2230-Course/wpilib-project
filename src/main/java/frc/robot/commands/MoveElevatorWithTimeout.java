package frc.robot.commands;

import frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj.Timer;

public class MoveElevatorWithTimeout extends Command {
    private final Elevator elevator;
    private final double timeout;
    private final double speed;
    private final Timer timer;

    public MoveElevatorWithTimeout(Elevator elevator, double speed, double timeout) {
        this.elevator = elevator;
        this.speed = speed;
        this.timeout = timeout;
        this.timer = new Timer();
        addRequirements(elevator);
        System.out.println("MoveElevatorWithTimeout command created with timeout: " + timeout + " seconds");
    }

    public void initialize() {
        timer.reset();
        timer.start();
    }

    public void execute() {
        elevator.setHeight(elevator.getHeight() + speed);
    }

    public boolean isFinished() {
        return timer.get() >= timeout;
    }

    public void end(boolean interrupted) {
        timer.stop();
        System.out.println("MoveElevatorWithTimeout command finished after " + timer.get() + " seconds");
        timer.reset();
    }
}
