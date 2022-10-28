package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;

public class CandyLift extends SubsystemBase implements HardwareAdapter {

  boolean upButtonState = false;
  boolean downButtonState = false;

  public CandyLift() {
  }

  public void ButtonUpPressed(){
    upButtonState = true;
  }

  public void ButtonUpReleased(){
    upButtonState = false;
  }

  public void ButtonDownPressed(){
    downButtonState = true;
  }

  public void ButtonDownReleased(){
    downButtonState = false;
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if(upButtonState){
      m_relay_up.setDirection(Relay.Direction.kForward);
      m_relay_down.setDirection(Relay.Direction.kReverse);
    } else if (downButtonState) {
      m_relay_up.setDirection(Relay.Direction.kReverse);
      m_relay_down.setDirection(Relay.Direction.kForward);
      
    } else {
      m_relay_up.setDirection(Relay.Direction.kReverse);
      m_relay_down.setDirection(Relay.Direction.kReverse);
    }
  }
}
