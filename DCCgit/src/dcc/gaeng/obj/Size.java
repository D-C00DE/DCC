package dcc.gaeng.obj;

public class Size {
	int w = 16;
	int h = 16;
	int l = 16;
	
	void sw (int a){
		w = a;	
	}
		void sh (int a){
		h = a;	
	}
		void sl (int a){
		l = a;
	}
		int gw(){
		return w;	
	}
		int gh(){
		return h;		
	}
		int gl(){
		return l;	
	}
}
