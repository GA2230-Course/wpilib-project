package frc.robot.subsystems.Intake;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.units.measure.AngularVelocity;

public class IntakeIOCTRE implements IntakeIO {

    protected final TalonFX rollerMasterMotor;
    private final StatusSignal<AngularVelocity> rollerMasterVelocitySignal;

    public IntakeIOCTRE(int rollerMotorID) {
        rollerMasterMotor = new TalonFX(rollerMotorID);
        rollerMasterMotor.getConfigurator().apply(IntakeConstants.ROLLER_MOTOR_CONFIG);

        rollerMasterVelocitySignal = rollerMasterMotor.getVelocity();
    }

    @Override
    public void updateInputs(IntakeIOInputs inputs) {
        BaseStatusSignal.refreshAll(rollerMasterVelocitySignal);

        inputs.rollerMasterVelocity = rollerMasterVelocitySignal.getValueAsDouble();

        inputs.isRollerMasterMotorConnected = rollerMasterVelocitySignal.getStatus().isOK();
    }
}