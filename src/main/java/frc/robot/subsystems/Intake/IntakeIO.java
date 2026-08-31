package frc.robot.subsystems.Intake;
import org.littletonrobotics.junction.AutoLog;

public interface IntakeIO {

    default void setRollerSpeed(double speed) {}
    
    default void updateInputs(IntakeIOInputs inputs) {}

    @AutoLog
    public static class IntakeIOInputs {
        public double rollerMasterVelocity = 0.0;
        public boolean isRollerMasterMotorConnected = false;
    }
    
}
