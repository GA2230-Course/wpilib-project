package frc.robot.commands;

import frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj.Timer;

public class OpenIntakeWithTimeout extends Command {
    private final Intake intake;
    private double timeout;
    private final Timer timer = new Timer();

    public OpenIntakeWithTimeout(Intake intake, double timeout) {
        this.intake = intake;
        this.timeout = timeout;
        addRequirements(intake);
        System.out.println("OpenIntakeWithTimeout command created with timeout: " + timeout + " seconds");
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
        System.out.println("OpenIntakeWithTimeout command finished after " + timer.get() + " seconds");
        timer.reset();
    }
}
