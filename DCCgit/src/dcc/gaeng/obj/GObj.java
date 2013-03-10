package dcc.gaeng.obj;
import dcc.gaeng.obj.Size;

public class GObj extends Pos{
	boolean active = false;
	boolean render = false;
	Size size = new Size();
	
	public void sAct(boolean a) {
		active = a;
	}
	public void sRen(boolean a) {
		render = a;
	}
	public boolean isAct(){
		return active;
	}
	public boolean isRen(){
		return render;
	}
	

}
