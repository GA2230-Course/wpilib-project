package frc.robot.subsystems.Intake;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.NeutralModeValue;

public final class IntakeConstants {

    public static final double ROLLER_GEAR_RATIO = 1.0;
    public static final double ROLLER_SIM_MOI = 0.001; 
    public static final double INTAKE_COLLECT_SPEED = 0.8;
    public static final double INTAKE_EJECT_SPEED = -0.8;

    public static final TalonFXConfiguration ROLLER_MOTOR_CONFIG = new TalonFXConfiguration();

    static {
        ROLLER_MOTOR_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;

        ROLLER_MOTOR_CONFIG.CurrentLimits.StatorCurrentLimit = 40.0;
        ROLLER_MOTOR_CONFIG.CurrentLimits.StatorCurrentLimitEnable = true;

        ROLLER_MOTOR_CONFIG.CurrentLimits.SupplyCurrentLimit = 35.0;
        ROLLER_MOTOR_CONFIG.CurrentLimits.SupplyCurrentLimitEnable = true;
    }
}