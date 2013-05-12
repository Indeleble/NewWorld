package miscelaneo.instrumentos;


import org.getspout.spoutapi.event.input.KeyBindingEvent;
import org.getspout.spoutapi.keyboard.BindingExecutionDelegate;
import org.getspout.spoutapi.keyboard.KeyBinding;
import org.getspout.spoutapi.keyboard.Keyboard;
import org.getspout.spoutapi.player.SpoutPlayer;

public class InstrumentoHandler implements BindingExecutionDelegate{

	@Override
	public void keyPressed(KeyBindingEvent event) {
		SpoutPlayer splayer = event.getPlayer();
		int inHand = splayer.getItemInHand().getTypeId();
		KeyBinding key = event.getBinding();
		Keyboard keydo = Keyboard.KEY_NUMPAD1;
		
		
//		if(inHand==352){ // Colocar aqui cada instrumento, como testeos el hueso.
			if(key.equals(keydo)){
				splayer.sendMessage("tocas do con la flauta");
			}
//		}
	}

	@Override
	public void keyReleased(KeyBindingEvent event) {
		// TODO Auto-generated method stub
	}
}
