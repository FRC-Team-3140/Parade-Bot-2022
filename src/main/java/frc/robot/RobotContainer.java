// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Autonomous.DoNothingAuto;
import frc.robot.commands.Autonomous.taxi;
import frc.robot.commands.drivetrain.Drive;
import frc.robot.commands.pneumatics.ShiftDown;
import frc.robot.commands.pneumatics.ShiftUp;
import frc.robot.subsystems.CandyLift;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Pneumatics;

/** Add your docs here. */
public class RobotContainer implements HardwareAdapter {
    private static final SendableChooser<Command> chooser = new SendableChooser<>();

    public static Drivetrain dt = new Drivetrain();
    public static Pneumatics pn = new Pneumatics();
    public static CandyLift cl = new CandyLift();

    public RobotContainer() {
        configDefaultCommands();
        configButtons();
        chooser.setDefaultOption("Nothing", new DoNothingAuto());
        chooser.addOption("Taxi", new taxi()); 
        Shuffleboard.getTab("Selector").add(chooser);
    
        // Robot Self Test

       
        }

    public void configDefaultCommands() {
        dt.setDefaultCommand(new Drive());

        new ShiftDown().schedule();
    }

    public void configButtons() {
        xbox.leftBumper.whenPressed(new ShiftUp());
        xbox.leftBumper.whenReleased(new ShiftDown());

        xbox.a.whenPressed(() -> {cl.ButtonUpPressed(); });
        xbox.a.whenReleased(() -> {cl.ButtonUpReleased(); });
        xbox.b.whenPressed(() -> {cl.ButtonDownPressed(); });
        xbox.b.whenReleased(() -> {cl.ButtonDownReleased(); });
    }
    public Command getAutonomousCommand() {
        return chooser.getSelected();
      }
}
