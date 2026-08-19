package frc.robot.commands;

import frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj.Timer;

public class OpenIntakeWithTimeout extends Command {
    private Intake intake;
    private double timeout;
    private Timer timer;

    public OpenIntakeWithTimeout(Intake intake, double timeout) {
        this.intake = intake;
        this.timeout = timeout;
        this.timer = new Timer();
        addRequirements(intake);
    }

    public void initialize() {
        intake.open();
        timer.start();
    }

    public void execute() {
    }

    public boolean isFinished() {
        return timer.get() >= timeout;
    }

    public void end(boolean interrupted) {
        intake.close();
        timer.stop();
        timer.reset();
    }
}
