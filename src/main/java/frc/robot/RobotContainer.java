// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Intake;
import frc.robot.commands.OpenIntakeWithTimeout;

public class RobotContainer {

  private final Intake m_intake = new Intake();
  private final CommandXboxController m_controller = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    m_controller.a().onTrue(new OpenIntakeWithTimeout(m_intake, 3));
  }

  public Command getAutonomousCommand() {
    return new OpenIntakeWithTimeout(m_intake, 3.0);
  }
}
