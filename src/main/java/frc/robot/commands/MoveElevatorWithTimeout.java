package frc.robot.commands;

import frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj.Timer;

public class MoveElevatorWithTimeout extends Command {
    private Elevator elevator;
    private double timeout;
    private double speed;
    private Timer timer;

    public MoveElevatorWithTimeout(Elevator elevator, double speed, double timeout) {
        this.elevator = elevator;
        this.speed = speed;
        this.timeout = timeout;
        this.timer = new Timer();
        addRequirements(elevator);
    }

    public void initialize() {
        timer.start();
    }

    public void execute() {
        elevator.setHeight(elevator.getHeight() + speed);
    }
}
