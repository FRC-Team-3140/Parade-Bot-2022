package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.drivetrain.Drive;
import frc.robot.commands.drivetrain.TimedDrive;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class taxi extends SequentialCommandGroup {
    public taxi() {
        addCommands(
            new TimedDrive(0.25, 3)
           );
        }
}
